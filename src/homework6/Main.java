package homework6;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String result;

    public static void main(String[] args) {
        System.out.println("Введите дату в формате: 25.01.2017");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String baseUrl = "https://api.privatbank.ua/p24api/exchange_rates?json&date=";
        String url = null;
        try {
            url = baseUrl + reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = HttpUtil.sendRequest(url, null, null);
        fromJson();
    }

    private static void fromJson(){
        Gson gson = new Gson();
        Currency currency = gson.fromJson(result, Currency.class);
        try{
            if (currency.getExchangeRate().isEmpty()){
                System.out.println("курс на данную дату еще не готов");
            }
            for (int i = 0; i < currency.getExchangeRate().size(); i++) {
                if (currency.getExchangeRate().get(i).getCurrency().equals("USD")){
                    System.out.println("Курс USD - " + currency.getExchangeRate().get(i).getSaleRateNB());
                }
            }
        }catch (NullPointerException e){
            System.out.println("Данные введены в не верном формате, введите дату в формате: 25.01.2017");
        }
    }
}