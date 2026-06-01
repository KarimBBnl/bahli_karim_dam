package examen.bahli.karim.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import examen.bahli.karim.beans.Analisis;
import examen.bahli.karim.motores.MotorSQL;

public class AnalisisDAOImpl extends AbstractDAO<Analisis> {
    private static final String SQL_INSERT =
            "INSERT INTO ANALISIS " +
                    "(MUTACION_DETECTADA, PORCENTAJE_COINCIDENCIA, OBSERVACIONES, FK_MUESTRASADN_ID, AUTOR_EXAMEN) " +
                    "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE =
            "UPDATE ANALISIS " +
                    "SET MUTACION_DETECTADA = ?, PORCENTAJE_COINCIDENCIA = ?, OBSERVACIONES = ? " +
                    "WHERE ID = ?";

    private static final String SQL_DELETE =
            "DELETE FROM ANALISIS WHERE ID = ?";

    private static final String SQL_FIND =
            "SELECT * FROM ANALISIS WHERE ID = ?";

    private static final String SQL_FIND_ALL =
            "SELECT * FROM ANALISIS ORDER BY ID";

    public AnalisisDAOImpl(MotorSQL motorSql) {
        super(motorSql);

    }

    @Override
    public void add(Analisis analisis) {
        try {
            motorSql.connect();
            motorSql.prepare(SQL_INSERT);

            motorSql.getPs().setString(1, analisis.getMutacionDetectada());
            motorSql.getPs().setString(2, analisis.getPorcentajeCoincidencia());
            motorSql.getPs().setString(3, analisis.getObservaciones());
            motorSql.getPs().setInt(4, analisis.getMuestrasADN().getId()); // FK
            motorSql.getPs().setString(5, "KARIM_BAHLI_DAM2");

            int rows = motorSql.executeUpdate();
            System.out.println("INSERTADOS: " + rows);

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSql.close();
        }
        
    }

    @Override
    public void update(int id, Analisis analisis) {
        try {
            motorSql.connect();
            motorSql.prepare(SQL_UPDATE);

            motorSql.getPs().setString(1, analisis.getMutacionDetectada());
            motorSql.getPs().setString(2, analisis.getPorcentajeCoincidencia());
            motorSql.getPs().setString(3, analisis.getObservaciones());
            motorSql.getPs().setInt(4, id);

            int rows = motorSql.executeUpdate();
            System.out.println("ACTUALIZADOS: " + rows);

        } catch (Exception e) {
            printError(e);
        } finally {
            motorSql.close();
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
        }
    }

    @Override
    public Analisis find(int id) {
        Analisis analisis = null;
        try {
            motorSql.connect();
            motorSql.prepare(SQL_FIND);
            motorSql.getPs().setInt(1, id);

            ResultSet rs = motorSql.executeQuery();
            if (rs.next()) {
                analisis = mapAnalisis(rs);
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSql.close();
        }
        return analisis;
    }

    @Override
    public ArrayList<Analisis> findAll() {
        ArrayList<Analisis> analisisLista = new ArrayList<>();
        try {
            motorSql.connect();
            motorSql.prepare(SQL_FIND_ALL);

            ResultSet rs = motorSql.executeQuery();
            while (rs.next()) {
                analisisLista.add(mapAnalisis(rs));
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSql.close();
        }
        return analisisLista;
    }

    private Analisis mapAnalisis(ResultSet rs) throws Exception {
        Analisis a = new Analisis();
        a.setId(rs.getInt("ID"));
        a.setMutacionDetectada(rs.getString("MUTACION_DETECTADA"));
        a.setPorcentajeCoincidencia(rs.getString("PORCENTAJE_COINCIDENCIA"));
        a.setObservaciones(rs.getString("OBSERVACIONES"));
        return a;
    }
}
