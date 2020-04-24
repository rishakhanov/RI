package io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Analizy {
    private final Map<String, String> values = new HashMap<String, String>();
    private int i = 0;

    public void run(String source, String target) {

        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            read.lines().forEach(out::add);

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] lines = out.toString().split(System.lineSeparator());
        i = lines.length;

        String[] res;
        String[][] draft = new String[i][2];
        int j = 0;

        for (String line: lines) {
            res = line.toString().split(" ");
            draft[j][0] = res[0];
            draft[j][1] = res[1];
            j++;
        }

        String x="", y="";

        for (int k = 0; k < i;k++) {
            if ((Integer.parseInt(draft[k][0]) == 400) || (Integer.parseInt(draft[k][0]) == 500)) {
                x = draft[k][1];
                for (int m = k+1; m < i; m++) {
                    if ((Integer.parseInt(draft[m][0]) == 200) || (Integer.parseInt(draft[m][0]) == 300)) {
                        y = draft[m][1];
                        k=m;
                        break;
                    }
                }
                values.put(x, y);
            }
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
