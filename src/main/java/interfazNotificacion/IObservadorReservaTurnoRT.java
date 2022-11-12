/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
public interface IObservadorReservaTurnoRT {
    public void enviarNotificacion(String numeroRT, GregorianCalendar fechaHoraActual, ArrayList<String> contactos);
}
