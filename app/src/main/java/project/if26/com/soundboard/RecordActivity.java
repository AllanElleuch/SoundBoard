package project.if26.com.soundboard;

import android.content.Context;
import android.icu.text.AlphabeticIndex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.media.MediaRecorder;
import android.view.View;
import java.io.IOException;
import android.widget.Toast;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.util.Log;


public class RecordActivity extends AppCompatActivity {

    private static Context context;

    private Button play, stop, record;
    private String outputFile;

    private MediaRecorder myAudioRecorder;
    public static final int RECORD_AUDIO = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        record = (Button) findViewById(R.id.record);


        //context of the application
        context = getApplicationContext();

        //output file for audio recorder
        outputFile = context.getFilesDir() + "/recording.3gp";



            stop.setEnabled(false);
            play.setEnabled(false);







            record.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   if(checkPermissionAudioRecord()){
                       //setup media recorder
                       myAudioRecorder = new MediaRecorder();
                       myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                       myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                       myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
                       myAudioRecorder.setOutputFile(outputFile);

                    try {
                        myAudioRecorder.prepare();
                        myAudioRecorder.start();
                    } catch (IllegalStateException ise) {
                        // make something ...
                    } catch (IOException ioe) {
                        // make something
                    }

                    record.setEnabled(false);
                    stop.setEnabled(true);

                    Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
                }

                }
            });



            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkPermissionAudioRecord()) {

                        myAudioRecorder.stop();
                        myAudioRecorder.release();
                        myAudioRecorder = null;
                        record.setEnabled(true);
                        stop.setEnabled(false);
                        play.setEnabled(true);
                        Toast.makeText(getApplicationContext(), "Audio Recorded successfully", Toast.LENGTH_LONG).show();
                    }
                }
            });

            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkPermissionAudioRecord()) {

                        MediaPlayer mediaPlayer = new MediaPlayer();

                        try {
                            mediaPlayer.setDataSource(outputFile);
                            mediaPlayer.prepare();
                            mediaPlayer.start();

                            Toast.makeText(getApplicationContext(), "Playing Audio", Toast.LENGTH_LONG).show();

                        } catch (Exception e) {
                            // make something
                        }

                    }
                }
            });






        }

        public boolean checkPermissionAudioRecord(){
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                    != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted
                Log.v("intentmain", "permission not granted for audio recording");

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECORD_AUDIO},
                        RECORD_AUDIO);
                return false;
            }else{


                return true;



            }


        }


    }


