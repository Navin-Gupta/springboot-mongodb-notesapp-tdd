package com.example.notesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotesExceptionResponse {
	private String message;
	private long timeStamp;
	private int status;
}
