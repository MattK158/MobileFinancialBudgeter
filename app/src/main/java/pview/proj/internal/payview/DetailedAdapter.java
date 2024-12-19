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

public class DetailedAdapter extends RecyclerView.Adapter<DetailedAdapter.MyViewHolder> {
    Context context;
    Activity activity;
    ArrayList<Subscription> subscriptionArrayList;

    public DetailedAdapter(Context context, ArrayList<Subscription> subscriptionArrayList, Activity activity){
        this.context = context;
        this.subscriptionArrayList = subscriptionArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public DetailedAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.detailed_row, parent, false);

        return new DetailedAdapter.MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull DetailedAdapter.MyViewHolder holder, int position) {
        holder.tvSubDate.setText(Integer.toString(subscriptionArrayList.get(position).getMonth()) + "/" + Integer.toString(subscriptionArrayList.get(position).getDay()));
        holder.tvSubSubscription.setText(subscriptionArrayList.get(position).getName());
        holder.tvSubTotal.setText("$" + subscriptionArrayList.get(position).getCost());
    }


    @Override
    public int getItemCount() {
        return subscriptionArrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvSubDate, tvSubSubscription, tvSubTotal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSubDate = itemView.findViewById(R.id.fullDate);
            tvSubSubscription = itemView.findViewById(R.id.subName);
            tvSubTotal = itemView.findViewById(R.id.total);
        }
    }
}
