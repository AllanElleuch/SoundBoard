package project.if26.com.soundboard;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

public class DrumPad_Rock extends Template_Activity {


    private SoundPool sp;
    private int sound1;
    private int sound2;
    private int sound3;
    private int sound4;
    private int sound5;
    private int sound6;
    private int sound7;
    private int sound8;
    private int sound9;
    private int sound10;
    private int sound11;
    private int sound12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drum_pad_rock);
        setNavigationView();


        sp = new SoundPool.Builder()
                .setMaxStreams(5)
                .build();


        //sp = new SoundPool(2, AudioManager.STREAM_MUSIC,0);

        sound1 = sp.load(getApplicationContext(),R.raw.rock_crash1,1);
        sound2 = sp.load(getApplicationContext(),R.raw.rock_crash2,1);
        sound3 = sp.load(getApplicationContext(),R.raw.rock_hatclosed,1);
        sound4 = sp.load(getApplicationContext(),R.raw.rock_hatopen,1);
        sound5 = sp.load(getApplicationContext(),R.raw.rock_kick,1);
        sound6 = sp.load(getApplicationContext(),R.raw.rock_kick2,1);
        sound7 = sp.load(getApplicationContext(),R.raw.rock_kick3,1);
        sound8 = sp.load(getApplicationContext(),R.raw.rock_kick4,1);
        sound9 = sp.load(getApplicationContext(),R.raw.rock_snare1,1);
        sound10 = sp.load(getApplicationContext(),R.raw.rock_snare2,1);
        sound11= sp.load(getApplicationContext(),R.raw.rock_snare3,1);
        sound12 = sp.load(getApplicationContext(),R.raw.rock_snare4,1);

    }

    public void playsound1 (View v) {
        sp.play(sound1,1.0f,1.0f,0,0,1);
    }
    public void playsound2 (View v) {
        sp.play(sound2,1.0f,1.0f,0,0,1);

    }
    public void playsound3 (View v) {
        sp.play(sound3,1.0f,1.0f,0,0,1);

    }
    public void playsound4 (View v) {
        sp.play(sound4,1.0f,1.0f,0,0,1);

    }
    public void playsound5 (View v) {
        sp.play(sound5,1.0f,1.0f,0,0,1);

    }
    public void playsound6 (View v) {
        sp.play(sound6,1.0f,1.0f,0,0,1);

    }
    public void playsound7 (View v) {
        sp.play(sound7,1.0f,1.0f,0,0,1f);

    }
    public void playsound8 (View v) {
        sp.play(sound8,1.0f,1.0f,0,0,1);

    }
    public void playsound9 (View v) {
        sp.play(sound9,1.0f,1.0f,0,0,1);

    }
    public void playsound10 (View v) {
        sp.play(sound10,1.0f,1.0f,0,0,1);

    }

    public void playsound11 (View v) {
        sp.play(sound11,1.0f,1.0f,0,0,1);

    }

    public void playsound12 (View v) {
        sp.play(sound12,1.0f,1.0f,0,0,1);

    }


}

