import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class WriteReadFileTest
{

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException
    {

        //写入文件演示
        PrintWriter out = new PrintWriter("myfile.txt");
        out.println("姓名 高数 Java 数据结构 平均成绩 总成绩");
        out.println("张三 20 30 40 0 0");
        out.println("李四 50 60 70 0 0");
        out.close();//输出完毕，需要close


        //读入文件演示
        Scanner in = new Scanner(new File("myfile.txt"));//为myfile.txt这个File创建一个扫描器in
        int number = 1;//行号
        while (in.hasNextLine())
        {//判断扫描器是否还有下一行未读取，该循环把文件的每一行都读出
            String line = in.nextLine();//读出myfile.txt的下一行
            System.out.println("第" + (number++) + "行的内容" + "=" + line);

            Scanner linescanner = new Scanner(line);//对每一行的内容建立一个扫描器
            linescanner.useDelimiter(" ");//使用空格作为分隔符
            String name = linescanner.next();
            String math = linescanner.next();
            String java = linescanner.next();
            String ds = linescanner.next();
            String avg = linescanner.next();
            String total = linescanner.next();
            System.out.println("name=" + name + " math=" + math + " java=" + java + " ds=" + ds + " avg" + avg + " total=" + total);
        }
        in.close();//读入完毕，最后需要对其进行close。


        //底下是参考实现代码,只进行简单的功能演示
        String students[] = new String[100];

        //创建100个学生
        for (int i = 0; i < students.length; i++)
        {
            students[i] = getStudent(i);
        }

        //输出每个学生的信息
        for (String x : students)
        {
            System.out.println(x);
        }

    }

    //获取学生信息，格式类似 "张三i 80 85 90 0 0"
    public static String getStudent(int i)
    {
        String name = "张三" + i + " ";
        String score = "";
        for (int j = 0; j < 3; j++)
        {
            score += getScore() + " ";

        }
        return name + score + 0 + " " + 0;

    }

    //获取0-100的随机数
    public static int getScore()
    {
        return (int) (Math.random() * 101);
    }

}
