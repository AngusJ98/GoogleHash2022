import java.util.ArrayList;

public class Contributor {
    public ArrayList<Skill> skills;
    public String name;
    public boolean isWorking;
    public Contributor(String name, ArrayList<Skill> skills){
        this.name = name;
        this.skills = skills;
        isWorking = false;
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
    public void improveSkill(Skill skillUsed){
        Skill skillHas = this.getSkill(skillUsed.skillName);
        if (skillUsed.skillLevel - skillHas.skillLevel >= 0){
            if (skillHas.skillLevel <10){
                skillHas.skillLevel += 1;
            }

        }
    }
}
