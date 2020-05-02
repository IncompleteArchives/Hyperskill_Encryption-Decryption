public class ShiftAlg implements EncDec {

    public String encrypt(String stringToEncrypt, int key) {

        String alphabetDefault = "abcdefghijklmnopqrstuvwxyz";

        String alphabet = alphabetDefault.substring(key) + alphabetDefault.substring(0, key);

        char[] chars = stringToEncrypt.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < alphabetDefault.length(); j++) {
                if (chars[i] == alphabetDefault.charAt(j)) {
                    chars[i] = alphabet.charAt(j);
                    break;
                } else if (chars[i] == alphabetDefault.toUpperCase().charAt(j)) {
                    chars[i] = alphabet.toUpperCase().charAt(j);
                    break;
                }
            }
        }
        return new String(chars);
    }

    public String decrypt(String stringToDecrypt, int key) {
        String alphabetDefault = "abcdefghijklmnopqrstuvwxyz";

        String alphabet = alphabetDefault.substring(alphabetDefault.length() - key) + alphabetDefault.substring(0,alphabetDefault.length() - key);

        char[] chars = stringToDecrypt.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < alphabetDefault.length(); j++) {
                if (chars[i] == alphabetDefault.charAt(j)) {
                    chars[i] = alphabet.charAt(j);
                    break;
                } else if (chars[i] == alphabetDefault.toUpperCase().charAt(j)) {
                    chars[i] = alphabet.toUpperCase().charAt(j);
                    break;
                }
            }
        }
        return new String(chars);

    }
}
