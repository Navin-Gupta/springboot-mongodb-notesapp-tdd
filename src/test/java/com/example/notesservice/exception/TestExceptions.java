package com.example.notesservice.exception;
import static com.example.utils.TestUtils.exceptionTestFile;
import static com.example.utils.TestUtils.currentTest;
import static com.example.utils.TestUtils.yakshaAssert;
import static org.junit.Assert.*;

import static org.mockito.Mockito.when;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.notesservice.controller.NoteController;
import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.repo.NoteRepository;
import com.example.notesservice.service.NoteService;
import com.example.notesservice.service.NoteServiceImpl;
import com.example.utils.MasterData;

@WebMvcTest(NoteController.class)
@RunWith(SpringRunner.class)
public class TestExceptions {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private NoteService noteService;

	@Test
	public void testAddNote() throws Exception {
	    NotesDto notesdto = new NotesDto();
		notesdto.setAuthor("Praveen");
		when(noteService.addNote(notesdto)).thenReturn(notesdto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/notesservice/add")
			.content(MasterData.toJson(notesdto))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int x = result.getResponse().getStatus();
		yakshaAssert(currentTest(),x==404? true : false,exceptionTestFile);
	}

	@Test
	public void testDeleteNote() throws Exception {
	    NotesDto notesdto = new NotesDto();
		notesdto.setId("1");
		when(noteService.addNote(notesdto)).thenReturn(notesdto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/notesservice/delete")
			.content(MasterData.toJson(notesdto))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int x = result.getResponse().getStatus();
		yakshaAssert(currentTest(),x==404? true : false,exceptionTestFile);
	}
	
}
