package mx.com.eon.web.ejb;

import java.io.Serializable;
import java.util.List;

public interface IBaseEJB <T extends Serializable> {
	
	void save(T t);
	void update(T t);
	void delete(Long id);
	List<T> findByName(String name);

}
