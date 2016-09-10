
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

public class beaconListenerImpl extends UnicastRemoteObject implements BeaconListenerRegister,Runnable,Serializable{

	public ArrayList<Beacon> bcn;	
	public static beaconListenerImpl bl2;
	protected beaconListenerImpl() throws RemoteException {
		super();
	}
	public beaconListenerImpl getInstance() throws RemoteException{
		try {
			bl2=new beaconListenerImpl();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return bl2;
	}
	public void beaconlist(ArrayList<Beacon> bcn){		
		this.bcn=bcn;	
	}
	
	@Override
	public int deposit(Beacon b) throws RemoteException {
		
			
			if(bcn.contains(b))
			{
				int x=bcn.indexOf(b);
				if((b.getStartUpTime()-bcn.get(x).getStartUpTime()>5000))
				{
					System.out.println(b+" This is not a new agent");
					bcn.get(x).setstartUpTime(b.getStartUpTime());
					
				}
				bcn.get(x).setlastSignaltime(System.currentTimeMillis());
				return 0;
			}
			else
			{
			bcn.add(b);
			System.out.println("deposited beacon"+ b);
			CmdRegisterImpl CR=new CmdRegisterImpl();
			GetLocalTime lt=new GetLocalTime(0,'Y');
			System.out.println((CR.execute("GetLocalTime", lt)).toString());
			GetVersion v=new GetVersion(0);			
			System.out.println((CR.execute("getVersion", v)).toString());
			return 1;
		}
	}

	public void run() {
		for(;;)
		{
			try {
				Iterator<Beacon> it=bcn.iterator();
					while(it.hasNext())
					{
						Beacon b=it.next();
						if(System.currentTimeMillis()-b.getLastSignalTime() >=9000)
						{
					    	System.out.println(b.toString() + " is dead");
					    	it.remove();
						}
					}
					Thread.sleep(2000);
				} 
				catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	}
