/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfazNotificacion;


/**
 *
 * @author Franco
 */
public interface ISujeto {
    public void notificar();
    public void suscribir(IObservadorReservaTurnoRT ob);
    public void quitar(IObservadorReservaTurnoRT ob);

}
