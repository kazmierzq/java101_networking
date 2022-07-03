package org.example;

import java.net.MalformedURLException;
import java.net.URL;

class URLExample {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://test.com/path-to-file/a/file.pdf");
        System.out.println("protocol: " + url.getProtocol());
        System.out.println("host: " + url.getHost());
        System.out.println("path: " + url.getPath());
        System.out.println("file: " + url.getFile());
        System.out.println("port: " + url.getPort());
    }
}
