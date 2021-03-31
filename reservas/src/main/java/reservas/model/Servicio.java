package reservas.model;

import reservas.service.ClienteService;
import reservas.service.ServicioService;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Time;
import java.util.Objects;

public class Servicio {
    public enum ServicioEstado {LIBRE, RESERVADO}
    private static final int serialVersionUID = 1;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String nombre;
    public String direccion;
    public double precio;
    public String fecha;
    public Time horaInicio;
    public Time horaFin;
    public Categoria categoria;
    public ServicioEstado estado;
    public String empresa;
    public String cliente;

    //Constructores
    public Servicio(){ }

    public Servicio(String nombre, String direccion, double precio, String fecha, Time horaInicio, Time horaFin, Categoria categoria,ServicioEstado estado, String empresa, String cliente){
        this.nombre = nombre;
        this.direccion = direccion;
        this.precio = precio;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.categoria = categoria;
        this.estado = estado;
        this.empresa = empresa;
        this.cliente = cliente;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getFecha() {
        return fecha;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public ServicioEstado getEstado() {
        return estado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getCliente() {
        return cliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setEstado(ServicioEstado estado) {
        this.estado = estado;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public boolean crearServicio() {
        ServicioService servicio = new ServicioService();
        return servicio.createService(this);
    }
}
