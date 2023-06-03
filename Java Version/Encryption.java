import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

public class Encryption {
    private static final int ByteFF = 0xFF;
    private static final int globalkey = 70;

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
            inputBytes.add(b);
        }

        List<Byte> result = new ArrayList<Byte>(inputBytes.size());
        for (byte bb : inputBytes) {
            result.add((byte) (bb ^ (globalkey & ByteFF)));
        }

        StringBuilder converted = new StringBuilder();
        for (byte b : result) {
            converted.append((char) b);
        }
        return converted.toString();
    }

    // DITO LALAGAY YUNG PROMPT FOR USER TO EDIT KEY
}
