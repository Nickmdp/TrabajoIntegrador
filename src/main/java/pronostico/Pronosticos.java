package pronostico;

public class Pronosticos {
    private Equipo equipo1;
     private Equipo equipo2;
    private Participante participante;
    private Resultadosenumerados resultado;

    public Participante getParticipante() {
        return participante;
    }
    public Equipo getEquipo2() {
        return equipo2;
    }
    public Equipo getEquipo1() {
        return equipo1;
    }
    public Pronosticos(Equipo equipo1, String gana1, String empata, String gana2, Equipo equipo2,Participante participante) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.participante=participante;

        if (gana1.equals("X")){
            this.resultado= Resultadosenumerados.GANA;
        }
        if (gana2.equals("X")){
            this.resultado= Resultadosenumerados.PIERDE;
        }
        if( empata.equals("X")){
            this.resultado= Resultadosenumerados.EMPATA;
        }

    }
    public int puntos(Partidos partido, int puntaje){

        int puntos = 0;
        Resultadosenumerados resultadoRealParaEquipo = partido.resultado();
        if(resultadoRealParaEquipo == this.resultado) {
            puntos = puntaje;
        }

        return puntos;
    }
}
