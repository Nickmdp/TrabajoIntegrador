package pronostico;

public class Equipo {
    String nombre;
    String ideq;
    String descripcion;

   /* public void setNombre(String nombre) {
        this.nombre = nombre;
    }
*/
    public Equipo(String nombre, String descripcion, String id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ideq=id;
    }

  /*  public Equipo(String nombre) {
        this.nombre = nombre;
    }*/

    public String getNombre() {
        return nombre;
    }


}
