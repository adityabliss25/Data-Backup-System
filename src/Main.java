import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> inventory = new ArrayList<>();
        inventory.add(new Product("A101", "Laptop", 5, 1200.00));
        inventory.add(new Product("B202", "Monitor", 10, 300.00)); // Added another item for better testing

        BackupService backup = new BackupService();

        // 1. Test JSON with Versioning
        String jsonVersion = backup.generateVersionedFileName("inventory", ".json");
        backup.saveToJson(inventory, jsonVersion);

        // 2. Test CSV Export (Requirement: Read and write CSV)
        backup.exportToCsv(inventory, "inventory_export.csv");

        // 3. Test Binary Save & Restore (Requirement: Object serialization)
        String binaryFile = "inventory_backup.dat";
        backup.saveToBinary(inventory, binaryFile);

        System.out.println("\n--- Attempting to restore data ---");
        List<Product> restoredData = backup.restoreFromBinary(binaryFile);
        restoredData.forEach(System.out::println);
    }
}