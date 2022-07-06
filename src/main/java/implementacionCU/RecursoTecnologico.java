package implementacionCU;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

public class RecursoTecnologico {
    private int numeroRT;
    private GregorianCalendar fechaAlta;
    private GregorianCalendar fechaBajaDefinitiva ;
    private TipoRecursoTecnologico tipoRecursoTecnologico ;
    private boolean estaEnMantenimiento ;
    public List<Turno> turnos = new ArrayList<>() ;
    private List<CambioEstadoRT> cambioEstadoRT = new ArrayList<>() ;
    private CambioEstadoRT actual ;
    private Modelo modelo;
    private List<Turno> turnosDisponibles = new ArrayList<>() ;
    
       public RecursoTecnologico(int numeroRT, int dA, int mA, int aA, TipoRecursoTecnologico tipoRT, boolean estaEnMantenimiento, CambioEstadoRT actual, Modelo modelo) {
        this.numeroRT = numeroRT;
        this.fechaAlta = new GregorianCalendar(aA,mA,dA) ;
        this.fechaBajaDefinitiva = null ;
        this.tipoRecursoTecnologico = tipoRT;
        this.estaEnMantenimiento = estaEnMantenimiento;
        this.actual = actual;
        this.modelo = modelo;
    }

    public CambioEstadoRT getActual() { return this.actual; }

    public void setFechaBajaDefinitiva (int dB, int mB, int aB) {
        this.fechaBajaDefinitiva = new GregorianCalendar(aB,mB,dB) ;
    }

    public boolean esDeTipoSeleccionado(TipoRecursoTecnologico tipoRT) {
        if (this.tipoRecursoTecnologico.equals(tipoRT)) {
            return true ;
        } else return false ;
    }

    public boolean esActivo() {
        GregorianCalendar fechaActual = new GregorianCalendar();
        return estaEnMantenimiento==false && this.fechaBajaDefinitiva==null;
    }
    
    public int getNumeroInventario() { return this.numeroRT ; }

    public String miModeloYMarca() { 
        return "modelo: "+modelo.getModelo() +", marca: "+ modelo.getMarca() ;
    }
    
    public String getModelo(){
        return this.modelo.getModelo();
    }
    
    public String getMarca(){
        return this.modelo.getMarca();
    }

    public void agregarTurno(Turno t) { this.turnos.add(t) ; }

    public List<Turno> misTurnoDisponibles(GregorianCalendar fechaActual) {
        for (Turno t: turnos) {
            if (t.esActivo(fechaActual)==true) {
                turnosDisponibles.add(t) ;
            }
        }
        return turnosDisponibles ;
    }

    public void actualizarEstadoTurno(Estado e ) {
        GregorianCalendar fechaActual = new GregorianCalendar();

        actual.setFechaHoraHasta(fechaActual);
        cambioEstadoRT.add(actual);

        actual = new CambioEstadoRT(fechaActual, e);
    }

    @Override
    public String toString() {
        return this.numeroRT + "";
    }

    public int getNumeroRT() {
        return numeroRT;
    }

    public TipoRecursoTecnologico getTipoRecursoTecnologico() {
        return tipoRecursoTecnologico;
    }
    
    
    
}