import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class Main {
    public enum Resultadosenum {GANA,PIERDE,EMPATA}

    public static void main(String[] args) {
        Path archResultados = Path.of(args[0]);
        Equipo eq[]=new Equipo[4];
        Partidos par[]=new Partidos[2];
        Integer j=0,i=0;
        try {
            List<String> lineasArch = Files.readAllLines(archResultados);
            boolean primero = true;
            for (String linea : lineasArch) {
                if (primero) {
                    primero = false;
                } else {
                    if (!linea.isBlank()) {
                        String[] split = linea.split(";");

                        eq[j]= new Equipo(split[1],split[2]);
                        eq[j+1]=new Equipo(split[6],split[7]);
                        par[i++]=new Partidos(eq[j],eq[j+1],Integer.valueOf(split[3]),Integer.valueOf(split[4]));
                        j+=2;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Fallo la apertura del archivo");
            System.exit(1);
        }
/*
        Equipo eq1=new Equipo("Argentina","Seleccionado");
        Equipo eq2=new Equipo("Arabia Saudita","Seleccioando");
        Equipo eq3=new Equipo("Polonia","Seleccioando");
        Equipo eq4=new Equipo("Mexico","Seleccioando");
/*
        Partidos par1=new Partidos(eq[0],eq[1],1,2);
        Partidos par2=new Partidos(eq[2],eq[3],0,0);

 */

        Pronosticos pron1=new Pronosticos(eq[0],'X',' ',' ',eq[1],par[0]);
        Pronosticos pron2=new Pronosticos(eq[2],' ','X',' ',eq[2],par[1]);
        Integer sumatotal=0;
        sumatotal=pron1.puntos()+pron2.puntos();
        System.out.println("El puntaje obtenido es de : "+sumatotal);
      //  System.out.println();
    }
}