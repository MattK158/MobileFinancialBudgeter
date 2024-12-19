package pview.proj.internal.payview.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import pview.proj.internal.payview.AddActivity;
import pview.proj.internal.payview.MainActivity;
import pview.proj.internal.payview.CalenderActivity;

public class CalenderController implements View.OnClickListener{
    private Activity activity;

    public CalenderController(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        Intent intent;
        if(clickedButton.getText().equals("Add New Item...")){
            intent = new Intent(activity, AddActivity.class);
            activity.startActivity(intent);
        }
        else if(clickedButton.getText().equals("Return")){
            intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
        }
    }
}
