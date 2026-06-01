package examen.bahli.karim.beans;

public class MuestrasADN {
    private int id;
    private int codigo;
    private String tipo;
    private String fechaExtraccion;
    private Laboratorio laboratorio;
    private Analisis analisis;

    public MuestrasADN(int id, int codigo, String tipo, String fechaExtraccion) {
        this.id = id;
        this.codigo = codigo;
        this.tipo = tipo;
        this.fechaExtraccion = fechaExtraccion;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getFechaExtraccion() {
        return fechaExtraccion;
    }
    public void setFechaExtraccion(String fechaExtraccion) {
        this.fechaExtraccion = fechaExtraccion;
    }

    
    public Laboratorio getLaboratorio() {
        return laboratorio;
    }
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
    public Analisis getAnalisis() {
        return analisis;
    }
    public void setAnalisis(Analisis analisis) {
        this.analisis = analisis;
    }
    @Override
    public String toString() {
        return "MuestrasADN [id=" + id + ", codigo=" + codigo + ", tipo=" + tipo + ", fechaExtraccion="
                + fechaExtraccion + ", getId()=" + getId() + ", getCodigo()=" + getCodigo() + ", getTipo()=" + getTipo()
                + ", getFechaExtraccion()=" + getFechaExtraccion() + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }


    
}
