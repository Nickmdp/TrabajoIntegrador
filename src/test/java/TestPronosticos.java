import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPronosticos {
    @Test
    public void testPierde(){
        Equipo eq1 = new Equipo("Arg","Selec","1");
        Equipo eq2 = new Equipo("Pol","Selec","2");
        Partidos partido = new Partidos(eq1,eq2,0,2);
        Assertions.assertEquals(Resultadosenumerados.PIERDE,partido.resultado());
    }
}
