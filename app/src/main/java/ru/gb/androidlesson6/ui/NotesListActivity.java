package ru.gb.androidlesson6.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ru.gb.androidlesson6.R;
import ru.gb.androidlesson6.data.InMemoryRepoImpl;
import ru.gb.androidlesson6.data.Repo;

public class NotesListActivity extends AppCompatActivity {

    private Repo repository = new InMemoryRepoImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);


        fillRepo();
    }

    private void fillRepo() {

    }
}
