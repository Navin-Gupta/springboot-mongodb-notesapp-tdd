package com.example.notesservice.service;

import java.util.List;
import java.util.Optional;

import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.model.Note;

public interface NoteService {
	public List<NotesDto> findAll();
	public NotesDto findById(String id);
	public NotesDto addNote(NotesDto note);
	public NotesDto deleteNote(String id);
	public List<NotesDto> findAllByStatus(String status);
}
