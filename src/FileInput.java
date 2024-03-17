import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;

public class FileInput {

    private final int gridSize;
    private final int numShips;
    private final String[] p1Ships;
    private final String[] p2Ships;
    private final int totalMissiles;
    private final String[] p1MissilesPos;
    private final String[] p2MissilesPos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileInput fileInput = (FileInput) o;
        return numShips == fileInput.numShips && totalMissiles == fileInput.totalMissiles && Objects.equals(p1Ships, fileInput.p1Ships) && Objects.equals(p2Ships, fileInput.p2Ships) && Objects.equals(p1MissilesPos, fileInput.p1MissilesPos) && Objects.equals(p2MissilesPos, fileInput.p2MissilesPos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numShips, p1Ships, p2Ships, totalMissiles, p1MissilesPos, p2MissilesPos);
    }

    @Override
    public String toString() {
        return "FileInput{" +
                "matrixDim=" + gridSize +
                ", totalShips=" + numShips +
                ", p1Ships=" + p1Ships +
                ", p2Ships=" + p2Ships +
                ", totalMissiles=" + totalMissiles +
                ", p1MissilesPos=" + p1MissilesPos +
                ", p2MissilesPos=" + p2MissilesPos +
                '}';
    }

    public FileInput(String filePath) throws Exception {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));

            gridSize = Integer.valueOf(reader.readLine());
            numShips = Integer.valueOf(reader.readLine());
            p1Ships = reader.readLine().split(":");
            p2Ships = reader.readLine().split(":");
            totalMissiles = Integer.valueOf(reader.readLine());
            p1MissilesPos = reader.readLine().split(":");
            p2MissilesPos = reader.readLine().split(":");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid file format! " + e.getMessage());
            throw e;
        }
        reader.close();
    }

    public int getGridSize() {
        return gridSize;
    }

    public int getNumShips() {
        return numShips;
    }


    public int getTotalMissiles() {
        return totalMissiles;
    }

    public String[] getP1Ships() {
        return p1Ships;
    }

    public String[] getP2Ships() {
        return p2Ships;
    }

    public String[] getP1MissilesPos() {
        return p1MissilesPos;
    }

    public String[] getP2MissilesPos() {
        return p2MissilesPos;
    }
}
