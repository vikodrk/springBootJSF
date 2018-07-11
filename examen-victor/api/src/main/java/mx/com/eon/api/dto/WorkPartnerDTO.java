package mx.com.eon.api.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mx.com.eon.api.enums.UserTypeEnum;

@ToString
@Getter
@Setter
public class WorkPartnerDTO extends BaseDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2211999568938481745L;
	private String company;
	private String area;
	private String rub;
	
	public WorkPartnerDTO() {
		setUserType(UserTypeEnum.WORK_PARTNER);
	}

	@Override
	public boolean equals(Object obj) {
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
