public class Main {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("Perov", "Ivan", "Alekseevich", 1, 50_000);
        employees[1] = new Employee("Pankov", "Mark", "Dmitrievich", 1, 70_000);
        employees[2] = new Employee("Gres", "Roman", "Antonovich", 3, 100_000);
        employees[3] = new Employee("Saveliev", "Yuriy", "Afanasievich", 5, 190_000);
        employees[4] = new Employee("Pavlov", "Stepan", "Aleksandrovich", 4, 120_000);
        employees[5] = new Employee("Grishin", "Dmitriy", "Stepanovich", 4, 105_000);
        employees[6] = new Employee("Miheev", "Oleg", "Evgenievich", 2, 111_000);
        employees[7] = new Employee("Lobov", "Aleksandr", "Dmitrievich", 5, 100_000);
        employees[8] = new Employee("Konstantinov", "Gulnaz", "Grigorievich", 3, 89_000);
        employees[9] = new Employee("Medakov", "Artem", "Pavlovich", 2, 90_000);


        employees[1].setSalary(150000);
        employees[1].setDepartment(3);
        System.out.println(employees.length);

        System.out.println("Сумма затрат на зп сотрудникам: " + countEmployeeSalarySum() + "\n");
        System.out.println("Всего сотрудников в компании: " + getEmployeeQuantity() + "\n");

        System.out.println("Средняя зп сотрудников: " + meanSalary() + "\n");
        System.out.println("Сотрудник с минимальной зп: \n" + findEmployeeWithMinimalSalary() + "\n");
        System.out.println("Сотрудник с максимальной зп: \n" + findEmployeeWithMaximalSalary() + "\n");

        System.out.println("Список ФИО всех сотрудников: ");
        printArray(getEmployeeFullNameList());
        System.out.println("___________________________________");

        //increaseSalaryForAllEmployees(10);
        for (int i = 0; i < employees.length && (employees[i] != null); i++) {
            System.out.println(employees[i]);
        }

        System.out.println(findEmployeeWithMinimalSalary(2));
        System.out.println(findEmployeeWithMaximalSalary(5));
        System.out.println(countSumOfSalaryInDepartment(2));
        System.out.println(countMeanSalaryInDepartment(2));
        increaseSalaryForEmployeesInDepartment(2, 10);
        System.out.println(countSumOfSalaryInDepartment(2));

    }


    public static int getEmployeeQuantity() {
        return Employee.count;
    }

    public static int countNotNullElementsInArray() {
        int i = 0;
        for (Employee empl : employees) {
            if (employees[i] != null) {
                i++;
            }
        }
        return i;
    }

    public static double countEmployeeSalarySum() {
        int salarySum = 0;
        for (int i = 0; i < employees.length; i++) {
            salarySum += employees[i].getSalary();
        }
        return salarySum;
    }

    public static Employee findEmployeeWithMinimalSalary() {
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

    public static Employee findEmployeeWithMaximalSalary() {
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

    public static double meanSalary() {
        return countEmployeeSalarySum() / countNotNullElementsInArray();
    }

    public static String[] getEmployeeFullNameList() {
        String[] fullNameList = new String[countNotNullElementsInArray()];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                fullNameList[i] = employees[i].getId() + " " + employees[i].getLastName() + " "
                        + employees[i].getFirstName() + " " + employees[i].getThirdName();
            }
        }
        return fullNameList;
    }

    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    //Middle level of project

    public static void increaseSalaryForAllEmployees(int percent) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                int newSalary = employees[i].getSalary() + (employees[i].getSalary() / 100 * percent);
                employees[i].setSalary(newSalary);
            }
        }
    }

    public static Employee findEmployeeWithMinimalSalary(int department) {
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

    public static Employee findEmployeeWithMaximalSalary(int department) {
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

    public static int countSumOfSalaryInDepartment(int department) {
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

    public static int countMeanSalaryInDepartment(int department) {
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

    public static void increaseSalaryForEmployeesInDepartment(int department, int percent) {
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