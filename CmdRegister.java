import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CmdRegister extends Remote {
	public Object execute(String CmdID, Object CmdObj) throws RemoteException;

}