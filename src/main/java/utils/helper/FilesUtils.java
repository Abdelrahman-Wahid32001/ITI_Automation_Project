package utils.helper;

import org.apache.commons.io.FileUtils;
import utils.report.LogsUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesUtils {
    private FilesUtils(){
        super();
    }
     public static void deleteFiles(File dirPath){
         if (dirPath==null || !dirPath.exists()){
             LogsUtils.warn("Directory does not exist:" + dirPath);
             return;
         }
         File[] filesList = dirPath.listFiles();
         if (filesList==null){
             LogsUtils.warn("Failed to list files in:" +dirPath);
             return;
         }
         for (File file : filesList){
             if(file.isDirectory()){
                 deleteFiles(file);
                 LogsUtils.info("File deleted successfully");
             }
             else {
                 try {
                     Files.delete(file.toPath());
                 }
                 catch (IOException e){
                     LogsUtils.error("Failed to delete file: " +file);
                 }
             }
         }
     }

     public static File getLatestFile(String dirPath){
         File folder = new File(dirPath);
         File[] files = folder.listFiles();
         if (files==null || files.length==0){
             LogsUtils.warn("No files found in the directory:" + dirPath);
             return null;
         }
         File latestFile = files[0];
         for (File file : files){
             if(file.lastModified()>latestFile.lastModified()){
                 latestFile=file;
             }
         }
         return latestFile;

     }
    public static boolean cleanFiles(File file){
        try {
            if (file.exists() && file.isDirectory()) {
                FileUtils.cleanDirectory(file);
                LogsUtils.info("Cleaned directory successfully: " + file.getPath());
                return true;
            } else {
                LogsUtils.info("Directory does not exist or is not a directory: " + file.getPath());
            }
        } catch (IOException e) {
            LogsUtils.warn("Could not clean directory (maybe it's in use?): " + file.getPath());
        }
        return false;
    }




     }

