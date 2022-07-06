package implementacionCU;
import java.util.Date;
import java.util.GregorianCalendar;

public class CambioEstadoTurno {
    private GregorianCalendar fechaHoraDesde;
    private GregorianCalendar fechaHoraHasta;
    private Estado estado;

    public CambioEstadoTurno(GregorianCalendar fechaHoraDesde, Estado e){
        this.fechaHoraDesde = fechaHoraDesde;
        this.estado = e;
    }

    public GregorianCalendar getFechaHoraDesde(){ return this.fechaHoraDesde; }
    public GregorianCalendar getFechaHoraHasta(){ return this.fechaHoraHasta; }
    public String getEstado(){ return this.estado.getNombre(); }

    public void setEstado(Estado estado){
        this.estado=estado;
    }

    public void setFechaHoraHasta(GregorianCalendar fa) { fechaHoraHasta = fa;}

    @Override
    public String toString() {
        return estado.getNombre() + '}';
    }


}
