package mx.com.eon.persistence.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.eon.model.UserType;
import mx.com.eon.persistence.dao.IUserTypeDAO;
import mx.com.eon.persistence.repository.IUserTypeRepository;

public class UserTypeDAOImpl implements IUserTypeDAO {
	
	@Autowired
	IUserTypeRepository repo;

	@Override
	public List<UserType> findAll() {
		return repo.findAll();
	}

	@Override
	public UserType findById(Long id) {
		return repo.getOne(id);
	}

}
