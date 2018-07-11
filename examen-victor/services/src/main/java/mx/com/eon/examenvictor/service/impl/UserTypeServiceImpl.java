package mx.com.eon.examenvictor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.eon.api.enums.UserTypeEnum;
import mx.com.eon.examenvictor.formatter.UserTypeFormatter;
import mx.com.eon.examenvictor.service.IUserTypeService;
import mx.com.eon.model.UserType;
import mx.com.eon.persistence.dao.IUserTypeDAO;

public class UserTypeServiceImpl implements IUserTypeService {
	
	@Autowired
	IUserTypeDAO dao;

	@Override
	public List<UserTypeEnum> findAll() {
		
		List<UserType> list = dao.findAll();
		List<UserTypeEnum> result = new ArrayList<>();
		list.forEach(e -> result.add(UserTypeFormatter.toEnum(e)));
		
		return result;
	}

	@Override
	public UserTypeEnum findById(long id) {
		return UserTypeEnum.enumFromId(dao.findById(id).getId());
	}

}
