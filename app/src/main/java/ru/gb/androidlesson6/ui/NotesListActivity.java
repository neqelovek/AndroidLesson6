package ru.gb.androidlesson6.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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

        adapter = new NotesAdapter();
        adapter.setNotes(repository.getAll());

        adapter.setOnNoteClickListener(this);

        list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
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
        if (item.getItemId() == R.id.menu_create) {
            Intent intent = new Intent(this, EditNoteActivity.class);
            int id = repository.getAll().size() + 1;
            Note note = new Note(id, "", "");
            intent.putExtra(Constants.NOTE, note);
            repository.create(note);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

//    @SuppressLint("NonConstantResourceId")
//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//
//            case R.id.context_delete:
//
//                return true;
//
//            case R.id.context_modify:
//
//                return true;
//
//
//            default:
//                return super.onContextItemSelected(item);
//        }
//
//    }
    @Override
    protected void onResume() {
        super.onResume();
        adapter.setNotes(repository.getAll());
        list.setAdapter(adapter);
    }
}
