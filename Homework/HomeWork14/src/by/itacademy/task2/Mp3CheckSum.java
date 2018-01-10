package by.itacademy.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

public class Mp3CheckSum {

    public void Mp3CheckSum(File[] files) {

        HashMap<String, ArrayList<String>> checkSumMap = new HashMap<>();
        for (int i = 0; i < files.length; i++) {
            try {
                if (checkSumMap.containsKey(getMD5Checksum(files[i]))) {
                    checkSumMap.get(getMD5Checksum(files[i])).add(files[i].getAbsolutePath());
                } else {
                    ArrayList<String> filePathList = new ArrayList<>();
                    checkSumMap.put(getMD5Checksum(files[i]), filePathList);
                    filePathList.add(files[i].getAbsolutePath());
                }
            } catch (Exception e) {
            }
        }

        for (HashMap.Entry<String, ArrayList<String>> entry : checkSumMap.entrySet()) {
            if (entry.getValue().size() >= 2) {
                System.out.println("Дубликаты по контрольной сумме:");
                for (int i = 0; i < entry.getValue().size(); i++) {
                    System.out.println("- " + entry.getValue().get(i));
                }
            }
        }
    }


    private byte[] createChecksum(File filename) throws Exception {
        InputStream fis =  new FileInputStream(filename);

        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("MD5");
        int numRead;

        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);

        fis.close();
        return complete.digest();
    }



    private String getMD5Checksum(File filename) throws Exception {
        byte[] b = createChecksum(filename);
        String result = "";

        for (int i=0; i < b.length; i++) {
            result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }

}
