public class Palindrome {

  public static boolean isPalindrome(String str)
  {
      //test for end of recursion
      if(str.length() < 2) {return true;}
  
      //check first and last character for equality
      if(str.charAt(0) != str.charAt(str.length() - 1)){return false;}
  
      //recursion call 
      return isPalindrome(str.substring(1, str.length() - 1));
  }
  
  public static void main(String[] args)
  {
      System.out.print(isPalindrome("deed"));
  }
}
