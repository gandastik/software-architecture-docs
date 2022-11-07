import java.util.*;

import edu.parinya.softarchdesign.structural.HealthcareServiceable;


public class HealthcareWorkerTeam implements HealthcareServiceable{
    public Set<HealthcareServiceable> members;

    HealthcareWorkerTeam() {
        this.members = new LinkedHashSet<HealthcareServiceable>();
    }

    public void addMember(HealthcareServiceable healthcareServiceable) {
        this.members.add(healthcareServiceable);
    }

    public void removeMember(HealthcareServiceable healthcareServiceable){
        this.members.remove(healthcareServiceable);
    }

    public void service() {
        for (HealthcareServiceable healthcareServiceable : members) {
            healthcareServiceable.service();
        }
    }

    public double getPrice() {
        double totalPrice = 0;
        for (HealthcareServiceable healthcareServiceable : members) {
            totalPrice += healthcareServiceable.getPrice();
        }
        return totalPrice;
    }
}
