package mx.com.eon.api.enums;

public enum UserTypeEnum {
	
	FAMILIAR(1l,"Familiares") , WORK_PARTNER(2l,"Companieros de Trabajo");
	
	private Long id;
	private String description;
	
	private UserTypeEnum(Long id, String description) {
		this.id=id;
		this.description=description;
	}
	
	public Long getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	
	public static UserTypeEnum enumFromId(long id) {
		
		UserTypeEnum type = null;
		int op = (int)id;
		
		switch(op) {
		case 1:
			type = FAMILIAR;
			break;
		case 2:
			type = WORK_PARTNER;
			break;
		}
		
		return type;
		
	}

}
