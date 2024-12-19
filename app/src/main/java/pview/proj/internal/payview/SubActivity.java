package pview.proj.internal.payview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import pview.proj.internal.payview.controller.SubController;
import pview.proj.internal.payview.model.Subscription;

public class SubActivity extends AppCompatActivity {
    private SubController controller;
    private ArrayList<Subscription> subscriptionArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        controller = new SubController(this);

        int buttonIDS[] = { R.id.returnButtonSub, R.id.newItem, R.id.removeButton };

        for(int i = 0; i< buttonIDS.length; i++){
            findViewById(buttonIDS[i]).setOnClickListener(controller);
        }

        subscriptionArrayList = controller.getSubscriptionData();

        for (int i = 0; i<subscriptionArrayList.size(); i++){
            Log.d("SubActivityLoad", subscriptionArrayList.get(i).getName());
        }

        RecyclerView detailedRecyclerView = findViewById(R.id.SubRecyclerView);
        DetailedAdapter adapter = new DetailedAdapter(this, subscriptionArrayList, this);
        detailedRecyclerView.setAdapter(adapter);
        detailedRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}