package MediumQuestions;

public class Palindrome2 {
    public static void main(String[] args) {
        String str = "aba";
        String str1 = "abca";
        String str2 = "abc";
        String str3 = "eeccccbebaeeabebccceea";
        String str4 = "mlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculm";

//        System.out.println(validPalindrome(str));
//        System.out.println(validPalindrome(str1));
//        System.out.println(validPalindrome(str2));
        System.out.println(validPalindrome(str3));
        System.out.println(validPalindrome(str4));
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean bool = true;

        while (right >= left) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            } else if (bool) {
                if (s.charAt(left) == s.charAt(right - 1) && s.charAt(left + 1) == s.charAt(right)){

                }
                if (s.charAt(left) == s.charAt(right - 1)) {
                    left++;
                    right -= 2;
                    bool = false;
                    continue;
                }
                if (s.charAt(left + 1) == s.charAt(right)) {
                    right--;
                    left += 2;
                    bool = false;
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}
