import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Base64;

public class Encryption {
    private static final int ByteFF = 0xFF;
    public int globalkey;

    public String encodeToBase64(String encyptedString) {
        return Base64.getEncoder().encodeToString(encyptedString.getBytes());
    }

    public byte[] decodeToBase64(String decodedString) {
        return Base64.getDecoder().decode(decodedString);
    }

    public String convertToString(byte[] arrayOfStrings) {
        return new String(arrayOfStrings);
    }

    public String encryptDecrypt(String input) {
        List<Byte> inputBytes = new ArrayList<Byte>();
        for (byte b : input.getBytes()) {
            inputBytes.add(b); // 121-65-89
        }

        List<Byte> result = new ArrayList<Byte>(inputBytes.size());
        for (byte bb : inputBytes) {
            result.add((byte) (bb ^ (globalkey & ByteFF))); // XOR
        }

        StringBuilder converted = new StringBuilder();
        for (byte b : result) {
            converted.append((char) b);
        }
        return converted.toString();
    }

    // DITO LALAGAY YUNG PROMPT FOR USER TO EDIT KEY
    Encryption() {
        this.setKey(globalkey);
    }

    public int getKey() {
        return this.globalkey;
    }

    public void setKey(int key) {
        this.globalkey = key;
    }

    public void saveKey() {
        // Save the key here
        try (BufferedWriter outFile = new BufferedWriter(new FileWriter(Variables.keyFilePath));) {
            outFile.write(Integer.toString(globalkey));
        } catch( IOException e) {
            System.out.println("Error opening/writing to file: " + e.getMessage());
        }
    }

    public void retrieveKey() {
        try (BufferedReader inFile = new BufferedReader(new FileReader(Variables.keyFilePath));) {
            String key = inFile.readLine();
            setKey(Integer.parseInt(key));
        } catch( IOException e) {
            System.out.println("Error opening/writing to file: " + e.getMessage());
        }
    }
}
