package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("c://file1.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (users.size()==0)
            {
                System.out.println("Нечего сохранять");
            }
            else
            {
                for (int i=0;i<users.size();i++)
                {
                    printWriter.print(users.get(i).getFirstName());
                    printWriter.print(",");
                    printWriter.print(users.get(i).getLastName());
                    printWriter.print(",");
                    printWriter.print(users.get(i).getBirthDate().getTime());
                    printWriter.print(",");
                    printWriter.print(users.get(i).getCountry().getDisplayedName());
                    printWriter.print(",");
                    if (users.get(i).isMale())
                    {
                        printWriter.print("+");
                    }
                    else
                    {
                        printWriter.print("-");
                    }
                    printWriter.println();
                }
            }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (inputStream.available()>0) {
                while (inputStream.available() > 0) {
                    String[] words = reader.readLine().split(",");
                    User newUser = new User();
                    if (words[0].equals("null")) {
                        newUser.setFirstName(null);
                    }
                    else
                    {
                        newUser.setFirstName(words[0]);
                    }
                    if (words[1].equals("null"))
                    {
                        newUser.setLastName(null);
                    }
                    else {
                        newUser.setLastName(words[1]);
                    }
                    if (words[2].equals("null")) {
                        newUser.setBirthDate(null);
                    }
                    else {
                        Date date = new Date(Long.parseLong(words[2]));

                        newUser.setBirthDate(date);
                    }
                    if (words[3].equals("null")) {
                        newUser.setCountry(null);
                    }
                    else
                    {
                        newUser.setCountry(User.Country.valueOf(words[3].toUpperCase()));
                    }
                    if (words[4].equals("+"))
                    {
                        newUser.setMale(true);
                    }
                    else newUser.setMale(false);
                    this.users.add(newUser);
                }
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
