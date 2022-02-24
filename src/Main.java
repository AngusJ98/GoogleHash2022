

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Contributor> test = new ArrayList<>();
        Parser.getinfo("a_an_example.in.txt");
        System.out.println(Parser.conts.toString());
    }
    
}
