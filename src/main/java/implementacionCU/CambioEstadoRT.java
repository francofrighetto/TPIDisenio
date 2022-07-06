package implementacionCU;
import java.util.Date;
import java.util.GregorianCalendar;

public class CambioEstadoRT {
    private GregorianCalendar fechaHoraDesde;
    private GregorianCalendar fechaHoraHasta;
    private Estado estado;

    // aD = año desde , aH = año hasta....
    public CambioEstadoRT(GregorianCalendar fechaHoraDesde, Estado e) {
        this.fechaHoraDesde = fechaHoraDesde ;
        this.estado = e ;
    }

    public GregorianCalendar getFechaHoraDesde(){ return this.fechaHoraDesde; }
    public GregorianCalendar getFechaHoraHasta(){ return this.fechaHoraHasta; }

    public String getEstado(){ return this.estado.getNombre(); }

    public void setEstado(Estado e){ this.estado = e ; }

    public boolean esReservable(){
        return (estado.esAmbitoCambioEstadoRT() && estado.esReservable()) ;
    }

    public void setFechaHoraHasta(GregorianCalendar fa) { fechaHoraHasta = fa;}
}