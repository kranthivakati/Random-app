package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextView txt;
    TextToSpeech tts;
    Button btm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.textView);
        btm=findViewById(R.id.button);
        tts=new TextToSpeech(MainActivity.this,this);

        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random ran=new Random();
                int val=ran.nextInt(4001-1)+1;
                txt.setText(Integer.toString(val));
                tts.speak(String.valueOf(val),TextToSpeech.QUEUE_ADD,null);

            }
        });

    }

    @Override
    public void onInit(int status) {
        if(status==TextToSpeech.SUCCESS){
            tts.setLanguage(Locale.getDefault());
        }
    }
}