import java.util.ArrayList;

public class Parser {
    
    public static ArrayList<Project> projs;
    public static ArrayList<Contributor> conts;

    public static void getinfo(String fileName) {
        Parser.conts = new ArrayList<>();
        Parser.projs = new ArrayList<>();
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
            Parser.conts.add(new Contributor(name, contSkills));
            currentCont++;
        }
        int currentProj = 0;
        while (currentProj < numProject ) {
            String[] projInfo = rawInput.get(currentLine);
            String name = projInfo[0];
            ArrayList<Skill> projSkills = new ArrayList<>();
            int days = Integer.parseInt(projInfo[1]);
            int score = Integer.parseInt(projInfo[2]);
            int endDay = Integer.parseInt(projInfo[3]);
            int numRoles = Integer.parseInt(projInfo[4]);
            currentLine++;

            for (int i = 0; i < numRoles; i++) {
                Skill skill = new Skill(rawInput.get(currentLine)[0],  Integer.parseInt(rawInput.get(currentLine)[1]));
                projSkills.add(skill);
                currentLine++;
            }
            Parser.projs.add(new Project(name, days, score, endDay, projSkills));
            currentProj++;
        }
        System.out.println(Parser.conts);
        System.out.println(projs);
    }

}