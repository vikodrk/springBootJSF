package mx.com.eon.examenvictor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.com.eon.api.dto.BaseDTO;
import mx.com.eon.api.dto.FamiliarDTO;
import mx.com.eon.api.dto.WorkPartnerDTO;

@Service
public interface IGeneralDataService {
	
	void saveData(BaseDTO entity);
	
	void deleteData(Long id);
	
	void updateData(BaseDTO entity);
	
	List<FamiliarDTO> getFamiliars(String name);
	
	List<WorkPartnerDTO> getWorkPartners(String name);

}
