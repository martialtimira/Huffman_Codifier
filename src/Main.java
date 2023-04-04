import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Pair<String, Integer>> prob_list = new ArrayList<Pair<String, Integer>>();

        try(BufferedReader br = new BufferedReader(new FileReader("prob_table.csv"))) {

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hello world!");
    }
}