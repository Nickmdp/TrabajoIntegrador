public class Main {
    public enum Resultadosenum {GANA,PIERDE,EMPATA}

    public static void main(String[] args) {
        Equipo eq1=new Equipo("Argentina","Seleccionado");
        Equipo eq2=new Equipo("Arabia Saudita","Seleccioando");
        Equipo eq3=new Equipo("Polonia","Seleccioando");
        Equipo eq4=new Equipo("Mexico","Seleccioando");

        Partidos par1=new Partidos(eq1,eq2,1,2);
        Partidos par2=new Partidos(eq3,eq4,0,0);

        Pronosticos pron1=new Pronosticos(eq1,'X',' ',' ',eq2,par1);
        Pronosticos pron2=new Pronosticos(eq3,'X',' ',' ',eq4,par2);
        Integer sumatotal=0;
        sumatotal=pron1.puntos()+pron2.puntos();
        System.out.println("El puntaje obtenido es de : "+sumatotal);
      //  System.out.println();
    }
}