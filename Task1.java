 package blog.Task1;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Task1 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(fileName2));
        String s;
        while ((s = file.readLine()) != null){
            String n = s.replaceAll("\\p{P}", "");
            file2.write(n);
        }
        file.close();
        file2.close();
    }
}
