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
    
    public ReservaFamiliar(String nombre, String telefono, String correo, String direccion, String fechaLlegada, String fechaSalida, String tipoHabitacion, int numeroPersonas) {
        super(nombre, telefono, correo, direccion, fechaLlegada, fechaSalida, tipoHabitacion, numeroPersonas);
    }

    @Override
    public double calcularPrecio() {
        // Precio base para una reserva grupal, más un adicional por persona
        double precioBase = 200.0;
        int personasAdicionales = getNumeroPersonas() - 2;  // Si son más de 2 personas, hay un costo adicional
        double precioAdicional = personasAdicionales * 50.0;  // 50 más por cada persona extra
        return precioBase + precioAdicional;
    }
    
    @Override
    public double calcularPrecioConServicios() {
        return calcularPrecio() + calcularCostoServicios();
    }
}
    

