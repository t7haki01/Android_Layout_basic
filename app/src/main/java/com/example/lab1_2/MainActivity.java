package com.example.lab1_2;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button showBtn, nextBtn;
    private CoordinatorLayout coordinatorLayout;
    private TextView textView1, textView2, textView3, textView4, textView5, endText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //From here for coordinatorLayout
        showBtn = findViewById(R.id.show_Btn);
        coordinatorLayout = findViewById(R.id.coordinateLayout);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout, "This is a simple Snackbar\nDemo for CoordinatorLayout", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Close", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
            }
        });

        //From here for frameLayout
        nextBtn = findViewById(R.id.next_btn);
        textView1 = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);
        textView4 = findViewById(R.id.text4);
        textView5 = findViewById(R.id.text5);
        endText = findViewById(R.id.endText);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean t1 = textView1.getVisibility() == View.GONE
                ,t2 = textView2.getVisibility() == View.GONE
                ,t3 = textView3.getVisibility() == View.GONE
                ,t4 = textView4.getVisibility() == View.GONE
                ,t5 = textView5.getVisibility() == View.GONE
                ,end = endText.getVisibility() == View.GONE;
                if(!t1 && !t2 && !t3 && !t4 && !t5 && !end){
                    textView1.setVisibility(View.GONE);
                }
                else if(t1 && !t2 && !t3 && !t4 && !t5 && !end){
                    textView2.setVisibility(View.GONE);
                }
                else if(t1 && t2 && !t3 && !t4 && !t5 && !end){
                    textView3.setVisibility(View.GONE);
                }
                else if(t1 && t2 && t3 && !t4 && !t5 && !end){
                    textView4.setVisibility(View.GONE);
                }
                else if(t1 && t2 && t3 && t4 && !t5 && !end){
                    textView5.setVisibility(View.GONE);
                    nextBtn.setText("Click to Start again");
                }
                else if(t1 && t2 && t3 && t4 && t5 && !end){
                    nextBtn.setText("NEXT");
                    textView1.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.VISIBLE);
                    textView3.setVisibility(View.VISIBLE);
                    textView4.setVisibility(View.VISIBLE);
                    textView5.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
