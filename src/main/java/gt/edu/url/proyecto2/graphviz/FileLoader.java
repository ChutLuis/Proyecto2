package gt.edu.url.proyecto2.graphviz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import gt.edu.url.proyecto2.*;

public class FileLoader {

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

    public void writeUsingFileWriter(String data) {
        File file = new File("/Users/tuxtor/Downloads/salida.txt");

        try (FileWriter fw = new FileWriter(file)) {
            fw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
