package ellehacks2018.green.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * A Transportation expense entry.
 */

public class Transportation extends Expense {

    public static ArrayList<Expense> foods = new ArrayList<>();

    public Transportation(double amount, String name, Date date) {
        super(amount, name, date);
        foods.add(this);
    }

    public void delete(Transportation transportation) {
        foods.remove(transportation);
    }

}
