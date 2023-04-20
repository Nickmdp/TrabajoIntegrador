package db;

import pronostico.Participante;
import pronostico.Pronosticos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

//import static pronostico.Main.buscarParticipantePorId;
import static pronostico.Main.repoEquipo;

public class RepoCSV {
    public static void LeerPronosticos(Path archPronosticos, List<Pronosticos> pron, List<Participante> participante) {
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
    public static Participante buscarParticipantePorId(String id, List<Participante> participante){
        Optional<Participante> supuestoParticipante = Optional.ofNullable(participante.stream().filter(a -> a.getIdparticipante().equals(id)).findFirst().orElse(null));
        if (!supuestoParticipante.isPresent()) {
            Participante p2 = null;
            return p2;
        }
        Participante participante1 = supuestoParticipante.get();
        return participante1;
    }
}
