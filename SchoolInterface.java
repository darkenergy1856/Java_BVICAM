import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SchoolInterface extends Remote {
   void admit(String name) throws RemoteException;

   PrivateStudent search(int rollNo) throws Exception;

}
