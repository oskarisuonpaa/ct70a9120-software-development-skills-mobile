package fi.lut.student.suonpaa.oskari.notebookapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> notesAdapter;
    private ArrayList<String> notesList = new ArrayList<>();
    private NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView notesListView = findViewById(R.id.notesListView);
        FloatingActionButton addNoteButton = findViewById(R.id.addNoteButton);

        noteRepository = new NoteRepository(this);
        notesList = noteRepository.getNoteTitles();

        notesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesList);
        notesListView.setAdapter(notesAdapter);

        notesListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, NoteDisplayActivity.class);
            intent.putExtra("noteId", position);
            startActivity(intent);
        });

        addNoteButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NoteActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        notesList.clear();
        notesList.addAll(noteRepository.getNoteTitles());
        notesAdapter.notifyDataSetChanged();
    }
}