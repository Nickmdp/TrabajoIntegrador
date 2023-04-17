import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private Integer rondaid;
    private List<Partidos> partidos;

    public Ronda(){}

    public Ronda(Integer id) {
        this.rondaid=id;
        this.partidos = new ArrayList<Partidos>();
    }

    public Integer getRondaid() {
        return rondaid;
    }

    public void setRondaid(Integer rondaid) {
        this.rondaid = rondaid;
    }

    public List<Partidos> getPartidos() {
        return partidos;
    }
    public void agregarpartidos(Partidos partido){
        this.partidos.add(partido);
    }
    public void setPartidos(List<Partidos> partidos) {
        this.partidos = partidos;
    }
}
