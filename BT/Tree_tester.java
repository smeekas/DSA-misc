import java.util.Stack;
public class Tree_tester {
    public static void main(String[] args) {
        Node root=new Node(56);
        root.left=new Node(118);
        root.right=new Node(15);
        root.left.left=new Node(25);
        root.left.right=new Node(18);
        root.right.left=new Node(200);
        root.right.right=new Node(75);
        root.right.right.left=new Node(120);
        System.out.print("INORDER: ");
        inorder(root);
        System.out.println();
        System.out.print("Iterative INORDER: ");
        Iinorder(root);
        System.out.println();
        System.out.print("PREORDER: ");
        preorder(root);
        System.out.println();
        System.out.print("Iterative PREORDER: ");
        Ipreorder(root);
        System.out.println();

        System.out.print("POSTORDER: ");
        postorder(root);
        System.out.println();

        System.out.print("Iterative POSTORDER: ");
        Ipostorder(root);
        System.out.println();

        System.out.println("SIZE:"+getsize(root));
        System.out.println("MAX:"+getmax(root.left));
        System.out.println("HEIGHT:"+getHeight(root));
        System.out.println("FULL NODES"+getfullnodes(root));
    }
    static int getfullnodes(Node root){
        if(root==null){
            return 0;
        }
        if(root.left!=null && root.right!=null){
            return 1+getfullnodes(root.left)+getfullnodes(root.right);
        }else{
            return  getfullnodes(root.left)+getfullnodes(root.right);
        }

    }

    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    static void preorder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);

        }

    }
    static void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }
    static int getHeight(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    static int getmax(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data,Math.max(getmax(root.left),getmax(root.right)));
    }

    static int getsize(Node root){
        if(root==null){
            return 0;
        }
        return 1+getsize(root.left)+getsize(root.right);
    }
    //------------------------------------------------
    static void Iinorder(Node root) {
        Stack<Node> st = new Stack<>();
        addleft(st,root);
        while(!st.isEmpty()){
            Node curr=st.pop();
            System.out.print(curr.data+" ");
            curr=curr.right;
            addleft(st,curr);
        }
    }
    static void addleft(Stack<Node> st,Node n) {
        while (n != null) {
            st.add(n);
            n = n.left;
        }
    }
    //--------------------------------------------------
    static void Ipreorder(Node root){
        Stack<Node> st=new Stack<>();
        Node curr=root;
        st.add(root);
        while(!st.isEmpty()){
            System.out.print(curr.data+" ");
            if(curr.right!=null){st.add(curr.right);}
            if(curr.left!=null){st.add(curr.left);}
            curr=st.pop();
        }
    }
    static void Ipostorder(Node root){
        Stack<Node> st=new Stack<>();
        Stack<Node> result=new Stack<>();
        Node curr=root;
        st.add(root);
        while(!st.isEmpty()){
            curr=st.pop();
            result.add(curr);
            if(curr.left!=null){st.add(curr.left);}
            if(curr.right!=null){st.add(curr.right);}

        }
        while(!result.isEmpty()){
            System.out.print(result.pop().data+" ");
        }
    }
}
