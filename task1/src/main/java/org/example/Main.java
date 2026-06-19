package org.example;

public class Main {
    public static void main(String[] args) {
        if (args.length == 4) {
            int n1 = Integer.parseInt(args[0]);
            int m1 = Integer.parseInt(args[1]);
            int n2 = Integer.parseInt(args[2]);
            int m2 = Integer.parseInt(args[3]);
            int i = 0;
            int b = 0;
            String itog1 = "";
            String itog2 = "";
            boolean z1 = false;
            boolean z2 = false;

            do {
                if (z1 == false) {
                    itog1 += (i + 1);
                    i = (i + m1 - 1) % n1;

                    if (i == 0) {
                        z1 = true;
                    }
                }

                if (z2 == false) {
                    itog2 += (b + 1);
                    b = (b + m2 - 1) % n2;

                    if (b == 0) {
                        z2 = true;
                    }
                }

            } while (z1 != true || z2 != true);

            System.out.println(itog1 + itog2);
        }else System.out.print("Недостаточно аргументов, нужно 4");
    }
}
