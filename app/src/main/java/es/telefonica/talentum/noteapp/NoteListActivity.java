package es.telefonica.talentum.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import es.telefonica.talentum.noteapp.model.Note;
import es.telefonica.talentum.noteapp.model.Notes;

public class NoteListActivity extends AppCompatActivity {

    Notes listOfNotes = new Notes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        NoteListFragment noteListFragment = (NoteListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_note_list);

        for (int i = 0; i < 20; i++) {
            Note note = new Note("Note" + i);
            note.setText("Noticia super importante" + i);
            listOfNotes.add(note);
        }

        NoteAdapter adapter = new NoteAdapter(listOfNotes, this);
        noteListFragment.setAdapter(adapter);
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_main_action_add_note) {

            Intent i = new Intent(NoteListActivity.this, NoteDetailActivity.class);
            startActivity(i);

            return true;

        }
            return super.onOptionsItemSelected(item);
    }
}