package ru.gb.androidlesson6.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.gb.androidlesson6.R;
import ru.gb.androidlesson6.data.Constants;
import ru.gb.androidlesson6.data.InMemoryRepoImpl;
import ru.gb.androidlesson6.data.Note;
import ru.gb.androidlesson6.data.Repo;

public class EditNoteActivity extends AppCompatActivity {

    private EditText title;
    private EditText description;
    private Button saveNote;
    private int id = -1;
    private Note note;
    private Repo repository = InMemoryRepoImpl.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        title = findViewById(R.id.edit_note_title);
        description = findViewById(R.id.edit_note_description);
        saveNote = findViewById(R.id.edit_note_update);

        Intent intent = getIntent();
        if (intent != null) {
            Note note = (Note) intent.getSerializableExtra(Constants.NOTE);
            id = note.getId();
            title.setText(note.getTitle());
            description.setText(note.getDescription());

            saveNote.setOnClickListener(v -> {
                String updateTitle = title.getText().toString();
                String updateDescription = description.getText().toString();
                Intent intent1 = new Intent(this, NotesListActivity.class);
                Note note1 = new Note(id, updateTitle, updateDescription);
                note1.setTitle(updateTitle);
                note1.setDescription(updateDescription);
                if (note1.getId() == null) {
                    repository.create(note1);
                } else {
                    repository.update(note1);
                }
                intent1.putExtra(Constants.NOTE, note1);
                startActivity(intent1);
                onRestart();
                finish();

            });
        }
    }
}