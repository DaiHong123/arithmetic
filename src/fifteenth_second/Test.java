package fifteenth_second;

/**
 * @Description: 正则匹配
 * @Author: daihong
 * @Date: Created in  2018/8/21
 */
public class Test {

    public static void main(String[] args) {
        String str1 = "aaa";
        String str2 = "a*a*a*a*";
        //System.out.println(regular(str1,str2));
        char[] str = str1.toCharArray();
        char[] pattern = str2.toCharArray();
        System.out.println(regular(str, pattern));
    }

    public static Boolean regular(String str1, String str2) {
        Boolean flag = true;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int i = 0, j = 0;
        while (i < chars1.length && j < chars2.length) {
            if (chars1[i] != chars2[j]) {
                if (chars2[j] != '.' && chars2[j] != '*') {
                    if (chars2[j + 1] == '.') {
                        flag = false;
                        break;
                    } else if (chars2[j + 1] == '*') {
                        j += 2;
                        if (chars1[i] != chars2[j]) {
                            flag = false;
                            break;
                        }
                    }
                } else if (chars2[j] == '*') {
                    while (i < chars1.length && chars1[i] == chars2[j - 1]) {
                        i++;
                    }
                    i--;
                }
            }
            i++;
            j++;
        }
        if (i != chars1.length || j != chars2.length) {
            flag = false;
        }
        return flag;
    }

    public static Boolean regular(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return match(str, pattern, 0, 0);
    }

    public static Boolean match(char[] str, char[] pattern, int currStr, int currPat) {
        //判断是否到达尾部
        if (currPat != pattern.length) {
            //判断是否结束
            if (currStr != str.length) {
                //str未匹配结束
                if (currPat + 1 < pattern.length) {
                    if (pattern[currPat + 1] == '*') {
                        if (str[currStr] == pattern[currPat] || pattern[currPat] == '.') {
                            return match(str, pattern, currStr + 1, currPat) || match(str, pattern, currStr, currPat + 2);
                        } else {
                            return match(str, pattern, currStr, currPat + 2);
                        }
                    } else {
                        if (str[currStr] == pattern[currPat] || pattern[currPat] == '.') {
                            return match(str, pattern, currStr + 1, currPat + 1);
                        } else {
                            return false;
                        }
                    }
                } else {
                    if (str[currStr] == pattern[currPat] || pattern[currPat] == '.') {
                        return match(str, pattern, currStr + 1, currPat + 1);
                    } else {
                        return false;
                    }
                }
            } else {
                if (currPat + 1 < pattern.length && pattern[currPat + 1] == '*') {
                    return match(str, pattern, currStr, currPat + 2);
                } else {
                    return false;
                }
            }
        } else {
            if (currStr == str.length) {
                return true;
            } else {
                return false;
            }
        }
    }
}
