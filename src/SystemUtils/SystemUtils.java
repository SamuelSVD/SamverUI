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
  
  public static ArrayList<ArrayList<Double>> multArrayByConst(ArrayList<ArrayList<Double>> list, double constant) {
 	ArrayList<ArrayList<Double>> new_list = new ArrayList<ArrayList<Double>>();
  	for (int i = 0; i < list.size(); i++) {
  		new_list.add(multByConst(list.get(i), constant));
  	}
  	return new_list;
  }
  
  public static ArrayList<Double> multByConst(ArrayList<Double> list, double constant) {
  	ArrayList<Double> new_list = new ArrayList<Double>();
  	for (int i = 0; i < list.size(); i++) {
  		new_list.add(list.get(i) * constant);
  	}
  	return new_list;
  }
  
  public static double sum(ArrayList<Double> list) {
  	double sum = 0;
  	for (int i = 0; i < list.size(); i++) {
  		sum += list.get(i);
  	}
  	return sum;
  }
  
  public static ArrayList<Double> sumEach(ArrayList<ArrayList<Double>> list) {
  	ArrayList<Double> sums = new ArrayList<Double>();
  	for (int i = 0; i < list.size(); i++) {
  		sums.add(sum(list.get(i)));
  	}
  	return sums;
  }
  
  public static String ArrayListToString(ArrayList<Double> arr) {
    String s = "{";
    for (int i = 0; i < arr.size(); i++) {
      s = s + Double.toString(arr.get(i));
      if (i != arr.size()-1) s = s + ",";
    }
    s = s + "}";
    return s;
  }
}
