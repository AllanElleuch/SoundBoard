package project.if26.com.soundboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.greendao.query.Query;

import java.util.List;

public class ViewNote extends Template_Activity {


    private NoteDao noteDao;
    private Query<Note> notesQuery;
    private NotesAdapter notesAdapter;
    List<Note> listNotes;
    public TextView text;
    public TextView comment;
    private Note note;
    public long noteID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);
        setNavigationView();

        //setUpViews();

        // get the note DAO
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        noteDao = daoSession.getNoteDao();

        // query all notes, sorted a-z by their text
        //updateNotes();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        long noteID = intent.getLongExtra(NoteActivity.EXTRA_NOTE_ID,-1);
        this.noteID=noteID;

        notesQuery = noteDao.queryBuilder().where(NoteDao.Properties.Id.eq(noteID)).build();
        listNotes = notesQuery.list();

        if(listNotes.size()>0) {
            Note noteDeLaList = listNotes.get(0);
            note = noteDeLaList;

            comment = (TextView) findViewById(R.id.editNoteComment );
            text = (TextView) findViewById(R.id.editNoteText);

            comment.setText(note.getComment());
            text.setText(note.getText());


        }



        Log.v("ViewNote", "NOTE ID : " +noteID);
        Log.v("ViewNote", "NOTE query size : " +listNotes.size());
    }

    public void onDeleteClick(View v) {
        //To edit shared preferences use editor as follows
        Log.v("ViewNote", "Delete note ID : " +noteID);

        noteDao.deleteByKey(this.noteID);
        finish();

    }

    public void onSaveClick(View v) {
        //To edit shared preferences use editor as follows
        Log.v("ViewNote", "Update note ID : " +noteID);

        note.setComment(this.comment.getText().toString());
        note.setText(this.text.getText().toString());
        DaoSession daoSession = ((App) getApplication()).getDaoSession();

        daoSession.getNoteDao().insertOrReplace(note);

        finish();

    }


}
