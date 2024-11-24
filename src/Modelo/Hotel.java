/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Hotel {

    private int capacidadMaxima; // Por ejemplo, número de habitaciones
    public static double ingresosTotales = 0.0; // Variable de clase (compartida por todas las instancias)

    // Constructor
    public Hotel(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    
    // Método estático para obtener los ingresos totales
    public static double getIngresosTotales() {
        return ingresosTotales;
    }
    
    // Método estático para agregar ingresos
    public static void agregarIngreso(double ingreso) {
        ingresosTotales += ingreso; // Incrementa los ingresos totales
    }

    // Métodos de instancia para la capacidad
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
}
