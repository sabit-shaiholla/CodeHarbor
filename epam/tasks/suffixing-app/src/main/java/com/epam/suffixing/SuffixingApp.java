package com.epam.suffixing;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;
import java.io.FileInputStream;

public class SuffixingApp {

    private static final Logger logger = Logger.getLogger(SuffixingApp.class.getName());

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar suffixing.jar <config-file>");
            System.exit(1);
        }

        String configFile = args[0];
        try (FileInputStream input = new FileInputStream(configFile)) {
            Properties properties = new Properties();
            properties.load(input);
            processConfig(properties);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error reading config file", e);
        }
    }

    private static void processConfig(Properties properties) {
        String mode = properties.getProperty("mode");
        String suffix = properties.getProperty("suffix");
        String filesList = properties.getProperty("files");

        if (mode == null || !mode.matches("(?i)copy|move")) {
            logger.log(Level.SEVERE, "Mode is not recognized: " + mode);
            return;
        }

        if (suffix == null || suffix.isEmpty()) {
            logger.log(Level.SEVERE, "No suffix is configured");
            return;
        }

        if (filesList == null || filesList.isEmpty()) {
            logger.log(Level.WARNING, "No files are configured to be copied/moved");
            return;
        }

        String[] files = filesList.split(":");

        for (String filePath : files) {
            processFile(filePath.trim(), mode, suffix);
        }
    }

    private static void processFile(String filePath, String mode, String suffix) {
        Path sourcePath = Paths.get(filePath.replace('\\', '/'));
        Path destinationPath = getSourceWithSuffix(sourcePath, suffix);
        logger.log(Level.INFO, "Processing file: " + sourcePath);

        try {
            if (!Files.exists(sourcePath)) {
                logger.log(Level.SEVERE, "No such file: " + sourcePath);
                return;
            }
            if (mode.equalsIgnoreCase("move")) {
                Files.move(sourcePath, destinationPath);
                logger.log(Level.INFO, sourcePath + " => " + destinationPath);
            } else {
                Files.copy(sourcePath, destinationPath);
                logger.log(Level.INFO, sourcePath + " -> " + destinationPath);
            }
        } catch (FileAlreadyExistsException e) {
            logger.log(Level.SEVERE, "Destination file already exists: " + destinationPath);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error processing file: " + sourcePath, e);
        }
    }

    private static Path getSourceWithSuffix(Path sourcePath, String suffix) {
        String fileName = sourcePath.getFileName().toString();
        int lastDotIndex = fileName.lastIndexOf('.');
        String baseName = (lastDotIndex == -1) ? fileName : fileName.substring(0, lastDotIndex);
        String extension = (lastDotIndex == -1) ? "" : fileName.substring(lastDotIndex);
        String suffixedName = baseName + suffix + extension;
        return sourcePath.resolveSibling(suffixedName.replace('\\', '/'));
    }
}
