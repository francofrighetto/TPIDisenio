/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfazNotificacion;

import implementacionCU.RecursoTecnologico;
import java.awt.Frame;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Franco
 */
public class InterfazNotificacionWpp implements IObservadorReservaTurnoRT {

    private String numeroRT;
    private Date fecha;
    private LocalTime hora;
    private ArrayList<String> contactos;
    
    @Override
    public void enviarNotificacion(RecursoTecnologico numeroRT, String fechaHoraActual, ArrayList<String> contactos) {
        // define el mensaje que se va a mandar y llama a un metodo de envio propio

        String mensaje ="Se ha registrado la reserva del turno para el recurso tecnologico "+numeroRT+", \n"
                + " en la fecha  " +fechaHoraActual +" al contacto " + contactos.get(1);
        this.enviarMensaje(mensaje);
    }
    
    public void enviarMensaje(String mensaje){
        // muestra mediante una ventana una simulacion del mensaje a enviar

        Frame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Se ha enviado el siguiente mensaje via WhatsApp \n "+mensaje);
    }

    @Override
    public String toString() {
        return "WhatsApp";
    }
    
    
}
