package ru.gb.androidlesson6.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import ru.gb.androidlesson6.R;
import ru.gb.androidlesson6.data.InMemoryRepoImpl;
import ru.gb.androidlesson6.data.Note;
import ru.gb.androidlesson6.data.Repo;
import ru.gb.androidlesson6.recycler.NotesAdapter;

public class NotesListActivity extends AppCompatActivity {

    private Repo repository = new InMemoryRepoImpl();
    private RecyclerView list;
    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);


        fillRepo();

        adapter = new NotesAdapter();
        adapter.setNotes(repository.getAll());

        list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
    }

    private void fillRepo() {
        repository.create(new Note("Title 1", "description 1"));
        repository.create(new Note("Title 2", "description 2"));
        repository.create(new Note("Title 3", "description 3"));
        repository.create(new Note("Title 4", "description 4"));
        repository.create(new Note("Title 5", "description 5"));
        repository.create(new Note("Title 6", "description 6"));
        repository.create(new Note("Title 7", "description 7"));
        repository.create(new Note("Title 8", "description 8"));
        repository.create(new Note("Title 9", "description 9"));
        repository.create(new Note("Title 10", "description 10"));
        repository.create(new Note("Title 11", "description 11"));
        repository.create(new Note("Title 12", "description 12"));

    }
}
