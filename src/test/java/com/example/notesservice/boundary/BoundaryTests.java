package com.example.notesservice.boundary;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.notesservice.dto.NotesDto;
import com.example.utils.MasterData;
import static com.example.utils.MasterData.getNotesDto;
import static com.example.utils.TestUtils.yakshaAssert;
import static com.example.utils.TestUtils.boundaryTestFile;
import static com.example.utils.TestUtils.currentTest;
public class BoundaryTests {
	
	
	private Validator validator;
	
	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	

	@Test
	public void testAuthorNameLength() throws Exception {
		NotesDto note = MasterData.getNotesDto();
		note.setAuthor("Praveenkumar");
		Set<ConstraintViolation<NotesDto>> violations = validator.validate(note);
		yakshaAssert(currentTest(),violations.isEmpty()? true : false,boundaryTestFile);
	}
	 
	@Test
	public void testTitleLength() throws Exception {
		NotesDto note = MasterData.getNotesDto();
		note.setTitle("DevOps");
		Set<ConstraintViolation<NotesDto>> violations = validator.validate(note);
		yakshaAssert(currentTest(),violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	@Test
	public void testDescriptionLength() throws Exception {
		NotesDto note = MasterData.getNotesDto();
		note.setDescription("This is a famous technology");
		Set<ConstraintViolation<NotesDto>> violations = validator.validate(note);
		yakshaAssert(currentTest(),violations.isEmpty()? true : false,boundaryTestFile);
			
	}
}
