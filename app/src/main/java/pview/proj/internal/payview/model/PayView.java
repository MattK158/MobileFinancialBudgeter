package pview.proj.internal.payview.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class PayView {
    ArrayList<Subscription> subscriptionArrayList;
    ArrayList<String> lines;

    public PayView(){

    }

    public ArrayList<Subscription> getSubList(){
        return subscriptionArrayList;
    }

    public void addSub(Subscription newSub){
        subscriptionArrayList.add(newSub);
    }

    /**
     *
     * Checks if subs.csv exists, creates in data/data/app/files and loads in default csv for format
     *
     * @param manager - assets
     * @param activity - MainActivity
     */
    public void loadSubscriptions(AssetManager manager, Activity activity){
        subscriptionArrayList = new ArrayList<>();
        lines = new ArrayList<>();
        Scanner scan;
        InputStream in;
        OutputStream out;
        String line;
        File userFile = new File("data/data/pview.proj.internal.payview/files", "subs.csv");

        try{
            if (!userFile.exists()){ // checks for sub.csv if false
                in = manager.open("subs.csv"); // reads in assets
                System.out.println("Reading in assets..."); // message to console
           } else {
                in = activity.openFileInput("subs.csv"); // opens user file for reading
                System.out.println("Reading from activity..."); // message to console
            }

            String tokens[]; // string array to store delimited csv
            scan = new Scanner(in);

            while(scan.hasNextLine()){
                line = scan.nextLine();
                lines.add(line + "\n");
                tokens = line.split(",");
                Subscription newSub = new Subscription(tokens[0], Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]), tokens[3]);
                addSub(newSub); // adds newSub to ArrayList of subs
            }
            in.close();
            scan.close();

            out = activity.openFileOutput("subs.csv", Context.MODE_PRIVATE);
            for(int i = 0; i<lines.size(); i++){
                out.write(lines.get(i).getBytes(StandardCharsets.UTF_8));
            }
            out.close();

            for(int i = 0; i<subscriptionArrayList.size(); i++){ // looped console message of loads
                Log.d("Sub Added", subscriptionArrayList.get(i).getName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean writeSubscription(String subscription, String day, String month, String cost,Activity activity){
        boolean created = false;
        OutputStream out;
        Scanner scan;
        String line = "";
        int nextMonth = Integer.valueOf(month) + 1;
        String subLine = subscription + "," + String.valueOf(nextMonth) + "," + day + "," + cost;
        lines = new ArrayList<>();

        try{
            InputStream in = activity.openFileInput("subs.csv");
            scan = new Scanner(in);
            while( scan.hasNextLine() ){
                line = scan.nextLine();
                lines.add(line + "\n");
            }
            in.close();
            scan.close();

            lines.add(subLine);

            out = activity.openFileOutput("subs.csv", Context.MODE_PRIVATE);


            for(int i = 0; i<lines.size(); i++){
                created = true;
                out.write(lines.get(i).getBytes(StandardCharsets.UTF_8));
            }
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return created;
    }

    public boolean removeSubscription(String subscription, Activity activity){
        boolean deleted = false;
        OutputStream out;
        Scanner scan;
        String line = "";
        String tokens[];
        lines = new ArrayList<>();

        try{
            InputStream in = activity.openFileInput("subs.csv");
            scan = new Scanner(in);
            while( scan.hasNextLine() ){
                line = scan.nextLine();
                lines.add(line + "\n");
            }
            in.close();
            scan.close();

            out = activity.openFileOutput("subs.csv", Context.MODE_PRIVATE);


            for(int i = 0; i<lines.size(); i++){
                tokens = lines.get(i).split(",");
                if(subscription.equals(tokens[0])) {
                    System.out.println(tokens[0] + " removed");
                    lines.remove(i);
                    deleted = true;
                }
            }
            for(int i = 0; i<lines.size(); i++){
                out.write(lines.get(i).getBytes(StandardCharsets.UTF_8));
            }
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return deleted;
    }
}
