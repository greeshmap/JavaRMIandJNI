import java.io.Serializable;
import java.rmi.RemoteException;
//import java.rmi.NotBoundException;
import java.rmi.server.UnicastRemoteObject;

public class CmdRegisterImpl extends UnicastRemoteObject implements CmdRegister,Serializable{
	Server S=new Server();
	protected CmdRegisterImpl() throws RemoteException {
		super();		
	}
	static {
		System.loadLibrary("Project3");
	}
	private native Object getlocaltime(GetLocalTime lt);
	private native Object getversion(GetVersion v);
	@Override 
	public Object execute(String CmdID, Object CmdObj) throws RemoteException {
		
		if(CmdID.equalsIgnoreCase("GetLocalTime"))
		{
			return new CmdRegisterImpl().getlocaltime((GetLocalTime) CmdObj);
		}
		else if(CmdID.equalsIgnoreCase("GetVersion"))
		{
			return new CmdRegisterImpl().getversion((GetVersion) CmdObj);
		}
		else
			return null;
	}

	
	
}