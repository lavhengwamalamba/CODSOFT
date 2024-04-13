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
import java.util.ArrayList;
import java.util.Scanner;

public class CurrencyConverter {
    static ArrayList<Currency> currencies = new ArrayList<>(java.util.Arrays.asList(
            new Currency("EUR", "Euro"),
            new Currency("USD", "US Dollar"),
            new Currency("JPY", "Japanese Yen"),
            new Currency("BGN", "Bulgarian Lev"),
            new Currency("CZK", "Czech Republic Koruna"),
            new Currency("DKK", "Danish Krone"),
            new Currency("GBP", "British Pound Sterling"),
            new Currency("HUF", "Hungarian Forint"),
            new Currency("PLN", "Polish Zloty"),
            new Currency("RON", "Romanian Leu"),
            new Currency("SEK", "Swedish Krona"),
            new Currency("CHF", "Swiss Franc"),
            new Currency("ISK", "Icelandic Króna"),
            new Currency("NOK", "Norwegian Krone"),
            new Currency("HRK", "Croatian Kuna"),
            new Currency("RUB", "Russian Ruble"),
            new Currency("TRY", "Turkish Lira"),
            new Currency("AUD", "Australian Dollar"),
            new Currency("BRL", "Brazilian Real"),
            new Currency("CAD", "Canadian Dollar"),
            new Currency("CNY", "Chinese Yuan"),
            new Currency("HKD", "Hong Kong Dollar"),
            new Currency("IDR", "Indonesian Rupiah"),
            new Currency("ILS", "Israeli New Sheqel"),
            new Currency("INR", "Indian Rupee"),
            new Currency("KRW", "South Korean Won"),
            new Currency("MXN", "Mexican Peso"),
            new Currency("MYR", "Malaysian Ringgit"),
            new Currency("NZD", "New Zealand Dollar"),
            new Currency("PHP", "Philippine Peso"),
            new Currency("SGD", "Singapore Dollar"),
            new Currency("THB", "Thai Baht"),
            new Currency("ZAR", "South African Rand")));
    static String base;
    static String target;
    static float amount;
    static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        // String[] currencies = { "USD", "CAD", "INR", "EUR" };
        System.out.println("Welcome to the Best Currency converter:");
        System.out.println("Select your base and Target Currency:");

        for (int i = 0; i < currencies.size(); i++) {
            Currency currency = currencies.get(i);
            System.out.printf("%2s" + ". " + "%-4s" + "%-25s",(i + 1), currency.getCode(), currency.getName());
            if ((i + 1) % 3 == 0) { // Start a new line after every 3 currencies
                System.out.println();
            }
        }
        if (currencies.size() % 3 != 0) {
            System.out.println();
        }
        System.out.print("Base: ");
        base = currencies.get(input.nextInt() - 1).getCode();
        input.nextLine();
        System.out.print("Target: ");
        target = currencies.get(input.nextInt() - 1).getCode();
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
                    .println("" + amount + " " + base + " in " + target + " is: " + df.format((amount / exchangeRate))
                            + target);
        } else {
            System.out.println("GET request failed :(");
        }

    }
}
