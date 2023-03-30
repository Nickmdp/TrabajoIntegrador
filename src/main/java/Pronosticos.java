public class Pronosticos {
    private Equipo equipo1;
    String gana1;
    String empata;
    String gana2;
    private Equipo equipo2;

    Main.Resultadosenum resultado;

    public Equipo getEquipo2() {
        return equipo2;
    }
    public Equipo getEquipo1() {
        return equipo1;
    }
    public Pronosticos(Equipo equipo1, String gana1, String empata, String gana2, Equipo equipo2) {
        this.equipo1 = equipo1;
        //this.gana1 = gana1;
        //this.empata = empata;
        //this.gana2 = gana2;
        this.equipo2 = equipo2;


        if (gana1.equals("X")){
            this.resultado= Main.Resultadosenum.GANA;
        }
        if (gana2.equals("X")){
            this.resultado= Main.Resultadosenum.PIERDE;
        }
        if( empata.equals("X")){
            this.resultado= Main.Resultadosenum.EMPATA;
        }

    }
    public int puntos(Partidos partido){

        int puntos = 0;
        Main.Resultadosenum resultadoRealParaEquipo = partido.resultado();
        if(resultadoRealParaEquipo == this.resultado) {
            puntos = 1;
        }

        return puntos;
    }
}
