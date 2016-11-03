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
  
  public static ArrayList<Double> sumAcross(ArrayList<ArrayList<Double>> list) {
  	ArrayList<Double> sums = new ArrayList<Double>();
  	for (int j = 0; j < list.get(0).size(); j++) {
  		double sum = 0;
  		for (int i = 0; i < list.size(); i++) {
  			sum += list.get(i).get(j);
  		}
  		sums.add(sum);
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

  public static double max(ArrayList<Double> p) {
  	double max = p.get(0);
  	for (int i = 0; i < p.size(); i++) {
  		if (p.get(i) > max) max = p.get(i);
  	}
  	return max;
  }
  
  public static ArrayList<Double> maxEach(ArrayList<ArrayList<Double>> p) {
  	ArrayList<Double> max_array = new ArrayList<Double>();
  	for (int i = 0; i < p.size(); i++) {
  		max_array.add(max(p.get(i)));
  	}
  	return max_array;
  }
  
  public static double min(ArrayList<Double> p) {
  	double min = p.get(0);
  	for (int i = 0; i < p.size(); i++) {
  		if (p.get(i) < min) min = p.get(i);
  	}
  	return min;
  }
  
  public static ArrayList<Double> minEach(ArrayList<ArrayList<Double>> p) {
  	ArrayList<Double> min_array = new ArrayList<Double>();
  	for (int i = 0; i < p.size(); i++) {
  		min_array.add(min(p.get(i)));
  	}
  	return min_array;
  }
  
  public static ArrayList<Double> pow(ArrayList<Double> list, double p) {
  	ArrayList<Double> pow_list = new ArrayList<Double>();
  	for (int i = 0; i < list.size(); i++) {
  		pow_list.add(Math.pow(list.get(i), p));
  	}
  	return pow_list;
  }
  
  public static ArrayList<ArrayList<Double>> powEach(ArrayList<ArrayList<Double>> list, double p) {
  	ArrayList<ArrayList<Double>> pow_list = new ArrayList<ArrayList<Double>>();
  	for (int i = 0; i < list.size(); i++) {
  			pow_list.add(pow(list.get(i), p));
  	}
  	return pow_list;
  }
  
  public static ArrayList<ArrayList<Double>> smoothAcross(ArrayList<ArrayList<Double>> list) {
  	ArrayList<ArrayList<Double>> smooth_list = new ArrayList<ArrayList<Double>>();
  	for (int i = 0; i < list.size(); i++) {
  		ArrayList<Double> smooth_sublist = new ArrayList<Double>();
  		for (int j = 0; j < list.get(i).size(); j++) {
  			double sum;
  			if (i == 0) {
  				sum = list.get(i).get(j) + list.get(i+1).get(j);
  				smooth_sublist.add(sum/2.0);
  			} else if (i == list.size() - 1) {
  				sum = list.get(i).get(j) + list.get(i-1).get(j);
  				smooth_sublist.add(sum/2.0);
  			} else {
  				sum = list.get(i).get(j) + list.get(i-1).get(j) + list.get(i+1).get(j);
  				smooth_sublist.add(sum/3.0);
  			}
  		}
  		smooth_list.add(smooth_sublist);
  	}
  	return smooth_list;
  }
  
  public static ArrayList<ArrayList<Double>> transpose(ArrayList<ArrayList<Double>> list) {
  	ArrayList<ArrayList<Double>> transpose = new ArrayList<ArrayList<Double>>();
  	for (int j = 0; j < list.get(j).size(); j++) {
  		ArrayList<Double> row = new ArrayList<Double>();
  		for (int i = 0; i < list.size(); i++) {
  			row.add(list.get(i).get(j));
  		}
  		transpose.add(row);
  	}
  	return transpose;
  }
}
