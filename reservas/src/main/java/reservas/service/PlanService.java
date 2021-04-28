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
    ServicioService servicioService;

    public Plan getPlan(int planId){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        Plan plan = new Plan();
        Integer auxService;
        Servicio servicio;

        try {
            String query = "SELECT DISTINCT * FROM planes WHERE (`id` = '" + planId + "');";

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            if(rs.next()){
                plan.id = rs.getInt("id");
                auxService = rs.getInt("servicio_id");
                servicio = servicioService.getService(auxService);
                plan.servicios.add(servicio);
                plan.nombre = rs.getString("nombre");
                plan.descripcion = rs.getString("descripcion");
                plan.precioTotal = rs.getInt("precioTotal");
            }

            while(rs.next()){
                auxService = rs.getInt("servicio_id");
                servicio = servicioService.getService(auxService);
                plan.servicios.add(servicio);
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

    public List<Plan> getPlanes(){
        Connection conn = SQL.conectarMySQL();  // Nos conectamos a la BBDD
        List<Plan> planes = new ArrayList<>();
        Integer auxService;

        try {
            String query = "SELECT DISTINCT * FROM planes;";

            Statement st = conn.createStatement(); //creamos el statement -> nos permite sacar los datos obtenidos de la select
            ResultSet rs = st.executeQuery(query); //ejecutamos la query

            while (rs.next()) {
                Plan plan = new Plan();
                plan.id = rs.getInt("id");
                //FALLA AL COGER EL SERVICIO ID
                /*auxService = rs.getInt("servicio_id");
                Servicio servicio = servicioService.getService(auxService);
                plan.servicios.add(servicio);*/
                plan.nombre = rs.getString("nombre");
                plan.descripcion = rs.getString("descripcion");
                plan.precioTotal = rs.getDouble("precioTotal");
                //HAY QUE VER COMO RESCATAR PARA CADA PLAN SU VECTOR DE SERVICIOS
                //EJEMPLO POR PROBAR
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
