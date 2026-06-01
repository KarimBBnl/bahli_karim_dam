package examen.bahli.karim.dao;

import examen.bahli.karim.motores.MotorSQL;

public abstract class AbstractDAO<T> implements DAO<T>{
    protected MotorSQL motorSql;

    public AbstractDAO(MotorSQL motorSql) {
        this.motorSql = motorSql;
    }
    
    //Metodos
    protected void printError(Exception e){
        System.out.println(
                "[ERROR] " + e.getMessage());
    }

 

}
