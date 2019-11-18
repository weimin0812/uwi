package leetcode.common;

public class ToolUtil {
    public static void main(String[] args) {
        String s = "店铺ID\t店铺名称\t对接小二\n" +
                "1513590\t画朴旗舰店\t达尔文\n" +
                "1715744\t禾猫官方旗舰店\t达尔文\n" +
                "352169127\t梦露小姐\t达尔文\n" +
                "679977316\t北极绒女装旗舰店\t达尔文\n" +
                "508630527\t网红时尚风\t达尔文\n" +
                "1156224\t奋祺旗舰店\t格林\n" +
                "583548112\t节奏曲服装\t格林\n" +
                "355683471\t南极人亿缘专卖店\t格林\n" +
                "1427221\t伊子漫服饰旗舰店\t格林\n" +
                "22036\t依美姿服饰\t格林\n" +
                "1056833\t酷爱女装\t弘儿\n" +
                "2069179\t诱惑鸟女装旗舰店\t弘儿\n" +
                "405316747\t攸范旗舰店\t弘儿\n" +
                "1771740\t南极人芳姿阳专卖店\t弘儿\n" +
                "55772\t米子美衣\t弘儿\n" +
                "634850211\t琳姿芳女装旗舰店\t云水\n" +
                "396508\t羽绒服工厂店\t云水\n" +
                "175093582\t杭州精品棉服\t云水\n" +
                "641644\t神王旗舰店\t云水\n" +
                "773294975\t米娜宝贝连衣裙\t云水\n" +
                "528781861\tMoses Queen官方旗舰店\t糖宝\n" +
                "755162720\t迹逅官方旗舰店\t糖宝\n" +
                "993365782\t歌西梵旗舰店\t糖宝\n" +
                "471907827\tXIAOSIYANG女装旗舰店\t糖宝\n" +
                "900237890\t洛凡诗女装官方旗舰店\t糖宝\n" +
                "31471\t有量服饰\t桂七\n" +
                "21325\t香朵儿旗舰店\t桂七\n" +
                "79825\t绚丽衣装\t桂七\n" +
                "783459701\t尚四季\t桂七\n" +
                "2057937\t玲珑兰沐乃衣专卖店\t桂七";
        String[] t = s.split("\n");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < t.length; i++) {
            String[] cols = t[i].split("\t");
            String mallId = cols[0].trim();
            try {
                long id = Long.parseLong(mallId);
                sb.append(id).append(",");
                count++;
            } catch (Exception e) {
                System.out.println("exception " + mallId);
            }
        }

        System.out.println(sb.toString());
        System.out.println(count);

    }

}
