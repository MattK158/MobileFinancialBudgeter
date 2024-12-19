package pview.proj.internal.payview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pview.proj.internal.payview.controller.CalenderController;

public class CalenderActivity extends AppCompatActivity {
    private CalenderController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        controller = new CalenderController(this);

        int buttonIDS[] = {R.id.AddButton, R.id.returnButtonCal};

        for(int i = 0; i< buttonIDS.length; i++){
            findViewById(buttonIDS[i]).setOnClickListener(controller);
        }
    }
}