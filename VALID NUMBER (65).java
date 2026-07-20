class Solution {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean digit = false;
        boolean dot = false;
        boolean exp = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                digit = true;
            }
            else if (ch == '.') {
                // Decimal point cannot appear after e/E
                if (dot || exp)
                    return false;
                dot = true;
            }
            else if (ch == 'e' || ch == 'E') {
                // e/E must appear only once and after a digit
                if (exp || !digit)
                    return false;
                exp = true;
                digit = false; // Need digits after e/E
            }
            else if (ch == '+' || ch == '-') {
                // Sign is valid only at the beginning
                // or immediately after e/E
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            }
            else {
                return false;
            }
        }

        return digit;
    }
}
