import java.util.ArrayList;
import java.util.List;

public class lc2942 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (check(word, x)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean check(String word, char x) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == x) {
                return true;
            }
        }
        return false;
    }
}
