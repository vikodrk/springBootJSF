package mx.com.eon.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.eon.model.GeneralDataDO;

@Repository
public interface IGeneralDataRepository extends JpaRepository<GeneralDataDO, Long>{
	
	@Query("SELECT e FROM GeneralDataDO e "+"WHERE (  UPPER(e.name) LIKE :name ) "+"AND e.user.id = :type ")
	List<GeneralDataDO> findByParameters(@Param("name")String name, @Param("type")Long type);

}
