package pronostico;

import db.RepoCSV;
import db.RepositorioPartidos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.*;


public class Main {

    public static Map<String, Equipo> repoEquipo = new HashMap<>();

    public static void main(String[] args) throws SQLException {

        Path archPronosticos = Path.of(args[0]);
        int puntaje=3;

        List<Pronosticos> pron = new ArrayList<Pronosticos>();
        List<Participante> participante = new ArrayList<Participante>();

     // Los resultados se leen de la Base de Datos
        List<Ronda> rondas = RepositorioPartidos.LeerPartidosdb();
    // Los pronosticos los leo del argumento
        RepoCSV.LeerPronosticos(archPronosticos, pron, participante);


        Integer sumatotal = 0;
        // recorro todos los pronosticos
        for (int k = 0; k < pron.size(); k++) {
            // Recorro todas las Rondas
            for (int l = 0; l < rondas.size(); l++) {
                Ronda ronda = rondas.get(l);
                Pronosticos pronostico = pron.get(k);
                // Recorro todos los partidos de cada ronda
                for (int n = 0; n < ronda.getPartidos().size(); n++) {
                    Partidos partido = ronda.getPartidos().get(n);
                    if (pronostico.getEquipo2().getNombre().equals(partido.getEquipo2().getNombre()) &&
                            pronostico.getEquipo1().getNombre().equals(partido.getEquipo1().getNombre())) {
                        Participante player = RepoCSV.buscarParticipantePorId(pronostico.getParticipante().getIdparticipante() , participante);
                        player.sumaPuntos(pronostico.puntos(partido,puntaje));
                        sumatotal += pronostico.puntos(partido,puntaje);
                     //   System.out.println(pronostico.getParticipante().getNombre()+pronostico.getResultado() + " " + partido.resultado() + "pronostico " + pronostico.getEquipo1().getNombre() + " " +
                     //           pronostico.getEquipo2().getNombre() + " ressultado " + partido.getEquipo1().getNombre() + " " + partido.getEquipo2().getNombre());
                    }
                }
            }
        }
        for (Participante participante1 : participante) {
            System.out.println(participante1.toString());
        }
    }


}