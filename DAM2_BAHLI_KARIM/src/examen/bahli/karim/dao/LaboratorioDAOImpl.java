package examen.bahli.karim.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import examen.bahli.karim.beans.Laboratorio;
import examen.bahli.karim.motores.MotorSQL;

public class LaboratorioDAOImpl extends AbstractDAO<Laboratorio> {

    private static final String SQL_INSERT = 
            "INSERT INTO LABORATORIO " +
                    "(NOMBRE, PAIS, FECHA_FUNDACION, AUTOR_EXAMEN) " +
                    "VALUES (?, ?, ?, ?)";

    private static final String SQL_UPDATE = 
            "UPDATE LABORATORIO " +
                    "SET NOMBRE = ?, PAIS = ?, FECHA_FUNDACION = ? " +
                    "WHERE ID = ?";

    private static final String SQL_DELETE = 
            "DELETE FROM LABORATORIO WHERE ID = ?";

    private static final String SQL_FIND = 
            "SELECT * FROM LABORATORIO WHERE ID = ?";

    private static final String SQL_FIND_ALL = 
            "SELECT * FROM LABORATORIO ORDER BY ID";


    public LaboratorioDAOImpl(MotorSQL motorSql) {
        super(motorSql);
    }

    @Override
    public void add(Laboratorio entity) {
        try {
            motorSql.connect();
            motorSql.prepare(SQL_INSERT);
            
            motorSql.getPs().setString(1, entity.getNombre());
            motorSql.getPs().setString(2, entity.getPais());
            motorSql.getPs().setDate(3, null);
            motorSql.getPs().setString(4, "KARIM_BAHLI_DAM2");

            int rows = motorSql.executeUpdate();
            System.out.println("INSERTADOS: " + rows);

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSql.close();
            motorSql.disconnect();
        }
    }

    @Override
    public ArrayList<Laboratorio> findAll() {
        ArrayList<Laboratorio> laboratorios = new ArrayList<>();
        try {
            motorSql.connect();
            motorSql.prepare(SQL_FIND_ALL);
            
            ResultSet rs = motorSql.executeQuery();
            while (rs.next()) {
                laboratorios.add(mapLaboratorio(rs));
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSql.close();
            motorSql.disconnect();
        }
        return laboratorios;
    }

    private Laboratorio mapLaboratorio(ResultSet rs) throws Exception {
        Laboratorio lab = new Laboratorio(0, null, null);
        lab.setId(rs.getInt("ID"));
        lab.setNombre(rs.getString("NOMBRE"));
        lab.setPais(rs.getString("PAIS"));
        return lab;
    }

    @Override
    public void update(int id, Laboratorio entity) {
        try {
            motorSql.connect();
            motorSql.prepare(SQL_UPDATE);
            
            motorSql.getPs().setString(1, entity.getNombre());
            motorSql.getPs().setString(2, entity.getPais());
            motorSql.getPs().setDate(3, null);
            motorSql.getPs().setInt(4, id);

            int rows = motorSql.executeUpdate();
            System.out.println("ACTUALIZADOS: " + rows);

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSql.close();
            motorSql.disconnect();
        }
    }

    @Override
    public void delete(int id) {
        try {
            motorSql.connect();
            motorSql.prepare(SQL_DELETE);
            motorSql.getPs().setInt(1, id);

            int rows = motorSql.executeUpdate();
            System.out.println("BORRADOS: " + rows);

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSql.close();
            motorSql.disconnect();
        }
    }

    @Override
    public Laboratorio find(int id) {
        Laboratorio lab = null;
        try {
            motorSql.connect();
            motorSql.prepare(SQL_FIND);
            motorSql.getPs().setInt(1, id);
            
            ResultSet rs = motorSql.executeQuery();
            if (rs.next()) {
                lab = mapLaboratorio(rs);
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSql.close();
            motorSql.disconnect();
        }
        return lab;
    }


}
