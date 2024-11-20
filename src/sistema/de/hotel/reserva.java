/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.de.hotel;

/**
 *
 * @author jheaf
 */
    class reserva extends persona {
    
    private String direccion;
    private String fechaLlegada;
    private String fechaSalida;
    private String tipoHabitacion;
    private int numeroPersonas;

    public reserva(String nombre, String telefono, String correo, String direccion, String fechaLlegada, String fechaSalida, String tipoHabitacion, int numeroPersonas) {
        super(nombre, telefono, correo);  // Llamada al constructor de la superclase Persona
        this.direccion = direccion;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.tipoHabitacion = tipoHabitacion;
        this.numeroPersonas = numeroPersonas;
    }
    
    // Getters y Setters adicionales
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getFechaLlegada() { return fechaLlegada; }
    public void setFechaLlegada(String fechaLlegada) { this.fechaLlegada = fechaLlegada; }

    public String getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(String fechaSalida) { this.fechaSalida = fechaSalida; }

    public String getTipoHabitacion() { return tipoHabitacion; }
    public void setTipoHabitacion(String tipoHabitacion) { this.tipoHabitacion = tipoHabitacion; }

    public int getNumeroPersonas() { return numeroPersonas; }
    public void setNumeroPersonas(int numeroPersonas) { this.numeroPersonas = numeroPersonas; }
}
