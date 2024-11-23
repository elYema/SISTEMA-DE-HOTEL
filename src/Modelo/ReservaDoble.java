    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Pablo
 */
public class ReservaDoble extends Reserva{
    
      public ReservaDoble(String nombre, String telefono, String correo, String direccion, String fechaLlegada, String fechaSalida, String tipoHabitacion, int numeroPersonas) {
        super(nombre, telefono, correo, direccion, fechaLlegada, fechaSalida, tipoHabitacion, numeroPersonas);
    }

    @Override
    public double calcularPrecio() {
        // Precio fijo para dos personas
        return 150.0;  // Precio para dos personas
    }
    
}
