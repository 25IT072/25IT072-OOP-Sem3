public class Payroll {
    public static void main(String[] args) {
        Employee[] employees = {
            new FullTime("Pal", 72, 8000),
            new PartTime("Khushi", 92, 80, 300),
            new Intern("Shreeya", 77, 2000),
            new Intern("Sneha", 10, 1500)
        };

        double total = 0;

        for(Employee e: employees){
            System.out.println("Name: " + e.name);
            System.out.println("ID: " + e.id);
            System.out.println("Monthly Salary: Rs." + e.monthly_salary());

            if(e instanceof Intern){
                System.out.println("Note: Intern");
            }
            System.out.println();
            total += e.monthly_salary();
        }
        System.out.println("Total Salary: " + total);
    }
}
