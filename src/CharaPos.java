public enum CharaPos
{
    Left(0, "left"),
    Right(1, "right"),
    Center(2, "center");

    private int id;
    private String str;

    CharaPos(int id, String str)
    {
        this.id = id;
        this.str = str;
    }

    public int getValue()
    {
        return this.id;
    }

    public String getStr()
    {
        return str;
    }

    public static int cvtStr2Value(String str)
    {
        switch (str)
        {
            case "right":
                return 1;
            case "left":
                return 0;
            case "center":
                return 2;
            default:
                return -1;
        }
    }
}
