package reservas.model;

import reservas.service.EmpresaService;

public class Empresa extends Usuario{

    private String direccion;

    private String inicioJornada;  // hh:mm

    private String finJornada;  // hh:mm

    private String tiempoServicio;  // x minutos

    public Empresa() {}

    public Empresa(String nombreUser, String password, String nombre, String apellidos, String email, String direccion) {
        super(nombreUser, password, nombre, apellidos, email);
        this.direccion = direccion;
    }

    //getters and setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public boolean eliminarEmpresa() {
        return super.eliminarUsuario();
    }

}