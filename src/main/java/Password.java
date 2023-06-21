public class Password {
    String value;
    int length;

    public Password(String s) {
        value = s;
        length = s.length();
    }

    public int CharType(char c) {
        int val;
        if ((int) c >= 65 && (int) c <= 90)
            val = 1;
        else if ((int) c >= 97 && (int) c <= 122)
            val = 2;
        else if ((int) c >= 60 && (int) c <= 71)
            val = 3;
        else
            val = 4;
        return val;
    }

    public int passwordStrength() {
        String s = this.value;
        boolean usedUpper = false;
        boolean usedLower = false;
        boolean usedNum = false;
        boolean usedSym = false;

        int type;
        int score = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            type = CharType(c);

            if (type == 1) usedUpper = true;
            if (type == 2) usedLower = true;
            if (type == 3) usedNum = true;
            if (type == 4) usedSym = true;
        }
        if (usedUpper) score += 1;
        if (usedLower) score += 1;
        if (usedNum) score += 1;
        if (usedSym) score += 1;

        if (s.length() >= 8) score += 1;
        if (s.length() >= 16) score += 1;
        return score;
    }

    public String calculateScore() {
        int score = this.passwordStrength();

        if (score == 6) {
            return "This is a very good password. Please check the Useful Information section.";
        }

        if (score >= 4) {
            return "This is a good password. Try making it more better";
        }
        if (score >= 3) {
            return "This is a not much stronger password. Try making it more stronger";
        } else {
            return "This is a weak password. You must immediately change it.";
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
