package implementacionCU;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Turno  {
    public GregorianCalendar fechaHoraInicio;
    public GregorianCalendar fechaHoraFin;
    private CambioEstadoTurno actual;
    private List<CambioEstadoTurno> cambioEstadoTurno =  new ArrayList<>();
    private List<Object> datos = new ArrayList<>();

    public  Turno (int aI, int mI,int dI,int horaI,int minI, int segI,int horaB,int minB, int segB,int aF, int mF,int dF, CambioEstadoTurno actual) {
        this.fechaHoraInicio = new GregorianCalendar(aI,mI,dI,horaI,minI,segI) ;
        this.fechaHoraFin = new GregorianCalendar(aF,mF,dF,horaB,minB,segB) ;
        this.actual = actual;
    }

    public GregorianCalendar getfechaInicioFin(){return this.fechaHoraFin;}

    public boolean esActivo(GregorianCalendar fechaActual){
        return (this.fechaHoraInicio.equals(fechaActual) || this.fechaHoraInicio.after(fechaActual)) && this.fechaHoraFin.after(fechaActual);
    }

    public List getDatosTurno(){
        datos.add(this.fechaHoraInicio);
        datos.add(this.fechaHoraFin);
        datos.add(this.actual.getEstado());
        return datos;
    }

    public void actualizarEstadoActual(Estado e){
        GregorianCalendar fechaActual = new GregorianCalendar();

        actual.setFechaHoraHasta(fechaActual);
        cambioEstadoTurno.add(actual);

        actual = new CambioEstadoTurno(fechaActual, e);
    }

    @Override
    public String toString() {
        return "Fecha y hora de inicio:" + this.fechaHoraInicio.getTime().toString() + ", Fecha y hora de fin:" + this.fechaHoraFin.getTime().toString()+ ", estado actual del turno:" + actual + '}';
    }

    public String getFechaHoraInicio() {
        String fechaFormateada= ""+fechaHoraInicio.getTime();
        return fechaFormateada.substring(8, 10)+"-"+fechaFormateada.substring(4,7);
    }
    
    public String getFechaHoraInicioCompleto(){
        String fechaFormateada= ""+fechaHoraInicio.getTime();

        return fechaFormateada.substring(8, 10)+" de "+fechaFormateada.substring(4,7)+" de " +fechaFormateada.substring(24, 28) + " a las "+ fechaFormateada.substring(11, 19);

    }
    
    
}