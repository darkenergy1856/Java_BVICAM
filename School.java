//Create an RMI application that exposes a remote object School.
// It should have two remote methods: admit() and search().
// The method admit should add a student’s record in the list of available students and search
// should return the details of student on the basis of roll number entered or raise an exception in case of
// invalid roll number. Demonstrate the use of these methods in a RMI client application.
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class School extends UnicastRemoteObject  implements SchoolInterface {

    private ArrayList<PrivateStudent> students;

    public School() throws RemoteException {
        super();
        students = new ArrayList<>();
    }

@Override
    public void admit(String name) throws RemoteException {
        students.add(new PrivateStudent(name));
        System.out.println("Admitted student : " + name + "\nRoll No. : " + students.get(PrivateStudent.assignedRollNo - 1).rollNo);
    }

@Override
    public PrivateStudent search(int rollNumber) throws RemoteException {
        for (PrivateStudent student : students) {
            if (student.getRollNo() == rollNumber) {
                return student;
            }
        }
        throw new RemoteException("Student with roll number " + rollNumber + " not found");
    }

    public static void main(String[] args) throws Exception {
        School school = new School();
        LocateRegistry.createRegistry(1900);
        Naming.rebind("rmi://localhost:1900/School", school);
        System.out.println("School server started...");
    }
}

