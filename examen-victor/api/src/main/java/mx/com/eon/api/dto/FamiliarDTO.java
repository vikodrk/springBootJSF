package mx.com.eon.api.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mx.com.eon.api.enums.FamiliarEnum;
import mx.com.eon.api.enums.UserTypeEnum;

@ToString
@Getter
@Setter
public class FamiliarDTO extends BaseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3860277480533576795L;
	
	private FamiliarEnum type;
	
	public FamiliarDTO() {
		setUserType(UserTypeEnum.FAMILIAR);
	}

	@Override
	public boolean equals(Object obj){
		boolean flag = false;
		if(obj!=null) {
			if (obj==this) {
				flag = true;
			}
			else if(obj.getClass()==this.getClass()) {
				flag = new EqualsBuilder().append(id,  ((BaseDTO)obj).id).isEquals();
			}
		}
		return flag;
	}
	
}
