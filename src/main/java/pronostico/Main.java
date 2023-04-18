package pronostico;

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
        LeerPronosticos(archPronosticos, pron, participante);


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
                        Participante player = buscarParticipantePorId(pronostico.getParticipante().getIdparticipante() , participante);
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

    private static void LeerPronosticos(Path archPronosticos, List<Pronosticos> pron, List<Participante> participante) {
        try {
            List<String> lineasArch = Files.readAllLines(archPronosticos);
            boolean primero = true;
            //Integer j = 0, i = 0;
            for (String linea : lineasArch) {
                if (primero) {
                    primero = false;
                } else {
                    if (!linea.isBlank()) {
                        String[] split = linea.split(";");
                        Participante player = buscarParticipantePorId(split[0], participante);
                        if (player == null) {
                            player = new Participante(split[0],split[1]);
                            participante.add(player);
                        }
                        pron.add(new Pronosticos(repoEquipo.get(split[2]), split[3], split[4], split[5], repoEquipo.get(split[6]), player));

                    }
                }
            }
            } catch(IOException e){
                System.out.println("Fallo la apertura del archivo pronosticos");
                System.exit(1);
            }
        }

    private static Participante buscarParticipantePorId (String id, List < Participante > participante){
        Optional<Participante> supuestoParticipante = Optional.ofNullable(participante.stream().filter(a -> a.getIdparticipante().equals(id)).findFirst().orElse(null));
        if (!supuestoParticipante.isPresent()) {
            Participante p2 = null;
            return p2;
        }
        Participante participante1 = supuestoParticipante.get();
        return participante1;
    }
}