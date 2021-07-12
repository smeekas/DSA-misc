import java.util.Scanner;

public class Circular_linked_list_tester {
    public static void main(String[] args) {

     Scanner scan =new Scanner(System.in);
     Node head=null;

        while(true){
                      System.out.println(
                            "1.insert at beginning\n"+
                            "2.insert at beginning O(1)\n"+
                            "3.insert at end\n"+
                            "4.insert at end O(1)\n"+
                            "5.traverse the linkedlist\n"+
                            "6.delete from beginning\n"+
                            "7.delete from beginning O(1)\n"+
                            "8.delete from end\n"+
                            "9.get kth data from linked list\n"+
                            "10.delete kth node\n"
                                );
            int choice=scan.nextInt();

//                    last video
            switch(choice){
                case 1:
                        System.out.print("enter the value :");
                        int data=scan.nextInt();
                        head=insert_at_beginning(head,data);
                        break;

                case 2:
                        System.out.print("enter the value :");
                        int data3=scan.nextInt();
                        head=insert_at_beginnig_effective(head,data3);
                        break;

                case 3:
                        System.out.print("enter the value :");
                        int data2=scan.nextInt();
                        head=insert_at_end(head,data2);
                        break;

                case 4:
                        System.out.print("enter the value :");
                        int data4=scan.nextInt();
                        head=insert_at_end_effective(head,data4);
                        break;

                case 5:
                        traverse_linkedlist(head);
                        break;

                case 6:
                        head=delete_from_beginning(head);
                        break;

                case 7:
                        head=delete_at_beginning_effective( head);
                        break;

                case 8:
                        head=delete_from_end(head);
                        break;


                case 9:
                    System.out.print("enter the index: ");
                    int index=scan.nextInt();
                    System.out.println(get_kth_value(head,index));
                    break;

                case 10:
                    System.out.print("enter kth value:");
                    int index2=scan.nextInt();
                    head=delete_kth_node(head,index2);
                    break;

            }

        }
    }
    static Node delete_kth_node(Node head,int index){
        if(head==null){
            return head;
        }
        if (index==1) {
            if(head.next==head){
                return null;
            }
            int swp=head.next.data;
            head.next.data=head.data;
            head.data=swp;
            head.next=head.next.next;
            return head;
        }
        Node curr=head;
        while(curr.next!=head && index!=2){
            curr=curr.next;
            index--;

        }
        if(curr.next==head){return head;}else{
            curr.next=curr.next.next;
            return  head;
        }
    }
    static int get_kth_value(Node head,int index){

         if(head==null){
            return -1;
        }
//         if(index==1){
//             return head.data;
//         }
//        Node curr=head;
//        while(index>=1){
//            if(curr==null){
//
//            }
//            if(index==1){
//                return curr.data;
//            }
//            index--;
//            curr=curr.next;
//        }
////        for(int i=0;i<index-1 && curr!=head;i++){
////            curr=curr.next;
////        }
        Node curr=head;
       do{
           if(index==1){
               return curr.data;
           }
           curr=curr.next;
           index--;
       }while(curr!=head);
        return -1;
    }

    static Node insert_at_beginning(Node head,int x){
        if(head==null){
            Node tmp=new Node(x);
            tmp.next=tmp;
            return tmp;
        }
        if(head.next==head){
            Node tmp=new Node(x);
            head.next=tmp;
            tmp.next=head;
            return tmp;
        }
        Node curr=head;
        while(curr.next!=head){
            curr=curr.next;
        }
        Node tmp=new Node(x);
        curr.next=tmp;
        tmp.next=head;
        return tmp;
    }
    static Node insert_at_end(Node head,int data){
        if(head==null){
            Node temp=new Node(data);
            temp.next=temp;
            return temp;
        }
        Node curr=head;

        while(curr.next!=head){
            curr=curr.next;
        }
        Node temp=new Node(data);
        curr.next=temp;
        temp.next=head;

        return head;
    }
    static void traverse_linkedlist(Node head){
        if(head==null){
            return ;
        }
        Node curr=head;

        do{
            System.out.print(curr.data+"->");
            curr=curr.next;
        }while(curr!=head);
        System.out.println();
    }
    static Node  delete_from_beginning(Node head){
        if(head==null|| head.next==head){
            return null;
        }
        Node curr=head;
        while(curr.next!=head){
            curr=curr.next;
        }
        curr.next=head.next;
        return head.next;
    }
    static Node delete_from_end(Node head){
        if(head==null|| head.next==head){
            return null;
        }
        Node curr=head;
        while(curr.next.next!=head){
            curr=curr.next;
        }
        curr.next=head;
        return head;
    }
    static Node  delete_at_beginning_effective(Node head){
        if(head==null || head.next==head){
            return null;
        }
        int swp=head.next.data;
        head.next.data=head.data;
        head.data=swp;
        head.next=head.next.next;
        return head;
    }
    static Node insert_at_end_effective(Node head,int x){
        if(head==null){
            Node tmp=new Node(x);
            tmp.next=tmp;
            return tmp;
        }
        Node tmp=new Node(x);
        tmp.next=head.next;
        head.next=tmp;

        int swp=head.data;
        head.data=tmp.data;
        tmp.data=swp;
        return tmp;
    }
    static Node insert_at_beginnig_effective(Node head,int x){
        if(head==null){
            Node tmp=new Node(x);
            tmp.next=tmp;
            return tmp;
        }
        Node tmp=new Node(x);
        tmp.next=head.next;
        head.next=tmp;
        int swp=head.data;
        head.data=tmp.data;
        tmp.data=swp;
        return head;
    }

}
