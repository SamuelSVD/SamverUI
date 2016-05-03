package SystemUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class SystemUtils {
  public static ArrayList<ArrayList<String>> readStringCSV(String filename) {
    ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
    int index = 0;
    try {
      FileReader fr = new FileReader(filename);
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) {
        ArrayList<String> list = new ArrayList<String>();
//        System.out.printf("%d: ", index);
//        System.out.println(line);
        String[] parts = line.split(",");
        for(String part:parts){
          list.add(part);
        }
        lists.add(list);
        line = br.readLine();
        index++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return lists;    
  }
  public static ArrayList<ArrayList<Double>> readDoubleCSV(String filename) {
    ArrayList<ArrayList<Double>> lists = new ArrayList<ArrayList<Double>>();
    ArrayList<ArrayList<String>> strings = readStringCSV(filename);
    for(int i = 0; i < strings.size(); i++) {
      ArrayList<Double> list = new ArrayList<Double>();
      for(int j = 0; j < strings.get(i).size(); j++) {
        list.add(Double.parseDouble(strings.get(i).get(j)));
      }
      lists.add(list);
    }
    return lists;
  }
}
