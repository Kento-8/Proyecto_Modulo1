import java.io.File;

public class Validator {

    // Método para validar la existencia de un archivo
    public boolean validateFile(String fileName) {
        File file = new File(fileName);
        return file.exists() && file.isFile();
    }
}