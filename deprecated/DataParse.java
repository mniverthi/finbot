import java.util.Scanner;
import java.awt.*;
import java.io.IOException;
import java.net.*;

public class DataParse{
    public static void main(String[] args) throws IOException {
        Document webPage = jsoup.connect("https://finance.yahoo.com/trending-tickers").timeout(6000).get();
        System.out.println("Hello world!");
        
    }
}