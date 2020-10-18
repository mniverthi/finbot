import java.awt.*;
import java.net.*;

public class Stock{
    private String name;
    private String price;
    private String symbol;
    private String time;
    private double change;
    private double percentChange;
    private String volume;
    private double avgVol;
    private String mktCap;

    
    public Stock(String name, String price, String symbol, String time, double change, double percentChange
    , String volume, double avgVol, String mktCap){
        this.name = name;
        this.price = price;
        this.symbol = symbol;
        this.time = time;
        this.change = change;
        this.percentChange = percentChange;
        this.volume = volume;
        this.avgVol = avgVol;
        this.mktCap = mktCap;
    }
    public String getName(){
        return name;
    }
    public String getPrice(){
        return price;
    }
    public String getSymbol(){
        return symbol;
    }

    public String toString(){
        return name + " (" + symbol + ") " price + "\n";
    }
}