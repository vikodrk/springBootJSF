package mx.com.eon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
@Table(name="FAMILIAR_TYPE")
public class FamiliarType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5100616698135706028L;

	@Id
	@Column(name="ID_FAMILIAR_TYPE")
	private Long id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if(obj!=null) {
			if(obj==this) {
				flag = true;
			}
			else if(obj.getClass()==this.getClass()) {
				flag = new EqualsBuilder().append(id, ((FamiliarType) obj).id).isEquals();
			}
		}
		return flag;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

}
