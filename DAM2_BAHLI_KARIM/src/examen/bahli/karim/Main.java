package examen.bahli.karim;

import java.util.ArrayList;
import java.util.List;

import examen.bahli.karim.beans.Laboratorio;
import examen.bahli.karim.beans.MuestrasADN;
import examen.bahli.karim.dao.MuestraADNDAOImpl;
import examen.bahli.karim.motores.MotorFactory;
import examen.bahli.karim.motores.MotorSQL;

public class Main {
      public static void main(String[] args) {

        MotorSQL motor = MotorFactory.create(MotorFactory.POSTGRE);

        MuestraADNDAOImpl dao = new MuestraADNDAOImpl(motor);

        System.out.println("--INICIANDO TEST--");

        // TEST 1 - ADD
        System.out.println("\nTEST 1 - ADD MUESTRA ADN");
        MuestrasADN muestrasADN = new MuestrasADN();
        muestrasADN.setCodigo("ADN001");
        muestrasADN.setTipo("SALIVA");
        muestrasADN.setFechaExtraccion(java.sql.Date.valueOf("2026-06-01"));

        Laboratorio laboratorio = new Laboratorio(1, null, null);
        muestrasADN.setLaboratorio(laboratorio);
        dao.add(muestrasADN);

        //TEST 2 - UPDATE
        System.out.println("\nTEST 2 - UPDATE MUESTRA ADN");
        MuestrasADN muestraUpdate = dao.find(1);
        if (muestraUpdate != null) {
            muestraUpdate.setTipo("SANGRE");
            dao.update(1, muestraUpdate);
        }

        //TEST 3 - FIND
        System.out.println("\nTEST 3 - FIND MUESTRA ADN");
        MuestrasADN encontrada = dao.find(1);
        if (encontrada != null) {
            System.out.println(encontrada);
        }

        //TEST 4 - FIND ALL
        System.out.println("\nTEST 4 - FIND ALL MUESTRAS ADN");
        List<MuestrasADN> lista = dao.findAll();
        for (MuestrasADN m : lista) {
            System.out.println(m);
        }

        // TEST 5 - FIND MUESTRAS_ADN BY AGENCIA (LABORATORIO)
        System.out.println("\nTEST 5 - FIND MUESTRAS_ADN BY LABORATORIO (ID = 1)");
        List<MuestrasADN> muestrasLab = dao.findByLaboratorio(1);
        for (MuestrasADN m : muestrasLab) {
          System.out.println(m);
        }

      // TEST 6 - FIND MUESTRA WITH ANALISIS (Consulta Obligatoria: MUESTRAS_CRITICAS)
        System.out.println("\nTEST 6 - MUESTRAS CRITICAS (INNER JOIN COMPLETO)");
        List<MuestrasADN> muestrasCriticas = dao.muestrasCriticas();

        if(muestrasCriticas.isEmpty()) {
          System.out.println("No se han encontrado muestras críticas con los criterios exigidos.");
        } else {
          for (MuestrasADN m : muestrasCriticas) {
            System.out.println("MUESTRA: " + m.getCodigo() + " | Tipo: " + m.getTipo());

            // Sacamos los datos del objeto Laboratorio inyectado
            System.out.println("  -> PROCEDENCIA: " + m.getLaboratorio().getNombre() + " (" + m.getLaboratorio().getPais() + ")");

            // Sacamos los datos del objeto Analisis inyectado
            System.out.println("  -> RESULTADO ANALISIS: ");
            System.out.println("       - Mutación detectada: " + m.getAnalisis().getMutacionDetectada());
            System.out.println("       - Coincidencia: " + m.getAnalisis().getPorcentajeCoincidencia() + "%");

          }
        }

        motor.disconnect();
        System.out.println("\n--- TESTS FINALIZADOS ---");
    }


}
