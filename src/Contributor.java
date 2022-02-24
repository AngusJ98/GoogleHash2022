import java.util.ArrayList;

public class Contributor {
    public ArrayList<Skill> skills;
    public String name;
    public boolean isWorking;
    public Contributor(String name, ArrayList<Skill> skills){
        this.name = name;
        this.skills = skills;
        printSkills();
        this.isWorking = false;
    }
    public void printSkills(){
        for (int i = 0; i < skills.size(); i++ ){
            System.out.println(skills.get(i));
        }
    }
    public Skill getSkill(String skillage){
        Skill foundSkill = null;
        for(int i = 0; i < this.skills.size(); i++) {
            //System.out.println(skills.get(i).skillName + " - " + skillage);
            if (skillage.equals(this.skills.get(i).skillName)) {
                //System.out.println("Found it");
                foundSkill = skills.get(i);
            }
        }
        if (foundSkill == null){
//            System.out.println("Creatin new skill");
//            System.out.println(skillage);
//            printSkills();
//            System.out.println("/-/-/-/-/-/-/");
            Skill newSkill = new Skill(skillage, 0);
            this.skills.add(newSkill);
            foundSkill = newSkill;
        }
        //System.out.println(this.name + " : " + foundSkill);
        return foundSkill;
    }
    public double goodness(){
        double testValue = 0;
        for(int i = 0;i < skills.size();i++){
            testValue += skills.get(i).skillLevel;
        }
        return testValue;
    }
    public int suitability(Skill skillGiven){
//        System.out.println("Suitability Call");
//        System.out.println(skillGiven);
//        printSkills();
//        System.out.println("Then this");
//        System.out.println(getSkill(skillGiven.skillName));
//        System.out.println("-----");

        if(getSkill(skillGiven.skillName).skillLevel >= skillGiven.skillLevel ){
           // System.out.println(getSkill(skillGiven.skillName).skillLevel + " vs " +  skillGiven.skillLevel);
            return 2;
        } else if (skillGiven.skillLevel - 1 == getSkill(skillGiven.skillName).skillLevel) {
            return 1;
        } else {
            return 0;
        }
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
