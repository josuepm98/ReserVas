package reservas.model;

import reservas.service.EmpresaService;

import java.util.List;

public class Empresa extends Usuario{

    private String direccion;

    private String categoria;

    private String inicioJornada;  // hh:mm

    private String finJornada;  // hh:mm

    private String tiempoServicio;  // x minutos

    public Empresa() {}

    public Empresa(String nombreUser, String password, String nombre, String apellidos, String email, String direccion, String categoria) {
        super(nombreUser, password, nombre, apellidos, email);
        this.direccion = direccion;
        this.categoria = categoria;
    }

    //getters and setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getInicioJornada() { return inicioJornada; }

    public void setInicioJornada(String inicioJornada) { this.inicioJornada = inicioJornada; }

    public String getFinJornada() { return finJornada; }

    public void setFinJornada(String finJornada) { this.finJornada = finJornada; }

    public String getTiempoServicio() { return tiempoServicio; }

    public void setTiempoServicio(String tiempoServicio) { this.tiempoServicio = tiempoServicio; }

    public boolean crearEmpresa() {
        EmpresaService empresa = new EmpresaService();
        return empresa.crearEmpresa(this);
    }

    public Empresa getEmpresa(){
        EmpresaService empresa = new EmpresaService();
        return empresa.getEmpresa(this.getNombreUser());
    }

    public boolean eliminarEmpresa() {
        return super.eliminarUsuario();
    }

    public List<Cliente> getClientesEmpresa(){
        EmpresaService empresa = new EmpresaService();
        return empresa.getClientesEmpresa(this.nombreUser);
    }

}