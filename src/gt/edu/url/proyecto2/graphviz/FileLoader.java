package gt.edu.url.proyecto2.graphviz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileLoader {
    public void loadFileWithJava8() {
		String fileName = "C:\\Users\\Laptop\\Desktop\\Lab8_GraphViz_1067817\\Grafo2.dot";

		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
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
