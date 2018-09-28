package test5;

import test1.MyRandom;

import java.util.HashMap;
import java.util.Map;


public class RandHomework
{
    public static void main(String[] argc)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] arr = new int[10];

        int temp;
        for (int i = 0; i < 5000; i++)
        {
            temp = MyRandom.randNum(0, 9);
            map.put(i, temp);
            arr[temp]++;
        }

        System.out.println(map.toString());
        for (int i = 0; i < arr.length; i++)
        {
            System.out.printf("选择实验%d的学生有%d人\n", i, arr[i]);
        }
    }
}
