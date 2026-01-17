import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BackupService {

    // Requirement: Object serialization to binary files
    public void saveToBinary(List<Product> products, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(products);
            System.out.println("Binary backup completed: " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving binary backup: " + e.getMessage());
        }
    }

    // Requirement: Read CSV files with data
    public void exportToCsv(List<Product> products, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("SKU,Name,Quantity,Price\n"); // Header
            for (Product p : products) {
                writer.write(p.toCsv() + "\n");
            }
            System.out.println("CSV export completed: " + filePath);
        } catch (IOException e) {
            System.out.println("Error exporting CSV: " + e.getMessage());
        }
    }
    public void saveToJson(List<Product> products, String filePath) {
        // Requirement: Resource management with try-with-resources
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(products, writer);
            System.out.println("JSON backup completed: " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving JSON: " + e.getMessage());
        }
    }
    public String generateVersionedFileName(String baseName, String extension) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        return baseName + "_v" + timestamp + extension;
    }
    public List<Product> restoreFromBinary(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Restore failed: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    public void createBackupDirectory(String dirPath) {
        File directory = new File(dirPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) { // Requirement: File and directory operations
                System.out.println("Backup directory created: " + dirPath);
            }
        }
    }
}