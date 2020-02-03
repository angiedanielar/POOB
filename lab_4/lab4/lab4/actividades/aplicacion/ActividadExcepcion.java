package aplicacion;

public class ActividadExcepcion extends Exception{
    public static final String COMPUESTA_VACIA="Actividad compuesta vacia";
    public static final String SIMPLE_SIN_CREDITOS="Actividad simple sin creditos";
    public static final String ACTIVIDAD_QUE_NO_EXISTE="No existe una actividad con esa descripción";
    public static final String ACTIVIDAD_CON_MISMA_DESCRIPCION="Existen al menos dos actividades con la misma descripción";
    public static final String ACTIVIDAD_SIN_SIGLA="No se permite crear una asignatura sin sigla";
    public static final String ACTIVIDAD_CON_MISMA_SIGLA="No se permite crear una asignatura con misma sigla";
    public ActividadExcepcion(String mensaje){
        super(mensaje);
    }
}
