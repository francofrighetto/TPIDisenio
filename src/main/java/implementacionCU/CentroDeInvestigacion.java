package implementacionCU;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

public class CentroDeInvestigacion {
    private String nombre;
    private GregorianCalendar fechaAlta;
    private GregorianCalendar fechaBaja;
    private List<RecursoTecnologico> recursosTecnologicos = new ArrayList<>();
    private List<AsignacionCientificoDelCI> cientificos = new ArrayList<>();
    private List<AsignacionCientificoDelCI> cientificosActivos = new ArrayList<>();
    private List<RecursoTecnologico> recursosFiltrados = new ArrayList<>() ;
    

    public CentroDeInvestigacion(String nombre, int aA,int mA,int dA, int aB, int mB, int dB){
        this.nombre = nombre ;
        this.fechaAlta = new GregorianCalendar(aA,mA,dA) ;
        this.fechaBaja = new GregorianCalendar(aB,mB,dB) ;
        
    }

    public void agregarRT(RecursoTecnologico rt) {       
        this.recursosTecnologicos.add(rt) ; 
    }
    public void agregarCientifico(AsignacionCientificoDelCI c) { this.cientificos.add(c) ; }
    
    public String getNombre() { return this.nombre; }
    
    public boolean estaActivo(){ 
        GregorianCalendar fechaActual = new GregorianCalendar();
        if (this.fechaBaja.after(fechaActual)) {
            return true ;
        } else { return false ; }
    }

    public List<AsignacionCientificoDelCI> misCientificosActivos(){
        for (AsignacionCientificoDelCI c: cientificos){
            if (c.esCientificoActivo() == true){
                cientificosActivos.add(c);
            }
        }
        return cientificosActivos ;
    }
    
    public PersonalCientifico getPersonalLogeado(Usuario logueado){
        
        for (AsignacionCientificoDelCI a: cientificosActivos){
            if (a.getPersonalCientifico().esTuUsuario(logueado) == true){
                return a.getPersonalCientifico();
            }
        }
        return null;
    }

    public List<RecursoTecnologico> mostrarRT(TipoRecursoTecnologico tipoRT){

        for (RecursoTecnologico rt: recursosTecnologicos) {
            if (rt.esDeTipoSeleccionado(tipoRT) && rt.esActivo()) {

                if (rt.getActual().esReservable() ==true) {
                    recursosFiltrados.add(rt);
                    /* ver donde se implementa
                    rt.getActual().getEstado() ;
                    rt.getNumeroInventario() ;
                    rt.miModeloYMarca() ; */
                }
            }
        }
        return recursosFiltrados ;
    }
    public boolean esMiRT(RecursoTecnologico RT){
        for (RecursoTecnologico rt: recursosTecnologicos){
            return (rt.equals(RT));
        }
        return false;
    }
    
}