package examen.bahli.karim.motores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreMotorSQL implements MotorSQL {

    private Connection connection;
    private static final String URL = "jdbc:postgresql://bahli-karim-dam.cgup9yonqtos.us-east-1.rds.amazonaws.com:5432/bahli-karim-dam";
    private static final String USER = "postgres";
    private static final String PASS = "12345678";
    private static final String DRIVER = "org.postgresql.Driver";


    @Override
    public void connect() {
         try {
            Class.forName(DRIVER); 
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión PostgreSQL establecida correctamente.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error conectando a PostgreSQL", e);
        }
    }

    @Override
    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
       return connection;
    }

}
