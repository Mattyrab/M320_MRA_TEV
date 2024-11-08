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

    private static int encryptFileBool = 0;

    private static boolean exit = false;


    // INPUT METHODS -------------------------------------------------------------------

    // main input function
    private static void input(EncryptionText text, Cipher cipher) {

        String plainTextFile = Input.inputString("Please give the plaintext file name: ");
        text.importText(plainTextFile, false);

        String cipherTextFile = Input.inputString("Please give ciphertext file name:");
        cipher.importCipher(cipherTextFile, true);

        text.setCipher(cipher);

        encryptFileBool = Input.inputInt("Encrypt (1) / Decrypt (2) / Exit (3) ");
    }

    // PROCESSING METHODS -----------------------------------------------------------------

    private static void process(EncryptionText text, Cipher cipher) {

        String plainText;
        String decryptedText;
        String encryptedText;
        String cipherText;

        switch (encryptFileBool) {

            case 1:
                // Generate cipher key if it doesn't exist
                if (cipher.getCipher().isEmpty()) {
                    cipher.createCipherKey(text.getEncryptionText());
                }

                plainText = text.getEncryptionText();
                cipherText = text.getCipherString();

                try {
                    encryptedText = RotateText.encrypt(Vigenere.encrypt(plainText, cipherText));
                    text.setEncryptionText(encryptedText);
                    text.setEncrypted(true);
                } catch (RuntimeException exception) {
                    throw new EmptyParameterException("Plaintext / Ciphertext is missing!", exception);
                }
                break;

            case 2:
                // Exit if cipher key doesn't exist
                if (text.getCipherString().isEmpty()) {
                    Output.printMessage("Cipher file is empty! Cannot decrypt");
                    break;
                }



                plainText = text.getEncryptionText();
                cipherText = text.getCipherString();

                try {
                    decryptedText = Vigenere.decrypt(RotateText.decrypt(plainText), cipherText);
                    text.setEncryptionText(decryptedText);
                    text.setEncrypted(false);
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


    // OUTPUT METHODS ------------------------------------------------------------------

    private static void output(EncryptionText text, Cipher cipher) {
        CustomFileProcessor.exportText(text.getFileName(), text.getEncryptionText());
        CustomFileProcessor.exportText(cipher.getFileName(), cipher.getCipher());
    }

    // MAIN METHOD -------------------------------------------------------------------

    public static void main(String[] args) {

        EncryptionText text = new EncryptionText();
        Cipher cipher = new Cipher();

        do {
            input(text, cipher);
            process(text, cipher);
            output(text, cipher);

        } while(!exit);
    }
}

