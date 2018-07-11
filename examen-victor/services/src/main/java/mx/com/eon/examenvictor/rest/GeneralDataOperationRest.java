package mx.com.eon.examenvictor.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import mx.com.eon.examenvictor.exception.GeneralException;
import mx.com.eon.examenvictor.service.IGeneralDataService;

@RestController
public class GeneralDataOperationRest {
	
	private static final Logger LOG = LoggerFactory.getLogger(GeneralDataOperationRest.class);
	
	@Autowired
	IGeneralDataService service;
	
	@RequestMapping(method=RequestMethod.DELETE,value="/data/delete/{id}")
	@HystrixCommand(fallbackMethod="eliminarFallback")
	public ResponseEntity<String> eliminar(@PathVariable(name="id",required=true) Long id){
		
		ResponseEntity<String> response = null;
		LOG.info("Eliminado registro:"+id);
		try {
		service.deleteData(id);
		response = new ResponseEntity<String>("Se elimino correctamente.", HttpStatus.OK);
		}
		catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new GeneralException("Error al eliminar registro:" + id, e);
		}
		
		return response;
	}
	
	public ResponseEntity<String> eliminarFallback(Long id){
		
		ResponseEntity<String> response = null;
		
		response = new ResponseEntity<String>("Ocurrio un error al eliminar elemento con id: "+id, HttpStatus.FORBIDDEN);
		
		return response;
	}

}
