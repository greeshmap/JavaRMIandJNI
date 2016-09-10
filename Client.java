
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

public class Client extends UnicastRemoteObject {
	protected Client() throws RemoteException {
		super();
	}
	public int ID;
	public int StartUpTime;String CmdAgentID;
	public ArrayList<Beacon> bcn=new ArrayList<Beacon>();
	public static void main(String[] args)throws NotBoundException,RemoteException, MalformedURLException, InterruptedException
	{
		
		ArrayList<Beacon> bcn=new ArrayList<Beacon>();
			try { String registry = "localhost"; 
			   String registration = "rmi://" + registry + "/BeaconListenerRegister";
			   Remote remoteService = Naming.lookup ( registration );
			   BeaconListenerRegister BLR = (BeaconListenerRegister) remoteService;
			   RemoteRef location1 = ((RemoteObject) BLR).getRef();
			   String str=location1.remoteToString();
			   System.out.println("client started for beaconListener");
			   
			   CmdRegisterImpl CR=new CmdRegisterImpl();
			   RemoteRef location = CR.getRef();
			   System.out.println (location.remoteToString());
			   registry = "localhost"; 
				registration = "rmi://" + registry + "/CmdRegister";
				Naming.rebind( registration, CR );
			//	Naming.rebind("CmdRegister", CR);			
				System.out.println("cmdRegister registered");
			
			Client cl=new Client();
			
			System.out.println("enter ID");
			Scanner sc=new Scanner(System.in);
		    cl.ID=sc.nextInt();
			cl.StartUpTime=(int) System.currentTimeMillis();
			cl.CmdAgentID=str;
			while(true)
			{
			Beacon b=new Beacon(cl.ID, cl.StartUpTime, cl.CmdAgentID,System.currentTimeMillis());
			int d=BLR.deposit(b);
			Thread.sleep(5000);			
			}
			
			}
			catch (Exception e) {
				
				e.printStackTrace();
			}
		
	}
	

}