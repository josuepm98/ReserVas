package reservas.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import reservas.model.Categoria;
import reservas.model.Usuario;


public class CategoriaService {

    // Creamos la cadena para conectar a la BBDD
    private ConexionMySQL SQL = new ConexionMySQL();

    public boolean crearCategoria(Categoria categoria) {
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = false;

        try {

            if(categoria.existe()) {
                System.out.println("Esa categoria ya existe");
            }else {
                String query = "insert into categoria values ('" + categoria.getNombre() + "');";
                PreparedStatement comando = conn.prepareStatement(query);
                comando.execute();
                resultado = true; 
            }return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return resultado;
        } finally {
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    // Devuelve true si la categoria pasada por parámetro existe
    public boolean existe(String nombre){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        boolean resultado = true;

        Statement comando;
        ResultSet consulta = null;

        try {
            comando = conn.createStatement();
            consulta = comando.executeQuery("select * from categoria where nombre = '" + nombre+ "';");

            if(!consulta.next()) {
                resultado = false;
            }
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return resultado;
        } finally {
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public boolean eliminarCategoria(Categoria categoria) {
        Connection conn = SQL.conectarMySQL();
        boolean resultado = false;

        try {

            if(!categoria.existe()) {
                System.out.println("Esa categoria no existe");
            }else {
                String query = "delete from categoria where (`nombre` = '" + categoria.getNombre() + "'); ";
                PreparedStatement comando = conn.prepareStatement(query);
                comando.execute();
                resultado = true; 
            }return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return resultado;
        } finally {
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }


}
