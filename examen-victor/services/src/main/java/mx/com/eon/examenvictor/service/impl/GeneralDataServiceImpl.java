package mx.com.eon.examenvictor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.eon.api.dto.BaseDTO;
import mx.com.eon.api.dto.FamiliarDTO;
import mx.com.eon.api.dto.WorkPartnerDTO;
import mx.com.eon.api.enums.UserTypeEnum;
import mx.com.eon.examenvictor.formatter.GeneralDataFormatter;
import mx.com.eon.examenvictor.service.IGeneralDataService;
import mx.com.eon.model.GeneralDataDO;
import mx.com.eon.persistence.dao.IFamiliarTypeDAO;
import mx.com.eon.persistence.dao.IGeneralDataDAO;
import mx.com.eon.persistence.dao.IUserTypeDAO;

public class GeneralDataServiceImpl implements IGeneralDataService {
	
	@Autowired
	IGeneralDataDAO dao;
	
	@Autowired
	IUserTypeDAO typeDao;
	
	@Autowired
	IFamiliarTypeDAO familiarDao;

	@Override
	public void saveData(BaseDTO entity) {
		GeneralDataDO result = entity.getClass()==FamiliarDTO.class?
				GeneralDataFormatter.toEntity((FamiliarDTO)entity, familiarDao, typeDao):
					GeneralDataFormatter.toEntity((WorkPartnerDTO)entity, typeDao);
		dao.saveData(result);
	}

	@Override
	public void deleteData(Long id) {
		dao.deleteData(id);
	}

	@Override
	public void updateData(BaseDTO entity) {
		GeneralDataDO result = entity.getClass()==FamiliarDTO.class?
				GeneralDataFormatter.toEntity((FamiliarDTO)entity, familiarDao, typeDao):
					GeneralDataFormatter.toEntity((WorkPartnerDTO)entity, typeDao);
		dao.updateData(result);
	}

	@Override
	public List<FamiliarDTO> getFamiliars(String name) {
		List<GeneralDataDO> list = dao.findByExample("%"+name.trim().toUpperCase()+"%", UserTypeEnum.FAMILIAR.getId());
		List<FamiliarDTO> result = new ArrayList<>();
		
		list.forEach(e->result.add((FamiliarDTO)GeneralDataFormatter.toDto(e)));
		
		return result;
	}

	@Override
	public List<WorkPartnerDTO> getWorkPartners(String name) {
		List<GeneralDataDO> list = dao.findByExample("%"+name.trim().toUpperCase()+"%", UserTypeEnum.WORK_PARTNER.getId());
		List<WorkPartnerDTO> result = new ArrayList<>();
		
		list.forEach(e->result.add((WorkPartnerDTO)GeneralDataFormatter.toDto(e)));
		
		return result;
	}

}
