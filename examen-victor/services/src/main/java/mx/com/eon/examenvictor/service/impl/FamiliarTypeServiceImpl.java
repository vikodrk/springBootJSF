package mx.com.eon.examenvictor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.eon.api.enums.FamiliarEnum;
import mx.com.eon.examenvictor.formatter.FamiliarFormatter;
import mx.com.eon.examenvictor.service.IFamiliarTypeService;
import mx.com.eon.model.FamiliarType;
import mx.com.eon.persistence.dao.IFamiliarTypeDAO;

public class FamiliarTypeServiceImpl implements IFamiliarTypeService {
	
	@Autowired
	IFamiliarTypeDAO dao;

	@Override
	public List<FamiliarEnum> getAll() {
		List<FamiliarType> list = dao.findAll();
		List<FamiliarEnum> result = new ArrayList<>();
		list.forEach(e -> result.add(FamiliarFormatter.toDto(e)));
		return result;
	}

	@Override
	public FamiliarEnum findById(long id) {
		return FamiliarFormatter.toDto(dao.findById(id));
	}

}
