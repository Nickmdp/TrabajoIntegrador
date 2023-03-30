public class Partidos {
    Equipo equipo1;
    Equipo equipo2;
    Integer goles1;
    Integer goles2;

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
    public Main.Resultadosenum resultado(){
        if (this.goles1>this.goles2){
            return Main.Resultadosenum.GANA;
        } else if (this.goles1<this.goles2) {
            return Main.Resultadosenum.PIERDE;

        } else
            return Main.Resultadosenum.EMPATA;
    }
}
