package fifteenth_third;

import java.util.*;

/**
 * @Description: 判断字符是否是数字
 * @Author: daihong
 * @Date: Created in  2018/8/22
 */
public class Test {
    public static void main(String[] args) {
        String str = "2el4";
        char[] chars = str.toCharArray();
        System.out.println(isMath(str));

        System.out.println(isNumber(str));
    }

    public static Boolean isMath(String str) {
        Boolean flag = true;
        if (str == null) {
            return false;
        }
        char[] chars = str.toCharArray();
        char first = chars[0];
        if (first < '0') {
            if (first != '-' && first != '+') {
                return false;
            } else {
                int i = 1;
                while (i < chars.length) {
                    if (chars.length <= 3) {
                        if (chars[i] < '0' || chars[i] > '9') {
                            flag = false;
                            break;
                        }
                    }
                    if (chars.length > 3) {
                        if (chars[2] != 'e' && (chars[2] < '0' || chars[2] > '9') && chars[2] != '.') {
                            flag = false;
                            break;
                        }
                        if (i != 2 && i != 3)
                            if (chars[i] < '0' || chars[i] > '9') {
                                flag = false;
                                break;
                            }
                        if (chars.length >= 4) {
                            if (chars[2] != 'e' && (chars[2] < '0' || chars[2] > '9') && chars[2] != '.') {
                                flag = false;
                                break;
                            }
                            if (chars[2] == 'e') {
                                if (chars[3] != '-' && (chars[3] < '0' || chars[3] > '9')) {
                                    flag = false;
                                    break;
                                }
                            } else if (chars[2] == '.') {
                                if (chars[3] == '-') {
                                    return false;
                                }
                                if (chars[3] < '0' || chars[3] > '9') {
                                    return false;
                                }
                            }
                        }
                    }
                    i++;
                }
            }
        } else if (first > '0' && first < '9') {
            int i = 1;
            while (i < chars.length) {
                if (chars.length <= 2) {
                    if (chars[i] < '0' || chars[i] > '9') {
                        return false;
                    }
                } else if (chars.length > 2) {
                    if (chars[1] != 'e' && (chars[1] < '0' || chars[1] > '9') && chars[1] != '.') {
                        flag = false;
                        break;
                    }
                    if (i != 1 && i != 2)
                        if (chars[i] < '0' || chars[i] > '9') {
                            flag = false;
                            break;
                        }
                    if (chars.length >= 3) {
                        if (chars[1] != 'e' && (chars[1] < '0' || chars[1] > '9') && chars[1] != '.') {
                            flag = false;
                            break;
                        }
                        if (chars[1] == 'e') {
                            if (chars[2] != '-' && (chars[2] < '0' || chars[2] > '9')) {
                                flag = false;
                                break;
                            }
                        } else if (chars[1] == '.') {
                            if (chars[2] == '-') {
                                return false;
                            }
                            if (chars[2] < '0' || chars[2] > '9') {
                                return false;
                            }
                        }
                    }
                }
                i++;
            }
        } else {
            return false;
        }
        return flag;
    }

    public static Boolean isMath(char[] str) {
        Boolean flag = true;
        if (str.length == 0) return false;
        HashMap<Integer, Character> map = new HashMap<>();
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '.' || str[i] == 'e' || str[i] == '+'||str[i]=='-') {
                map.put(i, str[i]);
            } else if (str[i] < '0' || str[i] > '9') {
                list.add(str[i]);
            }
        }
        int a = 0;  //代表+
        int b = 0;  //代表-
        int c = 0;  //代表e
        int d = 0;  //代表.
        Iterator<Map.Entry<Integer,Character>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Character> it = iterator.next();
            if (it.getValue()=='-'){
                b++;
            }
        }
        return flag;
    }
    public static Boolean isNumber(String str){
        return str.matches("[\\+\\-]?(\\d)?(\\.\\d)?([eE][\\+\\-]?\\d+)?");
    }
}
