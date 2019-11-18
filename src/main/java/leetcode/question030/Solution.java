package leetcode.question030;

import java.util.Calendar;
import java.util.Date;

public class Solution {
    private int age;
    private String name;

    public static void main(String[] args) {
        Date current = new Date();
        System.out.println(current.getTime());
        System.out.println(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();
        c.setTime(current);
        c.add(Calendar.MONTH, -1);
        System.out.println(c.getTime().getTime());
        System.out.println(c.getTimeInMillis());
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
