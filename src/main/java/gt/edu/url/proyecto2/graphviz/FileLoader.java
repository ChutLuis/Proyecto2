package gt.edu.url.proyecto2.graphviz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import gt.edu.url.proyecto2.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileLoader {

    /**
     * load a file using java 7 method.
     *
     * @return, returns a string with all the readed doc
     */
    public String writetext(String id) {

        String Rstring = "";
        File file = new File(id);
        try (FileInputStream fis = new FileInputStream(file)) {
            int content;
            while ((content = fis.read()) != -1) {
                // convert to char and add it
                Rstring += (char) content;
            }
            return Rstring;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * load a file using java 7 method and prints it in the console
     */
    public void loadFileWithJava7() {
        File file = new File("/Users/tuxtor/Downloads/linked_list.dot");

        try (FileInputStream fis = new FileInputStream(file)) {

            System.out.println("Total file size to read (in bytes) : " + fis.available());

            int content;
            while ((content = fis.read()) != -1) {
                // convert to char and display it
                System.out.print((char) content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads a file using java 8 and prints it in the consolo
     */
    public void loadFileWithJava8() {
        String fileName = "C:/Users/Luis/Desktop/try.txt";

        // read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * creates a new file .txt
     *
     * @param data data is the text that we want to add to the new doc
     */
    public void writeUsingFileWriter(String data) {
        File file = new File("C:/Users/Luis/Desktop/try.txt");

        try (FileWriter fw = new FileWriter(file)) {
            fw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
