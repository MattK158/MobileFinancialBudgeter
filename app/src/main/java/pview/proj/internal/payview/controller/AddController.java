package pview.proj.internal.payview.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pview.proj.internal.payview.MainActivity;
import pview.proj.internal.payview.R;
import pview.proj.internal.payview.SubActivity;
import pview.proj.internal.payview.model.PayView;

public class AddController implements View.OnClickListener {
    private final Activity activity;

    public AddController (Activity activity){ this.activity = activity; }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        Intent intent;

        if(clickedButton.getText().equals("Add Subscription")){
            PayView newView = new PayView();
            newView.loadSubscriptions(activity.getAssets(), activity);
            EditText subscription = activity.findViewById(R.id.tSub);
            EditText day = activity.findViewById(R.id.tDay);
            EditText month = activity.findViewById(R.id.tMonth);
            EditText cost = activity.findViewById(R.id.tCost);

            System.out.println(subscription.getText().toString() + " " + day.getText().toString() + " " + month.getText().toString());
            newView.writeSubscription(subscription.getText().toString(), day.getText().toString(), month.getText().toString(), cost.getText().toString(), activity);

            intent = new Intent(activity, SubActivity.class);
            activity.startActivity(intent);
        }
        else if(clickedButton.getText().equals("Return")){
            intent = new Intent(activity, SubActivity.class);
            activity.startActivity(intent);
        }
    }
}
