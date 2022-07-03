package org.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

class HttpURLConnectionExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://imdb.com");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        connection.setRequestMethod("GET");

        System.out.println( "Expired date: " + connection.getExpiration() );

        System.out.println( "Last modified: " + connection.getLastModified() );

        System.out.println( "Doc date: " + new Date(connection.getDate()) );

        System.out.println( "Content-type: " + connection.getContentType() );
        System.out.println( "Content length: " + connection.getContentLength() );
        System.out.println( "Response code: " + connection.getResponseCode() );
    }
}
