import java.util.List;
import java.util.Optional;

public class Participante {
    String idparticipante;
    String nombre;

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    Integer puntos;

    public Participante() {
    }

    public String getIdparticipante() {
        return idparticipante;
    }

    public void setIdparticipante(String idparticipante) {
        this.idparticipante = idparticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void sumaPuntos(Integer puntos){
        this.puntos=this.puntos+puntos;
    }




    }
