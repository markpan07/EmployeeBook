import org.w3c.dom.ls.LSOutput;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];

/*    employees[0] = new Employee("Perov", "Ivan", "Alekseevich", 1, 50_000);
    employees[1] = new Employee("Pankov", "Mark", "Dmitrievich", 1, 270_000);
    employees[2] = new Employee("Gres", "Roman", "Antonovich", 3, 300_000);
    employees[3] = new Employee("Saveliev", "Yuriy", "Afanasievich", 5, 190_000);
    employees[4] = new Employee("Pavlov", "Stepan", "Aleksandrovich", 4, 120_000);
    employees[5] = new Employee("Grishin", "Dmitriy", "Stepanovich", 4, 105_000);
    employees[6] = new Employee("Miheev", "Oleg", "Evgenievich", 2, 111_000);
    employees[7] = new Employee("Lobov", "Aleksandr", "Dmitrievich", 5, 100_000);
    employees[8] = new Employee("Konstantinov", "Gulnaz", "Grigorievich", 3, 89_000);
    employees[9] = new Employee("Medakov", "Artem", "Pavlovich", 2, 90_000);

    employees[1].setSalary(150000);
    employees[1].setDepartment(3);*/


    public Employee[] getEmployees() {
        return employees;
    }

    //Method for employee manage

    public Employee[] findEmployee(String lastName, String firstName, String thirdName) {
        int count = 0;
        for (Employee empl : employees) {
            if (empl != null) {
                if (empl.getLastName().equals(lastName) && empl.getFirstName().equals(firstName) &&
                        empl.getThirdName().equals(thirdName)) {
                    count++;
                }
            }
        }
        Employee[] foundEmployees = new Employee[count];

        count = 0;
        for (Employee empl : employees) {
            if (empl != null) {
                if (empl.getLastName().equals(lastName) && empl.getFirstName().equals(firstName) &&
                        empl.getThirdName().equals(thirdName)) {
                    foundEmployees[count] = empl;
                    count++;
                }
            }
        }
        return foundEmployees;
    }

    public Employee findEmployee(int id) {
        Employee search = null;
        for (Employee empl : employees) {

            if (empl != null) {
                if (empl.getId() == id) {
                    search = empl;
                }
            }

        }
        if (search == null) {
            System.out.println("Нет сотрудника с таким id");
        }
        return search;
    }


    public void changeSalary(int id, int newSalary) {
        Employee empl = findEmployee(id);
        empl.setSalary(newSalary);
    }

    public void changeDepartment(int id, int newDepartment) {
        Employee empl = findEmployee(id);
        empl.setDepartment(newDepartment);
    }

    public void addEmployee(String lastName, String firstName, String thirdName, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(lastName, firstName, thirdName, department, salary);
                break;
            }

        }
    }

    public void deleteEmployee(String lastName, String firstName, String thirdName, int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getLastName().equals(lastName) && employees[i].getFirstName().equals(firstName) &&
                    employees[i].getThirdName().equals(thirdName) && employees[i].getId() == id) {
                employees[i] = null;
                break;
            }

        }

    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    // Custom helpful methods

    public void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public int getEmployeeQuantitySalaryLess(int salary) {
        int count = 0;
        for (Employee empl : employees) {
            if ((empl != null) && (empl.getSalary() < salary)) {
                count++;
            }
        }
        return count;
    }

    public int getEmployeeQuantitySalaryMore(int salary) {
        int count = 0;
        for (Employee empl : employees) {
            if ((empl != null) && (empl.getSalary() >= salary)) {
                count++;
            }
        }
        return count;
    }

    public String[] getEmployeeListWithSalaryLess(int salary) {
        String[] employeeList = new String[getEmployeeQuantitySalaryLess(salary)];
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && (employees[i].getSalary() < salary)) {
                employeeList[count] = "ФИО: " + employees[i].getLastName() + " "
                        + employees[i].getFirstName() + " " + employees[i].getThirdName() + ", ЗП: "
                        + employees[i].getSalary() + ", ID: " + employees[i].getId();
                count++;
            }
        }
        return employeeList;

    }

    public String[] getEmployeeListWithSalaryMore(int salary) {
        String[] employeeList = new String[getEmployeeQuantitySalaryMore(salary)];
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && (employees[i].getSalary() >= salary)) {
                employeeList[count] = "ФИО: " + employees[i].getLastName() + " "
                        + employees[i].getFirstName() + " " + employees[i].getThirdName() + ", ЗП: "
                        + employees[i].getSalary() + ", ID: " + employees[i].getId();
                count++;
            }
        }
        return employeeList;

    }

    // Methods for all employees

    public void printEmployeesWithDepartment() {
        System.out.println("");
        System.out.println("Список сотрудников по департаментам");
        System.out.println("Департамент 1:");
        printArray(getEmployeeInfoListInDepartment(1));
        System.out.println("");
        System.out.println("Департамент 2:");
        printArray(getEmployeeInfoListInDepartment(2));
        System.out.println("");
        System.out.println("Департамент 3:");
        printArray(getEmployeeInfoListInDepartment(3));
        System.out.println("");
        System.out.println("Департамент 4:");
        printArray(getEmployeeInfoListInDepartment(4));
        System.out.println("");
        System.out.println("Департамент 5:");
        printArray(getEmployeeInfoListInDepartment(5));
        System.out.println("");
    }

    public int getEmployeeQuantity() {
        int count = 0;
        for (Employee empl : employees) {
            if (empl != null) {
                count++;
            }
        }
        return count;
    }

    public double countEmployeeSalarySum() {
        int salarySum = 0;
        for (int i = 0; i < employees.length; i++) {
            salarySum += employees[i].getSalary();
        }
        return salarySum;
    }

    public Employee findEmployeeWithMinimalSalary() {
        int minSalary = employees[0].getSalary();
        int position = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {

                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    position = i;
                }
            }
        }
        return employees[position];
    }

    public Employee findEmployeeWithMaximalSalary() {
        int maxSalary = employees[0].getSalary();
        int position = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    position = i;
                }
            }
        }
        return employees[position];
    }

    public double countMeanSalary() {
        return countEmployeeSalarySum() / getEmployeeQuantity();
    }

    public String[] getEmployeeFullNameList() {
        String[] fullNameList = new String[getEmployeeQuantity()];
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                fullNameList[count] = count + 1 + " " + employees[i].getLastName() + " "
                        + employees[i].getFirstName() + " " + employees[i].getThirdName();
                count++;
            }
        }
        return fullNameList;
    }

    public void increaseSalaryForAllEmployees(int percent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                int newSalary = employees[i].getSalary() + (employees[i].getSalary() / 100 * percent);
                employees[i].setSalary(newSalary);
            }
        }
    }


    //Methods for department
    public String[] getEmployeeInfoListInDepartment(int department) {
        String[] fullNameList = new String[getEmployeeQuantityInDepartment(department)];
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && (employees[i].getDepartment() == department)) {
                fullNameList[count] = "ФИО: " + employees[i].getLastName() + " "
                        + employees[i].getFirstName() + " " + employees[i].getThirdName() + ", ЗП: "
                        + employees[i].getSalary() + ", ID: " + employees[i].getId();
                count++;
            }
        }
        return fullNameList;

    }

    public int getEmployeeQuantityInDepartment(int department) {
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                count++;
            }
        }
        return count;
    }

    public Employee findEmployeeWithMinimalSalary(int department) {
        int minSalary = findEmployeeWithMaximalSalary().getSalary();
        int indexOfEmployee = findEmployeeWithMaximalSalary().getId() - 1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department) {
                    if (minSalary > employees[i].getSalary()) {
                        minSalary = employees[i].getSalary();
                        indexOfEmployee = employees[i].getId() - 1;
                    }
                }
            }
        }
        return employees[indexOfEmployee];
    }

    public Employee findEmployeeWithMaximalSalary(int department) {
        int maxSalary = findEmployeeWithMinimalSalary().getSalary();
        int index = findEmployeeWithMinimalSalary().getId() - 1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department) {
                    if (employees[i].getSalary() > maxSalary) {
                        maxSalary = employees[i].getSalary();
                        index = employees[i].getId() - 1;
                    }
                }
            }
        }
        return employees[index];
    }

    public int countSumOfSalaryInDepartment(int department) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department) {
                    sum = sum + employees[i].getSalary();
                }
            }
        }
        return sum;
    }

    public int countMeanSalaryInDepartment(int department) {
        int sum = countSumOfSalaryInDepartment(department);
        int peopleInDepartment = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department) {
                    peopleInDepartment++;
                }
            }
        }
        int meanSalary = sum / peopleInDepartment;
        return meanSalary;
    }

    public void increaseSalaryForEmployeesInDepartment(int department, int percent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() == department) {
                    int newSalary = employees[i].getSalary() + (employees[i].getSalary() / 100 * percent);
                    employees[i].setSalary(newSalary);
                }
            }
        }
    }
}
