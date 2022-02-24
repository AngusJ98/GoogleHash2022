
import java.util.ArrayList;

public class Project {
    String name;
    int days;
    int score;
    int bestBefore;
    ArrayList<Skill> roles;
    int daysWorkedOn;
    boolean isFinished = false;

    ArrayList<WorkingOn> woking;
    Project(String name, int days, int score, int endDay, ArrayList<Skill> roles) {
        this.name = name;
        this.days = days;
        this.bestBefore = endDay;
        this.roles = roles;
        woking = new ArrayList<WorkingOn>();
        for(int i = 0; i < roles.size(); i++){
            System.out.println(roles.get(i));
        }
    }
    public int getLastestFullDay(){
        return bestBefore-days;
    }
    public double scorePerDay(){
        float combineSkill = 0;
        for(int i = 0; i < roles.size(); i++){
            combineSkill = roles.get(i).skillLevel + combineSkill;
        }
        float combineSkillMult = 1;
        float daysMult = 1;
        float lastDay = getLastestFullDay();
        float lastDayMult = 100;
        return (double)(score / ((combineSkill*combineSkillMult)*(days*daysMult)*(lastDay*lastDayMult)));
    }

    public boolean getComplete(){
        if (days == daysWorkedOn){
            return true;
        } else {
            return false;
        }
    }
    public int getScore(int currentDay){
        int scoreTwo;
        for (int i = 0; i < woking.size();i++){
            woking.get(i).contrib.isWorking = false;
            woking.get(i).contrib.improveSkill(woking.get(i).skill);
        }
        this.isFinished = true;
        if (currentDay <= bestBefore){
            return score;
        } else {
            scoreTwo = score - (currentDay- bestBefore);
            if (scoreTwo < 1 ){
                scoreTwo = 1;
            }
            return scoreTwo;
        }
    }
    public boolean readyToGo(){
        if (woking.size() != roles.size()){
            return false;
        } else {
            System.out.println(this.name + " is ready to go!");
            return true;
        }
    }

}
