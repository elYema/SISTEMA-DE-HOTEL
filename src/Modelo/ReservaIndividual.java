/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Pablo
 */
public class ReservaIndividual extends Reserva {
     public ReservaIndividual(String nombre, String telefono, String correo, String direccion, String fechaLlegada, String fechaSalida, String tipoHabitacion, int numeroPersonas) {
        super(nombre, telefono, correo, direccion, fechaLlegada, fechaSalida, tipoHabitacion, numeroPersonas);
    }


    public double calcularPrecio() {
        // Precio fijo para una persona
        return 100.0;  // Precio para una persona
    }
    
    @Override
    public double calcularPrecioConServicios() {
        return calcularPrecio() + calcularCostoServicios();
    }
    
}
    

