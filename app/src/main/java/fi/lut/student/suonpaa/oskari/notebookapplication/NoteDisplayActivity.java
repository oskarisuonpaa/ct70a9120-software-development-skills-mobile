package fi.lut.student.suonpaa.oskari.notebookapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NoteDisplayActivity extends AppCompatActivity {
    private int noteId;
    private NoteRepository noteRepository;
    private TextView titleTextView;
    private TextView contentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_display);

        titleTextView = findViewById(R.id.titleTextView);
        contentTextView = findViewById(R.id.contentTextView);
        Button editButton = findViewById(R.id.editButton);
        Button deleteButton = findViewById(R.id.deleteButton);
        noteRepository = new NoteRepository(this);

        noteId = getIntent().getIntExtra("noteId", -1);

        editButton.setOnClickListener(v -> {
            Intent intent = new Intent(NoteDisplayActivity.this, NoteActivity.class);
            intent.putExtra("noteId", noteId);
            startActivity(intent);
        });

        deleteButton.setOnClickListener(v -> {
            noteRepository.deleteNote(noteId);
            finish();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateDisplayedNote();
    }

    private void updateDisplayedNote() {
        if (noteId != -1) {
            Note note = noteRepository.getNoteById(noteId);
            if (note != null) {
                titleTextView.setText(note.getTitle());
                contentTextView.setText(note.getContent());
            } else {
                finish();
            }
        }
    }
}