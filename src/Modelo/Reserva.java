/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Reserva {
    private Cliente cliente; // Relación con Cliente (composición)
    private String direccion;
    private String fechaLlegada;
    private String fechaSalida;
    private String tipoHabitacion;
    private int numeroPersonas;
    private List<ServicioAdicional> serviciosAdicionales; // Composición: lista de servicios adicionales

    public Reserva(Cliente cliente, String direccion, String fechaLlegada, String fechaSalida, String tipoHabitacion, int numeroPersonas) {
        this.cliente = cliente; // Asignar el cliente a la reserva
        this.direccion = direccion;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.tipoHabitacion = tipoHabitacion;
        this.numeroPersonas = numeroPersonas;
        this.serviciosAdicionales = new ArrayList<>(); // Inicialización de la lista de servicios
    }

    // Método abstracto que debe ser implementado por las subclases
    public abstract double calcularPrecioBase();

    // Métodos relacionados con los servicios adicionales
    public void agregarServicio(ServicioAdicional servicio) {
        this.serviciosAdicionales.add(servicio);
    }

    public List<ServicioAdicional> getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    public double calcularCostoServicios() {
        return serviciosAdicionales.stream().mapToDouble(ServicioAdicional::getCosto).sum();
    }

    // Método que calcula el precio total incluyendo los servicios adicionales
    public double calcularPrecioTotal() {
        return calcularPrecioBase() + calcularCostoServicios();
    }

    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
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
