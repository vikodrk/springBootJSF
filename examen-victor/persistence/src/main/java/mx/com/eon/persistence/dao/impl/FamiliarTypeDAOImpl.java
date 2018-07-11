package mx.com.eon.persistence.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.eon.model.FamiliarType;
import mx.com.eon.persistence.dao.IFamiliarTypeDAO;
import mx.com.eon.persistence.repository.IFamiliaryTypeRepository;

public class FamiliarTypeDAOImpl implements IFamiliarTypeDAO {
	
	@Autowired
	IFamiliaryTypeRepository repo;

	@Override
	public List<FamiliarType> findAll() {
		return repo.findAll();
	}

	@Override
	public FamiliarType findById(Long id) {
		return repo.getOne(id);
	}

}
