package org.example;

import static spark.Spark.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

// ["http://localhost:4568/", "http://localhost:4569/"];


public class ServiceProxy {

    public static void main(String[] args) throws IOException {
        port(getPort());
        get("/hello", (req, res) -> "Hola mundo!");
        get("/", (req, res)-> WebClient.getClient());

        get("/mathservice/:fun/:value", (req, res) -> {
            String URLMathServices = "http://localhost:4568/"+req.params("fun")+"/"+req.params("value");
            URL obj= new URL(URLMathServices);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        });

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}