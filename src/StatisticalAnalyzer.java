import java.util.HashMap;
import java.util.Map;

public class StatisticalAnalyzer {
    public Map<Character, Integer> analyzeFrequency(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                character = Character.toLowerCase(character);
                frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
            }
        }
        return frequencyMap;
    }

    public void displayFrequency(Map<Character, Integer> frequencyMap) {
        System.out.println("Análisis de Frecuencia:");
        frequencyMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

