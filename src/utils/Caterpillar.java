package utils;

public abstract class Caterpillar {

    public int countLongest(String string) {
        int result = 0;

        int length = string.length();
        if (length == 0) return result;


        int tail = 0;

        for (int head = 0; head < length; head++) {
            while (!getCondition(string.substring(tail, head + 1)) && tail < head) {
                tail++;
            }

            result = getResult(string.substring(tail, head + 1), result);
        }

        return result;
    }

    public abstract boolean getCondition(String substring);

    public abstract int getResult(String substring, int result);
}
