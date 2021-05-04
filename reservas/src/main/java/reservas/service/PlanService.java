package reservas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reservas.model.Categoria;
import reservas.model.Servicio;
import reservas.model.Plan;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//ES TEMPORAL Y SUPONIENDO NOMBRES QUE ESTAN POR DEFINIR EN LA BBDD Y EN MODEL PERO VAMOS, USO LA LOGICA PERO QUIZAS TOCA MODIFICARLO
//LOS ID DE LOS SERVICIOS DE UN PLAN SE GUARDAN EN UN ARRAYLIST DE INTEGERS
@Service
public class PlanService {
    private ConexionMySQL SQL = new ConexionMySQL();
    ServicioService servicioService = new ServicioService();

    public Plan getPlan(int planId){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        Plan plan = new Plan();

        try {
            String query = "SELECT * FROM planes WHERE (`id` = '" + planId + "');";

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            while(rs.next()){
                plan.id = rs.getInt("id");
                plan.servicios.add(servicioService.getService(rs.getInt("servicio_id")));
                plan.nombre = rs.getString("nombre");
                plan.descripcion = rs.getString("descripcion");
                plan.precioTotal = rs.getDouble("precioTotal");
            }

            return plan;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return plan;
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

    public ArrayList<Plan> getPlanes(){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        ArrayList<Plan> planes = new ArrayList<Plan>();

        try {
            String query = "SELECT * FROM planes;";

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            int idAnterior = -1;
            Plan plan = new Plan();
            while (rs.next()) {
                if(idAnterior == rs.getInt("id")){
                    plan.servicios.add(servicioService.getService(rs.getInt("servicio_id")));
                }else{
                    if(idAnterior != -1){
                        planes.add(plan);
                    }
                    plan = new Plan();
                    plan.id = rs.getInt("id");
                    plan.servicios.add(servicioService.getService(rs.getInt("servicio_id")));
                    plan.nombre = rs.getString("nombre");
                    plan.descripcion = rs.getString("descripcion");
                    plan.precioTotal = rs.getDouble("precioTotal");

                    idAnterior = plan.getId();
                }
            }
            // Para meter el último plan
            if(plan.getNombre() != null){
                planes.add(plan);
            }

            return planes;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Se ha producido un error.");
            return planes;
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
