# challenge
Wenance challenge

La aplicacion esta hecha en springboot con webflux y maven, utilizo el @Shedulle

#Ejecutar aplicacion en entorno local

#Con maven instalado
    - Clonar repositorio
    - Ejecutar el siguinte comando en la consola: mvn clean install
    - Se creara una carpeta target, en la misma esta el jar a ejecutar: java -jar challenge-0.0.1.jar

#Sin maven
    - Clonar el tag ejecutar, en la misma se encuentra el archivo jar a ejecutar: java -jar challenge-0.0.1.jar


##Tareas
    1. Obtener el precio del Bitcoin en cierto Timestamp
    
        Las pruebas las realizo desde postman -> http://localhost/api/price/{timeStamp}
        
        Respuesta:
        {
            "lprice": 47848.6,
            "curr1": "BTC",
            "curr2": "USD",
            "date": "2021-08-31T10:58:13.2375436"
        }
        
        Solucion: devuelvo el dato que obtengo luego de filtrar por el timeStamp 


    2. Conocer el promedio de valor entre dos Timestamps así como la diferencia porcentual entre 
    ese valor promedio y el valor máximo almacenado para toda la serie temporal disponible
      
        Las pruebas las realizo desde postman -> http://localhost/api/pricedata/{time1}/{time2}
        
        Respuesta: Valor promedio: 47852.55 Porcentaje de diferencia con el valor mas alto: 0.0351999398400
    
        Solucion: obtengo los datos que obtengo de los timeStamp consultados, obtengo el valor promedio de estos dos datos con la funcion average()
                  luego busco el valor maximo de toda la coleccion obtenida de la consulta al servicio REST y por ultimo calculo el porcentage de diferencia de las mismas                           utilizando la libreria java.math.*
    
   
Trate de utilizar todo lo que podia demostrar con streams, con la clase Mono, y para sumar Weblcient. 
Utilizo la clase LocalDateTime porque lo vengo utilizando en mis aplicaciones REST con angular y es la que mejor me funciono hasta ahora para poder filtrar o generar rangos de tiempo
Para que las llamadas recurrentes utilice @Scheduled en la clase TaskComponent
