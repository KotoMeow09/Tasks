import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task2 {
    public static void main(String[] args) throws IOException {
        String[] elps = Files.readString(Paths.get(args[0])).trim().split("\\s+");
        String[] points = Files.readString(Paths.get(args[1])).trim().split("\\s+");
        double cx = Double.parseDouble(elps[0]);
        double cy = Double.parseDouble(elps[1]);
        double a  = Double.parseDouble(elps[2]);
        double b  = Double.parseDouble(elps[3]);
        int res = 0;
        final double EPS = 1e-9; // погрешность

            for (int i = 0; i + 1 < points.length; i+=2){
                double x = Double.parseDouble(points[i]);
                double y = Double.parseDouble(points[i+1]);

                double val = (x - cx) * (x - cx) / (a * a) + (y - cy) * (y - cy) / (b * b);

                if (Math.abs(val - 1.0) < EPS){
                    res = 0;
                }else {
                    if (val < 1.0) {
                        res = 1;
                    }else if (val > 1.0) {
                        res = 2;}
                }
                System.out.println(res);
            }
    }
}
