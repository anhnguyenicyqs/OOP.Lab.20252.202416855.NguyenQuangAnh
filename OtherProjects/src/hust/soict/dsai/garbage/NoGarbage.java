package hust.soict.dsai.garbage;

import java.io.*;
import java.nio.file.*;

public class NoGarbage {
    public static void main(String[] args) throws Exception {
        String filename = "test.txt";
        if (!Files.exists(Paths.get(filename))) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10000; i++) sb.append("Hello World Line " + i + "\n");
            Files.write(Paths.get(filename), sb.toString().getBytes());
        }

        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        // Dùng StringBuilder -> không tạo garbage
        long startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        String result = outputStringBuilder.toString();
        long endTime = System.currentTimeMillis();
        System.out.println("Using StringBuilder: " + (endTime - startTime) + " ms, length=" + result.length());
    }
}
