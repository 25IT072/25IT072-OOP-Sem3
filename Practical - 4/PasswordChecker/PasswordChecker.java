public class PasswordChecker {
    //checking rule 1
    public static boolean minLength(String pwd){
        return pwd.length() >= 8;
    }
    //checking rule 2
    public static boolean upper(String pwd){
        return pwd.matches(".*[A-Z].*");
    }
    //checking rule 3
    public static boolean digit(String pwd){
        return pwd.matches(".*[0-9].*");
    }
    //checking rule 4
    public static boolean specialCharacter(String pwd){
        return pwd.matches(".*[^a-zA-Z0-9].*");
    }
    //returning password
    public static String strength(String pwd) {
        int count = 0;
        if(minLength(pwd))
            count++;
        if(upper(pwd))
            count++;
        if(digit(pwd))
            count++;
        if(specialCharacter(pwd))
            count++;
        if(count <= 1)
            return "Weak";
        else if(count <= 3)
            return "Medium";
        else
            return "Strong";
    }
}
