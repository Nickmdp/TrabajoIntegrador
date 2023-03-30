import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public enum Resultadosenum {GANA,PIERDE,EMPATA}
     static Map<String, Equipo> repoEquipo = new HashMap<>();
    public static void main(String[] args) {
        Path archResultados = Path.of(args[0]);
        Path archPronosticos = Path.of(args[1]);


        Equipo eq[]=new Equipo[4];
        Partidos par[]=new Partidos[2];
        Pronosticos pron[]=new Pronosticos[4];

        LeerPartidos(archResultados, eq, par);
        LeerPronosticos(archPronosticos,pron);
/*
        Pronosticos pron1=new Pronosticos(eq[0]," "," ","X",eq[1]);
        Pronosticos pron2=new Pronosticos(eq[2]," ","X"," ",eq[2]);
        */

        Integer sumatotal=0;
   //     sumatotal=pron1.puntos(par[0])+pron2.puntos(par[1]);
        System.out.println("El puntaje obtenido es de : "+sumatotal);
         sumatotal=0;
        for(int k=0;k<pron.length;k++){
            for (int l=0;l<par.length;l++){
                if(pron[k].getEquipo2().getNombre().equals(par[l].getEquipo2().getNombre()) &&
                   pron[k].getEquipo1().getNombre().equals(par[l].getEquipo1().getNombre())) {
                    sumatotal += pron[k].puntos(par[l]);
                    System.out.println(pron[k].resultado +" "+par[l].resultado()+ "pronostico "+pron[k].getEquipo1().getNombre()+" "+
                            pron[k].getEquipo2().getNombre()+ " ressultado "+par[l].getEquipo1().getNombre()+ " "+par[l].getEquipo2().getNombre());

                }
                  }
        }

       // sumatotal=pron1.puntos(par[0])+pron2.puntos(par[1]);
        System.out.println("El puntaje obtenido es de : "+sumatotal);
      //  System.out.println();
    }

    private static void LeerPartidos(Path archResultados, Equipo[] eq, Partidos[] par) {
        try {
            List<String> lineasArch = Files.readAllLines(archResultados);
            boolean primero = true;
            Integer j=0,i=0;
            for (String linea : lineasArch) {
                if (primero) {
                    primero = false;
                } else {
                    if (!linea.isBlank()) {
                        String[] split = linea.split(";");
                        eq[j]= new Equipo(split[1],split[2],split[0]);
                        repoEquipo.put(split[0],eq[j]);
                        eq[j+1]=new Equipo(split[6],split[7],split[5]);
                        repoEquipo.put(split[5],eq[j+1]);
                        par[i++]=new Partidos(eq[j], eq[j +1],Integer.valueOf(split[3]),Integer.valueOf(split[4]));
                        j+=2;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Fallo la apertura del archivo");
            System.exit(1);
        }
    }

    private static void LeerPronosticos(Path archPronosticos,Pronosticos[] pron ) {
        try {
            List<String> lineasArch = Files.readAllLines(archPronosticos);
            boolean primero = true;
            Integer j=0,i=0;
            for (String linea : lineasArch) {
                if (primero) {
                    primero = false;
                } else {
                    if (!linea.isBlank()) {
                        String[] split = linea.split(";");
                         pron[j++]=new Pronosticos(repoEquipo.get(split[0]),split[1],split[2],split[3],repoEquipo.get(split[4]));



                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Fallo la apertura del archivo pronosticos");
            System.exit(1);
        }
    }


}