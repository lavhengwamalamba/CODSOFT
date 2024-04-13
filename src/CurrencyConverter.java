package src;

import java.io.*;
// import okhttp3.OkHttpClient;
// import okhttp3.Request;
// import okhttp3.Response;
// import json;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CurrencyConverter {

    static String base;
    static String target;
    static float amount;
    static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String[] currencies = { "USD", "CAD", "INR", "EUR" };
        System.out.println("Welcome to the Best Currency converter:");
        System.out.println("Select your base and Target Currency:");

        for (int i = 0; i < currencies.length; i++) {
            System.out.printf((i + 1) + ". " + "%-5s", currencies[i]);
            if ((i + 1) % 3 == 0) { // Start a new line after every 3 currencies
                System.out.println();
            }
        }
        if (currencies.length % 3 != 0) {
            System.out.println();
        }
        System.out.print("Base: ");
        base = currencies[input.nextInt() - 1];
        input.nextLine();
        System.out.print("Target: ");
        target = currencies[input.nextInt() - 1];
        input.nextLine();
        System.out.println("Enter amount you want to Convert");
        amount = input.nextFloat();
        input.nextLine();
        getRequest(base, target, amount);
        System.out.println("Thank you for using the worlds best Currency converter!");
        input.close();

    }

    public static void getRequest(String base, String target, float amount) throws IOException {
        String GET_URL = "https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_oUJrey2cJ2Bv7zURph5Ch3jSsbAY3FKNnIYdZQ3x&currencies="
                + base + "&base_currency=" + target;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputline;
            StringBuffer response = new StringBuffer();

            while ((inputline = in.readLine()) != null) {
                response.append(inputline);
            }
            in.close();
            String responseString = response.toString();
            // System.out.println(responseString);
            Double exchangeRate = Double.parseDouble(
                    responseString.substring(responseString.lastIndexOf(":") + 2, responseString.indexOf("}")));
            // System.out.println("Exchange Rate: " + exchangeRate);
            System.out
                    .println("" + amount + " " + base + " in " + target + " is: " + df.format((amount / exchangeRate)) + target);
        } else {
            System.out.println("GET request failed :(");
        }

    }
}
