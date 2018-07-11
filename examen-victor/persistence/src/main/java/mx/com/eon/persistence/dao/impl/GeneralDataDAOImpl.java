package mx.com.eon.persistence.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.eon.model.GeneralDataDO;
import mx.com.eon.persistence.dao.IGeneralDataDAO;
import mx.com.eon.persistence.repository.IGeneralDataRepository;

public class GeneralDataDAOImpl implements IGeneralDataDAO {
	
	@Autowired
	IGeneralDataRepository repo;

	@Override
	public void saveData(GeneralDataDO entity) {
		repo.save(entity);
	}

	@Override
	public void updateData(GeneralDataDO entity) {
		repo.save(entity);
	}

	@Override
	public void deleteData(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<GeneralDataDO> findByExample(String name, Long type) {
		return repo.findByParameters(name, type);
	}

}
