package examen.bahli.karim.motores;

import java.sql.Connection;

public interface MotorSQL {
    void connect();
    void disconnect();
    Connection getConnection();

}
