import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        ArrayList<Pair<String, Float>> prob_list = new ArrayList<>();
        ArrayList<TreeNode> tree = new ArrayList<>();

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

        Pair<String, Float> a, b;

        // Genera l'arbre binari segons les probabilitats
        while (prob_list.size() > 2) {
            sort(prob_list);
            a = prob_list.remove(0);
            b = prob_list.remove(0);
            addNode(a.getFirst(), b.getFirst(), tree);
            prob_list.add(new Pair<>(a.getFirst()+b.getFirst(), a.getSecond()+b.getSecond()));
        }
        addNode(tree.get(0).getVal(), tree.get(1).getVal(), tree);

        // Genera la taula amb els valors binaris equivalent de cada simbol
        HashMap<String, String> dict = new HashMap<>();
        generateTable(tree.get(0), "", dict);

    }

    // Ordena l'ArrayList de prioritat més baixa a prioritat més alta.
    private static void sort(ArrayList<Pair<String, Float>> l) {
        l.sort(Comparator.comparing(Pair::getSecond));
    }

    // Crea un nou sub-arbre amb els nous valors, i si pot el relaciona amb els existents
    private static void addNode(String a, String b, ArrayList<TreeNode> treeNodes){
        TreeNode ta = null, tb = null;

        // Busca si ja s'han creat sub-arbres amb els valors obtinguts
        for(int i = 0; i < treeNodes.size(); i++) {
            if(treeNodes.get(i).getVal().equals(a)) ta = treeNodes.remove(i);
            if(treeNodes.get(i).getVal().equals(b)) tb = treeNodes.remove(i);
        }

        if (ta == null) ta = new TreeNode(a);
        if (tb == null) tb = new TreeNode(b);

        treeNodes.add(new TreeNode(a+b, ta, tb));
    }

    // Itera l'arbre recursivament pre-order mentre genera els codis binaris
    private static void generateTable(TreeNode node, String bin, HashMap<String, String> dict) {
        if(node.getLeft() == null && node.getRight() == null) dict.put(node.getVal(), bin);
        else {
            generateTable(node.getLeft(), bin+"0", dict);
            generateTable(node.getRight(), bin+"1", dict);
        }
    }

}