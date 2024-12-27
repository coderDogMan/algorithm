package week.week319;

public class 温度转换6233 {
    public static void main(String[] args) {
        double[] doubles = convertTemperature(36.50);
        System.out.println(doubles);
    }

    public static double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}
