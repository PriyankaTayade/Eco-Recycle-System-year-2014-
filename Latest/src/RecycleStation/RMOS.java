/*package RecycleStation;

import java.util.ArrayList;

import RCM.recycleMachine;

public class RMOS{
	
	private ArrayList<recycleMachine> RCMsUnderStation=new ArrayList<recycleMachine>();
	int noofRCMs = RCMsUnderStation.size();
    
	protected void addRecycleMachine(recycleMachine RCM,String RCMid,String location){
	      	
         RCMsUnderStation.add(RCM);
         RCM.setId(RCMid);
         RCM.setLocation(location);
	}
	protected void removeMachine(recycleMachine RCM){
		
		 RCMsUnderStation.remove(RCM);
		 
		
	};
	protected void addItemAccepted(recycleMachine RCM,item newitem){
		 
		RCM.items.add(newitem);
		RCM.noofrecyclableitems++;
		
	};
	
	showStatisticsPerRCM(recycleMachine RCM){
		
		
	};
	
	
	
	
	
} */