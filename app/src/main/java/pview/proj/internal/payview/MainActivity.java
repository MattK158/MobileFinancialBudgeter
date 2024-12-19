package pview.proj.internal.payview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pview.proj.internal.payview.model.PayView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import pview.proj.internal.payview.controller.MainController;
import pview.proj.internal.payview.model.Subscription;

public class MainActivity extends AppCompatActivity {
    private MainController controller;
    Context context;
    ArrayList<Subscription> subscriptionArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController(this);

        int buttonIDS[] = {R.id.subscriptions, R.id.calender};

        for(int i = 0; i<buttonIDS.length; i++){
            findViewById(buttonIDS[i]).setOnClickListener(controller);
        }
        controller.loadCSV(this);
        subscriptionArrayList = controller.getSubscriptionData();

        RecyclerView upcomingRecyclerView = findViewById(R.id.MainRecyclerView);
        UpcomingAdapter adapter = new UpcomingAdapter(this, subscriptionArrayList, this);
        upcomingRecyclerView.setAdapter(adapter);
        upcomingRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}