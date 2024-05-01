package note.mvc.note.mvc.data.repository;

import note.mvc.note.mvc.data.entity.Note;
import note.mvc.note.mvc.service.exception.NoteNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class NoteRepository {

    private final List<Note> notes = new ArrayList<>();

    public List<Note> findAllNotes() {

        return notes;
    }
    public Note addNote(Note note) {

        note.setId(UUID.randomUUID());
        notes.add(note);
        return note;
    }

    public void removeNoteById(UUID id) throws NoteNotFoundException {

        Note note = findNoteById(id);
        if (note != null) {
            notes.remove(note);
        } else {
            throw new NoteNotFoundException("Note not found");
        }
    }

    public void updateNote(Note note) throws NoteNotFoundException {
        Note noteToUpdate = findNoteById(note.getId());
        if (noteToUpdate != null) {
            int noteId = notes.indexOf(noteToUpdate);
            notes.set(noteId, note);
        } else {
            throw new NoteNotFoundException("Note not found");
        }
    }

    public Note findNoteById(UUID id) {

        return notes.stream()
                .filter(note -> note.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
