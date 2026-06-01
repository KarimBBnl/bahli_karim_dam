package examen.bahli.karim.dao;

import examen.bahli.karim.beans.Analisis;
import examen.bahli.karim.beans.Laboratorio;
import examen.bahli.karim.beans.MuestrasADN;
import examen.bahli.karim.motores.MotorSQL;

import java.sql.ResultSet;
import java.util.ArrayList;

/* ========================================= 
AUTOR: KARIM BAHLI
GRUPO: DAM2 
EXAMEN JDBC AWS RDS 
FECHA: 01/06/2026 
========================================= 
*/ 
public class MuestraADNDAOImpl extends AbstractDAO<MuestrasADN> {

    private static final String SQL_INSERT = 
            "INSERT INTO MUESTRAS_ADN " +
                    "(CODIGO, TIPO, FECHA_EXTRACCION, FK_LABORATORIO_ID, AUTOR_EXAMEN) " +
                    "VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = 
            "UPDATE MUESTRAS_ADN " +
                    "SET CODIGO = ?, TIPO = ?, FECHA_EXTRACCION = ? " +
                    "WHERE ID = ?";

    private static final String SQL_DELETE = 
            "DELETE FROM MUESTRAS_ADN WHERE ID = ?";

    private static final String SQL_FIND = 
            "SELECT * FROM MUESTRAS_ADN WHERE ID = ?";

    private static final String SQL_FIND_ALL = 
            "SELECT * FROM MUESTRAS_ADN ORDER BY ID";

    private static final String SQL_MUESTRAS_CRITICAS = 
            "SELECT M.ID AS M_ID, M.CODIGO, M.TIPO, M.FECHA_EXTRACCION, " +
                    "L.ID AS L_ID, L.NOMBRE AS L_NOMBRE, L.PAIS AS L_PAIS, " +
                    "A.ID AS A_ID, A.MUTACION_DETECTADA, A.PORCENTAJE_COINCIDENCIA, A.OBSERVACIONES " +
                    "FROM MUESTRAS_ADN M " +
                    "INNER JOIN LABORATORIO L ON M.FK_LABORATORIO_ID = L.ID " +
                    "INNER JOIN ANALISIS A ON M.ID = A.FK_MUESTRA_ADN_ID " +
                    "WHERE A.MUTACION_DETECTADA = TRUE " +
                    "AND A.PORCENTAJE_COINCIDENCIA > 90 " +
                    "AND L.PAIS = 'ESPAÑA' " +
                    "ORDER BY M.ID";

    private static final String SQL_FIND_BY_LABORATORIO =
            "SELECT * " +
                    "FROM MUESTRAS_ADN " +
                    "WHERE FK_LABORATORIO_ID = ?";
    public MuestraADNDAOImpl(MotorSQL motorSQL) {
        super(motorSQL);
    }

    @Override
    public void add(MuestrasADN muestra) {
        try {
            motorSql.connect();
            motorSql.prepare(SQL_INSERT);
            
            motorSql.getPs().setString(1, muestra.getCodigo());
            motorSql.getPs().setString(2, muestra.getTipo());
            motorSql.getPs().setDate(3, muestra.getFechaExtraccion());
            motorSql.getPs().setInt(4, muestra.getLaboratorio().getId());
            motorSql.getPs().setString(5, "KARIM_BAHLI_DAM2");

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
    public void update(int id, MuestrasADN muestra) {
        try {
            motorSql.connect();
            motorSql.prepare(SQL_UPDATE);
            
            motorSql.getPs().setString(1, muestra.getCodigo());
            motorSql.getPs().setString(2, muestra.getTipo());
            motorSql.getPs().setDate(3, muestra.getFechaExtraccion());
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
    public MuestrasADN find(int id) {
        MuestrasADN muestra = null;
        try {
            motorSql.connect();
            motorSql.prepare(SQL_FIND);
            motorSql.getPs().setInt(1, id);
            
            ResultSet rs = motorSql.executeQuery();
            if (rs.next()) {
                muestra = mapMuestraSimple(rs);
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSql.close();
            motorSql.disconnect();
        }
        return muestra;
    }

    @Override
    public ArrayList<MuestrasADN> findAll() {
        ArrayList<MuestrasADN> muestras = new ArrayList<>();
        try {
            motorSql.connect();
            motorSql.prepare(SQL_FIND_ALL);
            
            ResultSet rs = motorSql.executeQuery();
            while (rs.next()) {
                muestras.add(mapMuestraSimple(rs));
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSql.close();
            motorSql.disconnect();
        }
        return muestras;
    }


    //CONSULTAS AVANZADAS
    public ArrayList<MuestrasADN> muestrasCriticas() {
        ArrayList<MuestrasADN> muestras = new ArrayList<>();
        try {
            motorSql.connect();
            motorSql.prepare(SQL_MUESTRAS_CRITICAS);
            
            ResultSet rs = motorSql.executeQuery();
            while (rs.next()) {
                muestras.add(mapMuestraCompleta(rs));
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSql.close();
            motorSql.disconnect();
        }
        return muestras;
    }

    public ArrayList<MuestrasADN> findByLaboratorio(int idLaboratorio) {
        ArrayList<MuestrasADN> muestras = new ArrayList<>();
        try {
            motorSql.connect();
            motorSql.prepare(SQL_FIND_BY_LABORATORIO);
            motorSql.getPs().setInt(1, idLaboratorio);

            ResultSet rs = motorSql.executeQuery();
            while (rs.next()) {
                muestras.add(mapMuestraSimple(rs)); // Usamos el mapeo simple aquí
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSql.close();
        }
        return muestras;
    }

    private MuestrasADN mapMuestraSimple(ResultSet rs) throws Exception {
        MuestrasADN m = new MuestrasADN();
        m.setId(rs.getInt("ID"));
        m.setCodigo(rs.getString("CODIGO"));
        m.setTipo(rs.getString("TIPO"));
        m.setFechaExtraccion(rs.getDate("FECHA_EXTRACCION"));
        return m;
    }

    private MuestrasADN mapMuestraCompleta(ResultSet rs) throws Exception {
        MuestrasADN m = new MuestrasADN();
        m.setId(rs.getInt("M_ID"));
        m.setCodigo(rs.getString("CODIGO"));
        m.setTipo(rs.getString("TIPO"));
        m.setFechaExtraccion(rs.getDate("FECHA_EXTRACCION"));

        Laboratorio l = new Laboratorio(0, null, null);
        l.setId(rs.getInt("L_ID"));
        l.setNombre(rs.getString("L_NOMBRE"));
        l.setPais(rs.getString("L_PAIS"));

        Analisis a = new Analisis();
        a.setId(rs.getInt("A_ID"));
        a.setMutacionDetectada(rs.getString("MUTACION_DETECTADA"));
        a.setPorcentajeCoincidencia(rs.getString("PORCENTAJE_COINCIDENCIA"));
        a.setObservaciones(rs.getString("OBSERVACIONES"));

        m.setLaboratorio(l);
        m.setAnalisis(a);

        return m;
    }
}
