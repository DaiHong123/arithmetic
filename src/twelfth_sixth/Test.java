package twelfth_sixth;

/**
 * @Description: 复制链表
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
    static class Link{
        int element;
        Link next;
        Link sbLing;
        Link(int element){
            this.element = element;
            this.next = null;
            this.sbLing = null;
        }
    }
    public static void main(String[] args){
        Link link1 = new Link(1);
        Link link2 = new Link(2);
        Link link3 = new Link(3);
        Link link4 = new Link(4);
        Link link5 = new Link(5);
        link1.next = link2;
        link2.next = link3;
        link3.next = link4;
        link4.next = link5;
        link1.sbLing = link3;
        link2.sbLing = link5;
        link4.sbLing = link2;
         copy(link1);
    }
    public static Link copy(Link link){
        if(link==null) return null;
        Link copyLink=null;
        Link c = null;
        while (link!=null){
            if(copyLink==null){
                c = link;
                c.sbLing = link.sbLing;
                copyLink = link;
                copyLink.sbLing = link.sbLing;
            }else {
                c.next = link;
                c.next.sbLing = link.sbLing;
                c = c.next;
            }
           link = link.next;
        }
        while (copyLink!=null){
            System.out.println(copyLink.element);
            if(copyLink.sbLing!=null){
                System.out.println("复杂"+copyLink.sbLing.element);
            }
            copyLink = copyLink.next;
        }
        return copyLink;
    }
}
