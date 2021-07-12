import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Scanner;

public class search {
    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
        solve();
    }
//    static void solve(){
//        int arr[]={5,10,15,20,20,20,20,20};
//        System.out.println(bs(arr,0,arr.length-1,20));
//    }
//    static int bs(int arr[],int low,int high,int x){
//        if(low>high){
//            return -1;
//        }
//        int mid=(low+high)/2;
//        if(x>arr[mid]){
//            return bs(arr,mid+1,high,x);
//        }else if(x<arr[mid]){
//            return bs(arr,low,mid-1,x);
//        }else{
//            if(mid==0 || arr[mid]!=arr[mid-1]){
//                return mid;
//            }else{
//                return bs(arr,low,mid-1,x);
//            }
//        }
//    }
/*
    static  void solve(){
        int arr[]={5,10,10,20,20,20};
        int low=0,high=arr.length-1,x=20;
        while (low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<x){
                low=mid+1;
            }else if(arr[mid]>x){
                high=mid-1;
            }else{
                if(mid==0 || arr[mid]!=arr[mid-1]){
                    System.out.println(mid);
                    return;
                }else{
                    high=mid-1;
                }

            }
        }
        System.out.println(-1);
    }
*/
//    static  void solve(){
//        int arr[]={5,10,10,20,20,20,67};
//        int low=0,high=arr.length-1,x=20;
//        while (low<=high){
//            int mid=(low+high)/2;
//            if(arr[mid]<x){
//                low=mid+1;
//            }else if(arr[mid]>x){
//                high=mid-1;
//            }else{
//                if(mid==arr.length-1 || arr[mid]!=arr[mid+1]){
//                    System.out.println(mid);
//                    return;
//                }else{
//                    low=mid+1;
//                }
//
//            }
//        }
//        System.out.println(-1);
//    }
//    static void oc(){
//        //first oc;
//        if(first oc==-1)
//            return 0;
//        else
//            return last oc-first oc+1;
//    }
//    static void solve(){
//        int x=scan.nextInt();
////        int i=1;
////        while(i*i<=x){
////            i++;
////        }
////        System.out.println(i-1);
//        int low=1,high=x,ans=1;
//        while(low<=high){
//            int mid=(low+high)/2;
//            int square=mid*mid;
//            if(square==x){
//                System.out.println(mid);
//                return;
//            }
//            else if(square>x){
//                high=mid-1;
//            }else{
//                low=mid+1;
//                ans=mid;
//            }
//        }
//
//    }


//    static void solve(){
//        int N=scan.nextInt() ;
//        int arr[]=new int[N];
//        for(int i=0;i<N;i++){
//            arr[i]=scan.nextInt();
//        }
//        if(N==1){
//            System.out.println(arr[0]);
//            return;
//        }
//        if(arr[0]>arr[1]){
//            System.out.println(arr[0]);
//            return;
//        }
//        if(arr[N-1]>arr[N-2]){
//            System.out.println(arr[N-1]);
//            return;
//        }
//        for(int i=1;i<N-1;i++){
//            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
//                System.out.println(arr[i]);
//                return;
//            }
//        }
//        System.out.println(-1);
//
//    }


//    static void solve(){
//        int arr[]={10,20,30,40,50,8,9};
//        int x=8;
//        int low=0,high=arr.length-1;
//        while(low<=high){
//            int mid=(low+high)/2;
//            if(arr[mid]==x){
//                System.out.println(mid);
//                return;
//            }
//            if(arr[low]<arr[mid]){//first half is sorted
//                if(x>=arr[low] && x<arr[mid]){
//                    high=mid-1;//x is in the range search this half
//                }else{
//                    low=mid+1;//x not in thr range search other half
//                }
//            }
//            else{//other half is sorted
//                if(x>arr[mid] && x<=arr[high]){
//                    low=mid+1;//x is in the range search this half
//                }else{
//                    high=mid-1;//x not in thr range search other half
//                }
//            }
//
//        }
//        System.out.println(-1);
//    }
//    static void solve(){
//        int arr[]={3,5,9,2,8,10,11};
//        int x=17;
////        HashSet<Integer> hs=new HashSet<>();
////        for(int i=0;i<arr.length;i++){
////            hs.add(arr[i]);
////        }
////        for(int i=0;i<arr.length;i++){
////            if(hs.contains(x-arr[i])){
////                System.out.println("YES");
////                return;
////            }
////        }
////        System.out.println("NO");
//     arr=new int[]{2, 5, 8, 12, 30};
//
//     int low=0,high=arr.length-1;
//     while(low<high){
//         if(arr[low]+arr[high]==x){
//             System.out.println("YES");
//             return;
//         }
//         if(arr[low]+arr[high]>x){
//             high--;
//         }else{
//             low++;
//         }
//     }
//        System.out.println("NO");
//
//    }
    static void solve(){
        int arr[]={2,3,4,8,9,20,40};
int x=32;
        for(int i=0;i<arr.length;i++) {
            int low = i+1, high = arr.length - 1;
            while (low < high) {
                if (arr[low] + arr[high]+arr[i] == x) {
                    System.out.println("YES");
                    System.out.println(low+" "+high+" "+i);
                    return;
                }
                if (arr[low] + arr[high]+arr[i] > x) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        System.out.println("NO");
    }
}
