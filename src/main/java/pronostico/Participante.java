package pronostico;

import java.util.List;
import java.util.Optional;

public class Participante {
    String idparticipante;
    String nombre;
    Integer puntos;

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }



    public Participante(String id,String nombre) {
        this.idparticipante=id;
        this.nombre=nombre;
        this.puntos=0;
    }

   public String getIdparticipante() {
        return idparticipante;
    }

   /* public void setIdparticipante(String idparticipante) {
        this.idparticipante = idparticipante;
    }*/

 /*   public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
*/
    public void sumaPuntos(Integer puntos){
        this.puntos=this.puntos+puntos;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "idparticipante='" + idparticipante + '\'' +
                ", nombre='" + nombre + '\'' +
                ", puntos=" + puntos +
                '}';
    }
}
