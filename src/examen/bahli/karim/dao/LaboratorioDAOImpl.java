package examen.bahli.karim.dao;

import java.util.List;

import examen.bahli.karim.beans.Laboratorio;
import examen.bahli.karim.motores.MotorSQL;

public class LaboratorioDAOImpl extends AbstractDAO<Laboratorio> {

    public LaboratorioDAOImpl(MotorSQL motorSql) {
        super(motorSql);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void add(Laboratorio entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void update(Laboratorio entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Laboratorio findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Laboratorio> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }


}
