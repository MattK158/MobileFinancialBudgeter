package pview.proj.internal.payview.model;

public class Subscription {
    String name;
    int month;
    int day;
    String cost;

    public Subscription(String name, int month, int day, String cost){
        this.name = name;
        this.month = month;
        this.day = day;
        this.cost = cost;
    }

    public Subscription() {
        this.name = name;
        this.month = month;
        this.day = day;
        this.cost = cost;
    }

    public String getCost() { return cost; }
    public void setCost(String cost) { this.cost = cost; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
}
