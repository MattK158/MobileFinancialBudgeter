package pview.proj.internal.payview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pview.proj.internal.payview.model.Subscription;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.MyViewHolder> {
    Context context;
    Activity activity;
    ArrayList<Subscription> subscriptionArrayList;

    public UpcomingAdapter(Context context, ArrayList<Subscription> subscriptionArrayList, Activity activity){
        this.context = context;
        this.subscriptionArrayList = subscriptionArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public UpcomingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.upcoming_row, parent, false);

        return new UpcomingAdapter.MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull UpcomingAdapter.MyViewHolder holder, int position) {
            holder.tvSubscription.setText(subscriptionArrayList.get(position).getName());
            holder.tvDate.setText(Integer.toString(subscriptionArrayList.get(position).getMonth()) + "/" + Integer.toString(subscriptionArrayList.get(position).getDay()));
    }


    @Override
    public int getItemCount() {
        return subscriptionArrayList.size()/2;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvSubscription, tvDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSubscription = itemView.findViewById(R.id.paymentid);
            tvDate = itemView.findViewById(R.id.dateid);
        }
    }
}
