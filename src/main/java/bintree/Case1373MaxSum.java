package bintree;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author chenrun <chenrun@kuaishou.com>
 * Created on 2021-01-07
 */
public class Case1373MaxSum {

    public static final String FORMATTYPE_yyyy_MM_dd = "yyyy-MM-dd";

    public static void main(String[] args) {
        List<Dus> list = new ArrayList<>();
        list.add(new Dus("a", 1));
        list.add(new Dus("a", 3));
        list.add(new Dus("a", 5));
        list.add(new Dus("a", 7));
        list.add(new Dus("a", 8));
        list.add(new Dus("a", 10));
        list.add(new Dus("b", 3));
        list.add(new Dus("b", 5));
        list.add(new Dus("b", 7));
        list.add(new Dus("b", 8));
        list.add(new Dus("b", 10));
        List<Dus> result = new ArrayList<>();
        //        Map<String, List<Dus>> collect =
        list.stream().collect(Collectors.groupingBy(Dus::getName))
                .forEach(
                        (k, v) -> {
                            Optional<Dus> sum = v.stream().reduce(
                                    (c1, c2) -> {
                                        c1.setCost(c1.getCost() + c2.getCost());
                                        return c1;
                                    });
                            result.add(sum.get());
                        }
                );
        System.out.println(result);

        result.stream().sorted(new Comparator<Dus>() {
            @Override
            public int compare(Dus o1, Dus o2) {
                return 0;
            }
        });

        System.out.println(result);

        System.out.println( Double.compare(1.111, 1.12));
    }

    public static String dateBeforeDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -days);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(FORMATTYPE_yyyy_MM_dd);
            return sdf.format(calendar.getTime());
        } catch (Exception ex) {

            return null;
        }
    }

    static class Dus {
        private String name;
        private int cost;

        @Override
        public String toString() {
            return "dus{" +
                    "name='" + name + '\'' +
                    ", cost=" + cost +
                    '}';
        }

        public Dus(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }
}


