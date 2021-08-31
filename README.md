# challenge
Wenance challenge

La aplicacion esta hecha en springboot con webflux y maven

#Ejecutar aplicacion en entorno local

#Con maven instalado
-Clonar repositorio
-Ejecutar el siguinte comando en la consola: mvn clean install
-Se creara una carpeta target, en la misma esta el jar a ejecutar: java -jar challenge-0.0.1.jar

#Sin maven
- Clonar el tag ejecutar, en la misma se encuentra el archivo jar a ejecutar: java -jar challenge-0.0.1.jar


##Tareas
1- Obtener el precio del Bitcoin en cierto Timestamp
    
    Las pruebas las realizo desde postman -> http://localhost/api/price/{timeStamp}


2. Conocer el promedio de valor entre dos Timestamps así como la diferencia porcentual entre 
ese valor promedio y el valor máximo almacenado para toda la serie temporal disponible
      
    Las pruebas las realizo desde postman -> http://localhost/api/pricedata/{time1}/{time2}
    
    
