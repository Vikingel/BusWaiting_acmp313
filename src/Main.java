import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int[] timeline = readTimeline2("input.txt");
        //System.out.println("проверяем - исходный массив");
        //System.out.println(Arrays.toString(timeline));
        int otvet = findMaxInterval(timeline);
        System.out.println("ответ " + otvet);
        writeOtvetToFile(otvet, "output.txt");
    }

    private static void writeOtvetToFile(int otvet, String fname) {
        try (FileWriter fileWriter = new FileWriter("output.txt", false)) {
            fileWriter.write(String.valueOf(otvet)); // Записываем число в файл, конвертируя число в строку
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
                    }
    }

    private static int findMaxInterval(int[] timeline) throws FileNotFoundException {
        int[] lastVisitTime = new int[101];
        Arrays.fill(lastVisitTime, -1);
        int maxInterval = 0;
        for (int i = 0; i < timeline.length; i++) {
            int curRoute = timeline[i];
            if (lastVisitTime[curRoute] != -1) {
                int interval = i - lastVisitTime[curRoute];
                maxInterval=Math.max(maxInterval, interval);
            }
                lastVisitTime[curRoute] = i;
            }
            return maxInterval;
        }

    private static int[] readTimeline(String fname) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fname));
        int n = scanner.nextInt();
        int[] mas = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = scanner.nextInt();
        }
        scanner.close();
        return mas;
    }
    private static int[] readTimeline2(String fname) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fname));
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] numbers = new int[n];
           String bigStr= scanner.nextLine();
        scanner.close();
        String[] masStr=bigStr.split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i]= Integer.parseInt(masStr[i]);
        }
        return numbers;
    }
}


