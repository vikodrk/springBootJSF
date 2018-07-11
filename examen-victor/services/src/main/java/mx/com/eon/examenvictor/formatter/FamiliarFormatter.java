package mx.com.eon.examenvictor.formatter;

import mx.com.eon.api.enums.FamiliarEnum;
import mx.com.eon.model.FamiliarType;
import mx.com.eon.persistence.dao.IFamiliarTypeDAO;

public final class FamiliarFormatter {
	
	private FamiliarFormatter() {
		
	}
	
	public static FamiliarEnum toDto(FamiliarType entity) {
		return FamiliarEnum.enumFromId(entity.getId());
	}
	
	public static FamiliarType toEntity(FamiliarEnum enumFam, IFamiliarTypeDAO dao) {
		return dao.findById(enumFam.getId());
	}

}
