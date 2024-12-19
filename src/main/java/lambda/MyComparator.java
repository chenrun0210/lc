package lambda;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2){// 方法名
        if(s1 == null)
            return -1;
        if(s2 == null)
            return 1;
        return s1.length()-s2.length();
    }
}
