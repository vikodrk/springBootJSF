package mx.com.eon.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mx.com.eon.model.UserType;

@Repository
public interface IUserTypeDAO {
	
	List<UserType> findAll();
	
	UserType findById(Long id);

}
