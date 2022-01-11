package ru.gb.androidlesson6.data;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepoImpl implements Repo {

    private static InMemoryRepoImpl repo;

    private InMemoryRepoImpl() {

        create(new Note("Заметка 1", "Текст заметки 1"));
        create(new Note("Заметка 2", "Текст заметки 2"));
        create(new Note("Заметка 3", "Текст заметки 3"));
        create(new Note("Заметка 4", "Текст заметки 4"));
        create(new Note("Заметка 5", "Текст заметки 5"));
        create(new Note("Заметка 6", "Текст заметки 6"));

    }

    public static InMemoryRepoImpl getInstance() {
        if (repo == null) {
            repo = new InMemoryRepoImpl();
        }
        return repo;
    }


    private ArrayList<Note> notes = new ArrayList<>();
    private int counter = 0;

    @Override
    public int create(Note note) {
        int id = counter++;
        note.setId(id);
        notes.add(note);
        return id;
    }

    @Override
    public Note read(int id) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == id)
                return notes.get(i);
        }
        return null;
    }

    @Override
    public void update(Note note) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId().equals(note.getId())) {
                notes.set(i, note);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId() == id) {
                notes.remove(i);
                break;
            }
        }
    }

    @Override
    public void delete(Note note) {

    }

    @Override
    public List<Note> getAll() {
        return notes;
    }
}
