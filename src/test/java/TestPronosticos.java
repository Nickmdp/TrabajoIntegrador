import org.junit.jupiter.api.BeforeEach;
import pronostico.Equipo;
import pronostico.Partidos;
import pronostico.Resultadosenumerados;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPronosticos {
    private Equipo eq1;
    private Equipo eq2;

    @BeforeEach
    public void init (){
        Equipo eq1 = new Equipo("Arg","Selec","1");
        Equipo eq2 = new Equipo("Pol","Selec","2");
    }

    @Test
    public void testPierde(){
        Partidos partido = new Partidos(eq1,eq2,0,2);
        Assertions.assertEquals(Resultadosenumerados.PIERDE,partido.resultado());
    }
    @Test
    public void testGana(){
        Partidos partido = new Partidos(eq1,eq2,3,2);
        Assertions.assertEquals(Resultadosenumerados.GANA,partido.resultado());
    }
    @Test
    public void testEmpata(){
        Partidos partido = new Partidos(eq1,eq2,2,2);
        Assertions.assertEquals(Resultadosenumerados.EMPATA,partido.resultado());
    }
}
