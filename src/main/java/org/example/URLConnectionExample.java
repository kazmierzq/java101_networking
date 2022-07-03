package org.example;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

class URLConnectionExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://imdb.com");
        URLConnection urlConnection = url.openConnection();

        BufferedInputStream inputStream =
                new BufferedInputStream(urlConnection.getInputStream());

        int i = 0;
        while( (i = inputStream.read()) != -1) {
            System.out.print( (char)i );
        }
    }
}
