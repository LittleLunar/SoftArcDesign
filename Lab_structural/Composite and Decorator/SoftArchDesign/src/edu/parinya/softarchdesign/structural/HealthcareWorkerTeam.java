package edu.parinya.softarchdesign.structural;

import java.util.LinkedHashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable{
	private Set<HealthcareServiceable> members = new LinkedHashSet<HealthcareServiceable>();
	
	public void addMember(HealthcareServiceable newMember) {
		
		members.add(newMember);
		
	}
	
	public void removeMember(HealthcareServiceable member) {
		
		members.remove(member);
		
	}
	
	@Override
	public void service() {
			
		for (HealthcareServiceable member : members) {
			
			member.service();
		}
	}

	@Override
	public double getPrice() {
		
		int totalPrice = 0;
				
		for (HealthcareServiceable member : members) {
			totalPrice += member.getPrice();
		}
		
		return totalPrice;
	}
	
	
}
