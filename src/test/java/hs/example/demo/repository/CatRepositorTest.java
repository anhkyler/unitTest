package hs.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import hs.example.demo.entity.CatEntity;




//working with testing repository but it needs to load the entire application

@DataJpaTest
public class CatRepositorTest {
	
	@Autowired
	CatRepository catRepository;
	@Autowired
    TestEntityManager entityManager;
	
	@Test
	void givenNewProject_whenSave_thenSuccess() {
		CatEntity newProject = new CatEntity();
		newProject.setCatID(1);
		CatEntity insertedProject = catRepository.save(newProject);
	    assertThat(entityManager.find(CatEntity.class, insertedProject.getCatID()) ).isEqualTo(insertedProject);
	}  

	@Test
	void givenCatName_whenfindCatname_thenSuccess(){
		CatEntity newProject = new CatEntity();
		newProject.setCatID(1);
		newProject.setCatName("Xuan Suong");
		catRepository.save(newProject);
		
		String catName = "Xuan Suong";

		CatEntity findCatname = catRepository.findCatname(catName);
		assertThat(findCatname).isNotNull();
	}
}
