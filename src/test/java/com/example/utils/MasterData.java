package com.example.utils;

import java.io.IOException;

import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.model.Note;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MasterData {
	public static NotesDto getNotesDto() {

		NotesDto notesdto = new NotesDto();
		notesdto.setId("1");
		notesdto.setAuthor("Praveen");
		notesdto.setTitle("Jenkins");
		notesdto.setDescription("This is the best CI/CD tool");
		notesdto.setStatus("Done");
		
		return notesdto;
	}
	
	public static Note getNotes() {

		Note notes = new Note();
		notes.setId("1");
		notes.setAuthor("Praveen");
		notes.setTitle("Jenkins");
		notes.setDescription("This is the best CI/CD tool");
		notes.setStatus("Done");
		
		return notes;
	}
	
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	public static byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
    public static Note createNote(String id, String author, String title, String status, 
    		String description) {
    	Note note = new Note();
    	note.setId(id);
    	note.setAuthor(author);
    	note.setDescription(description);
    	note.setStatus(status);
    	note.setTitle(title);
  	 	return note;
    }

}
