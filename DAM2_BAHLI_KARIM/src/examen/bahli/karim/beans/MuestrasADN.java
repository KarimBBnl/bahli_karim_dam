package examen.bahli.karim.beans;

import java.sql.Date;

public class MuestrasADN {
    private int id;
    private String codigo;
    private String tipo;
    private Date fechaExtraccion;
    private Laboratorio laboratorio;
    private Analisis analisis;

    public MuestrasADN(int id, String codigo, String tipo, Date fechaExtraccion) {
        this.id = id;
        this.codigo = codigo;
        this.tipo = tipo;
        this.fechaExtraccion = fechaExtraccion;
    }

    public MuestrasADN() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Date getFechaExtraccion() {
        return fechaExtraccion;
    }
    public void setFechaExtraccion(Date fechaExtraccion) {
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

