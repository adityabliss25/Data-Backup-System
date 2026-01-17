A comprehensive Java-based system designed to persist inventory data across multiple formats to ensure data durability and recovery.

🚀**Technical Implementation**

**Object Serialization**: Impleme**nted Serializable interface in the Product class to convert complex data structures into binary streams for local storage.

**Multi-Format Support**: Created a BackupService capable of exporting data to CSV (for spreadsheet compatibility) and JSON (using the GSON library for web-standard data exchange).

**Version Management**: Developed a timestamp-based naming convention (yyyyMMdd_HHmmss) to prevent data overwriting and manage multiple recovery points.

**Resource Management**: Utilized try-with-resources to handle all FileReaders and FileWriters, ensuring zero memory leaks and safe closure of system resources.

**📂 File Management Utilities**

Automatic directory verification and creation.

Versioned backup generation for JSON and CSV exports.

Restoration utility to reload binary data back into the application state.
