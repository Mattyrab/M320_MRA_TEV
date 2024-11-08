import lib.CustomFileProcessor;
import java.util.Random;

/**
 * Class for handling ciphers
 *
 * @author Matthew Rabe
 */
public class Cipher {

    private String cipher;
    private String fileName;

    public Cipher(){}

    public Cipher(String newCipher){
        cipher = newCipher;
    }

    public Cipher(String textFileName, boolean createFile) {
        this.cipher = CustomFileProcessor.importText(textFileName, createFile);
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void importCipher(String cipherFileName, boolean createFile) {
        this.setFileName(cipherFileName);
        this.cipher = CustomFileProcessor.importText(cipherFileName, createFile);
    }

    /**
     * Create cipher key if none is present in the provided
     * cipher file before the encryption of the plaintext
     * @param plainText Text to be used for the cipher key creation
     */
    public void createCipherKey(String plainText) {

        int textLength = plainText.length();

        String cipherKey = "";

        Random cipherGenerator = new Random();

        cipherGenerator.setSeed(textLength + System.currentTimeMillis());

        for (int i = 0; i <= textLength; i++) {
            this.cipher =this.cipher.concat(String.valueOf((char)  cipherGenerator.nextInt(65, 90)));
        }
    }
}
