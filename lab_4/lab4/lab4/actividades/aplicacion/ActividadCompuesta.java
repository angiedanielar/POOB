package aplicacion;


import java.util.ArrayList;

public class ActividadCompuesta extends Actividad{
    private ArrayList<Actividad> actividades;
    
    public ActividadCompuesta(String id){
        super(id);
        actividades= new ArrayList<Actividad>();
    }
    
    public ActividadCompuesta(String id, String descripcion){
        super(id,descripcion);
        actividades= new ArrayList<Actividad>();
    }
    
    public void actividad(Actividad a) throws ActividadExcepcion{
        if(a.getId().equals("")){
            throw new ActividadExcepcion(ActividadExcepcion.ACTIVIDAD_SIN_SIGLA);
        }
        if(isAlreadyIn(a.getId())){
            throw new ActividadExcepcion(ActividadExcepcion.ACTIVIDAD_CON_MISMA_SIGLA);
        }
        actividades.add(a);
    } 
    
    public boolean isAlreadyIn(String s){
        boolean valor= false;
        for(Actividad a : actividades){
            if(s.equals(a.getId())){
                valor= true;
                break;
            }
        }
        return valor;
    }
    
    public int cuantasActividades(){
        return this.actividades.size();
    }
    
    public ArrayList<Actividad> getActividades(){
        return this.actividades;
    }
    
    @Override
    /**
     * retorna el numero de creditos de las actividades de la actividad compuesta
     * @return totalCreditos, el total de los creditos de la activadad compuesta
     * @throws ActividadExcepcion, si no tiene actividades
     */
    public int creditos() throws ActividadExcepcion{
        int totalCreditos= 0;
        if(cuantasActividades() == 0){
            throw new ActividadExcepcion(ActividadExcepcion.COMPUESTA_VACIA);
        }
        for(Actividad a: actividades){
            totalCreditos+= a.creditos();
        }
        return totalCreditos;
    }
    
    @Override
    /**
     * retorna el valor de los creditos de las actividades bien definidas
     * @return totalCreditos
     */
    public int creditosDefinidos(){
        int totalCreditos= 0;
        if(cuantasActividades() != 0){
            for(Actividad a:actividades){
                totalCreditos+= a.creditosDefinidos();
            }
        }        
        return totalCreditos;
    }
    
    @Override
    /**
     * retorna el valor de los creditos asumiendo que la descripcion recibida sea igual a la descripcion de la actividad
     * @param descripcion
     * @return acti.creditos();
     * @throws ActividadExcepcion, si la descripcion dada es diferente a la de la actividad, si acti.creditos() la lanza, o si hay  mas de una actividad con esa descripcion
     */    
    public int creditos(String descripcion) throws ActividadExcepcion{
        int cont= 0;
        Actividad acti= null;
        for(Actividad a: actividades){
            if(a.getDescripcion().equals(descripcion)){
                cont+= 1;
                acti= a;
            }
        }
        if (cont == 0){
             throw new ActividadExcepcion(ActividadExcepcion.ACTIVIDAD_QUE_NO_EXISTE);
        }
        else if(cont>= 2){
            throw new ActividadExcepcion(ActividadExcepcion.ACTIVIDAD_CON_MISMA_DESCRIPCION);
        }
        return acti.creditos();
    }
}
