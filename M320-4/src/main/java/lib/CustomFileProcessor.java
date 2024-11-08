/**
 * <title>CustomFileProcessor
 * <p>
 * Description: Simple text file processor
 * <p>
 *              Write and read text files
 * <p>
 * @author Matthew Rabe
 * <p>
 * @version 1.0.0, Date: 09-11-2023, Original
 */

package lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomFileProcessor {

    // Import text file using the Scanner Class
    public static String importText(String fileName, boolean createFile) {

        String sImportedFile = "";

        // Size of internal character buffer of Scanner
        final int BUFFER_SIZE = 1024;

        File importedFile = null;

        try {
            if (createFile) {
                try {
                    importedFile = new File(fileName);
                    if (importedFile.createNewFile()) {
                        Output.printMessage("File created: " + fileName);
                    } else {
                        Output.printMessage("File already exists.");
                    }
                } catch (IOException error) {
                    Output.printMessage("An IO error occurred.");
                    error.printStackTrace();
                    System.exit(0);
                }
            } else {
              importedFile = new File(fileName);
            }

            // Compare File length to Scanner max buffer size
            if (importedFile.length() < BUFFER_SIZE) {
                Scanner fileScanner = new Scanner(importedFile);

                while (fileScanner.hasNext()) {
                    sImportedFile = sImportedFile.concat(fileScanner.nextLine() + "\n");
                }
            } else {
                Output.printMessage("File size is too big, limit is " + BUFFER_SIZE + " characters.");
                System.exit(0);
            }
        } catch (FileNotFoundException error) {
            Output.printMessage("File not found.");
            System.exit(0);
        }
        return sImportedFile;
    }

    public static void exportText(String fileName, String fileText) {

        // Create new file for encrypted/decrypted text
        try {
            File fileToExport = new File(fileName);
            if (fileToExport.createNewFile()) {
                Output.printMessage("File created: " + fileName);
            } else {
                Output.printMessage("File " + fileName + " already exists.");
            }
        } catch (IOException error) {
            Output.printMessage("An error occurred.");
            error.printStackTrace();
        }

        // Write text to file
        try {
            FileWriter fileToWrite = new FileWriter(fileName);
            fileToWrite.write(fileText);
            fileToWrite.close();
            Output.printMessage("Successfully wrote to the file " + fileName + ".");
        } catch (IOException error) {
            Output.printMessage("An error occurred.");
            error.printStackTrace();
        }
    }
}
