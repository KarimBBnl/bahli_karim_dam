package examen.bahli.karim.beans;

public class Analisis {
    private int id;
    private String mutacionDetectada;
    private String porcentajeCoincidencia;
    private String observaciones;
    private Laboratorio laboratorio;
    private MuestrasADN muestrasADN;
    
    public Analisis(int id, String mutacionDetectada, String porcentajeCoincidencia, String observaciones) {
        this.id = id;
        this.mutacionDetectada = mutacionDetectada;
        this.porcentajeCoincidencia = porcentajeCoincidencia;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMutacionDetectada() {
        return mutacionDetectada;
    }

    public void setMutacionDetectada(String mutacionDetectada) {
        this.mutacionDetectada = mutacionDetectada;
    }

    public String getPorcentajeCoincidencia() {
        return porcentajeCoincidencia;
    }

    public void setPorcentajeCoincidencia(String porcentajeCoincidencia) {
        this.porcentajeCoincidencia = porcentajeCoincidencia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Analisis [id=" + id + ", mutacionDetectada=" + mutacionDetectada + ", porcentajeCoincidencia="
                + porcentajeCoincidencia + ", observaciones=" + observaciones + ", getId()=" + getId()
                + ", getMutacionDetectada()=" + getMutacionDetectada() + ", getPorcentajeCoincidencia()="
                + getPorcentajeCoincidencia() + ", getObservaciones()=" + getObservaciones() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    



}
