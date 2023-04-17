import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {


        //1 dsklfm 5 dlskf 7 lkgd 9 kdfsjn 10dfs dsf11sdf -66 sdf s-67 df g-65dfg 100 dsf n300
        Collection<Integer> col = new ArrayList<Integer>();
        Numbers myNum = new Numbers();
        String characters  = JOptionPane.showInputDialog("Please enter in the numbers you would like to sort. Any format will work");
        col = myNum.collect(characters);
        JOptionPane.showMessageDialog(null, myNum.summarizeCollection(col));
    }
}