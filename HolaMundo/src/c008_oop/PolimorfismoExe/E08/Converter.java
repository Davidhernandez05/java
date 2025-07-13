package c008_oop.PolimorfismoExe.E08;

public class Converter {

  public int convert(Double num) {
    return num.intValue();
  }

  public double convert(String num){
    return Double.parseDouble(num);
  }

  public String convert(Integer num) {
    return num.toString();
  }

}
