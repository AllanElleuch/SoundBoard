package project.if26.com.soundboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.media.SoundPool;
import android.util.Log;
import android.view.View;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import kotlin.Pair;

public class DrumPad extends Template_Activity {


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

    private long chrono= System.currentTimeMillis();

    private ArrayList< Pair<String,Long> > listEvenement = new ArrayList< Pair<String,Long> >();


    public final void Go_Chrono() {
        this.chrono = System.currentTimeMillis();
    }

    public final void addEvent_Chrono(String functionName) {
        Long chrono2 = System.currentTimeMillis();
        Long temps = chrono2 - this.chrono;
        this.chrono += temps;

        Pair tuple = new Pair(functionName, temps);
        this.listEvenement.add(tuple);
        Log.v("Chrono", "Temps evenement = " + temps + " ms");
        String printlist = "";

        String print = "";
        for(Pair pair : this.listEvenement) {
            print +=  pair.getSecond().toString() + " || " + pair.getFirst();
        }

        Log.v("Chrono", "Total evenement = " + print);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drum_pad);
        setNavigationView();


        sp = new SoundPool.Builder()
                .setMaxStreams(5)
                .build();


        //sp = new SoundPool(2, AudioManager.STREAM_MUSIC,0);

        sound1 = sp.load(getApplicationContext(),R.raw.hat01,1);
        sound2 = sp.load(getApplicationContext(),R.raw.hat02,1);
        sound3 = sp.load(getApplicationContext(),R.raw.hat10,1);
        sound4 = sp.load(getApplicationContext(),R.raw.kick03,1);
        sound5 = sp.load(getApplicationContext(),R.raw.kick05,1);
        sound6 = sp.load(getApplicationContext(),R.raw.kick11,1);
        sound7 = sp.load(getApplicationContext(),R.raw.snare02,1);
        sound8 = sp.load(getApplicationContext(),R.raw.snare05,1);
        sound9 = sp.load(getApplicationContext(),R.raw.snare09,1);
        sound10 = sp.load(getApplicationContext(),R.raw.snare15,1);
        sound11= sp.load(getApplicationContext(),R.raw.snare17,1);
        sound12 = sp.load(getApplicationContext(),R.raw.snare18,1);

    }

    public void record (View v) {
        this.chrono =  System.currentTimeMillis();
        this.listEvenement = new ArrayList< Pair<String,Long> >();

    }

    public void save (View v) {


    }
    public void play (View v) {

        Method method;

        for(Pair<String,Long> pair : this.listEvenement){

            Log.v("Chrono", "call : " + pair.getFirst());

            try {
                TimeUnit.MILLISECONDS.sleep(pair.getSecond());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            playsound(pair.getFirst());
            /*


            try {
                  method  = this.getClass().getMethod(pair.getFirst(),   View.class);


                try {
                    method.invoke(this, v   );
                } catch (IllegalArgumentException e) {
                    throw  new IllegalArgumentException();

                }
                catch (
                        IllegalAccessException e) {

                }
                catch (InvocationTargetException e) {   }

            }

            catch (SecurityException e) {
                throw  new SecurityException();
            }
            catch (NoSuchMethodException e) {

            }

             */


        }
    }


    public void playsound(String sound){
        switch (sound){
            case "sound1": sp.play(sound1,1.0f,1.0f,0,0,1);
            break;
            case "sound2": sp.play(sound2,1.0f,1.0f,0,0,1);
                break;
            case "sound3": sp.play(sound3,1.0f,1.0f,0,0,1);
                break;
            case "sound4": sp.play(sound4,1.0f,1.0f,0,0,1);
                break;
            case "sound5": sp.play(sound5,1.0f,1.0f,0,0,1);
                break;
            case "sound6": sp.play(sound6,1.0f,1.0f,0,0,1);
                break;
            case "sound7": sp.play(sound7,1.0f,1.0f,0,0,1);
                break;
            case "sound8": sp.play(sound8,1.0f,1.0f,0,0,1);
                break;
            case "sound9": sp.play(sound9,1.0f,1.0f,0,0,1);
                break;
            case "sound10": sp.play(sound10,1.0f,1.0f,0,0,1);
                break;
            case "sound11": sp.play(sound11,1.0f,1.0f,0,0,1);
                break;
            case "sound12": sp.play(sound12,1.0f,1.0f,0,0,1);
                break;
        }
    }


    public void playsound1 (View v) {
        sp.play(sound1,1.0f,1.0f,0,0,1);
        addEvent_Chrono("sound1");

    }
    public void playsound2 (View v) {
        sp.play(sound2,1.0f,1.0f,0,0,1);
        addEvent_Chrono("sound2" +
                "");

    }
    public void playsound3 (View v) {
        sp.play(sound3,1.0f,1.0f,0,0,1);
        addEvent_Chrono("sound3");

    }
    public void playsound4 (View v) {
        sp.play(sound4,1.0f,1.0f,0,0,1);
        addEvent_Chrono("sound4");

    }
    public void playsound5 (View v) {
        sp.play(sound5,1.0f,1.0f,0,0,1);
        addEvent_Chrono("sound5");

    }
    public void playsound6 (View v) {
        sp.play(sound6,1.0f,1.0f,0,0,1);
        addEvent_Chrono("sound6");

    }
    public void playsound7 (View v) {
        sp.play(sound7,1.0f,1.0f,0,0,1f);
        addEvent_Chrono("sound7");

    }
    public void playsound8 (View v) {
        sp.play(sound8,1.0f,1.0f,0,0,1);
        addEvent_Chrono("sound8");

    }
    public void playsound9 (View v) {
        sp.play(sound9,1.0f,1.0f,0,0,1);
        addEvent_Chrono("sound1");

    }
    public void playsound10 (View v) {
        sp.play(sound10,1.0f,1.0f,0,0,1);
        addEvent_Chrono("sound10");

    }

    public void playsound11 (View v) {
        sp.play(sound11,1.0f,1.0f,0,0,1);
        addEvent_Chrono("sound11");

    }

    public void playsound12 (View v) {
        sp.play(sound12,1.0f,1.0f,0,0,1);
        addEvent_Chrono("sound12");

    }


}

