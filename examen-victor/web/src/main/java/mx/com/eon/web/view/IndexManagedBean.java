package mx.com.eon.web.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import mx.com.eon.api.dto.FamiliarDTO;
import mx.com.eon.api.dto.WorkPartnerDTO;
import mx.com.eon.api.enums.UserTypeEnum;
import mx.com.eon.web.ejb.IFamiliarEJB;
import mx.com.eon.web.ejb.IWorkEJB;

@ManagedBean(name = "helloBean")
@javax.faces.bean.ViewScoped
public class IndexManagedBean extends AbstractBaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7605860903144867148L;

	private static final Logger LOG = Logger.getLogger("Index Form");

	@EJB
	private IFamiliarEJB familiarEJB;

	@EJB
	private IWorkEJB workEJB;

	private String name;

	private List<UserTypeEnum> userTypeList;
	private List<FamiliarDTO> familiarList;
	private List<WorkPartnerDTO> workList;

	private Long userType;

	private boolean familiarTable;

	@PostConstruct
	public void init() {

		familiarTable = false;

		removeObjectFromSession("workPartnerTmp");
		removeObjectFromSession("familiarTmp");

		userTypeList = new ArrayList<>();
		userTypeList.add(UserTypeEnum.FAMILIAR);
		userTypeList.add(UserTypeEnum.WORK_PARTNER);

		familiarList = new ArrayList<>();
		workList = new ArrayList<>();
	}

	public void find() {

		UserTypeEnum userType = UserTypeEnum.enumFromId(this.userType);

		LOG.info("Haciendo busqueda por " + userType.getDescription());

		switch (userType) {
		case FAMILIAR:
			familiarList = familiarEJB.findByName(name);
			familiarTable = true;
			break;
		case WORK_PARTNER:
			workList = workEJB.findByName(name);
			familiarTable = false;
			break;

		}
	}

	public void newRecord() {
		UserTypeEnum userType = UserTypeEnum.enumFromId(this.userType);

		LOG.info("Se hara registro por " + userType.getDescription());
		if(userType.equals(UserTypeEnum.FAMILIAR)) {

			signUpFamiliar();
		}
		else {
			signUpWorkPartner();
		}
	}

	public void signUpFamiliar() {
		try {
			redirect("familiarForm");
		} catch (IOException e) {
			LOG.throwing("arg0", "arg1", e);
			sendMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
		}
	}

	public void signUpWorkPartner() {
		try {
			redirect("workPartnerForm");
		} catch (IOException e) {
			LOG.throwing("arg0", "arg1", e);
			sendMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
		}
	}

	public void deleteFamiliar(Long id) {
		familiarEJB.delete(id);
		familiarList = familiarEJB.findByName(name);
		sendMessage(FacesMessage.SEVERITY_WARN, "Eliminacion Exitosa", "Se elimino el Familiar.");
	}

	public void deleteWorkPartner(Long id) {
		workEJB.delete(id);
		workList = workEJB.findByName(name);
		sendMessage(FacesMessage.SEVERITY_WARN, "Eliminacion Exitosa", "Se elimino el Companiero de Trabajo.");
	}

	public void updateFamiliar(FamiliarDTO dto) {
		setObjectToSession("familiarTmp", dto);
		signUpFamiliar();
	}

	public void updateWorkPartner(WorkPartnerDTO dto) {
		setObjectToSession("workPartnerTmp", dto);
		signUpWorkPartner();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserTypeEnum> getUserTypeList() {
		return userTypeList;
	}

	public void setUserTypeList(List<UserTypeEnum> userTypeList) {
		this.userTypeList = userTypeList;
	}

	public List<FamiliarDTO> getFamiliarList() {
		return familiarList;
	}

	public void setFamiliarList(List<FamiliarDTO> familiarList) {
		this.familiarList = familiarList;
	}

	public List<WorkPartnerDTO> getWorkList() {
		return workList;
	}

	public void setWorkList(List<WorkPartnerDTO> workList) {
		this.workList = workList;
	}

	public Long getUserType() {
		return userType;
	}

	public void setUserType(Long userType) {
		this.userType = userType;
	}

	public boolean isFamiliarTable() {
		return familiarTable;
	}

	public void setFamiliarTable(boolean familiarTable) {
		this.familiarTable = familiarTable;
	}

}
