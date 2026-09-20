import java.util.*;
class DivideByZeroException extends Exception{
    DivideByZeroException(String msg){
        super(msg);
    }
}

public class Calculator{
    Scanner sc = new Scanner(System.in); 
    boolean success = false;

    public void calculate() throws DivideByZeroException{
            while(!success){
                System.out.println("Enter 1st number: ");
                int a = sc.nextInt();

                System.out.println("Enter 2nd number: ");
                int b = sc.nextInt();

                sc.nextLine();
                System.out.println("Enter operator: ");
                String op = sc.nextLine();

                double result;

                switch(op){
                    case "+": result = a+b;
                              break;
                    case "-": result = a-b;
                              break;
                    case "*": result = a*b;
                              break;
                    case "/":{
                        if(b==0){
                            throw new DivideByZeroException("Cannot divide by zero");
                        }
                        result = (double)a/b;
                        break;
                    }          
                    default:{
                        throw new IllegalArgumentException("Invalid operator");
                    }
                }

                System.out.println("Result = " + result); 
                success = true;
            }
    }
    public static void main(String[] args){
        Calculator c = new Calculator();
        try{
            c.calculate();
        }
        catch(DivideByZeroException e){
            System.out.println("Error: " + e.getMessage());
        }
        catch(IllegalArgumentException e){ 
            System.out.println("Error: " + e.getMessage()); 
        }
    }
}
