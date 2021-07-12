public class binary_tree_tester {
    public static void main(String[] args) {
        Node root=new Node(15);
        root.left=new Node(5);
        root.right=new Node(20);
        root.left.left=new Node(3);
        root.right.right=new Node(80);
        root.right.left=new Node(18);
        root.right.left.left=new Node(16);
        root.right.right.left=new Node(88);
        root.right.right.right=new Node(70);
        inorder(root);
        System.out.println();
        System.out.println("CONTAIN 16? "+search_key(root,15));
        System.out.println("CONTAIN 100? "+search_key(root,100));
        System.out.println("CONTAIN 3? "+search_key(root,3));

        System.out.println("Interative CONTAIN 16? "+iterative_seatch(root,15));
        System.out.println("Interative CONTAIN 100? "+iterative_seatch(root,100));
        System.out.println("Interative CONTAIN 3? "+iterative_seatch(root,3));

        root=insert(root,100);
        inorder(root);
        System.out.println();
        root=iterative_Insert(root,2);
        inorder(root);


        System.out.println();
        System.out.println("------------------------");
        Node tree=new Node(12);
        tree.left=new Node(5);
        tree.right=new Node(15);
        tree.left.left=new Node(3);
        tree.right.right=new Node(17);
        tree.right.left=new Node(13);
        tree.right.right.right=new Node(20);
        tree.right.left.right=new Node(14);

        inorder(tree);
        delete(tree,15);
        System.out.println();
        inorder(tree);
    }
    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    static boolean search_key(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data>key){
           return search_key(root.left,key);
        }
        else if(root.data<key){
            return search_key(root.right,key);
        }
        else{
            return true;
        }
    }
    static boolean iterative_seatch(Node root,int key){
        Node curr=root;
        while(curr!=null){
            if(curr.data>key){
                curr=curr.left;
            }else if(curr.data<key){
                curr=curr.right;
            }
            else{
                return true;
            }
        }
        return false;
    }
    static Node insert(Node root,int key){
        if(root==null){
            return new Node(key);
        }
        if(root.data>key){
             root.left=insert(root.left,key);
        }else if(root.data<key){
             root.right=insert(root.right,key);
        }
        return  root;
    }
    static Node iterative_Insert(Node root,int key){
        if(root==null){
            return new Node(key);
        }
        Node parent=null, main_root=root;
        while(root!=null){
            parent=root;
            if(root.data>key){
                root=root.left;
            }else if(root.data<key) {
                root = root.right;
            }else{
                return root;
            }
        }
        if(parent==null){
            return new Node(key);
        }else if(parent.data>key){
            parent.left=new Node(key);
        }else{
            parent.right=new Node(key);
        }
        return main_root;
    }
    static Node delete(Node root,int key){
        if(root==null){
            return null;
        }
        if(root.data<key){
            root.right=delete(root.right,key);
        }else if(root.data>key){
            root.left=delete(root.left,key);
        }
        else{
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return  root.left;
            }else{
                root.data=findmin(root.right,root.data);
                root.right=delete(root.right,root.data);
                return root;
            }
        }
        return root;
    }
     static int findmin(Node root,int data){
        while(root.left!=null){
            root=root.left;
        }
        return root.data;
    }
}
