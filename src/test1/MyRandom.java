package test1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//1.使用Math类产生随机数

public class MyRandom
{
    public static int randNum()
    {
        return randNum(1, 100);
    }//对randNum的包装

    public static int randNum(int a, int b)
    {
        return (int) (a + Math.random() * (b - a + 1));
    }//生成[a,b]区间内随机数字

    public static char randChar()
    {
        return (char) ('a' + Math.random() * ('z' - 'a' + 1));
    }//生成随机小写字母

    public static int[] randNumArr(int n)////生成随机数字数组
    {
        int[] numArr = new int[n];
        for (int i = 0; i < numArr.length; i++)
        {
            numArr[i] = randNum();
        }
        return numArr;
    }

    public static char[] randCharArr(int n)//生成随机字母数组
    {
        char[] charArr = new char[n];
        for (int i = 0; i < charArr.length; i++)
        {
            charArr[i] = randChar();
        }
        return charArr;
    }

    public static double[] radioStatistic(int[] arr)//统计数组中元素出现频率
    {
        int sum = 0;
        for (int x : arr)
        {
            sum += x;
        }

        double[] radioArr = new double[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            radioArr[i] = (double) arr[i] / sum;
        }
        return radioArr;
    }

    static void test1()
    {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("构造拥有n个元素的数组（n由键盘输入），往数组中随机填入1-100之间的整数，然后统计并输出其中大于50与小于等于50的百分比。");
        System.out.println("输入n;");
        n = scanner.nextInt();
//        生成随机数数组
        int[] numArr = randNumArr(n);
        int[] arr = new int[2];
        for (int x : numArr)
        {
//            统计比率
            if (x < 50)
            {
                arr[0]++;
            } else
            {
                arr[1]++;
            }
        }

        double[] radioArr = radioStatistic(arr);
        System.out.println(Arrays.toString(numArr));
        System.out.printf("radio of <50 = %f\n", radioArr[0]);
        System.out.printf("radio of >=50 = %f\n", radioArr[1]);

    }

    static void test2()
    {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("扩展：随机生成n个（n由键盘输入）从a-z的字符（26个字符），统计输出每个字符所占总生成字符的百分比。");
        n = scanner.nextInt();
        char[] charArr = randCharArr(n);
        System.out.println(Arrays.toString(charArr));
        int[] Alpha = new int[26];
        for (char x : charArr)
        {
            Alpha[(x - 'a')]++;
        }
        double[] charRadioArr = radioStatistic(Alpha);
        for (int i = 0; i < charRadioArr.length; i++)
        {
            System.out.printf("%c:%f\n", (char) (i + 'a'), charRadioArr[i]);
        }
    }

    static void test3()
    {
//读取文件
        File file = new File("src/Object.txt");
        System.out.println("统计" + file.getName());
        //文件
        try
        {
            Scanner scanner = new Scanner(file);
            StringBuilder builder = new StringBuilder();
            int[] alphaCount = new int[26];
            while (scanner.hasNextLine())
            {
                //从文件读取一行存到builder里
                builder.replace(0, builder.length(), scanner.nextLine().toLowerCase());
                for (char x : builder.toString().toCharArray())
                {
                    if (Character.isAlphabetic(x))
                    {
                        alphaCount[(x - 'a')]++;
                    }
                }
            }

            double[] radio = radioStatistic(alphaCount);
            for (int i = 0; i < radio.length; i++)
            {
                System.out.printf("%c:%f\n", (char) (i + 'a'), radio[i]);
            }
            scanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
