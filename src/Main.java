import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public void testAlgoritham(Algorithm algorithm, long Duration,String Filename) {
        List<Data> dataPoints = new ArrayList<>();
        BigInteger[] a = algorithm.run(BigInteger.ZERO,BigInteger.ONE);
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < Duration) {
            a = algorithm.run(a[0],a[1]);
            dataPoints.add(new Data(toScientific(a[1]),System.currentTimeMillis()-startTime));
        }

        saveDatatoCSV(dataPoints,Filename);
    }

    String toScientific(BigInteger num) {
        String BigString = num.toString();
        return BigString.charAt(0) + "." + BigString.substring(1, Math.min(3, BigString.length())) + "e" + (BigString.length() - 1);
    }
    private void saveDatatoCSV(List<Data> dataPoints,String filename) {
        File file = new File("C:\\Users\\ss\\IdeaProjects\\Fibonacci_Madness\\src\\"+filename);
        try {
            if(file.createNewFile()){
                System.out.println("File Created Successfully...");
            }else {
                System.out.println("File already exists... Deleting and Creating new file");
                if(file.delete()){
                    if(file.createNewFile()) {
                        System.out.println("File Created Successfully...");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Could not Create CSV file");
            return;
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Fibonacci Number,Time Since Start (ms)\n");
            for (Data point : dataPoints) {
                writer.write(point.getData() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        System.out.println("Completed!!! Saved data to"+filename);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.testAlgoritham(new Simple_Implementation(),1000,"fibonacci_data.csv");
    }
}