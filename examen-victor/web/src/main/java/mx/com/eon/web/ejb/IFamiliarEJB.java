package mx.com.eon.web.ejb;

import java.util.List;

import javax.ejb.Local;

import mx.com.eon.api.dto.FamiliarDTO;
import mx.com.eon.api.enums.FamiliarEnum;

@Local
public interface IFamiliarEJB extends IBaseEJB<FamiliarDTO> {
	
	List<FamiliarEnum> familiarTypeList();

}
