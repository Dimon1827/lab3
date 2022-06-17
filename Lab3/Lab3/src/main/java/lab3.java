import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.Arrays;


public class lab3 {

    public static void main(String... args) {

        String txt = readFile("vhod.html");
        Pattern pat = Pattern.compile("\\b([a-z0-9._-]+@[a-z0-9.-]+)\\b");

        Matcher match = pat.matcher(txt);
        List <String> email = new ArrayList<String>();
        while (match.find()) {
            int st=match.start();
            int end=match.end();
            email.add(txt.substring(st,end));
            System.out.println(txt.substring(st,end));
        }


        writeHtml(email, "vyhod.txt");
    }

    public static String readFile(String emailPath) {
        try (FileReader read = new FileReader(emailPath);
             BufferedReader buff = new BufferedReader(read)) {
            String txt = "";
            while(buff.ready()) {
                txt = txt.concat(buff.readLine());
            }
            return txt;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeHtml(List emailPath, String htmlPath) {
        try (FileWriter write = new FileWriter(htmlPath);
             BufferedWriter buff = new BufferedWriter(write)) {
            buff.write(String.valueOf(emailPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}