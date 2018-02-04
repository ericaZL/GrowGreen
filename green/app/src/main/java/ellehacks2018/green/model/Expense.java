package ellehacks2018.green.model;

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

    private double amount;

    private String name;

    private Date date;

    private String catagory;

    public Expense(double amount, String name, Date date) {
        setAmount(amount);
        setName(name);
        setDate(date);
    }

    public void setAmount(double amount) {
        if (amount == 0){
            throw new IllegalArgumentException("Amount can't be 0!");
        }
        this.amount = amount;
    }

    public void setName(String name) {
        if (name == ""){
            throw new IllegalArgumentException("Name cannot be blank!");
        }
        this.name = name;
    }

    public void setDate(Date date) {
        if (date.after(Calendar.getInstance().getTime())){
            throw new IllegalArgumentException("You're not a time traveller = =");
        }
        this.date = date;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public void delete(Expense e){}
}
