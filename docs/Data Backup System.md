# Data Backup System Documentation

## 1. Project Overview and Objectives
The Data Backup System is designed to provide long-term storage and recovery for inventory records.

**Objective**: To transition from temporary in-memory storage to persistent data storage.

**Goal**: Enable multi-format backups (Binary, CSV, JSON) and implement recovery points through version management.

## 2. Setup and Installation Instructions
**IDE**: Developed and tested in IntelliJ IDEA.

**Java Version**: JDK 11 or higher.

**External Library**: Requires Gson 2.10.1 for JSON processing.

Step: Download gson-2.10.1.jar from Maven Central.

Step: Add the JAR to the project libs folder and select "Add as Library" in IntelliJ.

Git: Clone the repository and ensure the libs folder is included in the classpath.

## 3. Code Structure Explanation
The project follows a modular design to separate data models from business logic:

**Product.java**: The Data Model. Implements Serializable to allow binary state saving.

**BackupService.java**: The Engine. Contains methods for saveToBinary, exportToCsv, and saveToJson. It also handles filename versioning.

**Main.java**: The Driver. Demonstrates the workflow: creating data, backing it up in three formats, and restoring it from a file.

## 4. Technical Requirements Details
**Object Serialization**: Uses ObjectOutputStream to save the List<Product> to a .dat file.

**Resource Management**: Implements try-with-resources for all I/O operations to ensure file handles are released automatically.

**JSON Handling**: Utilizes GsonBuilder to generate "Pretty Printed" JSON files for human readability.

**Version Control**: Uses LocalDateTime to generate unique filenames, preventing accidental data overwrites during backups.

## 5. Screenshots & Diagrams
System Flow Diagram:
