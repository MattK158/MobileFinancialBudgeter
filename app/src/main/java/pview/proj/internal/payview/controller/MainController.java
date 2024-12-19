package pview.proj.internal.payview.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import pview.proj.internal.payview.CalenderActivity;
import pview.proj.internal.payview.SubActivity;
import pview.proj.internal.payview.model.PayView;
import pview.proj.internal.payview.model.Subscription;

public class MainController implements View.OnClickListener {
    private final Activity activity;

    public MainController(Activity activity){ this.activity = activity; }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        Intent intent;
        if(clickedButton.getText().equals("Subscriptions")){
            intent = new Intent(activity, SubActivity.class);
            activity.startActivity(intent);
        }
        if(clickedButton.getText().equals("Calender")){
            intent = new Intent(activity, CalenderActivity.class);
            activity.startActivity(intent);
        }
    }

    public void loadCSV(Context context) {
        PayView newView = new PayView();
        newView.loadSubscriptions(activity.getAssets(), activity);
    }

    public ArrayList<Subscription> getSubscriptionData() {
        PayView newView = new PayView();
        newView.loadSubscriptions(activity.getAssets(), activity);
        return newView.getSubList();
    }
}
