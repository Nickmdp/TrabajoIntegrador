package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class Conexion {
        private static Connection conexion = null;
        private static String db="arg_programa";
        private static String host = "localhost";

        public static Connection getConexion() throws SQLException {
            if(conexion == null) {
                conexion = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+db, "nico", "nico");
            }
            return conexion;
        }

        public static void cerrarConexion() throws SQLException {
            if(conexion != null && !conexion.isClosed()) {
                conexion.close();
                conexion = null;
            }
        }
    }


