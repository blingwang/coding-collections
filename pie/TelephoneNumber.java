public class TelephoneNumber{
    private static final int PHONE_NUMBER_LENGTH = 7;
    private int[] phoneNum;
    private char[] result = new char[PHONE_NUMBER_LENGTH];

    public TelephoneNumber(int[] n) { phoneNum = n;}

    public void printWords(){ printWords(0);}

    private void printWords(int curDigit){
        if(curDigit == PHONE_NUMBER_LENGTH){
            System.out.println(new String(result));
            return;
        }

        for(int i = 1; i <= 3; ++i){
            result[curDigit] = getCharKey(phoneNum[curDigit], i);
            printWords(curDigit + 1);

            // if 0 or 1, terminate after first iteration
            if( phoneNum[curDigit] == 0 || phoneNum[curDigit] == 1)
                return;
        }
    }
}
