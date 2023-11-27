import java.io.Serial;
import java.io.Serializable;

public class PrivateStudent implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    static int assignedRollNo = 0;
    int rollNo;

    String name;

    public PrivateStudent(String name)  {
        this.rollNo = ++assignedRollNo;
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    @Override
    public String toString() {
        return "PrivateStudent{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }
}