package mx.com.eon.web.view.workPartner;

import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import mx.com.eon.api.dto.WorkPartnerDTO;
import mx.com.eon.api.enums.UserTypeEnum;
import mx.com.eon.web.ejb.IWorkEJB;
import mx.com.eon.web.view.AbstractBaseBean;

@ManagedBean(name="workForm")
@ViewScoped
public class WorkPartnerFormBean extends AbstractBaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6896743841600336575L;

	private static final Logger LOG = Logger.getLogger("Work Form Bean");
	
	@EJB
	private IWorkEJB workEJB;

	private String name;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String company;
	private String area;
	private String rub;

	private boolean isNew;

	@PostConstruct
	public void init() {

		Object tmp = objectFromSession("workPartnerTmp");
		if (tmp != null) {
			isNew = false;
			LOG.info("Precargando formulario...");
			WorkPartnerDTO dto = (WorkPartnerDTO)tmp;
			name=dto.getName();
			firstName=dto.getFirstName();
			lastName=dto.getLastName();
			phone=dto.getPhone();
			address=dto.getAddress();
			company=dto.getCompany();
			area=dto.getArea();
			rub=dto.getRub();
		} else {
			isNew = true;
			LOG.info("Formulario Nuevo...");
		}

	}

	public void save() throws IOException {
		if (isNew) {
			LOG.info("Guardando Nuevo Registro...");
			workEJB.save(buildDTO());
			sendMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se guardo exitosamente el registro");
		} else {
			LOG.info("Actualizando Registro...");
			workEJB.update(buildDTO());
			sendMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se actualizo exitosamente el registro");
		}
		redirectToHome();
	}
	
private WorkPartnerDTO buildDTO() {
		
		WorkPartnerDTO dto = null;
		
		dto = isNew?new WorkPartnerDTO():(WorkPartnerDTO)objectFromSession("workPartnerTmp");
		
		dto.setAddress(address);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setName(name);
		dto.setPhone(phone);
		dto.setArea(area);
		dto.setCompany(company);
		dto.setRub(rub);
		dto.setUserType(UserTypeEnum.WORK_PARTNER);
		
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRub() {
		return rub;
	}

	public void setRub(String rub) {
		this.rub = rub;
	}

}
