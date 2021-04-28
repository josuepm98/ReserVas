package reservas.model;

import reservas.service.PlanService;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Plan {
    private static final int serialVersionUID = 1;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String nombre;
    public String descripcion;
    public double precioTotal;

    public Set<Servicio> servicios = new HashSet<>();

    public Plan(){

    }

    public Plan(String nombre, String descripcion, double precioTotal){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioTotal = precioTotal;
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



}
