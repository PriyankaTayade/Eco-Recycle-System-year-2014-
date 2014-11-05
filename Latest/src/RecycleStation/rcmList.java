package RecycleStation;

import java.util.ArrayList;

import RCM.Recycler;

public class rcmList {
	private ArrayList <Recycler> rcm;
	public rcmList()
	{
		rcm = new ArrayList<Recycler>();		
		Recycler rcm1= new Recycler("Santa Barbara",1);
		Recycler rcm2= new Recycler("Santa Clara",2);
		Recycler rcm3= new Recycler("San Francisco",3);
		rcm.add(rcm1);
		rcm.add(rcm2);
		rcm.add(rcm3);
	}
	
	public ArrayList<Recycler> getRcmList()
	{
		return rcm;
	}

}
