package ellehacks2018.green.model;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Date;

/**
 * An Expense Manager of all expenses.
 */

public class ExpenseManager {

    private static ArrayList<ArrayList<Expense>> expenses = new ArrayList<>();

    private final static String PATH = "";

    public ExpenseManager() throws IOException {
        try {
            readFromFile();
        } catch (Exception e) {
            expenses.add(Transportation.foods);
        }
        writeToFile();
    }

    public static void writeToFile() throws IOException {
        FileManager fm = new FileManager();
        ObjectOutput output = fm.saveToFile(PATH);
        // Serialize
        output.writeObject(expenses);
        output.close();
    }

    public static void readFromFile() throws ClassNotFoundException, IOException {
        FileManager fm = new FileManager();
        ObjectInput input = fm.readFromFile(PATH);

        // Deserialize
        expenses = (ArrayList<ArrayList<Expense>>) input.readObject();
        input.close();
    }

    public void add(String category, String name, Date date, double amount){
        if (category.equals("food")){
            Transportation transportation = new Transportation(amount, name, date);
        }
    }

}
