package io;

import java.io.*;
import java.util.*;

public class Analizy {
    private final Map<String, String> values = new HashMap<String, String>();

    public void run(String source, String target) {

        String line;
        String prev = "1";
        char[] res1 = new char[8];
        char[] res2 = new char[8];
        char[] p = new char[3];
        boolean x = false, y = false;

        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            while ((line = read.readLine()) != null) {
                if ((line.contains("500") || line.contains("400"))
                    & (prev.contains("200") || prev.contains("300"))) {
                    line.getChars(4,12,res1,0);
                    x = true;
                }

                if ((line.contains("200") || line.contains("300"))
                        & (prev.contains("400") || prev.contains("500"))) {
                    line.getChars(4,12,res2,0);
                    y = true;
                }

                if (x&y) {
                    values.put(String.valueOf(res1), String.valueOf(res2));
                    x = false;
                    y = false;
                }
                line.getChars(0,3,p,0);
                prev = String.valueOf(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter ouT = new PrintWriter(new FileOutputStream(target))) {
            for (String key: values.keySet()) {
                String keyName = key.toString();
                String value = values.get(key).toString();
                ouT.println(keyName + ";" + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }
}
