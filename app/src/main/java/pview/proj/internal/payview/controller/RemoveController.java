package pview.proj.internal.payview.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pview.proj.internal.payview.R;
import pview.proj.internal.payview.SubActivity;
import pview.proj.internal.payview.model.PayView;

public class RemoveController implements View.OnClickListener {
    private final Activity activity;

    public RemoveController(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        Intent intent;

        if (clickedButton.getText().equals("Remove")) {
            PayView newView = new PayView();
            newView.loadSubscriptions(activity.getAssets(), activity);
            EditText subscription = activity.findViewById(R.id.rSub);

            newView.removeSubscription(subscription.getText().toString(), activity);

            intent = new Intent(activity, SubActivity.class);
            activity.startActivity(intent);
        } else if (clickedButton.getText().equals("Return")) {
            intent = new Intent(activity, SubActivity.class);
            activity.startActivity(intent);
        }
    }
}