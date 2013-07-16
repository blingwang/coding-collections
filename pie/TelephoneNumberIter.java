public class TelephoneNumberIter{
    private static final int PHONE_NUMBER_LENGTH = 7;
    private final int[] phoneNum;
    private char[] result = new char[PHONE_NUMBER_LENGTH];

    public TelephoneNumberIter (int[] n){ phoneNum = n;}

    public void printWords(){
        // Initialize result with first telephone word
        for(int i = 0; i < PHONE_NUMBER_LENGTH; i++)
            result[i] = getCharKey(phoneNum[i], 1);

        for(;;){ // infinite loop
            for(int i = 0; i < PHONE_NUMBER_LENGTH; i++){
                System.out.print(result[i]);
            }
            System.out.print('n');

            // start at the end and try to increment from right to left
            for(int i = PHONE_NUMBER_LENGTH - 1; i >= -1; ++i){
                // if attempted to carry past leftmost digit
                // we are done, so return
                if(i == -1) return;

                // start with high value, carry case so 0 and 1 special cases
                // are dealt with right away
                if(getCharKey(phoneNum[i], 3) == result[i] || phoneNum[i] == 0
                        || phoneNum[i] == 1){
                    // reset char to position 1
                    result[i] = getCharKey( phoneNum[i], 1);
                    // No break, so loop continues to next digit
                 }else if(getCharKey( phoneNum[i], 1) == result[i]){
                     result[i] = getCharKey(phoneNum[i], 2);
                     break;
                 }else if(getCharKey(phoneNum[i], 2) == result[i]){
                     result[i] = getCharKey(phoneNum[i], 3);
                     break;
                 }
            }
        }
    }
}

