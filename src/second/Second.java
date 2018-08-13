package second;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Second {
    public String replace(String string){
        String replace = string.replace(" ", "%20");
        int count = 0;
        byte[] bytes = string.getBytes();
        for(int i=0;i<bytes.length;i++){
            if(bytes[i]==32){
                count++;
            }
            System.out.println(bytes[i]);
        }
        System.out.println(string);
        byte[] bytes1 = new byte[string.length()+count*2];
        int j = 0;
        for(int i=0; i<bytes.length; i++){
            if(bytes[i]==32){
                bytes1[j] = '%';
                bytes1[j+1] = '2';
                bytes1[j+2] = '0';
                j=j+3;
            }else {
                bytes1[j] = bytes[i];
                j=j+1;
            }
        }
        String s = new String(bytes1);
        System.out.println(s);
        System.out.println(count);
        return replace;
    }
    public static void main(String[] args){
        String string = "      ";
        Second second = new Second();
        System.out.println(second.replace(string));
        /*System.out.println(second.replace(string).length());*/
    }


}
