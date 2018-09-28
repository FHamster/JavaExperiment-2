package test3;

class Student implements Comparable<Student>
{
    String name;
    int math;
    int java;
    int ds;
    int avg;
    int total;

    public Student(String name, int math, int java, int ds, int avg, int total)
    {
        this.name = name;
        this.math = math;
        this.java = java;
        this.ds = ds;
        this.avg = avg;
        this.total = total;
    }

    public Student(String name, int math, int java, int ds)
    {
        this.name = name;
        this.math = math;
        this.java = java;
        this.ds = ds;
        this.total = math + java + ds;
        this.avg = total / 3;
    }

    public String getName()
    {
        return name;
    }

    public int getMath()
    {
        return math;
    }

    public int getJava()
    {
        return java;
    }

    public int getDs()
    {
        return ds;
    }

    public double getAvg()
    {
        return avg;
    }

    public int getTotal()
    {
        return total;
    }

    @Override
    public String toString()
    {
        return String.format("%s %d %d %d %d %d", name, math, java, ds, avg, total);
    }

    //随机生成一个学生
    public static Student randomStudent()
    {
        return new Student("张三", getScore(), getScore(), getScore());
    }

    //获取0-100的随机数
    public static int getScore()
    {
        return (int) (Math.random() * 101);
    }

    @Override
    public int compareTo(Student o)
    {
        if (this.avg < o.avg)
        {
            return 1;
        } else if (this.avg > o.avg)
        {
            return -1;
        }
        return 0;
    }
}
