package com.example.notesservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.dto.NotesExceptionResponse;
import com.example.notesservice.exception.NotesException;
import com.example.notesservice.model.Note;
import com.example.notesservice.service.NoteService;
import static com.example.notesservice.utils.NotesUtilities.convertToNoteDto;
@RestController
@RequestMapping("/noteservice")
public class NoteController {
	
	@Autowired
	private NoteService noteService;

	@GetMapping("/all")
	public ResponseEntity<List<NotesDto>> findAll(){
		
		ResponseEntity<List<NotesDto>> response = 
				new ResponseEntity<List<NotesDto>>(this.noteService.findAll(), HttpStatus.OK);
		return response;
		 // return null;
	}
	
	public static NotesDto getNotesDto() {

		NotesDto notesdto = new NotesDto();
		notesdto.setId("1");
		notesdto.setAuthor("Praveen");
		notesdto.setTitle("Jenkins");
		notesdto.setDescription("This is the best CI/CD tool");
		notesdto.setStatus("Done");
		
		return notesdto;
	}
	
	@PostMapping("/add")
	public ResponseEntity<NotesDto> addNote(@Valid @RequestBody NotesDto note, BindingResult result){
		System.out.println("Called Controller");
		if(result.hasErrors()) {
			throw new NotesException("Invalid Data to add!!");
		}
		/*ResponseEntity<NotesDto> response = 
				new ResponseEntity<NotesDto>(this.noteService.addNote(note), HttpStatus.OK);*/
		ResponseEntity<NotesDto> response = 
				new ResponseEntity<NotesDto>(getNotesDto(), HttpStatus.OK);
		
		return response;
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<NotesDto> deleteNote(@PathVariable("id") String id){
		return null;
	}
	
	@GetMapping("/note/{id}")
	public ResponseEntity<NotesDto> findById(@PathVariable("id") String id){
		return null;
	}
	
	@GetMapping("/update/{id}/{status}")
	public ResponseEntity<NotesDto> updateStatus(@PathVariable("id") String id){
		return null;
	}
	
	@GetMapping("/find/{author}")
	public ResponseEntity<NotesDto> updateStatus(@PathVariable("id") String id){
		return null;
	}
	
	@GetMapping("/find/{status}")
	public ResponseEntity<List<NotesDto>> findAllByStatus(@PathVariable("status") String status){
		return null;
	}
	
	@ExceptionHandler(NotesException.class)
	public ResponseEntity<NotesExceptionResponse> NotesHandler(NotesException ex){
		NotesExceptionResponse resp = 
				new NotesExceptionResponse(ex.getMessage(),System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
		ResponseEntity<NotesExceptionResponse> response = 
				new ResponseEntity<NotesExceptionResponse>(resp, HttpStatus.BAD_REQUEST);
		return response;
	}
}











