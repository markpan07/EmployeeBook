public class Main {


    public static void main(String[] args)  {

    EmployeeBook book1 = new EmployeeBook();
    book1.addEmployee("Pankov", "Mark", "Dmitrievich", 1, 150_000);
    book1.addEmployee("Ivanov", "Samuil", "Olegovich", 1, 150_000);
    book1.addEmployee("Gres", "Roman", "Dmitrievich", 1, 150_000);
    book1.printArray(book1.getEmployeeFullNameList());
    book1.getEmployees();
    Employee[] pankovMark = book1.findEmployee("Pankov", "Mark", "Dmitrievich");
    printEmployee(pankovMark);


    book1.deleteEmployee("Pankov", "Mark", "Dmitrievich", 1);
    book1.printArray(book1.getEmployeeFullNameList());
        System.out.println("");
    book1.addEmployee("Grishin", "Aleksey", "Olegovich", 2, 95_000);
    book1.addEmployee("Puzin", "Yuliy", "Alekseevich", 2, 95_000);
    book1.printArray(book1.getEmployeeFullNameList());
    Employee[] puzin = book1.findEmployee("Puzin", "Yuliy", "Alekseevich");
    printEmployee(puzin);






      /*  System.out.println("Сумма затрат на зп сотрудникам: " + countEmployeeSalarySum() + "\n");
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
            System.out.println(array[i].toString());
        }
    }



}