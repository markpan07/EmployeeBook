import java.util.Objects;

public class Employee {

    final private String firstName;
    final private String lastName;
    final private String thirdName;
    final private int id;
    private int department;
    private int salary;

    static int count = 0;

    public Employee(String lastName, String firstName, String thirdName, int department, int salary) {
        count++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.thirdName = thirdName;
        this.department = department;
        this.salary = salary;
        this.id = count;

    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getThirdName() {
        return this.thirdName;
    }

    public int getId() {
        return this.id;
    }

    public int getDepartment() {
        return this.department;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "---" + "\n" +
                "Id: " + this.id + " \n" +
                "Last Name : " + this.lastName + " \n" +
                "Name : " + this.firstName + " \n" +
                "Third Name : " + this.thirdName + " \n" +
                "Department: " + this.department + " \n" +
                "Salary: " + this.salary + " \n" +
                "---";

    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Employee e = (Employee) o;
        if (this.id == e.getId() && this.firstName.equals(e.getFirstName()) &&
                this.thirdName.equals(e.getThirdName()) && this.lastName.equals(e.getLastName())
                && this.department == e.getDepartment() &&
                this.salary == e.getSalary()) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, thirdName, department);
    }


}
