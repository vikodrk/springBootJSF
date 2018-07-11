package mx.com.eon.api.enums;

public enum FamiliarEnum {

	FRIEND(1, "Amigo"), FAMILIAR(2, "Familiar");

	private long id;
	private String description;

	private FamiliarEnum(long id, String description) {
		this.id = id;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public static FamiliarEnum enumFromId(long id) {
		int op = (int) id;
		FamiliarEnum enumValue = null;
		switch (op) {
		case 1:
			enumValue = FamiliarEnum.FRIEND;
			break;
		case 2:
			enumValue = FamiliarEnum.FAMILIAR;
			break;

		}
		return enumValue;
	}

}
