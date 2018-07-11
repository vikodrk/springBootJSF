package mx.com.eon.web.view.familiar;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mx.com.eon.api.dto.FamiliarDTO;
import mx.com.eon.api.enums.FamiliarEnum;
import mx.com.eon.api.enums.UserTypeEnum;
import mx.com.eon.web.ejb.IFamiliarEJB;
import mx.com.eon.web.view.AbstractBaseBean;

@ManagedBean(name = "familiarForm")
@ViewScoped
public class SaveFormBean extends AbstractBaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4439446615334459571L;

	private static final Logger LOG = Logger.getLogger("Familiar Bean");
	
	@EJB
	private IFamiliarEJB familiarEJB;

	private String name;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private List<FamiliarEnum> typeList;
	private Long type;
	private boolean isNew;

	@PostConstruct
	public void init() {

		Object tmp = objectFromSession("familiarTmp");
		typeList = familiarEJB.familiarTypeList();
		
		if (tmp != null) {
			LOG.info("Precargando formulario...");
			isNew = false;
			FamiliarDTO dto = (FamiliarDTO)tmp;
			name=dto.getName();
			firstName=dto.getFirstName();
			lastName=dto.getLastName();
			phone=dto.getPhone();
			address=dto.getAddress();
			type=dto.getType().getId();
		} else {
			LOG.info("Formulario vacio...");
			isNew = true;
		}

	}
	
	public void save() throws IOException {
		LOG.info("Guardando informacion...");
		if(isNew) {
			LOG.info("Nuevo Registro.");
			familiarEJB.save(buildDTO());
			sendMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se guardo exitosamente el registro");
		}
		else {
			LOG.info("Actualizando Registro.");
			familiarEJB.update(buildDTO());
			sendMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se actualizo exitosamente el registro");	
		}
		redirectToHome();
	}
	
	private FamiliarDTO buildDTO() {
		
		FamiliarDTO dto = null;
		
		dto = isNew?new FamiliarDTO():(FamiliarDTO)objectFromSession("familiarTmp");
		
		dto.setAddress(address);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setName(name);
		dto.setPhone(phone);
		dto.setType(FamiliarEnum.enumFromId(this.type));
		dto.setUserType(UserTypeEnum.FAMILIAR);
		
		return dto;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<FamiliarEnum> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<FamiliarEnum> typeList) {
		this.typeList = typeList;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

}
