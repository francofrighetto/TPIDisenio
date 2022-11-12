/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfazNotificacion;

import implementacionCU.RecursoTecnologico;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Franco
 */
public class InterfazNotificacionMail implements IObservadorReservaTurnoRT {

    private String numeroRT;
    private Date fecha;
    private LocalTime hora;
    private ArrayList<String> contactos;
    

    @Override
    public void enviarNotificacion(RecursoTecnologico numeroRT, String fechaHoraActual, ArrayList<String> contactos) {
 
        String mensaje ="Se ha registrado la reserva del turno para el recurso tecnologico "+numeroRT+",\n"
                + " en la fecha  " +fechaHoraActual +" al contacto " + contactos.get(0);
        this.enviarMail(mensaje);

    }
    
    public void enviarMail(String mensaje){
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Se ha enviado el siguiente mensaje via Mail \n "+mensaje);
    }
    
    @Override
    public String toString() {
        return "Mail";
    }
}
