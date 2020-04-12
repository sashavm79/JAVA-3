
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

    public class Main {
        public static void main(String[] args) throws IOException {

            Charset utf8 = StandardCharsets.UTF_8;
            // Задание 1
            try {
                byte[] arr = Files.readAllBytes(Paths.get("123/fail1.txt"));

                System.out.println(new String(arr));

            } catch (IOException e) {
                e.printStackTrace();
            }


            // Задание 2
            try (FileOutputStream fos = new FileOutputStream("123/summ.txt")) {
                ArrayList<InputStream> al = new ArrayList<>();
                al.add(new FileInputStream("123/fail1.txt"));
                al.add(new FileInputStream("123/2.txt"));
                al.add(new FileInputStream("123/3.txt"));
                al.add(new FileInputStream("123/4.txt"));
                al.add(new FileInputStream("123/5.txt"));

                Enumeration<InputStream> e = Collections.enumeration(al);
                SequenceInputStream in = new SequenceInputStream(e);

                int x;

                while ((x = in.read()) != -1) {
                    System.out.print((char) x);
                    fos.write(x);
                }

                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Задание 3
            readPage();
        }

        static void readPage() {

            long startApp = System.nanoTime();
            try (RandomAccessFile raf = new RandomAccessFile("123/fail3.txt", "r");
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
                long pagesCount = raf.length() / 1800;
                byte[] b = new byte[1800];

                System.out.println("\nКоличество страниц: " + pagesCount);
                System.out.println("Время загрузки приложения: " + ((System.nanoTime() - startApp) / 1000000) + "мc");

                while (true) {
                    System.out.println("\nВведите номер страницы от 0 до " + pagesCount + " или -1 для выхода.");
                    long numberPage = Long.parseLong(br.readLine());
                    long startRead = System.nanoTime();

                    if (numberPage <= pagesCount && numberPage >= 0) {
                        raf.seek(numberPage * 1800);
                        raf.read(b, 0, b.length);
                        System.out.println(new String(b));
                        System.out.println("\nВремя чтения страницы: " + ((System.nanoTime() - startRead) / 1000000) + "мc");
                    } else if (numberPage == -1) {
                        System.exit(0);
                    } else {
                        System.out.println("Неправильный номер страницы: " + numberPage);
                    }
                }

            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

