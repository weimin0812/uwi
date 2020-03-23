package log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LogHandler {
    public static void main(String[] args) {
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            /* 读入TXT文件 */
            String pathname = "/Users/weimin/Desktop/pdd-asc-guardian-api.txt";
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            int count = 0;
            Set<String> orders = new HashSet<>();
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
                if (line == null) {
                    break;
                }
                int start = line.indexOf("\"orderSn\":\"");
                int end = line.indexOf("\",\"strategyId\"");
                String orderSn = line.substring(start, end);
                orders.add(orderSn);
                count++;
            }
            System.out.println("count: " + count + ", size:" + orders.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
