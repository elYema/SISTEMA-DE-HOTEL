/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Pablo
 */
public class ReservaFamiliar extends Reserva {
    
    public ReservaFamiliar(Cliente cliente, String direccion, String fechaLlegada, String fechaSalida, String tipoHabitacion, int numeroPersonas) {
        super(cliente, direccion, fechaLlegada, fechaSalida, tipoHabitacion, numeroPersonas);
    }

    @Override
    public double calcularPrecioBase() {
        // Precio base para una reserva grupal, más un adicional por persona
        double precioBase = 200.0;
        int personasAdicionales = getNumeroPersonas() - 3;  // Si son más de 3 personas, hay un costo adicional
        double precioAdicional = personasAdicionales * 50.0;  // 50 más por cada persona extra
        return precioBase + precioAdicional;
    } 
}

