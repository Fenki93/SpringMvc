package note.mvc.note.mvc.service.service;

import lombok.RequiredArgsConstructor;
import note.mvc.note.mvc.data.entity.Note;
import note.mvc.note.mvc.data.repository.NoteRepository;
import note.mvc.note.mvc.service.exception.NoteNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public List<Note> listAll() {
        return noteRepository.findAllNotes();
    }

    @Override
    public Note add(Note note) {
        return noteRepository.addNote(note);
    }

    @Override
    public void deleteById(UUID id) throws NoteNotFoundException {
        noteRepository.removeNoteById(id);
    }

    @Override
    public void update(Note note) throws NoteNotFoundException {
        noteRepository.updateNote(note);
    }

    @Override
    public Note getById(UUID id) throws NoteNotFoundException {

        Note note = noteRepository.findNoteById(id);
        if (note != null) return note;
        throw new NoteNotFoundException("Note not found, id: " + id);
    }
}
