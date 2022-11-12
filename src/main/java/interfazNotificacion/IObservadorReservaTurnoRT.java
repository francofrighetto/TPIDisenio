/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfazNotificacion;

import implementacionCU.RecursoTecnologico;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Franco
 */
public interface IObservadorReservaTurnoRT {
    public void enviarNotificacion(RecursoTecnologico numeroRT, String fechaHoraActual, ArrayList<String> contactos);
}
