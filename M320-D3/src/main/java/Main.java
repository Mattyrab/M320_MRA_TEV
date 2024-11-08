import java.util.Random;

    /**
     * <title>AdvancedTextEncryption
     * <p>
     * Description: Advanced text encrypter / decrypter using Vigenere cipher and ROT-20/6
     * <p>
     *              Only supports ASCII characters. Special characters will be ignored.
     *              Encryption procedure is: apply 'encrypt' vigenere ciphe -> apply ROT-20
     *              Decryption procedure is: apply ROT-6 -> apply 'decrypt' vigenere cipher
     * <p>
     * @author Matthew Rabe
     * <p>
     * @version 1.0.0, Date: 09-11-2023, Original
     * @version 1.0.1, Date: 10-11-2023, Update description and comments
     */

import lib.Input;
import lib.CustomFileProcessor;

public class Main {

    // Initialise Strings to avoid null pointer exception
    private static String plainTextName = "";
    private static String plainText = "";

    private static String cipherName = "";
    private static String cipherText = "";

    private static boolean encryptFileBool = false;


    // INPUT METHODS -------------------------------------------------------------------

    // main input function
    private static void input() {

        plainTextName = Input.inputString("Please give the plaintext file name: ");
        plainText = CustomFileProcessor.importText(plainTextName, plainText, false);

        cipherName = Input.inputString("Please give ciphertext file name:");
        cipherText = CustomFileProcessor.importText(cipherName, cipherText, true);

        encryptFileBool = Input.inputBoolean("Encrypt (yes) / Decrypt (no) plaintext: ");
    }

    // PROCESSING METHODS -----------------------------------------------------------------

    private static void process() {

        if (encryptFileBool) {

            // Generate cipher key if it doesn't exist
            if (cipherText.isEmpty()) {
                cipherText = createCipherKey(plainText);
            }

            try {
                plainText = RotateText.encrypt(Vigenere.encrypt(plainText, cipherText));
            } catch (RuntimeException exception) {
                throw new EmptyParameterException("Plaintext / Ciphertext is missing!", exception);
            }
        } else {

            // Exit if cipher key doesn't exist
            if (cipherText.isEmpty()) {
                System.out.println("Cipher file is empty! Cannot decrypt");
                System.exit(0);
            }

            try {
                plainText = Vigenere.decrypt(RotateText.decrypt(plainText), cipherText);
            } catch (RuntimeException exception) {
                throw new EmptyParameterException("Plaintext / Ciphertext is missing!", exception);
            }
        }
    }



    // Create cipher key if none is present in the provided
    // cipher file before the encryption of the plaintext
    private static String createCipherKey(String sPlainText) {

        int textLength = sPlainText.length();

        String cipherKey = "";

        Random cipherGenerator = new Random();

        cipherGenerator.setSeed(textLength + System.currentTimeMillis());

        for (int i = 0; i <= textLength; i++) {
            cipherKey = cipherKey.concat(String.valueOf((char)  cipherGenerator.nextInt(65, 90)));
        }
        return cipherKey;
    }

    // OUTPUT METHODS ------------------------------------------------------------------

    private static void output() {
        CustomFileProcessor.exportText(plainTextName, plainText);
        CustomFileProcessor.exportText(cipherName, cipherText);
    }

    // MAIN METHOD -------------------------------------------------------------------

    public static void main(String[] args) {

        input();
        process();
        output();
    }
}

