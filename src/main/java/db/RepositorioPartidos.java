package db;

import pronostico.Equipo;
import pronostico.Partidos;
import pronostico.Ronda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static pronostico.Main.repoEquipo;


public class RepositorioPartidos {
    public static List<Ronda> LeerPartidosdb() throws SQLException  {
        // Se conecta a la BD
        Connection conexion = Conexion.getConexion();
        // Selecciona todos los resultados
        PreparedStatement sentenciaDeBusqueda = conexion.prepareStatement("SELECT * FROM resultados");

        ResultSet resultado = sentenciaDeBusqueda.executeQuery();
        List<Ronda> ronda = new ArrayList<>();
        while (resultado.next()) {
            // por cada partido almaceno en la ronda correspondiente el resultado
            Equipo eq1 = new Equipo(resultado.getString("equipo1nombre"), "", resultado.getString("equipo1id"));
            repoEquipo.put(resultado.getString("equipo1id"), eq1);
            Equipo eq2 = new Equipo(resultado.getString("equipo2nombre"), "", resultado.getString("equipo2id"));
            repoEquipo.put(resultado.getString("equipo2id"), eq2);
            String rondapartido = resultado.getString("rondaid");
            // Busco si la ronda existe
            Ronda ron = ronda.stream()
                    .filter(rond -> rondapartido.equals(rond.getRondaid()))
                    .findAny()
                    .orElse(null);
            // Si la ronda no existe creo una nueva
            if (ron == null) {
                Ronda ron1 = new Ronda(rondapartido);
                ron1.agregarpartidos(new Partidos(eq1, eq2, resultado.getInt("equipo1goles"), resultado.getInt("equipo2goles")));
                ronda.add(ron1);
            } else {
                ron.agregarpartidos(new Partidos(eq1, eq2, resultado.getInt("equipo1goles"), resultado.getInt("equipo2goles")));
            }
        }
        return ronda;
    }

}
