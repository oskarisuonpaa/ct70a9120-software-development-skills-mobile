package fi.lut.student.suonpaa.oskari.notebookapplication;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NoteRepository {
    private static final String PREFS_NAME = "fi.lut.student.suonpaa.oskari.notebookapplication.notes";
    private static final String NOTES_KEY = "notes";
    private final SharedPreferences sharedPreferences;
    private final Gson gson = new Gson();

    public NoteRepository(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public List<Note> getAllNotes() {
        String json = sharedPreferences.getString(NOTES_KEY, "");
        if(json.isEmpty()) {
            return new ArrayList<>();
        } else {
            Type type = new TypeToken<ArrayList<Note>>(){}.getType();
            return gson.fromJson(json, type);
        }
    }

    public Note getNoteById(int noteId) {
        List<Note> notes = getAllNotes();
        if(noteId >= 0 && noteId < notes.size()) {
            return notes.get(noteId);
        }
        return null;
    }

    public void createNote(Note note) {
        List<Note> notes = getAllNotes();
        notes.add(note);
        sharedPreferences.edit().putString(NOTES_KEY, gson.toJson(notes)).apply();
    }

    public void updateNote(int index, String title, String content) {
        List<Note> notes = getAllNotes();
        if(index >= 0 && index < notes.size()) {
            Note note = notes.get(index);
            note.setTitle(title);
            note.setContent(content);
            sharedPreferences.edit().putString(NOTES_KEY, gson.toJson(notes)).apply();
        }
    }

    public ArrayList<String> getNoteTitles() {
        List<Note> notes = getAllNotes();
        ArrayList<String> noteTitles = new ArrayList<>();
        for(Note note : notes) {
            noteTitles.add(note.getTitle());
        }
        return noteTitles;
    }

    public void deleteNote(int noteId) {
        List<Note> notes = getAllNotes();
        if(noteId >= 0 && noteId < notes.size()) {
            notes.remove(noteId);
            sharedPreferences.edit().putString(NOTES_KEY, gson.toJson(notes)).apply();
        }
    }
}
