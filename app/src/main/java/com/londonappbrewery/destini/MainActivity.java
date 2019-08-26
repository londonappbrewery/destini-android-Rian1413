package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    TextView textv;
    Button button1;
    Button button2;
    public static String t1;
    public static String t2;
    public static String t3;
    public AlertDialog.Builder alert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = getString(R.string.T1_Story);
        t2 = getString(R.string.T2_Story);
        t3 = getString(R.string.T3_Story);



        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        textv = findViewById(R.id.storyTextView);
        button1 = findViewById(R.id.buttonTop);
        button2 = findViewById(R.id.buttonBottom);




        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                choosingAnswer1();
            }
        });




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                choosingAnswer2();
            }
        });
    }



    public void choosingAnswer1(){
        if (textv.getText().equals(t1)){
            textv.setText(R.string.T3_Story);
            button1.setText(R.string.T3_Ans1);
            button2.setText(R.string.T3_Ans2);
        }
        else if (textv.getText().equals(t2)){
            textv.setText(R.string.T3_Story);
            button1.setText(R.string.T3_Ans1);
            button2.setText(R.string.T3_Ans2);
        }
        else if (textv.getText().equals(t3)){
            textv.setText(R.string.T6_End);
        }
        else{
            alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("end of the story");
            alert.setMessage("click on restart to restart story");
            alert.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    startActivity(getIntent());
                }
            });
            alert.show();
    }}



    public void choosingAnswer2(){
        if (textv.getText().equals(t1)){
            textv.setText(R.string.T2_Story);
            button1.setText(R.string.T2_Ans1);
            button2.setText(R.string.T2_Ans2);
        }
        else if (textv.getText().equals(t2)){
            textv.setText(R.string.T4_End);

        }
        else if (textv.getText().equals(t3)){
            textv.setText(R.string.T5_End);
        }
        else
            Toast.makeText(getApplicationContext() , "you finished the story " , Toast.LENGTH_LONG).show();

    }

    public void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);

        outstate.putString("Textview" , textv.getText().toString());
        outstate.putString("button1" , button1.getText().toString());
        outstate.putString("button2" , button2.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

            textv.setText(savedInstanceState.getString("Textview"));
            button1.setText(savedInstanceState.getString("button1")) ;
            button2.setText(savedInstanceState.getString("button2")) ;


    }
}
