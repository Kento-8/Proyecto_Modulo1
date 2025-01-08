import java.util.Scanner;
public class CentralMain {

    public static void opciones() {
        Scanner scanner = new Scanner(System.in);
        Cipher cipher = new Cipher();
        FileManager fileManager = new FileManager();
        Validator validator = new Validator();
        BruteForce bruteForce = new BruteForce();
        StatisticalAnalyzer statisticalAnalyzer = new StatisticalAnalyzer();

        while (true) {
            System.out.println("Seleccione una opción:\n1. Cifrar texto\n2. Desencriptar archivo\n3. Análisis estadístico\n4. Fuerza bruta\n5. Salir");
            int option = scanner.nextInt(); scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1: // Cifrar texto
                    System.out.print("Ingrese el texto a cifrar: ");
                    String inputText = scanner.nextLine();
                    System.out.print("Ingrese el nombre del archivo: ");
                    String fileName = scanner.nextLine();
                    fileManager.saveToFile(fileName, inputText);
                    System.out.print("Ingrese el desplazamiento: ");
                    int shift = scanner.nextInt();
                    try {
                        String encryptedText = cipher.encrypt(inputText, shift);
                        fileManager.saveToFile("archivoEncriptado.txt", encryptedText);
                        fileManager.saveProperties(shift, fileName, "archivoEncriptado.txt");
                        System.out.println("Texto cifrado guardado.");
                    } catch (KeyInvalidException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2: // Desencriptar archivo
                    System.out.print("Ingrese el nombre del archivo a desencriptar: ");
                    String fileToDecrypt = scanner.nextLine();
                    if (validator.validateFile(fileToDecrypt)) {
                        System.out.print("Ingrese el desplazamiento: ");
                        int decryptShift = scanner.nextInt();
                        try {
                            String decryptedText = cipher.decrypt(fileManager.readFromFile(fileToDecrypt), decryptShift);
                            System.out.println("Texto desencriptado: " + decryptedText);
                        } catch (KeyInvalidException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("El archivo no existe.");
                    }
                    break;

                case 3: // Análisis estadístico
                    System.out.print("Ingrese el texto para análisis: ");
                    statisticalAnalyzer.displayFrequency(statisticalAnalyzer.analyzeFrequency(scanner.nextLine()));
                    break;

                case 4: // Fuerza bruta
                    System.out.print("Ingrese el texto cifrado: ");
                    bruteForce.crack(scanner.nextLine());
                    break;

                case 5: // Salir
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

