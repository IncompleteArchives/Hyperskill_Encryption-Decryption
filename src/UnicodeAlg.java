public class UnicodeAlg implements EncDec{


    public String encrypt(String stringToEncrypt, int key) {
        char[] chars = stringToEncrypt.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((int) chars[i] + key);
        }

        return new String(chars);
    }

    public String decrypt(String stringToDecrypt, int key) {
        char[] chars = stringToDecrypt.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((int) chars[i] - key);
        }

        return new String(chars);
    }
}
