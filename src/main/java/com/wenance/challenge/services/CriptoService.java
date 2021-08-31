package com.wenance.challenge.services;

import com.wenance.challenge.models.Cripto;

import reactor.core.publisher.Mono;

/**  
 * Servicio que realiza las llamadas a la api para almacenar los datos en memoria
 * @author RS
 */
public interface CriptoService {

	/**  
	 * inicializacion del proyecto
	 */
	public void task();

	
	/**  
	 * Obtener el precio del Bitcoin en cierto Timestamp
	 */
	public Mono<Cripto> findByTimeStamp(String timeStamp);

	
	/**  
	 *  el promedio de valor entre dos Timestamps así como la diferencia porcentual entre 
     *  ese valor promedio y el valor máximo almacenado
	 */
	public Mono<String> averageValuesByTimestamps(String time1, String time2);

}
