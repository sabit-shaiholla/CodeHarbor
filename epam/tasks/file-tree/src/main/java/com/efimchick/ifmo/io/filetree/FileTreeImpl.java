package com.efimchick.ifmo.io.filetree;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class FileTreeImpl implements FileTree {
    private static final String BYTES_SUFFIX = " bytes";

    @Override
    public Optional<String> tree(Path path) {
        File file = new File(String.valueOf(path));
        if (!file.exists()) {
            return Optional.empty();
        }
        if (file.isFile()) {
            return Optional.of(file.getName() + " " + file.length() + BYTES_SUFFIX);
        }
        if (file.isDirectory()) {
            String tree = directoryTree(file, new ArrayList<>());
            System.out.println(tree);
            return Optional.of(tree);
        }
        return Optional.empty();
    }

    private String directoryTree(File folder, List<Boolean> lastFolders){
        StringBuilder directory = new StringBuilder();
        if (!lastFolders.isEmpty())
            directory.append(!(lastFolders.get(lastFolders.size() - 1)) ? "├─ " : "└─ ");
        directory.append(folder.getName())
                .append(" ")
                .append(folderSize(folder));

        buildFileTree(folder, lastFolders, directory);
        return directory.toString();
    }

    private void buildFileTree(File folder, List<Boolean> lastFolders, StringBuilder directory) {
        File[] files = folder.listFiles();
        if (files != null) {
            files = sortFiles(files);
            int folderCount = files.length;
            for (int i = 0; i < folderCount; i++) {
                addFileBranch(lastFolders, directory, i, folderCount, files);
            }
        }
    }

    private void addFileBranch(List<Boolean> lastFolders, StringBuilder directory, int i, int folderCount, File[] files) {
        directory.append("\n");
        ArrayList<Boolean> list = new ArrayList<>(lastFolders);
        list.add(i + 1 == folderCount);
        for (Boolean lastFolder : lastFolders) {
            directory.append(lastFolder ? "   " : "│  ");
        }
        if (files[i].isFile()) {
            directory.append(i + 1 == folderCount ? "└" : "├")
                    .append("─ ")
                    .append(files[i].getName())
                    .append(" ")
                    .append(files[i].length())
                    .append(BYTES_SUFFIX);
        } else {
            directory.append(directoryTree(files[i], list));
        }
    }

    private long getFolderSize(File folder){
        long size = 0;
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length();
                } else {
                    size += getFolderSize(file);
                }
            }
        }
        return size;
    }

    private String folderSize(File folder){
        return getFolderSize(folder) + BYTES_SUFFIX;
    }

    private File[] sortFiles(File[] files){
        Arrays.sort(files, Comparator.comparing(File::isDirectory, Comparator.reverseOrder())
                .thenComparing(File::getName, String.CASE_INSENSITIVE_ORDER));
        return files;
    }
}
