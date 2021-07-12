import java.util.Scanner;

public class doubly_linkedlist_tester {
    public static void main(String[] args) {
        Node head=null;
        Scanner scan=new Scanner(System.in);
        while(true){
            System.out.println("1.insert at beginning\n"+
                                "2.traverse the linked list\n"+
                                "3.insert at end\n"+
                                "4.reverse the doubly linked list\n"+
                                "5.delete the head\n"+
                            "6.delete the tail\n");
            int cases=scan.nextInt();
            switch (cases){
                case 1:
                    System.out.println("enter the data:");
                        head=insert_at_beginning(head,scan.nextInt());
                        break;
                case 2:print(head);
                        break;
                case 3:
                    System.out.println("enter the data:");
                    head=insert_at_end( head,scan.nextInt());
                        break;
                case 4:
                    head=reverse(head);
                    break;
                case 5:
                    head=delete_head(head);
                        break;
                case 6:
                    head=delete_tail(head);
                    break;
            }
        }

    }
    static Node  insert_at_beginning(Node head,int data){
        if(head==null){
            Node node=new Node(data);
            return node;
        }
        Node node=new Node(data);
        node.next=head;
        head.prev=node;
        return node;
    }
    static void print(Node node){
        while(node!=null){
            System.out.print(node.data+"->");
            node=node.next;
        }
        System.out.println();
    }
    static  Node insert_at_end(Node head,int data){
        if(head==null){
            Node node=new Node(data);
            return node;
        }
        Node tmp=head;
        Node node=new Node(data);
        while(tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next=node;
        node.prev=tmp;
        return head;
    }
    static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node new_head = null;
        while(head!=null) {


            Node tmp = head.next;
            head.next = head.prev;
            head.prev = tmp;
            new_head=head;
            //---------
            head=head.prev;
            //---------
        }
        return new_head;
    }
    static Node delete_head(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node tmp=head.next;
        head.next=null;
        tmp.prev=null;
        return tmp;
    }
    static Node delete_tail(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node current=head;
        while(current.next.next!=null){
            current=current.next;
        }
        current.next.prev=null;
        current.next=null;
        return head;
    }
}
