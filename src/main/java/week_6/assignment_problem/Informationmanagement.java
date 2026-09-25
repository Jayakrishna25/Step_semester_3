package main.java.week_6.assignment_problem;
class Employeee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employeee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

class M5 {
    public static void main(String[] args) {
        Employeee e1 = new Employeee("Aarav", 55000);
        Employeee e2 = new Employeee("Diya", 62000);
        Employeee e3 = new Employeee("Kabir", 48000);

        Employeee.printCompanyInfo();
    }
}