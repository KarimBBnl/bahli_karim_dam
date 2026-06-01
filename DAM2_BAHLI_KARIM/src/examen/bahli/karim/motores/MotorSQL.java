package examen.bahli.karim.motores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface MotorSQL {
    void connect();
    void disconnect();
    Connection getConnection();
    void prepare(String sql);
    PreparedStatement getPs();
    ResultSet executeQuery();
    int executeUpdate();
    void close();

}
