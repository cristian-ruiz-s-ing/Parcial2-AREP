package org.example;

import java.util.ArrayList;

import static spark.Spark.*;

public class MathServices {
    public static void main(String[] args){
        port(getPort());
        get("/hello/:value", (req, res) -> {
            return "Hola mundo"+ req.params("value");
        });
        get("/factors/:value", (req, res) -> getFactors(req.params("value")));
        get("/primes/:value", (req, res) -> getPrimes(req.params("value")));
    }

    private static String getPrimes(String value) {
        int num = Integer.parseInt(value);
        int temp = 1;
        ArrayList<Integer> primes = new ArrayList<>();
        while (temp <= num){
            ArrayList<Integer> factors = getFactors(String.valueOf(temp));
            if (factors.size()==2){
                primes.add(temp);
            }
            temp +=1;
        }

        return primes.toString();
    }

    private static ArrayList<Integer> getFactors(String value) {
        int num = Integer.parseInt(value);
        int temp = 1;
        ArrayList<Integer> factors = new ArrayList<>();
        while (temp <= num){
            if (num % temp == 0){
                factors.add(temp);
            }
            temp += 1;
        }
        return factors;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }

}
