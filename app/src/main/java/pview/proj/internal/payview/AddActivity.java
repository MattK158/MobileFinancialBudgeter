package pview.proj.internal.payview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pview.proj.internal.payview.controller.AddController;

public class AddActivity extends AppCompatActivity {

    private AddController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        controller = new AddController(this);

        int buttonIDS[] = {R.id.confirm, R.id.returnBsub};

        for(int i = 0; i<buttonIDS.length; i++){
            findViewById(buttonIDS[i]).setOnClickListener(controller);
        }
    }
}