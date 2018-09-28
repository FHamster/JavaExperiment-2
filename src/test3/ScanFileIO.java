package test3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ScanFileIO
{
    public static void main(String[] argc) throws FileNotFoundException
    {
        //初始化File文件地址
        File FileIO = new File("src/FileIO.txt");

        //随机生成10000个学生及三门科目的分数，
        // 然后写入指定文件名的文件。
        FileOUT(FileIO);


        //(3)从文件中读出学生信息，统计平均分、总分，
        // 并写入文件。
        // 比如，原学生信息为 "张三 90 91 92 0 0"，
        // 处理后的结果为"张三 90 91 92 91 273"，
        // 这里仅使用整型运算即可，不需要用浮点数。
        Student[] stuArr = FileIN(FileIO);

        //找出平均成绩前5名的学生，写入“first_5.txt”文件。
        File FileFirst5 = new File("src/first_5.txt");
        First5(FileFirst5, stuArr);
        //从stuarr搜索张三
        String[] find = findStudent(stuArr, "张三");
    }

    public static String[] findStudent(Student[] stuArr, String name)
    {
        LinkedList<Student> stuList = new LinkedList<Student>();
        for (Student x : stuArr)
        {
            if (x.name.equals(name))
            {
                stuList.add(x);
            }
        }
        Student[] find = new Student[stuList.size()];
        find = stuList.toArray(find);
        String[] findStr = new String[find.length];
        for (int i = 0; i < find.length; i++)
        {
            findStr[i] = find[i].toString();
        }
        return findStr;
    }

    public static void First5(File FileIO, Student[] stuArr) throws FileNotFoundException
    {
        PrintWriter out = new PrintWriter(FileIO);
        Arrays.sort(stuArr);
        for (int i = 0; i < 5; i++)
        {
            out.println(stuArr[i]);
        }
        out.close();
    }

    public static Student[] FileIN(File FileIO) throws FileNotFoundException
    {
        Scanner fileScanner = new Scanner(FileIO);
        LinkedList<Student> stuList = new LinkedList<Student>();

        String name;
        int math;
        int java;
        int ds;
        int avg;
        int total;

        while (fileScanner.hasNextLine())
        {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(" ");

            name = lineScanner.next();
            math = lineScanner.nextInt();
            java = lineScanner.nextInt();
            ds = lineScanner.nextInt();
            avg = lineScanner.nextInt();
            total = lineScanner.nextInt();
            stuList.add(new Student(name, math, java, ds, avg, total));
        }
        Student[] stuArr = new Student[stuList.size()];
        stuArr = stuList.toArray(stuArr);
        fileScanner.close();
        return stuArr;
    }

    public static void FileOUT(File FileIO)
    {
//        捕捉未找到文件异常
        try
        {
            PrintWriter out = new PrintWriter(FileIO);
            for (int i = 0; i < 10000; i++)
            {
                out.println(Student.randomStudent().toString());
            }
            out.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("用人话说就是没找到文件");
        }
    }
}


