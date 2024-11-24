/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private String direccion;
    private int capacidadMaxima; // Por ejemplo, número de habitaciones
    private List<Persona> clientes; // Lista de clientes (relación de agregación)
    private List<Reserva> reservas; // Lista de reservas (relación de agregación)

    // Constructor
    public Hotel(String nombre, String direccion, int capacidadMaxima) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidadMaxima = capacidadMaxima;
        this.clientes = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // Métodos para gestionar clientes
    public void registrarCliente(Persona cliente) {
        if (!clientes.contains(cliente)) { // Evitar duplicados
            clientes.add(cliente);
        }
    }

    public Persona buscarCliente(String nombre) {
        for (Persona cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente;
            }
        }
        return null; // Cliente no encontrado
    }

    public List<Persona> listarClientes() {
        return clientes;
    }

    // Métodos para gestionar reservas
    public void agregarReserva(Reserva reserva) {
        if (reservas.size() >= capacidadMaxima) {
            System.out.println("No hay más espacio disponible en el hotel.");
            return;
        }
        reservas.add(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservas;
    }

    // Métodos para estadísticas
    public int calcularOcupacionActual() {
        return reservas.size();
    }

    public double calcularIngresosTotales() {
        double ingresos = 0;
        for (Reserva reserva : reservas) {
            ingresos += reserva.calcularPrecioConServicios();
        }
        return ingresos;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
}