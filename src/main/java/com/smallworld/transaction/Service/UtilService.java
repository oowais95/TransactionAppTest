package com.smallworld.transaction.Service;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class UtilService {


        public  String readText(String path) throws IOException {

            BufferedReader br = new BufferedReader(new FileReader(path));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                return everything;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                br.close();
            }

        }


}
