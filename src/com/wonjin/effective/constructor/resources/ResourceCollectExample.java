package com.wonjin.effective.constructor.resources;

import java.io.*;

public class ResourceCollectExample {
    // try-finally
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        try {
            return bufferedReader.readLine();
        } finally {
            bufferedReader.close();
        }
    }

    // try-with-resources
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            return bufferedReader.readLine();
        }
    }

    // try-finally
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[100];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    // try-with-resources
    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[100];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }
}
