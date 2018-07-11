package mx.com.eon.examenvictor.formatter;

import mx.com.eon.api.dto.BaseDTO;
import mx.com.eon.api.dto.FamiliarDTO;
import mx.com.eon.api.dto.WorkPartnerDTO;
import mx.com.eon.api.enums.FamiliarEnum;
import mx.com.eon.api.enums.UserTypeEnum;
import mx.com.eon.model.GeneralDataDO;
import mx.com.eon.persistence.dao.IFamiliarTypeDAO;
import mx.com.eon.persistence.dao.IUserTypeDAO;

public final class GeneralDataFormatter {
	
	private GeneralDataFormatter() {
		
	}
	
	public static GeneralDataDO toEntity(FamiliarDTO dto, IFamiliarTypeDAO dao,IUserTypeDAO typeDao) {
		GeneralDataDO entity = new GeneralDataDO();
		
		entity.setAddress(dto.getAddress());
		entity.setFamiliar(FamiliarFormatter.toEntity(dto.getType(), dao));
		entity.setFirstName(dto.getFirstName());
		entity.setId(dto.getId());
		entity.setLastName(dto.getLastName());
		entity.setName(dto.getName());
		entity.setPhoneNumber(dto.getPhone());
		entity.setUser(UserTypeFormatter.toEntity(UserTypeEnum.FAMILIAR, typeDao));
		
		return entity;
	}
	
	public static GeneralDataDO toEntity(WorkPartnerDTO dto, IUserTypeDAO typeDao) {
		GeneralDataDO entity = new GeneralDataDO();
		
		entity.setAddress(dto.getAddress());
		entity.setFirstName(dto.getFirstName());
		entity.setId(dto.getId());
		entity.setLastName(dto.getLastName());
		entity.setName(dto.getName());
		entity.setPhoneNumber(dto.getPhone());
		
		entity.setArea(dto.getArea());
		entity.setCompany(dto.getCompany());
		entity.setRub(dto.getRub());
		
		entity.setUser(UserTypeFormatter.toEntity(UserTypeEnum.WORK_PARTNER, typeDao));
		
		return entity;
	}
	
	public static BaseDTO toDto(GeneralDataDO entity) {
		BaseDTO dto = null;
		
		UserTypeEnum type = UserTypeEnum.enumFromId(entity.getUser().getId());
		switch(type) {
		case FAMILIAR:
			
			dto = new FamiliarDTO();
			((FamiliarDTO) dto).setAddress(entity.getAddress());
			((FamiliarDTO) dto).setFirstName(entity.getFirstName());
			((FamiliarDTO) dto).setId(entity.getId());
			((FamiliarDTO) dto).setLastName(entity.getLastName());
			((FamiliarDTO) dto).setName(entity.getName());
			((FamiliarDTO) dto).setPhone(entity.getPhoneNumber());
			
			((FamiliarDTO) dto).setType(FamiliarEnum.enumFromId(entity.getFamiliar().getId()));
			((FamiliarDTO) dto).setUserType(type);
			
			break;
			
		case WORK_PARTNER:
			
			dto = new WorkPartnerDTO();
			
			((WorkPartnerDTO) dto).setAddress(entity.getAddress());
			((WorkPartnerDTO) dto).setArea(entity.getArea());
			((WorkPartnerDTO) dto).setCompany(entity.getCompany());
			((WorkPartnerDTO) dto).setFirstName(entity.getFirstName());
			((WorkPartnerDTO) dto).setId(entity.getId());
			((WorkPartnerDTO) dto).setLastName(entity.getLastName());
			((WorkPartnerDTO) dto).setName(entity.getName());
			((WorkPartnerDTO) dto).setPhone(entity.getPhoneNumber());
			((WorkPartnerDTO) dto).setRub(entity.getRub());
			
			((WorkPartnerDTO) dto).setUserType(type);
			
			break;
		}
		
		return dto;
	}

}
