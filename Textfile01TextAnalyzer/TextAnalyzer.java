import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextAnalyzer {
    public static void main(String[] args) {
        String fileName = "textfile.txt";
        StringBuilder textContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textContent.append(line).append(" ");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        String text = textContent.toString().trim();
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int sentenceCount = countSentences(text);
        String upperCaseText = convertToUpperCase(text);
        String longestWord = findLongestWord(words);

        System.out.println("Total Words: " + wordCount);
        System.out.println("Total Sentences: " + sentenceCount);
        System.out.println("Uppercase Text:\n" + upperCaseText);
        System.out.println("Longest Word: " + longestWord);
    }

    private static int countSentences(String text) {
        String[] sentences = text.split("[.!?]");
        int count = 0;
        for (String sentence : sentences) {
            if (!sentence.trim().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    private static String convertToUpperCase(String text) {
        return text.toUpperCase();
    }

    private static String findLongestWord(String[] words) {
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
}
