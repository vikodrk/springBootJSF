package mx.com.eon.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.eon.model.FamiliarType;

@Repository
public interface IFamiliaryTypeRepository extends JpaRepository<FamiliarType, Long>{

}
