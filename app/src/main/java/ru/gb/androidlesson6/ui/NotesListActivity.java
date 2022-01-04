package ru.gb.androidlesson6.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;

import ru.gb.androidlesson6.R;
import ru.gb.androidlesson6.data.Constants;
import ru.gb.androidlesson6.data.InMemoryRepoImpl;
import ru.gb.androidlesson6.data.Note;
import ru.gb.androidlesson6.data.Repo;
import ru.gb.androidlesson6.recycler.NotesAdapter;

public class NotesListActivity extends AppCompatActivity implements NotesAdapter.OnNoteClickListener {

    private Repo repository = InMemoryRepoImpl.getInstance();
    private RecyclerView list;
    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);


        fillRepo();

        adapter = new NotesAdapter();
        adapter.setNotes(repository.getAll());

        adapter.setOnNoteClickListener(this);

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

    @Override
    public void onNoteClick(Note note) {
        Intent intent = new Intent(this, EditNoteActivity.class);
        intent.putExtra(Constants.NOTE, note);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
           case R.id.menu_create:
               Intent intent = new Intent(this, EditNoteActivity.class);
               intent.putExtra(Constants.NOTE_NEW, String.valueOf(item));
               startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
