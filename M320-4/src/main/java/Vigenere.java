/**
 * Utility Class for encrypting and decrypting text via the Vigenère cipher.
 * Only supports the english language, numbers and special characters are ignored.
 *
 * @author Matthew Rabe
 */
public final class Vigenere implements Encryption {

    /**
     * This is the decimal difference between char 'a' and 'A',
     * thus, the definition in decimal value is: 97 - 65
     * which equals a difference of: 32
     */
    private static final int deltaLetter = 'a' - 'A';

    private Vigenere(){}

    /**
     * This method encrypts a string with the provided cipher.
     * The cipher can be longer or shorter than the raw text.
     *
     * @param rawText The text that is to be encrypted
     * @param cipher The cipher key to use for encryption
     * @return encryptedText
     */
    public static String encrypt(String rawText, String cipher) {
        String encryptedText = "";

        int rawTextLength = rawText.length();
        int cipherLength = cipher.length();
        int cipherPosition = 0;

        for (int position = 0; position < rawTextLength; position++)
        {

            // get character in text and cipher at their respective positions
            int charText = rawText.charAt(position);
            int charKey = cipher.charAt(cipherPosition);

            // check if character is uppercase letter
            if (charText >= 'A' && charText <= 'Z') {
                charText = (charText + charKey) % 26;

                // convert into uppercase letter
                charText += 'A';
            } else
            // check if character is lowercase letter
            if (charText >= 'a' && charText <= 'z') {
                charText = (charText + charKey - deltaLetter) % 26;

                // convert into lowercase letter
                charText += 'a';
            }

            encryptedText = encryptedText.concat(String.valueOf((char) charText));

            /* This section ensures that the cipher is looped over if the
             * rawText is longer than the cipher.
             */
            cipherPosition++;

            if (cipherPosition > cipherLength) {
                cipherPosition = 0;
            }
        }
        return encryptedText;
    }


    /**
     * This method encrypts a string with the provided cipher.
     * The cipher can be longer or shorter than the raw text.
     *
     * @param encryptedText The text that is to be decrypted
     * @param cipher The cipher key to use for encryption
     * @return decryptedText
     */
    public static String decrypt(String encryptedText, String cipher) {
        String rawText = "";

        int cipherTextLength = encryptedText.length();
        int cipherLength = cipher.length();
        int cipherPosition = 0;

        for (int position = 0 ; position < cipherTextLength; position++)
        {
            // get character in text and cipher at their respective positions
            int charText = encryptedText.charAt(position);
            int charKey =  cipher.charAt(cipherPosition);

            // check if character is uppercase letter
            if (charText >= 'A' && charText <= 'Z') {
                charText =  ((charText - charKey) + 26) % 26;

                // convert into uppercase letter
                charText += 'A';
            } else
            // check if character is lowercase letter
            if (charText >= 'a' && charText <= 'z') {
                charText =  ((charText - charKey - deltaLetter) + 26) % 26;

                // convert into lowercase letter
                charText += 'a';
            }

            rawText = rawText.concat(String.valueOf((char) charText));

            /* This section ensures that the cipher is looped over if the
             * rawText is longer than the cipher.
             */
            cipherPosition++;

            if (cipherPosition > cipherLength) {
                cipherPosition = 0;
            }
        }
        return rawText;
    }
}
