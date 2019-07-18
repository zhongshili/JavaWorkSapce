package common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexAnswerUtil {

	/**
	    * @param returnString html字符串
	    * @return 过滤后的html字符串
	    */
	    public static String clear(String returnString){
	        int start = returnString.indexOf("<body")==-1?0:returnString.indexOf(">", returnString.indexOf("<body"))+1;
	        int end = returnString.indexOf("</body>")==-1?returnString.length():returnString.indexOf("</body>");
	        returnString = returnString.substring(start, end);
	        Pattern pattern = Pattern.compile(
	                "(<\\w+\\s*[^>]+?>)",
	                Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(returnString);
	        while (matcher.find()) {
	            String group = matcher.group();
	            if (group == null) {
	                continue;
	            }
	            String sub = matcher.group();
	            String imageRegex = "<img.*?(src[=]\"[^\"]+\")[^>]+?>";
	            returnString = returnString.replaceAll(imageRegex, "<img $1/>");
	            String otherRegex = "<(?!img)(\\w+)\\s[^>]+>";
	            Pattern sub_p = Pattern.compile(otherRegex);
	            Matcher m_html = sub_p.matcher(sub);
	            String newSub = m_html.replaceAll("<$1>");
	            returnString = returnString.replace(sub, newSub);
	        }
	        return returnString;
	    }
	
}
