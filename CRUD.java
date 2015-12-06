package blog.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;


public class CRUD {
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        if(args[0].equals("-u"))
        {
            BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            ArrayList<String> list = new ArrayList<>();
            String s = file.readLine();
            while (s != null)
            {
                list.add(s);
                s = file.readLine();
            }
            file.close();
            if (args.length > 4)
            {
                StringBuilder sb = new StringBuilder();
                String Q = args[args.length - 1];

                String Price = args[args.length - 2];
                String name = args[args.length - 3];
                if (name.length() < 30)
                {
                    StringBuilder stb = new StringBuilder();
                    stb.append(name);
                    while (stb.length() < 30) stb.append(" ");
                    String N = stb.toString();
                    sb.append(N);
                } else
                {
                    String g = name.substring(0, 30);
                    sb.append(g);
                }

                if (Price.length() < 8)
                {
                    StringBuilder stb = new StringBuilder();
                    stb.append(Price);
                    while (stb.toString().length() < 8) stb.append(" ");
                    String N = stb.toString();
                    sb.append(N);
                } else
                {
                    String g = Price.substring(0, 8);
                    sb.append(g);
                }

                if (Q.length() < 4)
                {
                    StringBuilder stb = new StringBuilder();
                    stb.append(Q);
                    while (stb.toString().length() < 4) stb.append(" ");
                    String N = stb.toString();
                    sb.append(N);
                } else
                {
                    String g = Q.substring(0, 4);
                    sb.append(g);
                }
            String m;
            for (int i = 0; i < list.size(); i++)
            {
                m = list.get(i);
                String n = m.substring(0, 8);
                String[] j = n.split("\\s");
                String id = null;
                for (int k = 0; k < j.length; k++)
                {
                    id = j[k] + "";
                }
                if (id.equals(args[1]))
                {
                    if(id.length() > 8){ id = id.substring(0, 8);}
                    while (id.length() < 8){
                        id += " ";
                    }
                    String newe = id + sb.toString();
                    list.set(i, newe);
                }
            }
        }
            FileOutputStream file2 = new FileOutputStream(filename);
            for (String i: list){
                file2.write(i.getBytes());
                file2.write(("\r\n").getBytes());
            }
            file2.close();

        }else
            if(args[0].equals("-d")){
            BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            ArrayList<String> list = new ArrayList<>();
            String s = file.readLine();
            while (s != null) {
                list.add(s);
                s = file.readLine();
            }
            file.close();
                String m;
                for(int i = 0; i < list.size(); i++){
                    m = list.get(i);
                    String n = m.substring(0, 8);
                    String[] j = n.split("\\s");
                    String id = null;
                    for (int k = 0; k < j.length; k++) {
                        id = j[k] + "";
                    }
                    if(id.equals(args[1])){
                        list.remove(i);
                    }
                }

                FileOutputStream file2 = new FileOutputStream(filename);
                for (String i: list){
                    file2.write(i.getBytes());
                    file2.write(("\r\n").getBytes());
                }
               
        }

    }
}
