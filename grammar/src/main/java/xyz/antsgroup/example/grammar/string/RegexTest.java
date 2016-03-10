package xyz.antsgroup.example.grammar.string;

import java.util.*;
import java.util.regex.*;

/**
 * Pattern Matcher 这两个类是为了获取更多正则匹配的信息,如果只是为了获取是否匹配可直接使用 String 的 mathes(),replace,replaceAll等方法.
 */
public class RegexTest
{
    public static void main(String[] args) throws PatternSyntaxException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter pattern: ");
        String patternString = in.nextLine();

        Pattern pattern = Pattern.compile(patternString);   // 获取一个可以快速处理匹配的模式对象

        while (true)
        {
            System.out.println("Enter string to match: ");
            String input = in.nextLine();
            if (input == null || input.equals("")) return;
            Matcher matcher = pattern.matcher(input);   // 这个对象可以定位模式的匹配
            if (matcher.matches())
            {
                System.out.println("Match");
                int g = matcher.groupCount();   // 获取模式中群组数量
                if (g > 0)
                {
                    // ([a-z])([0-9])
                    // 输入 t6
                    // 输出 (t)(6)
                    for (int i = 0; i < input.length(); i++)
                    {
                        // Print any empty groups
                        for (int j = 1; j <= g; j++)
                            if (i == matcher.start(j) && i == matcher.end(j))   // 第j(从1开始)个群组开始结束的位置
                                System.out.print("()");
                        // Print ( for non-empty groups starting here
                        for (int j = 1; j <= g; j++)
                            if (i == matcher.start(j) && i != matcher.end(j))
                                System.out.print('(');
                        System.out.print(input.charAt(i));
                        // Print ) for non-empty groups ending here
                        for (int j = 1; j <= g; j++)
                            if (i + 1 != matcher.start(j) && i + 1 == matcher.end(j))
                                System.out.print(')');
                    }
                    System.out.println();
                }
            }
            else
                System.out.println("No match");
        }
    }
}