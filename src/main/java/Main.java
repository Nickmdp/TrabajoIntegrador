import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Main {

    static Map<String, Equipo> repoEquipo = new HashMap<>();

    public static void main(String[] args) {
        Path archResultados = Path.of(args[0]);
        Path archPronosticos = Path.of(args[1]);

        List<Equipo> eq = new ArrayList<Equipo>();
        List<Ronda> rondas = new ArrayList<Ronda>();
        List<Pronosticos> pron = new ArrayList<Pronosticos>();
        List<Participante> participante = new ArrayList<Participante>();

        LeerPartidos(archResultados, eq, rondas);
        LeerPronosticos(archPronosticos, pron, participante);


        Integer sumatotal = 0;

        for (int k = 0; k < pron.size(); k++) {
            for (int l = 0; l < rondas.size(); l++) {
                Ronda ronda = rondas.get(l);
                Pronosticos pronostico = pron.get(k);
                for (int n = 0; n < ronda.getPartidos().size(); n++) {
                    Partidos partido = ronda.getPartidos().get(n);

                    if (pronostico.getEquipo2().getNombre().equals(partido.getEquipo2().getNombre()) &&
                            pronostico.getEquipo1().getNombre().equals(partido.getEquipo1().getNombre())) {
                        Participante player = Main.buscarParticipantePorId(pronostico.getParticipante().getIdparticipante() , participante);
                        player.sumaPuntos(pronostico.puntos(partido));
                        sumatotal += pronostico.puntos(partido);
                        System.out.println(pronostico.resultado + " " + partido.resultado() + "pronostico " + pronostico.getEquipo1().getNombre() + " " +
                                pronostico.getEquipo2().getNombre() + " ressultado " + partido.getEquipo1().getNombre() + " " + partido.getEquipo2().getNombre());
                    }
                }
            }
        }

        System.out.println("El puntaje obtenido es de : " + sumatotal);
        //  System.out.println();
    }

    private static void LeerPartidos(Path archResultados, List<Equipo> eq, List<Ronda> ronda) {
        try {
            List<String> lineasArch = Files.readAllLines(archResultados);
            boolean primero = true;
            for (String linea : lineasArch) {
                if (primero) {
                    primero = false;
                } else {
                    if (!linea.isBlank()) {
                        String[] split = linea.split(";");
                        Equipo eq1 = new Equipo(split[3], split[4], split[2]);
                        eq.add(eq1);
                        repoEquipo.put(split[2], eq1);
                        Equipo eq2 = new Equipo(split[8], split[9], split[7]);
                        eq.add(eq2);
                        repoEquipo.put(split[7], eq2);
                        Integer r = 1;
                        Ronda ron = ronda.stream()
                                .filter(rond -> r.equals(rond.getRondaid()))
                                .findAny()
                                .orElse(null);
                        if (ron == null) {
                            Ronda ron1 = new Ronda(1);
                            ron1.agregarpartidos(new Partidos(eq1, eq2, Integer.valueOf(split[5]), Integer.valueOf(split[6])));
                            ronda.add(ron1);
                        } else {

                            ron.agregarpartidos(new Partidos(eq1, eq2, Integer.valueOf(split[5]), Integer.valueOf(split[6])));

                        }

                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Fallo la apertura del archivo");
            System.exit(1);
        }
    }

    private static void LeerPronosticos(Path archPronosticos, List<Pronosticos> pron, List<Participante> participante) {
        try {
            List<String> lineasArch = Files.readAllLines(archPronosticos);
            boolean primero = true;
            Integer j = 0, i = 0;
            for (String linea : lineasArch) {
                if (primero) {
                    primero = false;
                } else {
                    if (!linea.isBlank()) {
                        String[] split = linea.split(";");
                        Participante player = buscarParticipantePorId(split[0], participante);
                        if (player == null) {
                            player = new Participante();
                            player.setIdparticipante(split[0]);
                            player.setNombre(split[1]);
                            player.setPuntos(0);
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
            //throw new ParticipanteNoExiste("No se encontraron coincidencias para el legajo " + id);
            Participante p2 = null;
            return p2;
        }
        Participante participante1 = supuestoParticipante.get();
        return participante1;
    }
}