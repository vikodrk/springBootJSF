package mx.com.eon.api.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;
import mx.com.eon.api.enums.UserTypeEnum;

@Getter
@Setter
public abstract class BaseDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1916889969040734571L;
	protected Long id;
	private String name;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private UserTypeEnum userType;

	public abstract boolean equals(Object obj);
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}
}
