

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Contributor> test = new ArrayList<>();
        Parser.getinfo("./res/a_an_example.in.txt");

        System.out.println(Parser.conts.size());
        Combiner lmao = new Combiner(Parser.projs, Parser.conts);
        Output.write();
    }
}
    
