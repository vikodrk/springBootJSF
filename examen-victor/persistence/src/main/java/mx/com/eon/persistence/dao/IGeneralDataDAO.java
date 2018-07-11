package mx.com.eon.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.eon.model.GeneralDataDO;

@Repository
public interface IGeneralDataDAO {
	
	@Transactional
	void saveData(GeneralDataDO entity);
	
	@Transactional
	void updateData(GeneralDataDO entity);
	
	@Transactional
	void deleteData(Long id);
	
	@Transactional(readOnly=true)
	List<GeneralDataDO>findByExample(String name, Long type);

}
