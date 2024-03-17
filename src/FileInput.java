import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileInput {

    private int gridSize;
    private int numShips;
    private List<Pair<Integer, Integer>> p1Ships;
    private List<Pair<Integer, Integer>> p2Ships;
    private int totalMissiles;
    private List<Pair<Integer, Integer>> p1MissilesPos;
    private List<Pair<Integer, Integer>> p2MissilesPos;

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
            p1Ships = processString(reader.readLine());
            p2Ships = processString(reader.readLine());
            totalMissiles = Integer.valueOf(reader.readLine());
            p1MissilesPos = processString(reader.readLine());
            p2MissilesPos = processString(reader.readLine());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid file format! " + e.getMessage());
            throw e;
        }
    }

    public int getGridSize() {
        return gridSize;
    }

    public int getNumShips() {
        return numShips;
    }

    public List<Pair<Integer, Integer>> getP1Ships() {
        return p1Ships;
    }

    public List<Pair<Integer, Integer>> getP2Ships() {
        return p2Ships;
    }

    public int getTotalMissiles() {
        return totalMissiles;
    }

    public List<Pair<Integer, Integer>> getP1MissilesPos() {
        return p1MissilesPos;
    }

    public List<Pair<Integer, Integer>> getP2MissilesPos() {
        return p2MissilesPos;
    }

    public static List<Pair<Integer, Integer>> processString(String dataString) {
        // Split the string by colons (":") to separate key-value pairs
        String[] keyValuePairs = dataString.split(":");

        // Create an empty list to store the pairs
        List<Pair<Integer, Integer>> resultList = new ArrayList<>();

        // Iterate through each key-value pair
        for (String pair : keyValuePairs) {
            // Split the pair by comma (",") to separate key and value
            String[] keyValue = pair.split(",");

            // Convert key and value to integers
            int key = Integer.parseInt(keyValue[0]);
            int value = Integer.parseInt(keyValue[1]);

            // Create a Pair (tuple) and append it to the list
            resultList.add(new Pair<>(key, value));
        }

        return resultList;
    }
}
