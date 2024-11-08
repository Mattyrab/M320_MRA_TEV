import lib.CustomFileProcessor;

/**
 * Class for handling text, both encrypted and decrypted
 *
 * @author Matthew Rabe
 */
public class EncryptionText {

    private String text;
    private Cipher cipher;
    private String fileName;
    private boolean encrypted = false;

    public EncryptionText() {}

    public EncryptionText(String newText){
        text = newText;
    }

    public EncryptionText(String textFileName, boolean createFile) {
        this.text = CustomFileProcessor.importText(textFileName, createFile);
    }

    public String getEncryptionText() {
        return text;
    }

    public void setEncryptionText(String text) {
        this.text = text;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public String getCipherString() {
        return cipher.getCipher();
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    public void importText(String textFileName, boolean createFile) {
        this.setFileName(textFileName);
        this.text = CustomFileProcessor.importText(textFileName, createFile);
    }
}
