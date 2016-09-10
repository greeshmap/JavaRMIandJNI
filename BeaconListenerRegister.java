
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface BeaconListenerRegister extends Remote{
	
	public int deposit(Beacon b)throws RemoteException;

}
