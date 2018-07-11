package mx.com.eon.examenvictor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.com.eon.api.enums.UserTypeEnum;

@Service
public interface IUserTypeService {
	
	List<UserTypeEnum> findAll();
	
	UserTypeEnum findById(long id);

}
