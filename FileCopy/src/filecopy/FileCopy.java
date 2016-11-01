/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filecopy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileCopy {

    static void copyToUTF8(String in, String out) throws IOException {
        FileInputStream fis = new FileInputStream(in);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        try (PrintWriter pw = 
                new PrintWriter(new OutputStreamWriter(new FileOutputStream(out),
                        StandardCharsets.UTF_8))) {
            for (String ln = br.readLine(); ln != null; ln = br.readLine()) {
                System.out.println(ln);
                pw.println(ln);
            }
        } 
//        finally {
//           pw.close(); 
//        }
    }

    public static void main(String[] args) {
        try {
            copyToUTF8("manifest.mf", "copym.mf");
        } catch (IOException ex) {
            Logger.getLogger(FileCopy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
