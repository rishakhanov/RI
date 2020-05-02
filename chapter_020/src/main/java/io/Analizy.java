package io;

import java.io.*;
import java.util.*;

public class Analizy {
    private final Map<String, String> values = new HashMap<String, String>();

    public void run(String source, String target) {

        String line;
        String prev = "1";
        String[] res;
        String x = null, y = null;

        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            while ((line = read.readLine()) != null) {
                res = line.split(" ");
                if ( ((Integer.parseInt(res[0]) == 400) || (Integer.parseInt(res[0]) == 500))
                        & (Integer.parseInt(prev) == 200 || Integer.parseInt(prev) == 300) ) {
                    x = res[1];
                }

                if ( ((Integer.parseInt(res[0]) == 200) || (Integer.parseInt(res[0]) == 300))
                        & (Integer.parseInt(prev) == 400 || Integer.parseInt(prev) == 500) ) {
                    y = res[1];
                }

                if (x != null && y != null) {
                    values.put(x,y);
                    x = null;
                    y = null;
                }
                prev = res[0];
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
