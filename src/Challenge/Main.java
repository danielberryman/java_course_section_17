package Challenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

//        CHALLENGE #1 (string literal)
        String regex = "I want a bike.";
        String str = "I want a bike.";

//        C#2
        regex = "^I want a b.{3}\\.$";
//        regex = "I want a (ball|bike).";
//        regex = "I want a \\w+.";
//        regex = ".*";
        String str1 = "I want a bike.";
        String str2 = "I want a ball.";

//        C#3

//        C#4
        regex = " ";
        str = "Replace all blanks with underscores";
        System.out.println(str.replaceAll(regex, "_"));
        System.out.println(str.replaceAll("\\s", "_"));

//        C#5
        str = "aaabccccccccccdddefffg";
        System.out.println(str.matches("a+bc+d+ef+g"));
        System.out.println(str.matches("[abcdefg]+"));
        System.out.println(str.matches("[a-g]+"));

//        C#6
        regex = "^a{3}bc{10}d{3}ef{3}g$";

//        C#7
        str = "abcd.12345";
        str = "kjis.22";
        str = "kjisk.22";
        regex = "\\D+\\.\\d+";

//        C#8
        str = "abcd.135uvqz.7tzik.999";
        regex = "(\\D+)(\\.)(\\d+)";

//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher1 = pattern.matcher(str);
//        Matcher matcher2 = pattern.matcher(str2);
//        System.out.println(matcher1.matches());
//        System.out.println(matcher2.matches());

//        while(matcher1.find()) {
//            System.out.println("Numbers include: " + matcher1.group(3));
//        }

//        C#9
        str = "abcd.135\tuvqz.7\ttzik.999\n";
        regex = "(\\D+)(\\.)(\\d+)\\s";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(str);
//        Matcher matcher2 = pattern.matcher(str2);
//        System.out.println(matcher1.matches());
//        System.out.println(matcher2.matches());

        while(matcher1.find()) {
            System.out.println("Numbers include: " + matcher1.group(3));
        }

//        C#10
        int count = 0;
        matcher1.reset();
        while(matcher1.find()) {
            count++;
            System.out.println("Ocurrance #: " + count + " : " + matcher1.start(3) + ", " + (matcher1.end(3)-1));
        }

//        C#11
        str = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        String strReplacement = str.replaceAll("}, \\{", "");
        System.out.println(strReplacement);

//        C#12
        str = "11111";
//        System.out.println(str.matches("^\\d{5}$"));

//        C#13
        str2 = "11111-1111";
//        System.out.println(str2.matches("^\\d{5}-\\d{4}$"));

//        C#14
//        System.out.println(str.matches("^\\d{5}$|^\\d{5}-\\d{4}$"));
//        System.out.println(str2.matches("^\\d{5}$|^\\d{5}-\\d{4}$"));

//        OR

        System.out.println(str.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(str2.matches("^\\d{5}(-\\d{4})?$"));
        String str3 = "11111-1111-2345";
        System.out.println(str3.matches("^\\d{5}(-\\d{4})?$"));

        str = "123.456.abc";
        str = "123.123.123.132.123.123";
        regex = "\\w{3}(\\.\\w{3})+";

        System.out.println(str.matches(regex));


    }
}
