package mx.com.eon.examenvictor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.com.eon.api.enums.FamiliarEnum;

@Service
public interface IFamiliarTypeService {
	
	List<FamiliarEnum> getAll();
	
	FamiliarEnum findById(long id);

}
