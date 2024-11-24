/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


/**
 *
 * @author Pablo
 */
public class Cliente extends Persona {
    private static int contadorAcciones = 0; // Contador global para clientes
    private static int contadoReservas = 0; // Contador global para reservas
    private String numeroCliente; // Identificador único para el cliente
    private String numeroReservas; // Relación con reservas
    CuentaBancaria cuentaB;

    public Cliente(String nombre, String telefono, String correo, String numeroCliente) {
        super(nombre, telefono, correo); // Llama al constructor de Persona
        this.numeroCliente = numeroCliente;
        this.numeroReservas = numeroReservas;
        this.cuentaB = cuentaB;
    }

    // Métodos estáticos para el contador de clientes
    public static void incrementarContador() {
        contadorAcciones++;
    }

    public static int getContadorAcciones() {
        return contadorAcciones;
    }

    // Métodos estáticos para el contador de reservas
    public static void incrementarReservas() {
        contadoReservas++;
    }

    public static int getContadoReservas() {
        return contadoReservas;
    }

    // Getters y Setters normales
    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }
    
    public CuentaBancaria getCuentaB() {
        return cuentaB;
    }

    public void setCuentaB(CuentaBancaria cuentaB) {
        this.cuentaB = cuentaB;
    }
}
    

