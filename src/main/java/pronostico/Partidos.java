package pronostico;

public class Partidos {
    private Equipo equipo1;
    private Equipo equipo2;
    private Integer goles1;
    private Integer goles2;

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public Partidos(Equipo equipo1, Equipo equipo2, Integer goles1, Integer goles2) {

        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.goles1 = goles1;
        this.goles2 = goles2;
    }
    public Resultadosenumerados resultado(){
        if (this.goles1>this.goles2){
            return Resultadosenumerados.GANA;
        } else if (this.goles1<this.goles2) {
            return Resultadosenumerados.PIERDE;
        } else
            return Resultadosenumerados.EMPATA;
    }
}
