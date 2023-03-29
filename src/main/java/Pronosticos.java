public class Pronosticos {
    Equipo equipo1;
    char gana1;
    char empata;
    char gana2;
    Equipo equipo2;
    Partidos partido;
    Main.Resultadosenum resultado;

    public Pronosticos(Equipo equipo1, char gana1, char empata, char gana2, Equipo equipo2 ,Partidos partido) {
        this.equipo1 = equipo1;
        this.gana1 = gana1;
        this.empata = empata;
        this.gana2 = gana2;
        this.equipo2 = equipo2;
        this.partido = partido;
        if (this.gana1=='X'){
            this.resultado= Main.Resultadosenum.GANA;
        }
        if (this.gana2=='X'){
            this.resultado= Main.Resultadosenum.PIERDE;
        }
        if( this.empata=='X'){
            this.resultado= Main.Resultadosenum.EMPATA;
        }

    }
    public int puntos(){

        int puntos = 0;
        Main.Resultadosenum resultadoRealParaEquipo = this.partido.resultado();
        if(resultadoRealParaEquipo == this.resultado) {
            puntos = 1;
        }

        return puntos;
    }
}
