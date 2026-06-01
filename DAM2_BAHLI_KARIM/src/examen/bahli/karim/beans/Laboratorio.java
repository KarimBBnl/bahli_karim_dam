package examen.bahli.karim.beans;

public class Laboratorio {
    private int id;
    private String nombre;
    private String pais;
    
    
   
    
    public Laboratorio(int id, String nombre, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    @Override
    public String toString() {
        return "Laboratorio [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", getId()=" + getId()
                + ", getNombre()=" + getNombre() + ", getPais()=" + getPais() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
  
    
    

    
}
