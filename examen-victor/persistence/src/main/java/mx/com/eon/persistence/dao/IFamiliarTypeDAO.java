package mx.com.eon.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mx.com.eon.model.FamiliarType;

@Repository
public interface IFamiliarTypeDAO {
	
	List<FamiliarType> findAll();
	
	FamiliarType findById(Long id);

}
