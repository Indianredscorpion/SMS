package com.sms.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sms.entity.Studant;
import com.sms.model.StudantDTO;
import com.sms.repository.StudantRepository;
import com.sms.service.StudantService;
import com.sms.util.StudantConverter;

@SpringBootTest
 class StudantServiceTest {

	@MockBean
	StudantRepository studantRepository;
	
	@Autowired
	StudantConverter converter;
	
	@Autowired
	StudantService studantService;
	
	Studant studant;
	
	@BeforeEach
	void setUp() throws Exception {
	 studant = Studant.builder().userName("Omkar")
				.password("Nashte123")
				.studantName("Omkar")				
				.contact("1234567891")
				
				.email("OmkarNashte@gmail.com")
				.doj(LocalDate.of(2023, 8, 20))
				.build();
	}
	
	//test method will test saveStudant method
	@Test
	@DisplayName("Testing save studant method")
	void testSaveStudant()
	{
		Mockito.when(studantRepository.save(studant)).thenReturn(studant);
		
//		assertThat(studantService.saveStudant(studant).getStudantName())
//		.isEqualTo(converter.convertToStudantDTO(studant).getStudantName());
		assertEquals("Heena", studantService.saveStudant(studant).getStudents());
	}
	
	@Test
	@DisplayName("Testing get studant details using id")
	void testGetStudantById()
	{
	 	Optional<Studant> opStudant = Optional.of(studant);
		Mockito.when(studantRepository.findById(studant.getId())).thenReturn(opStudant);
		
		StudantDTO eDto =converter.convertToSmpDTO(opStudant.get());
		
	}

	@Test
	@DisplayName("Testing update studant method")
	void testUpdateStudant()
	{
		Optional<Studant> opStudant = Optional.of(studant);
		Studant stud2 = opStudant.get();
		
		Mockito.when(studantRepository.findById(studant.getId())).thenReturn(opStudant);
		stud2.setSmpName("Omkar Nashte");
		
		Mockito.when(studantRepository.save(stud2)).thenReturn(stud2);
		
		assertEquals("Omkar Nashte", studantService.updateStudantById(stud2.getId(), stud2).getStudents());
		
	}
	
	@Test
	@DisplayName("Negative test case")
	void testNegativeGetStudantById()
	{
	 	Optional<Studant> opStudant = Optional.of(studant);
		Mockito.when(studantRepository.findById(studant.getId())).thenReturn(opStudant);

		
	}
	

}
