package hust.soict.dsai.garbage;

import java.io.*;
import java.nio.file.*;

public class GarbageCreator {
    public static void main(String[] args) throws Exception {
        String filename = "test.txt";
        // Tạo file test nếu chưa có
        if (!Files.exists(Paths.get(filename))) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10000; i++) sb.append("Hello World Line " + i + "\n");
            Files.write(Paths.get(filename), sb.toString().getBytes());
        }

        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        // Dùng + operator -> tạo rất nhiều garbage
        long startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Using + operator: " + (endTime - startTime) + " ms, length=" + outputString.length());
    }
}
