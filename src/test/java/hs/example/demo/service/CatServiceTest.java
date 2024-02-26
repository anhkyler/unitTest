package hs.example.demo.service;

import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hs.example.demo.entity.CatEntity;
import hs.example.demo.repository.CatRepository;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class CatServiceTest {
	
	@Mock
	CatEntity catEntity;
	
	@Mock
	CatRepository catRepository;
	
	@InjectMocks
	CatService catService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	@Test
	public void testSaveAll_ExpectedObject() {
		CatEntity newProject = new CatEntity();
		newProject.setCatID(1);
		newProject.setCatName("Hieu So");
		when(catRepository.save(newProject)).thenReturn(newProject);
//		https://www.javaguides.net/2022/03/spring-boot-unit-testing-service-layer.html
		CatEntity savecaCatEntity = catRepository.save(newProject);
		Assertions.assertThat(savecaCatEntity).isNotNull();
	}
}
