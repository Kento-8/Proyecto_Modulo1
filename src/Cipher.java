
public class Cipher {

    static char[] alfabeto = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
            , ' ', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '?', '!','@', '#', '$', '%','^', '&', '*','(',')','_','+'};

    public String encrypt(String text, int shift) throws KeyInvalidException {
        if (shift < 0) throw new KeyInvalidException("El desplazamiento no puede ser negativo.");
        StringBuilder encryptedText = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                
                encryptedText.append((char) ((character - base + shift) % 26 + base));
            } else {
                encryptedText.append(character); 
            }
        }
        return encryptedText.toString();
    }

    
    public String decrypt(String text, int shift) throws KeyInvalidException {
        if (shift < 0) throw new KeyInvalidException("El desplazamiento no puede ser negativo.");
        StringBuilder decryptedText = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                
                decryptedText.append((char) ((character - base - shift + 26) % 26 + base));
            } else {
                decryptedText.append(character); 
            }
        }
        return decryptedText.toString();
    }
}
