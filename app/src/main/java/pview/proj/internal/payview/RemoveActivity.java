package pview.proj.internal.payview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pview.proj.internal.payview.controller.RemoveController;

public class RemoveActivity extends AppCompatActivity {

    private RemoveController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        controller = new RemoveController(this);

        int buttonIDS[] = { R.id.confirmRemove, R.id.returnBsub2 };

        for(int i = 0; i<buttonIDS.length; i++){
            findViewById(buttonIDS[i]).setOnClickListener(controller);
        }
    }
}