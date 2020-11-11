package com.wowotou.payservice.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;

public class PosStr2Byte {
    private static final char[] a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] b = new byte[256];
    private byte[] c = new byte[4];
    protected int a() {
        return 4;
    }

    protected int b() {
        return 72;
    }

    static {
        int i = 0;
        for (int i2 = 0; i2 < 255; i2++) {
            b[i2] = (byte) -1;
        }
        while (i < a.length) {
            b[a[i]] = (byte) i;
            i++;
        }
    }
    protected void a(PushbackInputStream pushbackInputStream, OutputStream outputStream) throws IOException {
    }

    protected void b(PushbackInputStream pushbackInputStream, OutputStream outputStream) throws IOException {
    }

    protected int c(PushbackInputStream pushbackInputStream, OutputStream outputStream) throws IOException {
        return b();
    }

    protected void d(PushbackInputStream pushbackInputStream, OutputStream outputStream) throws IOException {
    }

    protected void a(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i)  {

    }

    protected int a(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read();
            if (read != -1) {
                bArr[i3 + i] = (byte) read;
                i3++;
            } else if (i3 == 0) {
                return -1;
            } else {
                return i3;
            }
        }
        return i2;
    }

    public void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        a(pushbackInputStream, outputStream);
        while (true) {
            try {
                int c = c(pushbackInputStream, outputStream);
                int i = 0;
                while (a() + i < c) {
                    a(pushbackInputStream, outputStream, a());
                    i += a();
                }
                if (a() + i == c) {
                    a(pushbackInputStream, outputStream, a());
                } else {
                    a(pushbackInputStream, outputStream, c - i);
                }
                d(pushbackInputStream, outputStream);
            } catch (Exception e) {
                b(pushbackInputStream, outputStream);
                return;
            }
        }
    }

    public byte[] str2byte(String str) throws IOException {
        byte[] bArr = new byte[str.length()];
        str.getBytes(0, str.length(), bArr, 0);
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(byteArrayInputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
