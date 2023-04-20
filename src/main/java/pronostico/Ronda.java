package pronostico;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    private String rondaid;
    private List<Partidos> partidos;
    public Ronda(String id) {
        this.rondaid=id;
        this.partidos = new ArrayList<Partidos>();
    }
    public String getRondaid() {
        return rondaid;
    }
    public List<Partidos> getPartidos() {
        return partidos;
    }
    public void agregarpartidos(Partidos partido){
        this.partidos.add(partido);
    }

}
