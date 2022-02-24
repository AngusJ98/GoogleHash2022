import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Output {
    public static ArrayList<Project> projectsDone = new ArrayList<>();
    
    public static String formatOutput() {
        StringBuilder pog = new StringBuilder();
        pog.append(projectsDone.size() + "\n");
        for (Project i : projectsDone) {
            pog.append(i.name + "\n");
            pog.append(i.woking.get(0).contrib.name);
            for (WorkingOn j : i.woking) {
                pog.append(" " + j.contrib.name);
            }
            pog.append("\n");
        }
        return pog.toString();
    }

    public static void write() {
        try {
            File outputFile = new File("out.txt");
            FileWriter writer = new FileWriter(outputFile);
            writer.append(formatOutput());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
