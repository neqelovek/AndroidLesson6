package ru.gb.androidlesson6.data;

public interface Repo {

    int create (Note note);
    Note read (int id);
    void update (Note note);
    void delete (int id);
}
