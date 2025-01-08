import java.io.*;
import java.util.Properties;

public class FileManager {
    public void saveToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) content.append(line).append("\n");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return content.toString().trim();
    }

    public void saveProperties(int shift, String originalFileName, String encryptedFileName) {
        Properties properties = new Properties();
        properties.setProperty("desplazamiento", String.valueOf(shift));
        properties.setProperty("nombreArchivoOriginal", originalFileName);
        properties.setProperty("nombreArchivoEncriptado", encryptedFileName);
        try (OutputStream output = new FileOutputStream("propiedades.properties")) {
            properties.store(output, null);
        } catch (IOException e) {
            System.out.println("Error al guardar las propiedades: " + e.getMessage());
        }
    }
}