package aplicacion;


public class ActividadSimple extends Actividad{
    private Integer creditos;
    
    public ActividadSimple(String id, Integer creditos){
        super(id);
        this.creditos=creditos;
    }
    
    public ActividadSimple(String id, String descripcion, Integer creditos){
        super(id,descripcion);
        this.creditos=creditos;
    }    
    
    @Override
    /**
     * retorna el valor de los creditos de la actividad
     * @return creditos
     * @throws ActividadExcepcion, si los creditos son nulos
     */
    public int creditos() throws ActividadExcepcion{
        if(this.creditos == null){
            throw new ActividadExcepcion(ActividadExcepcion.SIMPLE_SIN_CREDITOS);            
        }
        return this.creditos;
    }
    
    @Override
    /**
     * retorna el valor del credito de esta actividad si esta bien definida, cero si no
     * @return valor
     */
    public int creditosDefinidos(){
        int valor;
        try{
            valor= creditos();
            if(valor< 0){
                valor= 0;
            }
        }
        catch( ActividadExcepcion e){
            valor= 0;
        }
        return valor;
    }
    
    @Override
    /**
     * retorna el valor de los creditos asumiendo que la descripcion recibida sea igual a la descripcion de la actividad
     * @param descripcion
     * @return creditos();
     * @throws ActividadExcepcion, si la descripcion dada es diferente a la de la actividad o si creditos la lanza
     */
    public int creditos(String descripcion) throws ActividadExcepcion{
        if(getDescripcion().equals(descripcion)){
            throw new ActividadExcepcion(ActividadExcepcion.ACTIVIDAD_QUE_NO_EXISTE);
        }
        return creditos();
    }
}
