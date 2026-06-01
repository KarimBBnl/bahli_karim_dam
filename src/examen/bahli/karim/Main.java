package examen.bahli.karim;

import java.util.List;

import examen.bahli.karim.beans.Laboratorio;
import examen.bahli.karim.beans.MuestrasADN;
import examen.bahli.karim.dao.MuestraADNDAOImpl;
import examen.bahli.karim.motores.MotorFactory;
import examen.bahli.karim.motores.MotorSQL;

public class Main {
      public static void main(String[] args) {

        MotorSQL motor = MotorFactory.create(MotorFactory.POSTGRE);
        motor.connect();

        MuestraADNDAOImpl dao = new MuestraADNDAOImpl(motor);

        System.out.println("--INICIANDO TEST--");

        // TEST 1
        System.out.println("TEST 1");
        MuestrasADN muestrasADN = new MuestrasADN(1, 2, null, null);

        muestrasADN.setId(1);
        muestrasADN.setCodigo(11110);
        muestrasADN.setTipo(null);
        muestrasADN.setFechaExtraccion(null);

        Laboratorio laboratorio = new Laboratorio(0, null, null);
        laboratorio.setId(0);
        muestrasADN.setLaboratorio(laboratorio);
        dao.add(muestrasADN);

        //TEST 2
        System.out.println("TEST 2 UPDATE");
        MuestrasADN muestraUpdate = dao.findById(1);
        muestraUpdate.setTipo("SALIVA");
        dao.update(muestraUpdate);

        //Test 3

        System.out.println("TEST 3");

        MuestrasADN encontrada = dao.findById(1);

        System.out.println(encontrada);
        

        //TEST 4

        System.out.println("TEST 4  FIND ALL");

        List<MuestrasADN> lista = dao.findAll();

        for (MuestrasADN m : lista) {
            System.out.println(m);
}

     



        motor.disconnect();
        System.out.println("--- TESTS FINALIZADOS ---");
    }


}
