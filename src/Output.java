import java.util.ArrayList;

public class Output {
    public static ArrayList<Project> projectsDone = new ArrayList<>();
    
    public static String formatOutput() {
        StringBuilder pog = new StringBuilder();
        pog.append(projectsDone.size() + "\n");
        for (Project i : projectsDone) {
            for (WorkingOn j : i.woking) {
                pog.append(j.contrib.name + " ");
            }
            pog.append("\n");
        }
        return pog.toString();
    }

}
