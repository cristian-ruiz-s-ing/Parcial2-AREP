package org.example;

import static spark.Spark.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ServiceProxy {
    static int temp = 0;

    public static void main(String[] args) throws IOException {
        port(getPort());
        get("/hello", (req, res) -> "Hola mundo!");
        get("/", (req, res)-> WebClient.getClient());

        get("/mathservice/:fun/:value", (req, res) -> {
            String[] URLMathServices = {"http://ec2-54-221-50-99.compute-1.amazonaws.com:4568/"+req.params("fun")+"/"+req.params("value"), "http://ec2-3-90-108-226.compute-1.amazonaws.com:4569/"+req.params("fun")+"/"+req.params("value")};
            // Round Robin ""
            URL obj = new URL(URLMathServices[temp]);
            System.out.println(obj);
            if (temp == 0){
                temp = 1;
            } else{
                temp =0;
            }
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