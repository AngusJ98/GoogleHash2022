import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Combiner {
    public Combiner(ArrayList<Project> projects, ArrayList<Contributor> contributors){
        int projectsComplete = 0;
        int days = 0;
        int score = 0;
        while(projectsComplete < projects.size()){
            ArrayList<Project> incompleteProjs = new ArrayList<>();
            for (int i = 0; i < projects.size(); i++){
                if(projects.get(i).getComplete()){
                    score = score + projects.get(i).getScore(days);
                    projectsComplete += 1;
                } else if (projects.get(i).woking.size() == 0){
                    incompleteProjs.add(projects.get(i));
                }
            }

            // Code here for assigning people



            //sort incompleteProjs
            Collections.sort(incompleteProjs, Comparator.comparingDouble(proj -> proj.scorePerDay()));

            for (Project i : incompleteProjs) {
                boolean cantComplete = false;
                boolean isComplete = false;
                int roleLooking = 0;
                while (!cantComplete && !isComplete) {
                    ArrayList<Contributor> availableConts = new ArrayList<>();
                    for (Contributor j : contributors) {
                        if (!j.isWorking) {
                            availableConts.add(j);
                        }
                    }

                    Collections.sort(availableConts, Comparator.comparingDouble(cont -> cont.goodness()));
                    boolean personFound = false;

                    boolean canMentor = false;
                    int skillReq = i.roles.get(roleLooking).skillLevel;
                    for (int people = 0; people < i.woking.size(); people++) {
                        if (i.woking.get(people).contrib.getSkill(i.roles.get(roleLooking).skillName).skillLevel >= skillReq) {
                            canMentor = true;
                        }
                    }
                    int valueLookingFor;
                    if (canMentor) {
                        valueLookingFor = 1;
                    } else {
                        valueLookingFor = 2;
                    }
                    int increment = 0;
                    while (!personFound) {
                        if (availableConts.get(increment).suitability(i.roles.get(roleLooking)) == valueLookingFor) {
                            personFound = true;
                            System.out.println(availableConts.get(increment).name + " was chosen for " +  i.roles.get(roleLooking).skillName + " " + i.roles.get(roleLooking).skillLevel);
                            i.woking.add(new WorkingOn(availableConts.get(increment), i.roles.get(roleLooking)));
                            availableConts.get(increment).isWorking = true;
                        }
                        increment += 1;
                        if (increment >= availableConts.size()) {
                            if (valueLookingFor == 1) {
                                valueLookingFor = 2;
                                increment = 0;
                            } else {
                                personFound = true;
                                cantComplete = true;
                            }
                        }

                    }

                    roleLooking = roleLooking + 1;
                    if (roleLooking >= i.roles.size()){
                        isComplete = true;
                    }

                }
                if (cantComplete) {
                    for (WorkingOn contrib : i.woking) {
                        contrib.contrib.isWorking = false;
                    }
                    i.woking = new ArrayList<WorkingOn>();
                } else{
                    Output.projectsDone.add(i);
                }

            }




            for (int i = 0; i < projects.size(); i++){
                if(!projects.get(i).getComplete()){
                    if(projects.get(i).readyToGo()){
                        projects.get(i).daysWorkedOn += 1;
                    }
                }
            }



            days = days+1;
        }
    }
}
