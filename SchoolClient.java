import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SchoolClient{

    public static void main(String[] args) throws IOException, NotBoundException, MalformedURLException, RemoteException {
        SchoolInterface school  = (SchoolInterface) Naming.lookup("rmi://localhost:1900/School");

        // Admit a student

        school.admit("Aryan Chandra");

        // Search for a student
        int rollNumber = 1;
        try {
            PrivateStudent foundStudent = school.search(rollNumber);
            System.out.println("Found student: " + foundStudent);
        } catch (Exception e) {
            System.out.println("Student not found: " + e.getMessage());
        }
    }
}

