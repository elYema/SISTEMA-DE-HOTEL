/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.hotel;

import java.util.ArrayList;

/**
 *
 * @author jheaf
 */
    class hotel {
    private String nombre;
    private ArrayList<reserva> listaReservas;  

    public hotel(String nombre) {
        this.nombre = nombre;
        this.listaReservas = new ArrayList<>();
    }

    // Método para agregar una reserva
   public void agregarReserva(reserva reserva) {
        listaReservas.add(reserva);
    }

    public ArrayList<reserva> getReservas() {
        return listaReservas;
    }
}

