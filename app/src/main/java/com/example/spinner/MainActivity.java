package com.example.spinner;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView count,scr,color;
    Button red,green,blue,yellow,cyan,magenta,black,orange,purple;
    ImageView start;
    int cnt,index=-100,score=0;
    Random r;
    String colors[] = {"RED","GREEN","BLUE","YELLOW","CYAN","MAGENTA","BLACK","ORANGE","PURPLE"};
    ArrayList<Button> arr;
    ArrayList arrId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = findViewById(R.id.count);
        scr = findViewById(R.id.score);
        color = findViewById(R.id.color);
        red = findViewById(R.id.red);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);
        yellow = findViewById(R.id.yellow);
        cyan = findViewById(R.id.cyan);
        magenta = findViewById(R.id.magenta);
        black = findViewById(R.id.black);
        orange = findViewById(R.id.orange);
        purple = findViewById(R.id.purple);
        start = findViewById(R.id.start);
        r = new Random();
        arr = new ArrayList();
        arrId = new ArrayList();
        arr.add(red); arr.add(green); arr.add(blue);
        arr.add(yellow); arr.add(cyan); arr.add(magenta);
        arr.add(black); arr.add(orange); arr.add(purple);

        for (Button b : arr) {
            b.setOnClickListener(this);
            arrId.add(b.getId());
        }


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
                start.setEnabled(false);
            }
        });



    }
    public void startGame(){
        if(cnt==20){
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cnt++;
                count.setText("Count: "+cnt+"/20");
                index = r.nextInt(900);
                index /= 100;
                color.setText(colors[index]);
                startGame();
            }
        }, 1000);

    }

    @Override
    public void onClick(View view) {
        if(cnt==20) {
            return;
        }
        int x = arrId.indexOf(view.getId());
        if(x==index) {
            score += 5;
            scr.setText("Score: "+score);
        }

        index = -100;
    }
}