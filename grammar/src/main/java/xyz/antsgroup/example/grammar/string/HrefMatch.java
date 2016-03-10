package xyz.antsgroup.example.grammar.string;

import java.io.*;
import java.net.*;
import java.util.regex.*;

/**
 *
 * 输出如下:
 * <a href="http://event.on24.com/r.htm?e=1109338&amp;s=1&amp;k=B588F6BDAD2F6849B9AC025994945048&amp;partnerref=americasjavahpvts7">
 * <a href="/technetwork/java/javase/downloads/index.html">
 * <a href="/technetwork/java/embedded/embedded-se/downloads/index.html">
 * <a href="/technetwork/java/javase/cpu-psu-explained-2331472.html">
 * <a href="technetwork/java/embedded/javame/embed-me/overview/javame-embedded-overview-2148916.html">
 * <a href="https://cloud.oracle.com/java?intcmp=CLD-try-java-cloud-hpviolator-otn01">
 * <a href="http://events.oracle.com/search/search?group=Events&amp;keyword=java">
 * <a href="https://blogs.oracle.com/java/entry/building_a_3_tiered_application">
 * <a href="http://www.oracle.com/partners/campaign/java8-spec-criteria-2331685.html">
 * <a href="https://blogs.oracle.com/java/entry/the_state_of_the_module1">
 * <a href="https://blogs.oracle.com/java/entry/completablefuture_for_asynchronous_programming_in">
 * <a href="https://blogs.oracle.com/jcp/entry/last_day_sessions_in_early">
 * <a href="https://blogs.oracle.com/java/entry/generic_specialization">
 * <a href="https://blogs.oracle.com/geertjan/entry/cassandra_couchbase_in_netbeans_ide">
 * <a href="https://blogs.oracle.com/geertjan/entry/couchbase_status_in_netbeans_ide">
 * <a href="https://blogs.oracle.com/geertjan/entry/setting_up_docker_and_vamp">
 * <a href="https://blogs.oracle.com/geertjan/entry/very_awesome_microservices_platform">
 * <a href="https://blogs.oracle.com/jcp/entry/javaland_2016_is_almost_here">
 * <a href="https://blogs.oracle.com/java/entry/java_se_8_for_java">
 * <a href="http://nighthacking.com">
 */
public class HrefMatch
{
    public static void main(String[] args)
    {
        try
        {
            // get URL string from command line or use default
            String urlString;
            if (args.length > 0) urlString = args[0];
            else urlString = "http://java.sun.com";

            // open reader for URL
            InputStreamReader in = new InputStreamReader(new URL(urlString).openStream());

            // read contents into string builder
            StringBuilder input = new StringBuilder();
            int ch;
            while ((ch = in.read()) != -1)
                input.append((char) ch);

            // search for all occurrences of pattern
            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find())
            {
                int start = matcher.start();
                int end = matcher.end();
                String match = input.substring(start, end);
                System.out.println(match);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (PatternSyntaxException e)
        {
            e.printStackTrace();
        }
    }
}