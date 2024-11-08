/**
 * Utility Class for encrypting and decrypting text via the Rotation method.
 *
 * @author Matthew Rabe
 */
public final class RotateText implements Encryption {

    private RotateText(){}

    /**
     * ROT-20, this is applied to both upper- and lowercase letters.
     * Check decimal value of ASCII-Character and either push Character forward
     * or backward, depending on value.
     *
     * @param rawText The text that is to be encrypted
     * @return rotatedText
     */
    public static String encrypt(String rawText) {
        String rotatedText = "";

        for (int position = 0; position < rawText.length(); position++) {
            int iCharValue = rawText.charAt(position);

            if (iCharValue >= 65 && iCharValue <= 70) {
                iCharValue = iCharValue + 20;
            } else if (iCharValue >= 71 && iCharValue <= 90) {
                iCharValue = iCharValue - 6;
            } else if (iCharValue >= 97 && iCharValue <= 102) {
                iCharValue = iCharValue + 20;
            } else if (iCharValue >= 102 && iCharValue <= 122) {
                iCharValue = iCharValue - 6;
            }

            rotatedText = rotatedText.concat(String.valueOf((char) iCharValue));
        }
        return rotatedText;
    }

    /**
     * ROT-6, this is applied to both upper- and lowercase letters.
     * Check decimal value of ASCII-Character and either push Character forward
     * or backward, depending on value.
     *
     * @param encryptedText The text that is to be decrypted
     * @return rotatedText
     */
    public static String decrypt(String encryptedText) {
        String rotatedText = "";

        for (int position = 0; position < encryptedText.length(); position++) {
            int iCharValue = encryptedText.charAt(position);

            if (iCharValue >= 65 && iCharValue <= 84) {
                iCharValue = iCharValue + 6;
            } else if (iCharValue >= 85 && iCharValue <= 90) {
                iCharValue = iCharValue - 20;
            } else if (iCharValue >= 97 && iCharValue <= 116) {
                iCharValue = iCharValue + 6;
            } else if (iCharValue >= 117 && iCharValue <= 122) {
                iCharValue = iCharValue - 20;
            }

            rotatedText = rotatedText.concat(String.valueOf((char) iCharValue));
        }
        return rotatedText;
    }
}
