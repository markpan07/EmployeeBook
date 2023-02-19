public class Main {


    public static void main(String[] args) {

        EmployeeBook book1 = new EmployeeBook();
        book1.addEmployee("Pankov", "Mark", "Dmitrievich", 1, 150_000);
        book1.addEmployee("Ivanov", "Samuil", "Olegovich", 1, 150_000);
        book1.addEmployee("Gres", "Roman", "Dmitrievich", 1, 150_000);
        book1.addEmployee("Miheev", "Oleg", "Evgenievich", 2, 111_000);
        book1.addEmployee("Lobov", "Aleksandr", "Dmitrievich", 5, 100_000);
        book1.addEmployee("Konstantinov", "Gulnaz", "Grigorievich", 3, 89_000);
        book1.addEmployee("Medakov", "Artem", "Pavlovich", 2, 90_000);

        System.out.println("Список сотрудников:");
        book1.printArray(book1.getEmployeeFullNameList());
        System.out.println("Поиск сорудника по запросу:");
        Employee[] pankovMark = book1.findEmployee("Pankov", "Mark", "Dmitrievich");
        printEmployee(pankovMark);


        book1.deleteEmployee("Pankov", "Mark", "Dmitrievich", 1);
        System.out.println("Список сотрудников после удаления: ");
        book1.printArray(book1.getEmployeeFullNameList());
        System.out.println("");
        book1.addEmployee("Grishin", "Aleksey", "Olegovich", 4, 95_000);
        book1.addEmployee("Puzin", "Yuliy", "Alekseevich", 2, 95_000);
        System.out.println("Список сотрудников после добавления: ");
        book1.printArray(book1.getEmployeeFullNameList());
        Employee[] puzin = book1.findEmployee("Puzin", "Yuliy", "Alekseevich");
        printEmployee(book1.getEmployees());

        printEmployee(book1.findEmployee(4));
        book1.changeSalary(4, 100_000);
        book1.changeDepartment(4, 1);
        printEmployee(book1.findEmployee(4));

        book1.printEmployeesWithDepartment();




//middle level
      /*
        System.out.println("Сумма затрат на зп сотрудникам: " + countEmployeeSalarySum() + "\n");
        System.out.println("Всего сотрудников в компании: " + getEmployeeQuantity() + "\n");

        System.out.println("Средняя зп сотрудников: " + countMeanSalary() + "\n");
        System.out.println("Сотрудник с минимальной зп: \n" + findEmployeeWithMinimalSalary() + "\n");
        System.out.println("Сотрудник с максимальной зп: \n" + findEmployeeWithMaximalSalary() + "\n");

        System.out.println("Список ФИО всех сотрудников: ");
        printArray(getEmployeeFullNameList());
        System.out.println("___________________________________");

        System.out.println("Информация по 2му департаменту:" + "\n");
        System.out.println("Сотрудник с минимальной зп: \n" + findEmployeeWithMinimalSalary(2)+ "\n");
        System.out.println("Сотрудник с максимальной зп: \n" + findEmployeeWithMaximalSalary(5) + "\n");
        System.out.println("Сотрудники департамента: ");
        printArray(getEmployeeInfoListInDepartment(2));
        System.out.println("Сумма зарплат в департаменте: " + countSumOfSalaryInDepartment(2) +  "\n");
        System.out.println("Срденяя ЗП в департаменте: " + countMeanSalaryInDepartment(2) + "\n");
        System.out.println("ЗП после индексации на 10%% у сотрудников в департаменте");
        increaseSalaryForEmployeesInDepartment(2, 10);
        printArray(getEmployeeInfoListInDepartment(2));
        System.out.println("___________________________________");


        System.out.println("Сотрудники в  с ЗП меньше 100 000 рублей: " + getEmployeeQuantitySalaryLess(100000));
        printArray(getEmployeeListWithSalaryLess(100000));
        System.out.println();
        System.out.println("Сотрудники с ЗП больше 100 000 рублей: " + getEmployeeQuantitySalaryMore(100000));
        printArray(getEmployeeListWithSalaryMore(100000));*/
    }

    public static void printEmployee(Employee[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println(array[i].toString());
            } else {
                System.out.println(i + "- Пустое место");
            }
        }
    }

    public static void printEmployee(Employee empl) {
        System.out.println(empl.toString());
    }


}