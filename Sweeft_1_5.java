public class Sweeft_1_5 {



    public static boolean isPalindrome(String text){
        if(text.length() < 2) return true;
        return text.charAt(0) == text.charAt(text.length()-1) &&
                isPalindrome(text.substring(1,text.length()-1));
    }

    public static int minSplit(int amount) {
        if (amount == 0) return 0;

        int[] money = new int[]{50, 20, 10, 5, 1};

        for (int i = 0; i < money.length; i++) {
            if (amount - money[i] >= 0)
                return 1 + minSplit(amount - money[i]);
        }
        return 0;
    }

    public  static int notContains(int[] array){
        int[] newArray = new int[array.length];
        for(int i=0;i<array.length;i++){
            if(array[i] > 0 && array[i] <= array.length)
                newArray[array[i]-1] = 1;
        }

        for(int i=0;i<newArray.length;i++){
            if(newArray[i] != 1) return i+1;
        }

        return array.length+1;
    }

    public static boolean isProperly(String sequence){
        int count = 0;
        for(int i=0;i<sequence.length();i++) {
            if (Character.toString(sequence.charAt(i)).equals("(")) count--;
            if (Character.toString(sequence.charAt(i)).equals(")")) count++;
            if (count > 0) return false;
        }
        if(count != 0) return false;

        return true;
    }


    public static int countVariants(int stearsCount){
        if(stearsCount == 0 || stearsCount== 1) return 1;
        return countVariants(stearsCount-1) + countVariants(stearsCount-2);
    }
}


