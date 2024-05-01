package note.mvc.note.mvc.service.service;

import note.mvc.note.mvc.data.entity.Note;
import note.mvc.note.mvc.service.exception.NoteNotFoundException;

import java.util.List;
import java.util.UUID;

public interface NoteService {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(UUID id) throws NoteNotFoundException;
    void update(Note note) throws NoteNotFoundException;
    Note getById(UUID id) throws NoteNotFoundException;
}