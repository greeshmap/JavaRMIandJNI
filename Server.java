
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;
import java.util.ArrayList;
import java.util.Iterator;
import java.rmi.Naming;

public class Server {
	ArrayList<Beacon> bcn=new ArrayList<Beacon>();
	public void beaconlist(ArrayList<Beacon> bcn){		
		this.bcn=bcn;	
	}
	public static void main(String[] args) throws Exception,RemoteException
	{		
		ArrayList<Beacon> bcn=new ArrayList<Beacon>();
		try{
			beaconListenerImpl BL=new beaconListenerImpl();
			RemoteRef location = BL.getRef();
			System.out.println (location.remoteToString());
			String registry = "localhost"; 
			if (args.length >=1) 
			{
			registry = args[0];
			}
			String registration = "rmi://" + registry + "/BeaconListenerRegister";
			Naming.rebind( registration, BL );		
			System.out.println("beaconListener registered..");
			registry = "localhost"; 
			if (args.length >=1) 
			{
				registry = args[0]; 
			}
			registration = "rmi://" + registry + "/CmdRegister";
			Remote remoteService;
			remoteService = Naming.lookup ( registration );
			CmdRegister CR = (CmdRegister) remoteService;
			BL.getInstance();
			BL.beaconlist(bcn);
			new Thread(BL).start();
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	}

