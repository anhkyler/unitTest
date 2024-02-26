package hs.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import hs.example.demo.entity.CatEntity;
import hs.example.demo.repository.CatRepository;

public class CatService {
	@Autowired
	CatRepository catRepository;
	
	public CatEntity saveCat() {
		CatEntity catentity = new CatEntity();
		catentity.setCatID(1);
		return catRepository.save(catentity);
	}
	
	public CatEntity saveAllCat(CatEntity catEntity) {
		CatEntity findOneCat = catRepository.findCatname(catEntity.getCatName());
		if(findOneCat != null)
			return findOneCat;
//		else 
//			throw new ResourceNotFoundException("not found");
		
		return catRepository.save(catEntity);
	}
}
