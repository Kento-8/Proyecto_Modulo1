public class BruteForce {
    public void crack(String encryptedText) {
        Cipher cipher = new Cipher();
        System.out.println("Intentando descifrar el texto cifrado...");
        for (int shift = 0; shift < 26; shift++) {
            try {
                System.out.println("Desplazamiento " + shift + ": " + cipher.decrypt(encryptedText, shift));
            } catch (KeyInvalidException e) {
                System.out.println("Error al descifrar con desplazamiento " + shift + ": " + e.getMessage());
            }
        }
    }
}