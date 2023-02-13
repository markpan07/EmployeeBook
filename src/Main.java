public class Main {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Perov", "Ivan", "Alekseevich", 1, 50_000);
        employees[1] = new Employee("Pankov", "Mark", "Dmitrievich", 1, 70_000);
        employees[2] = new Employee("Gres", "Roman", "Antonovich", 3, 100_000);
        employees[3] = new Employee("Saveliev", "Yuriy", "Afanasievich", 5, 90_000);
        employees[4] = new Employee("Pavlov", "Stepan", "Aleksandrovich", 4, 120_000);
        employees[1].setSalary(150000);
        employees[1].setDepartment(3);

        System.out.println("Сумма затрат на зп сотрудникам: " + countEmployeeSalarySum() + "\n");
        System.out.println("Всего сотрудников в компании: " + getEmployeeQuantity() + "\n");

        System.out.println("Средняя зп сотрудников: " + meanSalary() + "\n");
        System.out.println("Сотрудник с минимальной зп: \n" + findEmployeeWithMinimalSalary() + "\n");
        System.out.println("Сотрудник с максимальной зп: \n" + findEmployeeWithMaximumSalary() + "\n");


        System.out.println("Список ФИО всех сотрудников: ");
        printArray(getEmployeeFullNameList());

    }

    public static int getEmployeeQuantity() {
        return Employee.count;
    }

    public static int countEmployeeSalarySum() {
        int salarySum = 0;
        for (int i = 0; (employees[i] != null) && (i <= (employees.length - 1)); i++) {
            salarySum = salarySum + employees[i].getSalary();
        }
        return salarySum;
    }

    public static Employee findEmployeeWithMinimalSalary() {
        int minSalary = employees[0].getSalary();
        int position = 0;

        for (int i = 0; (employees[i] != null) && (i <= employees.length - 1); i++) {
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                position = i;
            }
        }
        return employees[position];
    }

    public static Employee findEmployeeWithMaximumSalary() {
        int maxSalary = employees[0].getSalary();
        int position = 0;

        for (int i = 0; (employees[i] != null) && (i <= employees.length - 1); i++) {
            if (employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                position = i;
            }
        }
        return employees[position];
    }

    public static int meanSalary() {
        return countEmployeeSalarySum() / Employee.count;
    }

    public static String[] getEmployeeFullNameList() {
        String[] fullNameList = new String[Employee.count];
        for (int i = 0; (employees[i] != null) && (i <= employees.length - 1); i++) {
            fullNameList[i] = employees[i].getId() + " " + employees[i].getLastName() + " "
                    + employees[i].getFirstName() + " " + employees[i].getThirdName();
        }
        return fullNameList;
    }

    public static void printArray(String[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.println(array[i]);
        }
    }


}