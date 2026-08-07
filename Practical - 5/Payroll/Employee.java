public abstract class Employee {
    protected String name;
    protected int id;

    Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
    public abstract double monthly_salary();
}
class FullTime extends Employee{
    private double fixed_salary;

    FullTime(String name, int id, double fixed_salary){
        super(name, id);
        this.fixed_salary = fixed_salary;
    }

    public double monthly_salary(){
        return fixed_salary;
    }
}

class PartTime extends Employee{
    private int hours;
    private double rate;

    PartTime(String name, int id, int hours, double rate){
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    public double monthly_salary(){
        return hours*rate;
    }
}

class Intern extends Employee{
    private double stipend;

    Intern(String name, int id, double stipend){
        super(name, id);
        this. stipend = stipend;
    }

    public double monthly_salary(){
        return stipend;
    }
}