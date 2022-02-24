import java.util.ArrayList;

public class Contributor {
    public ArrayList<Skill> skills;
    public String name;
    public Contributor(String name, ArrayList<Skill> skills){
        name = name;
        skills = skills;
    }
    public Skill getSkill(String skillName){
        Skill foundSkill = null;
        for(int i = 0; i < skills.size(); i++) {
            if (skillName == skills.get(i).skillName) {
                foundSkill = skills.get(i);
            }
        }
        if (foundSkill == null){
            Skill newSkill = new Skill(skillName, 0);
            skills.add(newSkill);
            foundSkill = newSkill;
        }
        return foundSkill;
    }
}
