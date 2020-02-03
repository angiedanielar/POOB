package aplicacion;

public abstract class Actividad{
    private String id;
    private String descripcion;
    
    public Actividad(String id){
        this.id=id;
        this.descripcion="Por definir";
    }
    
    public Actividad(String id, String descripcion){
        this.id=id;
        this.descripcion=descripcion;
    }
    
    /**
     * retorna la descripcion de la actividad
     * @return descripcion
     */
    public String getDescripcion(){
        return this.descripcion;
    }
    
    /**
     * retorna el id de la actividad
     * @return id
     */
    public String getId(){
        return this.id;
    }
    
    /**
     * cambia la descripcion de la actividad
     * @param descripcion, la nueva descripcion de la actividad
     */
    public void setDescripcion(String descrip){
        this.descripcion= descrip;
    }
    
    public abstract int creditos() throws ActividadExcepcion;
    
    /**
     * Calcular el numero de creditos considerando las actividades bien definidas
     * @return totalCreditos, el valor total de los creditos 
     * 
     */
    public abstract int creditosDefinidos();
    
    public abstract int creditos(String descripcion) throws ActividadExcepcion;
    
}
