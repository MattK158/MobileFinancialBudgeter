package pview.proj.internal.payview.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pview.proj.internal.AddActivity;
import pview.proj.internal.MainActivity;
import pview.proj.internal.RemoveActivity;
import pview.proj.internal.model.PayView;
import pview.proj.internal.model.Subscription;

public class SubController implements View.OnClickListener {
    private Activity activity;

    public SubController(Activity activity){this.activity = activity;}

    @Override
    public void onClick(View view){
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
        else{
            intent = new Intent(activity, RemoveActivity.class);
            activity.startActivity(intent);
        }
    }

    public ArrayList<Subscription> getSubscriptionData() {
        PayView newView = new PayView();
        newView.loadSubscriptions(activity.getAssets(), activity);
        return newView.getSubList();
    }
}
