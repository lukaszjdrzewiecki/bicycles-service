package p76.bicycles.dto;

public class numberID {

    private static long idCounter = 0;

    public static synchronized Long createID()
    {
        return Long.valueOf(idCounter++);
    }
}
