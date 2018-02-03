package com.example.model;

/**
 * Created by karally on 2018/2/3.
 */

import android.os.Parcelable;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Expense implements Serializable{

    private FileManager fileManager = new FileManager();

    private static ArrayList<Expense> expenses = new ArrayList<>();

    private int amount;

    private String name;

    private Date date;

    public Expense(int amount, String name, Date date) {
        if (amount == 0){
            throw new IllegalArgumentException("Amount can't be 0!");
        }
        if (name == ""){
            throw new IllegalArgumentException("Name cannot be blank!");
        }
        if (date.after(Calendar.getInstance().getTime())){
            throw new IllegalArgumentException("You're not a time traveller = =");
        }
        this.amount = amount;
        this.name = name;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void save(String filePath) throws IOException {
        ObjectOutput obj = fileManager.saveToFile(filePath);

        obj.writeObject(expenses);
        obj.close();
    }

    public void restore(String filePath) throws IOException {
        ObjectOutput output = fileManager.saveToFile(filePath);
        output.writeObject(expenses);
        output.close();
    }

}
