package Introduction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        string.replaceAll("I", "You");
        System.out.println(string);
//        yourString = yourString.replaceAll("am", "are");
//        System.out.println(yourString);
//
        String alphanumeric = "abcDeeefkbsv38748724ijbnabcDeee";
//        System.out.println(alphanumeric.replaceAll(".", "y"));
//        System.out.println(alphanumeric.replaceAll("^abcDeee", "yyy"));
//
//        System.out.println(alphanumeric.matches("^hello"));
//        System.out.println(alphanumeric.matches("abcDeeefkbsv38748724bnabcDeee"));
//
//        System.out.println(alphanumeric.replaceAll("Deee$", "end"));
//        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
//        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));
//        System.out.println(alphanumeric.replaceAll("[aei][fj]", "X"));
        System.out.println("harry is a wizard.".replaceAll("[Hh]arry", "Harry"));


        String newAlphanumeric = "abcDeeefkbsv38748724ij$bnabcDeee";
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[abcdeeefkbs]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-eA-E3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-z0-9]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));

        String hasWhiteSpace = "  I have blanks \t a tab, and also a newline\n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        System.out.println(hasWhiteSpace.replaceAll("\t", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\S", ""));
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\W", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\b", "X"));

//        QUANTIFIER
        System.out.println(alphanumeric.replaceAll("^abcDe{3}", "yyy"));
        System.out.println(alphanumeric.replaceAll("^abcDe+", "yyy"));
        alphanumeric = "abcDfkbsv38748724ijbnabcDeee";
        System.out.println(alphanumeric.replaceAll("^abcDe*", "yyy"));
        alphanumeric = "abcDefkbsv38748724ijbnabcDeee";
        System.out.println(alphanumeric.replaceAll("^abcDe{2,5}", "yyy"));
        alphanumeric = "abcDeeefkbsv38748724hijbnabcDeee";
        System.out.println(alphanumeric.replaceAll("h+i*j", "Y"));
        System.out.println(alphanumeric.replaceAll("hi*j", "Y"));

//        PATTERN CLASS
        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub Heading</h2>");
        htmlText.append("<p>paragraph1</p>");
        htmlText.append("<p>paragraph2</p>");
        htmlText.append("<h2>summary</h2>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurance " + count + " : " + matcher.start() + " to " + (matcher.end()-1));
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        groupMatcher.reset();
        while(groupMatcher.find()) {
            System.out.println("Occurance: " + groupMatcher.group(1));
        }

//        greedy vs lazy quantifiers

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurances: " + h2TextMatcher.group(2));
        }

//        Look at Matcher docs for more methods

//        LOGICAL OPERATORS
        System.out.println("harry david".replaceAll("harry|david", "daniel"));

//        NOT
//        [^abc] caret is a version of NOT
        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]";
//        above means there MUST be a character that follows t
//        [^] this expression consumers a character
//        Instead we can use not operator ! in a negative look-ahead expression
//        Look-ahead's always start with (?
//        The not operator doesn't consume a character so it will match instances of just 't'
        String tNotVRegExp = "t(?!v)";
        Pattern p = Pattern.compile(tNotVRegExp);
        Matcher m = p.matcher(tvTest);

        count = 0;
        while(m.find()) {
            count++;
            System.out.println("Occurance: " + count + " : " + m.start() + " to " + m.end());
        }

//        Positive look ahead expression
//        From example above:
//        "t(?=v)"
//        this will find all instances where t IS followed by a v

        System.out.println("_________________________________");


    }
}
