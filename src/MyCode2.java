/* package whatever; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


// This one skips all illegal characters before doing stepThroughMatching
class MyCode2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);

        ArrayList<Integer> output = new ArrayList<>();

        int n = input.indexOf(";");
        String word = input.substring(0, n);
        String phrase = input.substring(n + 1);

        String hashed = hash(word.toLowerCase());

        if (phrase == null || word == null || phrase.length() < word.length())
            return;

        int beginIndex = 0;
        int endIndex = 1;
        int i = 0;
        while (i < phrase.length()) {
            // traversing for legal characters
            if (hashed.contains(phrase.toLowerCase().substring(i, i + 1))) {
                endIndex = i + 1;
            } else {
                if (endIndex >= beginIndex + word.length())
                    output.addAll(stepThroughMatch(hashed, phrase.substring(beginIndex, endIndex), beginIndex));
                beginIndex = i + 1;
            }
            i++;
        }

        output.addAll(stepThroughMatch(hashed, phrase.substring(beginIndex, endIndex), beginIndex));

        output.stream().forEach((m) -> System.out.print("" + m + " "));
    }

    static String hash(String str) {
        char[] arr = str.toLowerCase().toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    static ArrayList<Integer> stepThroughMatch(String hashedWord, String phrase, int overhead) {
        ArrayList<Integer> list = new ArrayList<>();
        if (phrase.length() >= hashedWord.length())
            for (int i = 0; i <= phrase.length() - hashedWord.length(); i++)
                if (hashedWord.equals(hash(phrase.substring(i, i + hashedWord.length()))))
                    list.add(i + overhead);

        return list;
    }

}
