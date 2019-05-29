/* package whatever; // don't place package name! */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class MyCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);

        ArrayList<Integer> output = new ArrayList<>();

        int n = input.indexOf(";");
        String word = input.substring(0,n);
        String phrase = input.substring(n+1);

        String hashed = hash(word.toLowerCase());

        if (phrase==null || word==null||phrase.length() < word.length())
            return;

        for (int i=0; i<phrase.length()-word.length(); i++)
            if (hashed.equals(hash(phrase.substring(i, i+word.length()))))
                output.add(i);

        output.stream().forEach((m)->System.out.print("" + m + " "));

    }

    static String hash(String str) {
        char[] arr  = str.toLowerCase().toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

}
