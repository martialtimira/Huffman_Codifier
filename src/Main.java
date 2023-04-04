import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Pair<String, Float>> prob_list = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("Input_Files/prob_table.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split_line = line.split(",");
                Pair<String, Float> element = new Pair<>(split_line[0], Float.parseFloat(split_line[1]));
                System.out.println("Pair Created: [" + element.getFirst() + ", " + element.getSecond() + "]");
                prob_list.add(element);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("LIST SIZE: " + prob_list.size());
    }
}