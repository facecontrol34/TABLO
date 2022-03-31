package com.example.tablo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counterOfPointsOfAnts = 0;
    int counterOfPointsOfRoaches = 0;
    TextView textView;
    ViewGroup.LayoutParams params;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txt_view);
        params = textView.getLayoutParams();
        textView.setText(counterOfPointsOfAnts +"    :    "+ counterOfPointsOfRoaches);
    }

    public void onClickAddPointToAnts(View view) {
        counterOfPointsOfAnts++;
        TextView textView = findViewById(R.id.txt_view);
        textView.setText(counterOfPointsOfAnts +"    :    "+ counterOfPointsOfRoaches);
    }

    public void onClickAddPointToRoaches(View view) {
        counterOfPointsOfRoaches++;
        TextView textView = findViewById(R.id.txt_view);
        textView.setText(counterOfPointsOfAnts +"    :    "+ counterOfPointsOfRoaches);
    }

    public void onClickReset(View view){
        TextView textView = findViewById(R.id.txt_view);
        counterOfPointsOfAnts = 0;
        counterOfPointsOfRoaches = 0;
        textView.setText(counterOfPointsOfAnts +"    :    "+ counterOfPointsOfRoaches);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("counterOfPointsOfAnts", counterOfPointsOfAnts);
        outState.putInt("counterOfPointsOfRoaches", counterOfPointsOfRoaches);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("counterOfPointsOfAnts")
                && savedInstanceState.containsKey("counterOfPointsOfRoaches")) {
            counterOfPointsOfAnts = savedInstanceState.getInt("counterOfPointsOfAnts");
            counterOfPointsOfRoaches = savedInstanceState.getInt("counterOfPointsOfRoaches");
        }
        textView.setText(counterOfPointsOfAnts +"    :    "+ counterOfPointsOfRoaches);
    }

    @Override
    public void onResume() {
        super.onResume();
        textView.setText(counterOfPointsOfAnts +"    :    "+ counterOfPointsOfRoaches);
    }
}