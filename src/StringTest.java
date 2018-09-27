import java.util.Arrays;
import java.util.Scanner;

//2. String对象的创建、截取和拼接

public class StringTest
{
    public static void main(String[] argc)
    {
        Scanner scanner = new Scanner(System.in);

        int n = 0;
        System.out.println("输入将要输入的身份证数量");
        if (scanner.hasNextInt())
        {
            n = scanner.nextInt();
            scanner.nextLine();
        }

        ID[] ids = new ID[n];
        for (int i = 0; i < n; i++)
        {
            ids[i] = new ID(scanner.nextLine());
        }

        System.out.println("未按照日期顺序输出出生日期");

        for (ID x : ids)
        {
            System.out.println(x.getBirthDate());
        }

//        按照日期顺序输出出生日期
        System.out.println("按照日期顺序输出出生日期");
        System.out.println("基于实现compareTo接口");

        Arrays.sort(ids);
        for (ID x : ids)
        {
            System.out.println(x.getBirthDate());
        }
//        System.out.println(idTest.getBirthDate());
    }
}

class ID implements Comparable<ID>
{
    private String ID;
    private int year;
    private int mon;
    private int dayInMon;

    public ID(String id)
    {
        this.ID = id;
        this.year = Integer.parseInt(id.substring(6, 10));
        this.mon = Integer.parseInt(id.substring(10, 12));
        this.dayInMon = Integer.parseInt(id.substring(12, 14));
    }

    public String getBirthDate()
    {
        String string = String.format("%4d-%02d-%02d", year, mon, dayInMon);
        return string;
    }

    @Override
    public int compareTo(ID o)
    {
        if (this.year > o.year)
        {
            return 1;
        } else if (this.year < o.year)
        {
            return -1;
        } else
        {
            if (this.mon > o.mon)
            {
                return 1;
            } else if (this.mon < o.mon)
            {
                return -1;
            } else
            {
                if (this.dayInMon > o.dayInMon)
                {
                    return 1;
                } else if (this.dayInMon < o.dayInMon)
                {
                    return -1;
                } else
                {
                    return 0;
                }
            }
        }
    }
}
