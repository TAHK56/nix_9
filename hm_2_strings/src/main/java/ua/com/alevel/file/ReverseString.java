package ua.com.alevel.file;

public class ReverseString  {
    public static String reverse(String src) {
        String[] words = src.split(" ");
        String res = src;

        for (int i = 0; i < words.length; i++) {
            res =  res.replaceAll(words[i], reverseOneWord(words[i]));
        }
        return res;
    }

    public static String reverse(String src, String dest) {

        if (src.contains(dest)) {
            return src.replaceAll(dest, reverseOneWord(dest));
        } else {
            return "No matches";
        }
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        String res = src.substring(firstIndex, lastIndex + 1);
        return src.replaceAll(res,reverse(res));
    }


    private static String reverseOneWord(String src) {
        char[] letters = src.toCharArray();
        for (int i = 0; i < letters.length / 2; i++) {
            char tmp = letters[i];
            letters[i] = letters[letters.length - i - 1];
            letters[letters.length - i - 1] = tmp;
        }

        return new String(letters);
    }


}
