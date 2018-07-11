package mx.com.eon.examenvictor.formatter;

import mx.com.eon.api.enums.UserTypeEnum;
import mx.com.eon.model.UserType;
import mx.com.eon.persistence.dao.IUserTypeDAO;

public final class UserTypeFormatter {
	
	private UserTypeFormatter() {
		
	}
	
	public static UserTypeEnum toEnum(UserType entity) {
		return UserTypeEnum.enumFromId(entity.getId());
	}
	
	public static UserType toEntity(UserTypeEnum dto, IUserTypeDAO dao) {
		return dao.findById((long)dto.getId());
	}
	

}
