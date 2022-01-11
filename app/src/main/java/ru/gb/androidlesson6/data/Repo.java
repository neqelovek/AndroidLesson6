package ru.gb.androidlesson6.data;

import java.util.List;

public interface Repo {

    int create (Note note);
    Note read (int id);
    void update (Note note);
    void delete (int id);
    void delete (Note note);

    List<Note> getAll();
}
