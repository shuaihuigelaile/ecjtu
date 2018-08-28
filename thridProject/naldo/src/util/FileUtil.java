package util;

public class FileUtil {
    public static String getFileName(String header){

        String[] temp = header.split(";");
        String[] temp2 = temp[2].split("=");

        String filename = temp2[1].substring(temp2[1].lastIndexOf("\\")+1).replaceAll("\"","");
        return filename;
    }
}
