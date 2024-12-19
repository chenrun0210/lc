package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("I", "love", "you", "too");
        //传统写法
        MyComparator myComparator = new MyComparator();
        Collections.sort(list, myComparator);

        //匿名内部类的写法
        Collections.sort(list, new Comparator<String>() {// 接口名
            @Override
            public int compare(String s1, String s2) {// 方法名
                if (s1 == null)
                    return -1;
                if (s2 == null)
                    return 1;
                return s1.length() - s2.length();
            }
        });

        // 省略参数表的类型
        Collections.sort(list, (s1, s2) -> {
            if (s1 == null)
                return -1;
            if (s2 == null)
                return 1;
            return s1.length() - s2.length();
        });

    }
}
