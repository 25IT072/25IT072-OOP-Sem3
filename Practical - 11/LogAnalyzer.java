import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.List;
public class LogAnalyzer{
public static void main(String[] args) {
    try {
        Path file1 = Paths.get("log1.txt");
        Path file2 = Paths.get("log2.txt");
        Path file3 = Paths.get("log3.txt");
        Files.write(file1, List.of("Application started", "ERROR: Database connection failed", "User logged in"), StandardCharsets.UTF_8);

        Files.write(file2, List.of("Server started", "WARNING: Low memory", "ERROR: File not found"), StandardCharsets.UTF_8);

        Files.write(file3, List.of("User logged out", "Application closed", "ERROR: Network failure"), StandardCharsets.UTF_8);

        Path[] files = {file1, file2, file3};
        String keyword = "ERROR";
        int totalLines = 0;
        int matchingLines = 0;

        for (Path file : files) {
            System.out.println("\n");
            System.out.println("File: " + file.getFileName());
            List<String> lines = Files.readAllLines(file);

            for (String line : lines) {
                System.out.println(line);
                totalLines++;

                if (line.contains(keyword)) {
                    matchingLines++;
                }
            }
            long size = Files.size(file);
            System.out.println("File size: " + size + " bytes");
        }

        System.out.println("\n");
        System.out.println("----- LOG ANALYSIS SUMMARY -----");
        System.out.println("Total lines: " + totalLines);
        System.out.println("Lines containing '" + keyword + "': " + matchingLines);

    } catch (IOException e) {
        System.out.println("File error: " + e.getMessage());
    }
}
}

