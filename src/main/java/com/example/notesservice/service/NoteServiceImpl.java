package com.example.notesservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.notesservice.dto.NotesDto;
import com.example.notesservice.model.Note;
import com.example.notesservice.repo.NoteRepository;
import static com.example.notesservice.utils.NotesUtilities.convertToNote;
import static com.example.notesservice.utils.NotesUtilities.convertToNoteDto;
import static com.example.notesservice.utils.NotesUtilities.convertToNotesDtoList;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteRepository noteRepository;

	@Override
	public List<NotesDto> findAll() {
		// TODO Auto-generated method stub
		List<Note> notes = this.noteRepository.findAll();
		List<NotesDto> noteDtos = convertToNotesDtoList(notes);
		return noteDtos;
		// return null;
	}

	@Override
	public NotesDto findById(String id) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public NotesDto addNote(NotesDto noteDto) {
		return convertToNoteDto(this.noteRepository.save(convertToNote(noteDto)));
	}

	@Override
	public NotesDto deleteNote(String id) {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public List<NotesDto> findAllByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}
}
