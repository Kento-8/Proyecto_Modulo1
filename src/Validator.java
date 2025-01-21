import java.io.File;

public class Validator {
    public boolean validateFile(String fileName) {
        File file = new File(fileName);
        return file.exists() && file.isFile();
    }
}
