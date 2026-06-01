package examen.bahli.karim.dao;
import examen.bahli.karim.beans.MuestrasADN;
import examen.bahli.karim.motores.MotorSQL;
import java.util.List;

public class MuestraADNDAOImpl extends AbstractDAO<MuestrasADN> {

    public MuestraADNDAOImpl(MotorSQL motorSql) {
        super(motorSql);
    }


    @Override
    public String toString() {
        return "MuestraADNDAOImpl []";
    }


    @Override
    public void add(MuestrasADN entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }


    @Override
    public void update(MuestrasADN entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public MuestrasADN findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }


    @Override
    public List<MuestrasADN> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
