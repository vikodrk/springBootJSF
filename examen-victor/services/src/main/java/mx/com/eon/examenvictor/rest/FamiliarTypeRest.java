package mx.com.eon.examenvictor.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.com.eon.api.enums.FamiliarEnum;
import mx.com.eon.examenvictor.service.IFamiliarTypeService;

@RestController
public class FamiliarTypeRest {
	
	@Autowired
	IFamiliarTypeService service;
	
	@RequestMapping(method=RequestMethod.GET, value="/services/familiarType/all")
	public ResponseEntity<Object> findAll(){
		ResponseEntity<Object> response = null;
		List<FamiliarEnum> result = service.getAll();
		response = new ResponseEntity<Object>(result, HttpStatus.OK);
		return response;
	}

}
