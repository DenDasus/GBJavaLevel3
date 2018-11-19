import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Scanner;

public class HomeWork3 {
    final static int pageSize = 1800;
    public static void main(String[] args) {
        try {
            task1();
            task2();
            createBook(10, pageSize);
            task3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void task1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/testfiles/task1.txt");
        
        ArrayList<Byte> arr = new ArrayList<>();
        
        while (true) {
            int x = fileInputStream.read();
            if (x == -1) {
                break;
            } else {
                arr.add((byte) x);
            }
        }
        
        System.out.println(arr.toString());
        fileInputStream.close();
    }
    
    public static void task2() throws IOException {
        final int fileCount = 5;
        ArrayList<InputStream> arrayList = new ArrayList<>();
        for (int i = 1; i <= fileCount; i++) {
            arrayList.add(new FileInputStream("src/testfiles/task2_" + i + ".txt"));
        }
        Enumeration<InputStream> e = Collections.enumeration(arrayList);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new SequenceInputStream(e));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/testfiles/task2_combined.txt"));
        
        while(true) {
            int x = bufferedInputStream.read();
            if(x != -1) {
                bufferedOutputStream.write(x);
            } else {
                break;
            }
        }
        
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
    
    public static void task3() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("src/testfiles/task3.txt", "r");
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер страницы:");
        
        int pageNum = scanner.nextInt();
        
        byte[] arr = new byte[pageSize];
        randomAccessFile.seek(pageSize * pageNum);
        randomAccessFile.read(arr);
    
        String outString = new String(arr);
        System.out.println(outString);
        
        randomAccessFile.close();
    }
    
    public static void createBook(int pageCount, int pageSize) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/testfiles/task3.txt"));

        for (int i = 0; i < pageCount; i++) {
            for (int j = 0; j < pageSize; j++) {
                bufferedOutputStream.write(0x30 + i);
            }
        }
    }
}
