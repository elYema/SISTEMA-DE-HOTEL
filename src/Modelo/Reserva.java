/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Reserva extends Persona {
    private double precioTotal;
    private String direccion;
    private String fechaLlegada;
    private String fechaSalida;
    private String tipoHabitacion;
    private int numeroPersonas;
    private List<ServicioAdicional> serviciosAdicionales; // Composición: lista de servicios adicionales

    public Reserva(String nombre, String telefono, String correo, String direccion, String fechaLlegada, String fechaSalida, String tipoHabitacion, int numeroPersonas) {
        super(nombre, telefono, correo); // Llamada al constructor de la clase Persona
        this.direccion = direccion;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.tipoHabitacion = tipoHabitacion;
        this.numeroPersonas = numeroPersonas;
        this.serviciosAdicionales = new ArrayList<>(); // Inicialización de la lista de servicios
    }

    // Método abstracto que debe ser implementado por las subclases
    public abstract double calcularPrecio();

    // Métodos relacionados con los servicios adicionales
    public void agregarServicio(ServicioAdicional servicio) {
        this.serviciosAdicionales.add(servicio);
    }

    public void eliminarServicio(ServicioAdicional servicio) {
        this.serviciosAdicionales.remove(servicio);
    }

    public List<ServicioAdicional> getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    public double calcularCostoServicios() {
        return serviciosAdicionales.stream().mapToDouble(ServicioAdicional::getCosto).sum();
    }

    // Método que calcula el precio total incluyendo los servicios adicionales
    public double calcularPrecioConServicios() {
        return calcularPrecio() + calcularCostoServicios();
    }

    // Getters y Setters existentes
    public String getDireccion() {
        return direccion;
    }
    
     public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
        
    }
    
    
    
    
}
