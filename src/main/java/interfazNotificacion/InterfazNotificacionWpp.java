/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfazNotificacion;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

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
    public void enviarNotificacion(String numeroRT, GregorianCalendar fechaHoraActual, ArrayList<String> contactos) {
        this.enviarMensaje();
    }
    
    public void enviarMensaje(){
        // implementar ...
    }

    @Override
    public String toString() {
        return "WhatsApp";
    }
    
    
}
