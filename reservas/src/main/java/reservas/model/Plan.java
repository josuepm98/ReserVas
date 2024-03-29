package reservas.model;

import java.util.ArrayList;

public class Plan {
    public enum PlanEstado {LIBRE, RESERVADO}

    public int id;
    public String nombre;
    public String descripcion;
    public double precioTotal;
    public PlanEstado estado;
    public String img;

    public ArrayList<Servicio> servicios;

    public Plan() {
        servicios = new ArrayList<Servicio>();
    }

    public Plan(String nombre, String descripcion, double precioTotal){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioTotal = precioTotal;
        this.servicios = new ArrayList<Servicio>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public PlanEstado getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioTotal(double precioTotal){
        this.precioTotal = precioTotal;
    }

    public void setEstado(PlanEstado estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return img;
    }

    public void setImagen(String imagen) {
        this.img = imagen;
    }

}
