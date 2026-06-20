import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task4 {
    public static void main(String[] args) throws IOException {
        String path = Files.readString(Paths.get(args[0]));
        String[] numbers = new String(path).split("\\s+");
        int [] n = new int[numbers.length];

            for (int i = 0; i < numbers.length; i++){
                n[i] = Integer.parseInt(numbers[i]);}

            if (n.length == 0){
                System.out.println(0);
                return;}

                java.util.Arrays.sort(n);
                int mediana = n[n.length / 2];

                    long moves = 0;
                    for(int pric : n) {
                    moves += Math.abs(pric - mediana);}

                        if (moves <= 20){
                            System.out.println(moves);

                        }else {
                            System.out.println("За 20 ходов невозможно");}
    }
}