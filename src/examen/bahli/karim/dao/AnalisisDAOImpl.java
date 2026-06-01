package examen.bahli.karim.dao;

import java.util.List;

import examen.bahli.karim.beans.Analisis;
import examen.bahli.karim.motores.MotorSQL;

public class AnalisisDAOImpl extends AbstractDAO<Analisis> {

    public AnalisisDAOImpl(MotorSQL motorSql) {
        super(motorSql);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void add(Analisis entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void update(Analisis entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Analisis findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Analisis> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
