import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        System.out.printf("Insert file path: ");
        String filePath = in.nextLine();
        FileInput fi;
        try {
            fi = new FileInput(filePath);
        } catch (Exception e) {
            System.out.println("Invalid file format");
            return;
        }

        Battleships battleships = new Battleships(fi.getGridSize(), fi.getNumShips(), fi.getTotalMissiles());
        battleships.game(fi.getP1Ships(), fi.getP2Ships(), fi.getP1MissilesPos(), fi.getP2MissilesPos());
    }
}