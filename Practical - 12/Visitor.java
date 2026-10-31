import java.util.*;
public class Visitor{
    public static void main(String[] args) {
      List<String> loginNames = Arrays.asList(
        "Kanishk","Yashvi","Tanmay","Kanu","Riya","Sonu","Sneh","Swara","Kiaan"
      );

      HashSet<String> uniqueUsers = new HashSet<>(loginNames);
      LinkedHashSet<String> orderedUsers = new LinkedHashSet<>(loginNames);
      System.out.println("Total unique visitors: "+ uniqueUsers.size());
      System.out.println("First three distinct visitors:");
      int count = 0;

      for (String name : orderedUsers) {
          System.out.println(name);
          count++;
          if (count == 3) {
            break;
          }
      }
    }
    int totalLines = 0;
    int matchingLines = 0;
    for (Path file : files) {
        System.out.println("\n");
        System.out.println("File: " + file.getFileName());
        List<String> lines = Files.readAllLines(file);
    }
}



