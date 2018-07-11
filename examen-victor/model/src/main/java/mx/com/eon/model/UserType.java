package mx.com.eon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name="USER_TYPE")
public class UserType {
	
	@Id
	@Column(name="ID_USER_TYPE")
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
				flag = new EqualsBuilder().append(id, ((UserType) obj).id).isEquals();
			}
		}
		return flag;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

}
