import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 5, 6, 8, 7, 1, 0, 6, 12, 1, 3};
        System.out.println("arr : " + Arrays.toString(arr));
        swapMinToMax(arr);
        System.out.println("arr : " + Arrays.toString(arr));
        System.out.println("max = " + getMax(arr));
        System.out.println("min = " + getMin(arr));
        System.out.println("sorting...");
        sorting(arr);
        System.out.println("arr : " + Arrays.toString(arr));

//        List list = new ArrayList<Integer>();
//        for (int i = 0; i < arr.length; i++) {
//            if (isSimpleNumber(arr[i])) {
//                list.add(arr[i]);
//            }
//        }
//        System.out.println("simple list : " + list);

//        /home/armen
//
//        List<File> fileList = new ArrayList();
//        searchFiles(new File("/home/armen"),fileList);
//        for (File file : fileList) {
//            System.out.println(file.getAbsolutePath());
//        }
    }

    private static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void swapMinToMax(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void reverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    private static boolean isSimpleNumber(int number) {
        if (number <= 0) {
            return false;
        }
        if (number == 1) {
            return true;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void searchFiles(File rooFile, List<File> fileList) {
        if (rooFile.isDirectory()) {
            System.out.println("searching at : " + rooFile.getAbsolutePath());
            File[] directoryFiles = rooFile.listFiles();
            if (directoryFiles != null) {
                for (File file : directoryFiles) {
                    if (file.isDirectory()) {
                        searchFiles(file, fileList);
                    } else {
                        if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png")) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }

    public static void sorting(int[] arr) {
        int min = arr[0];
        int minPosition = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minPosition = j;
                }
            }
            int t = arr[i];
            arr[i] = min;
            arr[minPosition] = t;
            min = arr[i];
            minPosition = i;

        }
    }
}
