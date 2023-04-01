import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    List<Point> data;

    public CSVHelper(String filePath){
        data = readCSV(filePath);
    }
    
    public static List<Point> readCSV(String filePath) {
        List<Point> points = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int x = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[1]);
                Point point = new Point(x, y);
                points.add(point);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return points;
    }
    
}
