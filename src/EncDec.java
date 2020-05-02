public interface EncDec {

    String encrypt(String stringToEncrypt, int key);

    String decrypt(String stringToDecrypt, int key);

    }

