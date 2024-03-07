package fi.lut.student.suonpaa.oskari.notebookapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class NoteActivity extends AppCompatActivity {
    private EditText titleEditText;
    private EditText contentEditText;
    private int noteId = -1;
    private NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        titleEditText = findViewById(R.id.titleEditText);
        contentEditText = findViewById(R.id.contentEditText);
        Button saveButton = findViewById(R.id.saveButton);
        noteRepository = new NoteRepository(this);

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("noteId")) {
            noteId = intent.getIntExtra("noteId", -1);
            Note note = noteRepository.getNoteById(noteId);
            if(note != null) {
                titleEditText.setText(note.getTitle());
                contentEditText.setText(note.getContent());
            }
        }

        saveButton.setOnClickListener(v -> saveNote());
    }

    private void saveNote() {
        String title = titleEditText.getText().toString().trim();
        String content = contentEditText.getText().toString().trim();

        if(noteId == -1) {
            noteRepository.createNote(new Note(title, content));
        } else {
            noteRepository.updateNote(noteId, title, content);
        }

        finish();
    }
}