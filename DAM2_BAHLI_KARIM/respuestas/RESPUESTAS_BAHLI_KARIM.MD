PREGUNTA 1
Explica cómo funciona la relación 1:N entre Laboratorio y MuestraADN tanto en SQL como en Java.

En SQL la relación 1:N se establece mediante una Foreign Key  en la tabla MUESTRAS ADN que referencia a la Primary Key de LABORATORIOS
Y en Java se refleja mediante la composición de objetos (private Laboratorio laboratorio;) la clase MUESTRAS_ADN tiene que tener una instancia completa de la clase LABORATORIOS 


PREGUNTA 2
Explica por qué en Java utilizamos:

private Laboratorio laboratorio;
y no:
private int laboratorioId;

Se usa por que el patrón DAO abstrae la persistencia de datos SQL de la parte de Java
Si utilizáramos un int laboratorioId, devolvemos un modelo de datos relacional. Al inyectar el objeto permitimos que el resto de la aplicación navegue por los metodos ya creados sin tener que realizar nuevas consultas a la base de datos


PREGUNTA 3
Explica qué ventaja aporta PreparedStatement frente a concatenar SQL manualmente.

Precompila la consulta SQL en el motor de base de datos antes de ejecutarlo lo cual mejora significativamente el rendimiento en consultas repetitivas y además evitamos ataques de Inyección SQL