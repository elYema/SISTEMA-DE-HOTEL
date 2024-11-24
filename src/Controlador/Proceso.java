/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Reserva;
import Modelo.ReservaIndividual;
import Modelo.ReservaDoble;
import Modelo.ReservaFamiliar;
import Modelo.ServicioAdicional;

import java.io.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Proceso {
    private File archivo = new File("datos.txt");
// Método para guardar todos los datos en el archivo
public void guardarDatos(ArrayList<Reserva> listaReservas) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
        for (Reserva reserva : listaReservas) {
            double precioTotal = reserva.calcularPrecioConServicios(); // Calcular el precio total
            
            // Guardar todos los datos de la reserva, incluyendo el precio total
            String linea = reserva.getNombre() + "," +
                           reserva.getTelefono() + "," +
                           reserva.getCorreo() + "," +
                           reserva.getDireccion() + "," +
                           reserva.getFechaLlegada() + "," +
                           reserva.getFechaSalida() + "," +
                           reserva.getTipoHabitacion() + "," +
                           reserva.getNumeroPersonas() + "," +
                           precioTotal; // Agregar precio total
            bw.write(linea);
            bw.newLine();
        }
    } catch (IOException e) {
        System.err.println("Error al guardar los datos: " + e.getMessage());
    }
}


    // Método para cargar datos desde el archivo
public void cargarDatos(ArrayList<Reserva> listaReservas, DefaultTableModel modelo) {
    listaReservas.clear();
    modelo.setRowCount(0); // Limpiar la tabla

    if (!archivo.exists()) {
        return; // Si el archivo no existe, salir
    }

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");

            // Crear la reserva a partir de los datos leídos
            String nombre = datos[0];
            String telefono = datos[1];
            String correo = datos[2];
            String direccion = datos[3];
            String fechaLlegada = datos[4];
            String fechaSalida = datos[5];
            String tipoHabitacion = datos[6];
            int numeroPersonas = Integer.parseInt(datos[7]);
            double precioTotal = Double.parseDouble(datos[8]);

            Reserva reserva;
            switch (tipoHabitacion) {
                case "Individual":
                    reserva = new ReservaIndividual(nombre, telefono, correo, direccion, fechaLlegada, fechaSalida, tipoHabitacion, numeroPersonas);
                    break;
                case "Doble":
                    reserva = new ReservaDoble(nombre, telefono, correo, direccion, fechaLlegada, fechaSalida, tipoHabitacion, numeroPersonas);
                    break;
                case "Familiar":
                    reserva = new ReservaFamiliar(nombre, telefono, correo, direccion, fechaLlegada, fechaSalida, tipoHabitacion, numeroPersonas);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de habitación desconocido: " + tipoHabitacion);
            }

            reserva.setPrecioTotal(precioTotal); // Establecer el precio total
            listaReservas.add(reserva); // Agregar a la lista

            // Agregar datos al modelo de la tabla
            modelo.addRow(new Object[]{nombre, telefono, correo, direccion, fechaLlegada, fechaSalida, tipoHabitacion, numeroPersonas, precioTotal});
        }
    } catch (IOException e) {
        System.err.println("Error al cargar los datos: " + e.getMessage());
    }
}
}
