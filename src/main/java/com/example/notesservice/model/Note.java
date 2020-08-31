package com.example.notesservice.model;





import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;


@Document
@Data
@NoArgsConstructor
public class Note {
	
	@Id
	private String id;
	
	private String title;
	
	private String author;
	
	private String description;
	
	private String status;

}
