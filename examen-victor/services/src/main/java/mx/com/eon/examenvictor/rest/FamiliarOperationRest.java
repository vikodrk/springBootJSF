package mx.com.eon.examenvictor.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import mx.com.eon.api.dto.FamiliarDTO;
import mx.com.eon.examenvictor.exception.GeneralException;
import mx.com.eon.examenvictor.service.IGeneralDataService;

@RestController
public class FamiliarOperationRest {

	private static final Logger LOG = LoggerFactory.getLogger(FamiliarOperationRest.class);

	@Autowired
	IGeneralDataService service;

	@RequestMapping(method = RequestMethod.POST, value = "/data/familiar/save")
	@HystrixCommand(fallbackMethod = "generalFallBack")
	public ResponseEntity<String> saveFamiliar(@RequestBody FamiliarDTO dto) {
		ResponseEntity<String> response = null;
		LOG.info("Guardando informacion de: "+dto);
		try {
			service.saveData(dto);
			response = new ResponseEntity<String>("Se creo el registro: " + dto, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new GeneralException("Error al crear registro:" + dto, e);
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/data/familiar/update")
	@HystrixCommand(fallbackMethod = "generalFallBack")
	public ResponseEntity<String> updateFamiliar(@RequestBody FamiliarDTO dto) {
		ResponseEntity<String> response = null;
		LOG.info("Actualizando informacion de: "+dto);
		try {
			service.updateData(dto);
			response = new ResponseEntity<String>("Se actualizo el registro: " + dto, HttpStatus.OK);

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new GeneralException("Error al actualizar registro:" + dto, e);
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/data/familiar/get/{name}")
	@HystrixCommand(fallbackMethod = "generalFallBack")
	public ResponseEntity<List<FamiliarDTO>> obtainFamiliars(
			@PathVariable(name = "name", required = true) String name) {
		ResponseEntity<List<FamiliarDTO>> response = null;
		LOG.info("Buscando informacion por: "+name);
		try {
		List<FamiliarDTO> result = service.getFamiliars(name);
		response = new ResponseEntity<List<FamiliarDTO>>(result, HttpStatus.OK);
		}
		catch(Exception e) {
			LOG.error(e.getMessage(), e);
			throw new GeneralException("Error al buscar registros por:"+name, e);
		}
		return response;
	}

	public ResponseEntity<String> generalFallBack(FamiliarDTO dto) {
		ResponseEntity<String> response = null;
		response = new ResponseEntity<String>("Ocurrio un error al actualizar/guardar la entidad:" + dto,
				HttpStatus.FORBIDDEN);
		return response;
	}
	
	public ResponseEntity<List<FamiliarDTO>> generalFallBack(String name) {
		ResponseEntity<List<FamiliarDTO>> response = null;
		response = new ResponseEntity<List<FamiliarDTO>>(new ArrayList<>(),
				HttpStatus.FORBIDDEN);
		return response;
	}

}
