package test2;

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
        return String.format("%4d-%02d-%02d", year, mon, dayInMon);
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
