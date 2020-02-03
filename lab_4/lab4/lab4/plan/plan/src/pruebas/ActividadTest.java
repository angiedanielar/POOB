package aplicacion;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class ActividadTest{
   
    private ActividadCompuesta plan;
    
    public ActividadTest(){
    }


    @Before
    public void setUp(){
        plan=new ActividadCompuesta("Plan de estudios");
        //plan.setDescripcion("El plan de estudios");
        //ActividadCompuesta is=new ActividadCompuesta("Software");
        ActividadCompuesta isb=new ActividadCompuesta("Software Basico");
        try{
            isb.actividad(new ActividadSimple("MBDA",4));
            isb.actividad(new ActividadSimple("POOB",4));
            ActividadCompuesta isi=new ActividadCompuesta("Software Intermedio");
            isi.actividad(new ActividadSimple("CVDS",4));
            isi.actividad(new ActividadSimple("ARSW",4));
            isi.actividad(new ActividadSimple("IETI",4));
            ActividadSimple isf=new ActividadSimple("Trabajo Dirigido",3);
            plan.actividad(isb);
            plan.actividad(isi);
            plan.actividad(isf);
        }
        catch(ActividadExcepcion e){
        }
    }

    @After
    public void tearDown(){
    }
    
    @Test
    public void deberiaCalcularElNumeroDeCreditosDeUnaActivia(){
        try {
           assertEquals(23,plan.creditos());
        } catch (ActividadExcepcion e){
            fail("Lanzó excepcion : "+e.getMessage());
        }    
    }    
    
    @Test
    public void deberiaCalcularElNumeroDeCreditosAsumiendo(){
        try {
           assertEquals(23,plan.creditos());
        } catch (ActividadExcepcion e){
            fail("Lanzó excepcion : "+e.getMessage());
        }    
    }       
    
    @Test
    public void deberiaLanzarExcepcionSiUnaActividadCompuestaNoTieneActividadesSimples(){       
        try { 
            plan.actividad(new ActividadCompuesta("Electivas"));
            assertEquals(23,plan.creditos());
            fail("No lanzó excepcion");
        } catch (ActividadExcepcion e) {
            assertEquals(ActividadExcepcion.COMPUESTA_VACIA,e.getMessage());
        }    
    }    
        
    @Test
    public void deberiaLanzarExcepcionSiNoSeConocenLosCreditosDeUnaActividadSimple(){
        
        try {
            plan.actividad(new ActividadSimple("Practica",null));
            assertEquals(23,plan.creditos());
            fail("No lanza la excepcion");
        } 
        catch (ActividadExcepcion e) {
            assertEquals(ActividadExcepcion.SIMPLE_SIN_CREDITOS,e.getMessage());
        }    
    }     
    
    @Test
    public void deberiaCalcularElNumeroDeCreditosDeLaActividadSimpleBienDefinida(){
        try{
            plan.actividad(new ActividadSimple("PREM",4));
            plan.actividad(new ActividadSimple("LCAL",-1));
            assertEquals(27,plan.creditosDefinidos());
        }
        catch(ActividadExcepcion e){
        } 

    }
    
    @Test
    public void deberiaCalcularElNumeroDeCreditosDeLasActividadesCompuestasBienDefinidas(){
        try{
            ActividadCompuesta mat= new ActividadCompuesta("Matematicas");
            mat.actividad(new ActividadSimple("PREM",4));
            mat.actividad(new ActividadSimple("CALD",-4));
            ActividadCompuesta log= new ActividadCompuesta("Logica");
            log.actividad(new ActividadSimple("MDIS",3));
            log.actividad(new ActividadSimple("TPRO",4));
            plan.actividad(mat);
            plan.actividad(log);
            assertEquals(34,plan.creditosDefinidos());
        }
        catch(ActividadExcepcion e){
        } 
        
    }
    
    @Test
    public void deberiaCalcularElNumeroDeCreditosDeUnaCompuestaBasadoEnLaDescripcion(){

        try{
            ActividadCompuesta log= new ActividadCompuesta("Logica","Linea de Logica");
            log.actividad(new ActividadSimple("MDIS",3));
            log.actividad(new ActividadSimple("TPRO",4));
            plan.actividad(log);
            assertEquals(7,plan.creditos("Linea de Logica"));            
        }
        catch (ActividadExcepcion e) {
            fail("Lanzó excepcion : "+e.getMessage());
        } 
    }
    
    @Test
    public void deberiaCalcularElNumeroDeCreditosDeUnaSimpleBasadoEnLaDescripcion(){
        
        try{
            plan.actividad(new ActividadSimple("PREM","Precalculo",4));
            assertEquals(4,plan.creditos("Precalculo"));            
        }
        catch (ActividadExcepcion e) {
            fail("Lanzó excepcion : "+e.getMessage());
        } 
    }
    
    @Test
    public void deberiaLanzarExcepcionConElNumeroDeDescripciones(){
        try { 
           assertEquals(23,plan.creditos("Por definir"));
           fail("No lanza la excepcion");
        } 
        catch (ActividadExcepcion e) {
            assertEquals(ActividadExcepcion.ACTIVIDAD_CON_MISMA_DESCRIPCION,e.getMessage());
        }    
    } 
    
    @Test
    public void deberiaLanzarExcepcionConLaDescripcion(){
        try { 
           assertEquals(23,plan.creditos("hola"));
           fail("No lanza la excepcion");
        } 
        catch (ActividadExcepcion e) {
            assertEquals(ActividadExcepcion.ACTIVIDAD_QUE_NO_EXISTE,e.getMessage());
        }    
    }  
    
    @Test
    public void deberiaLanzarExcepcionSiNoHaySigla(){
        try{
            plan.actividad(new ActividadSimple("","hola",4));
            fail("No lanza la excepcion");
        }
        catch (ActividadExcepcion e) {
            assertEquals(ActividadExcepcion.ACTIVIDAD_SIN_SIGLA,e.getMessage());
        }
    }
    
    @Test
    public void deberiaLanzarExcepcionSiYaHayUnaActividadConElMismoId(){
        try{
            plan.actividad(new ActividadSimple("PREM","Precalculo",4));
            plan.actividad(new ActividadSimple("PREM","Precalculo",4));
            fail("No lanza la excepcion");
        }
        catch (ActividadExcepcion e) {
            assertEquals(ActividadExcepcion.ACTIVIDAD_CON_MISMA_SIGLA,e.getMessage());
        }
    }
}
