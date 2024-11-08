import java.util.Random;
import lib.Input;
import lib.CustomFileProcessor;
import lib.Output;

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
public class Main {

    // Initialise Strings to avoid null pointer exception
    private static String plainTextFile = "";
    private static String plainText = "";

    private static String cipherTextFile = "";
    private static String cipherText = "";

    private static int encryptFileBool = 0;

    private static boolean exit = false;


    // INPUT METHODS -------------------------------------------------------------------

    // main input function
    private static void input() {

        plainTextFile = Input.inputString("Please give the plaintext file name: ");
        plainText = CustomFileProcessor.importText(plainTextFile, false);

        cipherTextFile = Input.inputString("Please give ciphertext file name:");
        cipherText = CustomFileProcessor.importText(cipherTextFile, true);

        encryptFileBool = Input.inputInt("Encrypt (1) / Decrypt (2) / Exit (3) ");
    }

    // PROCESSING METHODS -----------------------------------------------------------------

    private static void process() {

        switch (encryptFileBool) {

            case 1:
                // Generate cipher key if it doesn't exist
                if (cipherText.isEmpty()) {
                    cipherText = createCipherKey(plainText);
                }

                try {
                    plainText = RotateText.encrypt(Vigenere.encrypt(plainText, cipherText));
                } catch (RuntimeException exception) {
                    throw new EmptyParameterException("Plaintext / Ciphertext is missing!", exception);
                }
                break;

            case 2:
                // Exit if cipher key doesn't exist
                if (cipherText.isEmpty()) {
                    Output.printMessage("Cipher file is empty! Cannot decrypt");
                    break;
                }

                try {
                    plainText = Vigenere.decrypt(RotateText.decrypt(plainText), cipherText);
                } catch (RuntimeException exception) {
                    throw new EmptyParameterException("Plaintext / Ciphertext is missing!", exception);
                }
                break;

            case 3:
                exit = true;
                break;

            default:
               Output.printMessage("Invalid Option. \n\n");
                break;
        }
    }



    // Create cipher key if none is present in the provided
    // cipher file before the encryption of the plaintext
    private static String createCipherKey(String plainText) {

        int textLength = plainText.length();

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
        CustomFileProcessor.exportText(plainTextFile, plainText);
        CustomFileProcessor.exportText(cipherTextFile, cipherText);
    }

    // MAIN METHOD -------------------------------------------------------------------

    public static void main(String[] args) {

        do {

            input();
            process();
            output();

        } while(!exit);
    }
}

