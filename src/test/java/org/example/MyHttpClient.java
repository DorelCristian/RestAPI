package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient{

    public static void main(String[] args) {
        String url = "http://localhost:8080/Cursa";


        HttpClient client = HttpClient.newHttpClient();

        String requestBody = "{\"destinatie\":\"dest\",\"date\":\"08-07-2003\"}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
 //               .DELETE()
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                    .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .GET()
                .build();

        try {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            int statusCode = response.statusCode();
            System.out.println("Status Code: " + statusCode);


            String responseBody = response.body();
            System.out.println("Response Body:");
            System.out.println(responseBody);

        } catch (Exception e) {
            System.err.println("Eroare în timpul trimiterii cererii: " + e.getMessage());
        }
    }
}