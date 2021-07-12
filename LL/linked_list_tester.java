import java.util.ArrayList;
import java.util.Scanner;

public class linked_list_tester {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        Node head=null;
        while(true){
            System.out.println("1.insert at beginning\n"+
                    "2.insert at end\n"+
                    "3.recursive traverse\n"+
                    "4.non-recursive traverse\n"+
                    "5.search node recursively\n"+
                    "6.search node non-recursively\n"+
                    "7.delete from beginning\n"+
                    "8.delete from end\n"+
                    "9.insert at given position\n"+
                    "10.insert in sorted linked list\n"+
                    "11.get middle element\n"+
                    "12.get middle element(two pointer method)\n"+
                    "13.get_nth_node_from_end\n"+
                    "14.get_nth_bode_from_end(two pointer method)\n"+
                    "15.reverse a linked list\n"+
                    "16.reverse a linked list( O(1) space)\n"+
                    "17.reverse a linked list(recursively(right to left))\n"+
                    "18.reverse a linked list(recursively(left to right))\n"+
                    "19.remove duplicate from linked list\n");
            int cases=scan.nextInt();
            switch(cases){
                case 1:
                        System.out.print("enter the number: ");

                        head=insert_at_beginning(head,scan.nextInt());
                        break;
                case 2:
                        System.out.print("enter the number: ");
                        head=insert_at_end(head,scan.nextInt());
                        break;
                case 3:
                        recursive_traverse(head);
                        break;
                case 4:
                        non_recursive_traverse(head);
                        break;
                case 5:
                        System.out.print("enter the value of node: ");
                        int result=recursive_search_node(head,scan.nextInt());
                        System.out.println(result);
                        break;
                case 6:
                        System.out.print("enter the value of node: ");
                        int res=non_recursive_search_node(head,scan.nextInt());
                        System.out.println(res);
                        break;
                case 7:
                        head=delete_from_beginning(head);
                        break;
                case 8:
                        head=delete_from_end(head);
                        break;
                case 9:
                        System.out.print("enter a position and value: ");
                        int pos=scan.nextInt();
                        int key=scan.nextInt();
                        head=insert_at_position(head,pos,key);
                        break;
                case 10:
                        System.out.println("enter the value");
                        int key2=scan.nextInt();
                        head=insert_in_sorted(head,key2);
                        break;
                case 11:
                        System.out.println(get_middle_element(head));
                        break;
                case 12:
                        System.out.println(get_middle_element_two_pointer(head));
                        break;
                case 13:
                        System.out.print("enter the nth value: ");
                        System.out.println(get_nth_node_from_end(head,scan.nextInt()));
                        break;
                case 14:
                        System.out.print("enter the nth value: ");
                        System.out.println(get_nth_node_from_end_two_pointer(head,scan.nextInt()));
                        break;
                case 15:
                        head=reverse_a_linkedlist(head);
                        break;
                case 16:
                        head=reverse_a_linkedlist_effective(head);
                        break;
                case 17:head=reverse_a_linkedlist_recursively_right_to_left(head);
                        break;
                case 18:
                        head=reverse_a_linkedlist_recursively_left_to_right(head,null);
                        break;
                case 19:
                        remove_duplicate(head);
                        break;

            }

        }

    }
    static void remove_duplicate(Node head){
        if(head==null || head.next==null){
            return ;
        }
        Node curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.data==curr.next.data){
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
            }
        }
    }

     static void recursive_traverse(Node node){
        //space complexity O(n)
        //time complexity O(n)
        if(node==null){
            return;
        }else{
            System.out.print(node.data+"->");
            node=node.next;
            recursive_traverse(node);
        }
         System.out.println();
    }
    static void non_recursive_traverse(Node node){
        while(node!=null){
            System.out.print(node.data+"->");
            node=node.next;
        }
        System.out.println();
    }
    static int non_recursive_search_node(Node head,int key){
        int count=1;
        while(head!=null){
            if(head.data==key){
                return count;
            }
            head=head.next;
            count++;
        }
        return -1;
    }
    static int recursive_search_node(Node node,int key){
        if(node==null){
            return -1;
        }
        if(node.data==key){
            return 1;
        }else {
        int res=recursive_search_node(node.next,key);
        if(res==-1){return -1;}
        return res+1;
        }
    }
    static Node insert_at_beginning(Node head,int x){
        if(head==null){
            Node tmp=new Node(x);
            return tmp;
        }
        Node temp=new Node(x);
        temp.next=head;
        return temp;
    }
    static Node insert_at_end(Node head,int key){
       if(head==null){
           head=new Node(key);
           return head;
       }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;

        }
        temp.next=new Node(key);
        return head;
    }
    static Node delete_from_beginning(Node head){
        if(head==null){
            return null;
        }
        head=head.next;
        return head;
    }
    static Node delete_from_end(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }
    static Node insert_at_position(Node head,int pos,int key){
        if(pos==1){
            Node tmp=new Node(key);
            tmp.next=head;
            return tmp;
        }
        Node curr=head;
        for(pos=pos;pos>2;pos--){
            curr=curr.next;
        }
        Node tmp=new Node(key);
        tmp.next=curr.next;
        curr.next=tmp;
        return head;
//        Node curr=head;
//        for(int i=1;i<=pos-2&&curr!=null;i++){
//            curr=curr.next;
//        }
//        Node tmp=new Node(key);
//        tmp.next=curr.next;
//        curr.next=tmp;
//        return head;

    }
    static Node insert_in_sorted(Node head,int key) {
        if (head == null) {
            Node tmp=new Node(key);
            return tmp;
        }
        if(head.data>key){
            Node tmp=new Node(key);
            tmp.next=head;
            return tmp;
        }
        Node curr=head;
        while( curr.next!=null && curr.next.data<key){
            curr=curr.next;
        }
        Node tmp=new Node(key);
        tmp.next=curr.next;
        curr.next=tmp;
        return head;
    }

    static int get_middle_element(Node head){
        Node curr=head;
        int count=1;
        while(curr.next!=null){
            count++;
            curr=curr.next;
        }
        count=count/2;
        curr=head;
        for(int i=0;i<count;i++){
                  curr=curr.next;
        }
        return curr.data;
    }
    static int get_middle_element_two_pointer(Node head){
        Node slow=head;
        Node fast=head;
        if(head.next==null){
            return head.data;
        }
        while( fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
    static int get_nth_node_from_end(Node head,int n){
        if(head==null){return -1;}
        int count=0;
        for(Node curr=head;curr!=null;curr=curr.next){
            count++;
        }
        if(count<n){
            return -1;
        }
        Node curr=head;
        for(int i=count-n;i>=1;i--){
            curr=curr.next;
        }
        return curr.data;
    }
    static int get_nth_node_from_end_two_pointer(Node head,int n){
        if(head==null){return -1;}
        Node slow=head;
        Node fast=head;
        while(n!=1 && fast!=null){
            fast=fast.next;
            n--;

        }
        if(fast==null){
            return -1;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow.data;

         }


    static Node reverse_a_linkedlist(Node head){
    if(head==null){
      return head;
    }

        ArrayList<Integer> values=new ArrayList<>();
        Node curr=head;
        while(curr!=null){
            values.add(curr.data);
            curr=curr.next;
        }
        curr=head;
        for(int i=values.size()-1;i>=0 ;i--){
            curr.data=values.get(i);
            curr=curr.next;
        }
        return head;
    }
    static Node reverse_a_linkedlist_effective(Node head){
        if(head==null){
            return head;
        }
        Node prev=null,curr=head,nxt;
        while(curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
    static Node reverse_a_linkedlist_recursively_right_to_left(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node new_head=reverse_a_linkedlist_recursively_right_to_left(head.next);
        Node nxt=head.next;
        nxt.next=head;
        head.next=null;
        return new_head;

    }
    static Node reverse_a_linkedlist_recursively_left_to_right(Node head,Node prev){
        if(head==null){
            return prev;
        }

//        Node curr=head;
//        Node nxt=curr.next;
//        curr.next=prev;
        Node nxt=head.next;
        head.next=prev;
        return reverse_a_linkedlist_recursively_left_to_right(nxt,head);

    }
}
