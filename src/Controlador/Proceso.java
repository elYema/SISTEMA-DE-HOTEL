/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Reserva;
import Modelo.ReservaIndividual;
import Modelo.ReservaDoble;
import Modelo.ReservaFamiliar;
import Modelo.Cliente;
import Modelo.Hotel;
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
            Cliente cliente = reserva.getCliente(); // Obtener cliente asociado

            // Obtener los servicios adicionales en formato texto
            StringBuilder serviciosTexto = new StringBuilder();
            for (ServicioAdicional servicio : reserva.getServiciosAdicionales()) {
                serviciosTexto.append(servicio.getNombre()).append(":").append(servicio.getCosto()).append(";");
            }

            // Formar la línea a guardar
            String linea = cliente.getNombre() + "," +
                           cliente.getTelefono() + "," +
                           cliente.getCorreo() + "," +
                           reserva.getDireccion() + "," +
                           reserva.getFechaLlegada() + "," +
                           reserva.getFechaSalida() + "," +
                           reserva.getTipoHabitacion() + "," +
                           reserva.getNumeroPersonas() + "," +
                           reserva.calcularPrecioTotal() + "," +
                           serviciosTexto.toString(); // Agregar los servicios adicionales

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
    Hotel.ingresosTotales = 0.0;
    if (!archivo.exists()) {
        return; // Si el archivo no existe, salir
    }

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");

            // Leer los datos del cliente y la reserva
            String nombre = datos[0];
            String telefono = datos[1];
            String correo = datos[2];
            String direccion = datos[3];
            String fechaLlegada = datos[4];
            String fechaSalida = datos[5];
            String tipoHabitacion = datos[6];
            int numeroPersonas = Integer.parseInt(datos[7]);
            double precioTotal = Double.parseDouble(datos[8]);
            String serviciosTexto = datos.length > 9 ? datos[9] : ""; // Servicios adicionales (si existen)

            // Crear el cliente
            Cliente cliente = new Cliente(nombre, telefono, correo, "C" + telefono.hashCode());

            // Crear la reserva según el tipo de habitación
            Reserva reserva;
            switch (tipoHabitacion) {
                case "Individual":
                    reserva = new ReservaIndividual(cliente, direccion, fechaLlegada, fechaSalida, tipoHabitacion, numeroPersonas);
                    break;
                case "Doble":
                    reserva = new ReservaDoble(cliente, direccion, fechaLlegada, fechaSalida, tipoHabitacion, numeroPersonas);
                    break;
                case "Familiar":
                    reserva = new ReservaFamiliar(cliente, direccion, fechaLlegada, fechaSalida, tipoHabitacion, numeroPersonas);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de habitación desconocido: " + tipoHabitacion);
            }

            // Cargar los servicios adicionales
            if (!serviciosTexto.isEmpty()) {
                String[] servicios = serviciosTexto.split(";");
                for (String servicio : servicios) {
                    String[] detalles = servicio.split(":");
                    if (detalles.length == 2) {
                        String nombreServicio = detalles[0];
                        double costoServicio = Double.parseDouble(detalles[1]);
                        reserva.agregarServicio(new ServicioAdicional(nombreServicio, costoServicio));
                    }
                }
            }

            listaReservas.add(reserva); // Agregar a la lista

            // Sumar el precio total de la reserva a los ingresos totales del hotel
            Hotel.agregarIngreso(precioTotal);

            // Agregar datos al modelo de la tabla
            modelo.addRow(new Object[]{
                    cliente.getNombre(),
                    cliente.getTelefono(),
                    cliente.getCorreo(),
                    direccion,
                    fechaLlegada,
                    fechaSalida,
                    tipoHabitacion,
                    numeroPersonas,
                    precioTotal
            });
        }
    } catch (IOException e) {
        System.err.println("Error al cargar los datos: " + e.getMessage());
    }
}
}