public class Skill {
    public String skillName;
    public int skillLevel;
    public Skill(String skillName, int SkillLevel){
        this.skillName = skillName;
        this.skillLevel = SkillLevel;

    }

    @Override
    public String toString() {
        return "skillName='" + skillName + '\'' +
                ", skillLevel=" + skillLevel +
                '}';
    }
}
