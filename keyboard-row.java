import java.util.*;

class Solution {
    public String[] findWords(String[] words) {

        HashSet<Character> row1 = new HashSet<>();
        HashSet<Character> row2 = new HashSet<>();
        HashSet<Character> row3 = new HashSet<>();

        for (char c : "qwertyuiop".toCharArray())
            row1.add(c);

        for (char c : "asdfghjkl".toCharArray())
            row2.add(c);

        for (char c : "zxcvbnm".toCharArray())
            row3.add(c);

        List<String> result = new ArrayList<>();

        for (String word : words) {

            String lower = word.toLowerCase();

            HashSet<Character> currentRow;

            char first = lower.charAt(0);

            if (row1.contains(first))
                currentRow = row1;
            else if (row2.contains(first))
                currentRow = row2;
            else
                currentRow = row3;

            boolean valid = true;

            for (char ch : lower.toCharArray()) {

                if (!currentRow.contains(ch)) {
                    valid = false;
                    break;
                }
            }

            if (valid)
                result.add(word);
        }

        return result.toArray(new String[0]);
    }
}