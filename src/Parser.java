import java.lang.reflect.Array;
import java.util.ArrayList;

public class Parser {
    
    int numContribute;
    int numProject;
    

    public static ArrayList<Contributor> getinfo(String fileName) {
        ArrayList<String[]> rawInput = FileReader.readFileAsIntArray(fileName);
        String[] info = rawInput.get(0);
        int numContribute;
        int numProject;
        numContribute = Integer.parseInt(info[0]);
        numProject = Integer.parseInt(info[1]);
        ArrayList<Contributor> conts = new ArrayList<>();
        int currentCont = 0;
        int currentLine = 1;
        while (currentCont < numContribute) {
            String[] contributeInfo = rawInput.get(currentLine);
            String name = contributeInfo[0];
            int numSKills = Integer.parseInt(contributeInfo[1]);
            currentLine++;
            ArrayList<Skill> contSkills = new ArrayList<>();
            for (int i = 0; i < numSKills; i++) {
                Skill skill = new Skill(rawInput.get(currentLine)[0],  Integer.parseInt(rawInput.get(currentLine)[1]));
                contSkills.add(skill);
                currentLine++;
            }
            conts.add(new Contributor(name, contSkills));
            currentCont++;
        }
        return conts;
    }

}