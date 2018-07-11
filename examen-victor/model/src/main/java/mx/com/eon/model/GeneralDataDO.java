package mx.com.eon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "GENERAL_DATA")
public class GeneralDataDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6665020280574259003L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_GENERAL_DATA")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="PHONE_NUMER")
	private String phoneNumber;
	
	@Column(name="ADDRESS")
	private String address;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FAMILIAR_TYPE_FK")
	private FamiliarType familiar;

	@Column(name="COMPANY")
	private String company;
	
	@Column(name="AREA")
	private String area;
	
	@Column(name="RUB")
	private String rub;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_TYPE_ID_USER_TYPE")
	private UserType user;

	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if (obj != null) {
			if (obj == this) {
				flag = true;
			} else if (obj.getClass() == this.getClass()) {
				flag = new EqualsBuilder().append(id, ((GeneralDataDO) obj).id).isEquals();
			}
		}
		return flag;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).toHashCode();
	}

}
