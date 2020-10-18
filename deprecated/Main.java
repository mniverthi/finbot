import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      Main.matchBenchmark(line);
    }
  }
  
  public static void matchBenchmark(String input) {
    // Access your code here. Feel free to create other classes as required
    String[] newInput = input.split(":");
    String[] portfolio = newInput[0].split("[|]");
    String[] benchmark = newInput[1].split("[|]");

    ArrayList<String> buy = new ArrayList<>();
    ArrayList<String> sell = new ArrayList<>();
    for(int i = 0; i < benchmark.length; i++) {
        String result = "";
        String[] currentBench = benchmark[i].split(",");
        for (int j = 0; j < portfolio.length; j++) {
            String[] currentPort = portfolio[j].split(",");
            if (currentBench[0].equals(currentPort[0]) && currentBench[1].equals(currentPort[1])) {
                if (Integer.parseInt(currentBench[2]) > Integer.parseInt(currentPort[2])) {
                    int t =Integer.parseInt(currentBench[2]) - Integer.parseInt(currentPort[2]);
                    result += "BUY,"+currentBench[0]+","+currentBench[1]+","+t;
                    break;
                } else if (Integer.parseInt(currentBench[2]) < Integer.parseInt(currentPort[2])) {
                    int t =Integer.parseInt(currentPort[2]) - Integer.parseInt(currentBench[2]);
                    result += "SELL,"+currentBench[0]+","+currentBench[1]+","+t;
                    break;
                } else {
                    result = "EQUAL";
                }
            }
        }
        if (result.equals("")) {
            result += "BUY,"+currentBench[0]+","+currentBench[1]+","+currentBench[2];
        }
        if (result.substring(0,3).equals("BUY")) {
            buy.add(result);
        } else {
            sell.add(result);
        }
    }
    // ArrayList<String> newBuy = new ArrayList<>();
    // ArrayList<String> newSell = new ArrayList<>();
    // for(int i = 0; i < portfolio.length; i++) {
    //     String result = "";
    //     String[] currentBench = portfolio[i].split(",");
    //     for (int j = 0; j < benchmark.length; j++) {
    //         String[] currentPort = benchmark[j].split(",");
    //         if (currentBench[0].equals(currentPort[0]) && currentBench[1].equals(currentPort[1])) {
    //             if (Integer.parseInt(currentBench[2]) > Integer.parseInt(currentPort[2])) {
    //                 int t =Integer.parseInt(currentBench[2]) - Integer.parseInt(currentPort[2]);
    //                 result += "BUY,"+currentBench[0]+","+currentBench[1]+","+t;
    //                 break;
    //             } else if (Integer.parseInt(currentBench[2]) < Integer.parseInt(currentPort[2])) {
    //                 int t =Integer.parseInt(currentPort[2]) - Integer.parseInt(currentBench[2]);
    //                 result += "SELL,"+currentBench[0]+","+currentBench[1]+","+t;
    //                 break;
    //             } else {
    //                 break;
    //             }
    //         }
    //     }
    //     if (result.equals("")) {
    //         result += "BUY,"+currentBench[0]+","+currentBench[1]+","+currentBench[2];
    //     }
    //     if (result.substring(0,3).equals("BUY")) {
    //         newBuy.add(result);
    //     } else {
    //         newSell.add(result);
    //     }
    // }
        LinkedHashSet<String> set1 = new LinkedHashSet<>(buy);
        //set1.addAll(newBuy);
        ArrayList<String> combinedList1 = new ArrayList<>(set1);
         
        
         
        LinkedHashSet<String> set2 = new LinkedHashSet<>(sell);
        //set2.addAll(newSell);
        ArrayList<String> combinedList2 = new ArrayList<>(set2);
        Collections.sort(combinedList2);
        Collections.sort(combinedList1);
        for(String i : combinedList2) {
          if (!i.equals("EQUAL"))
            System.out.println(i);
        }
        for(String i : combinedList1) {
          if (!i.equals("EQUAL"))
            System.out.println(i);
        }
  }

}