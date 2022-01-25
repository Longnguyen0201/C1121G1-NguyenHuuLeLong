package ss19_string_regex.bai_tap;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            content = content.replaceAll("\n+","");
            Pattern pattern = Pattern.compile("<a\\w{4}=\"[/|a-z|-|.]*\">(.*?)<a>");
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()){
                System.out.println(matcher.group(1));
                scanner.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
