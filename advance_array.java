import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Main {
    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
        solve();
    }
    static void  pr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int[] ip(int N){
        int arr[]=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=scan.nextInt();
        }
        return arr;
    }
//    static void solve(){
//        int N=scan.nextInt();
//        int arr[]=new int[N];
//        for(int i=0;i<N;i++){
//            arr[i]=scan.nextInt();
//        }
//        int tmp=-1;
//        for(int i=0;i<N;i++){
//            if(arr[i]!=0){
//                tmp++;
//                int tt=arr[i];
//                arr[i]=arr[tmp];
//                arr[tmp]=tt;
//            }
//        }
//        pr(arr);
//    }


//    static void solve(){
//        int N=scan.nextInt();
//        boolean lesser=false;
//        int []arr=ip(N);
//        int curr=arr[N-1];
//        System.out.println(curr);
//        for(int i=N-2;i>=0;i--) {
//            if(arr[i]>curr){
//                System.out.println(arr[i]);
//                curr=arr[i];
//            }
//        }
//
//    }

//static  void solve(){
//        int N=scan.nextInt();
//        int arr[]=ip(N);
//        int minSoFar=arr[0];
//        int maxDiffSoFar=0;
//        for(int i=1;i<N;i++){
//            minSoFar=Math.min(minSoFar,arr[i]);
////            if(arr[i]<minSoFar){
////                //arr[i]-minSoFar will be negative
////                 continue;
////            }
//            maxDiffSoFar=Math.max(arr[i]-minSoFar,maxDiffSoFar);
//        }
//    System.out.println(maxDiffSoFar);
//}


//static void solve(){
//        int N=scan.nextInt();
//        int arr[]=ip(N);
//        int sum=0;
//        int diff=0;
//        for(int i=1;i<N;i++){
//            if(arr[i]>arr[i-1]){
//                sum+=arr[i]-arr[i-1];
//            }
//        }
//    System.out.println(sum);
//}





//    static void solve(){
//        int N=scan.nextInt();
//        int arr[]=ip(N);
//
//        int pre[]=new int[N];
//        int suf[]=new int[N];
//
//        int water=0;
//
//        pre[0]=arr[0];
//        for(int i=1;i<N;i++){
//            pre[i]=Math.max(pre[i-1],arr[i]);
//        }
//
//
//        suf[N-1]=arr[N-1];
//        for(int i=N-1;i>=0;i--){
//            suf[i]=Math.max(suf[i+1],arr[i]);
//        }
//
//        for(int i=1;i<N-1;i++){
//            water+=(Math.min(pre[i],suf[i])-arr[i]);
//        }
//        System.out.println(water);
//    }


//    static void solve(){
//        int N=scan.nextInt();
//        int []arr=ip(N);
//
//        int ans=0;
//        int tmp=0;
//        for(int i=0;i<N;i++){
//            if(arr[i]==1){
//                tmp++;
//                ans=Math.max(ans,tmp);
//            }else{
//                tmp=0;
//            }
//        }
//        System.out.println(ans);
//    }



//    static void solve(){
//        int N=scan.nextInt();
//        int []arr=ip(N);
//        int ans=0;
//        int tmp=0;
//        for(int i=0;i<N;i++){
//            if(ans+arr[i]<=0){
//                tmp=0;
//            }else{
//                tmp+=arr[i];
//                ans=Math.max(tmp,ans);
//            }
//        }
//        System.out.println(ans);
//    }


//    static void solve(){
//        int N=scan.nextInt();
//        int []arr=ip(N);
//        int ans=0;
//        int curr=1;
//
//        for(int i=1;i<N;i++){
//        if((arr[i]%2==0 && arr[i-1]%2!=0)||(arr[i]%2!=0 && arr[i-1]%2==0)){
//            curr++;
//           ans= Math.max(curr,ans);
//        }else{
//            curr=1;
//        }
//
//        }
//        System.out.println(ans);
//    }



    //FALSE
//    static void solve(){
//        int N=scan.nextInt();
//        int arr[]=new int[N+N];
//        for(int i=0;i<N;i++){
//            arr[i]=scan.nextInt();
//            arr[i+N]=arr[i];
//        }
//        int max=N;
//        int ans=0;
//        int curr=0;
//        int k=0;
//        for(int i=0;i<N+N;i++){
//            if(ans+arr[i]<=0){
//                curr=0;
//                k=0;
//            }else{
//                if(k==N){
//                    k=0;
//                    continue;
//                }
//                curr+=arr[i];
//                ans=Math.max(ans,curr);
//                k++;
//            }
//        }
//        System.out.println(ans);
//    }



    //MOORE'S VOTING ALGORITHM
//    static void solve(){
//        int N=scan.nextInt();
//        int arr[]=ip(N);
//        int res=0;
//        int count=0;
//        for(int i=0;i<N;i++){
//            if(arr[i]==arr[res]){
//                count++;
//            }else{
//                count--;
//            }
//            if(count==0){
//                res=i;count=1;
//            }
//        }
//        count=0;
//       for(int i=0;i<N;i++){
//            if(arr[res]==arr[i]){
//                count++;
//            }
//       }
//       if(count<=N/2){
//           //element should must be greater than   N/2 +1
//           System.out.println(-1);
//           return ;
//       }
//        System.out.println(arr[res]);
//
//
//    }

//    static void solve(){
//        int N=scan.nextInt();
//        int arr[]=ip(N);
//       for(int i=1;i<N;i++){
//           if(arr[i]!=arr[i-1]){
//               if(arr[i]!=arr[0]){
//                   System.out.print("from "+ i+" to " );
//               }else{
//                   System.out.println(i-1);
//               }
//           }
//       }
//       if(arr[0]!=arr[N-1])
//           System.out.print(N-1);
//
//    }

//    static void solve(){
//        int N=scan.nextInt();
//        int K=scan.nextInt();
//        int arr[]=ip(N);
//        int sum=0;
//        int max=0;
//        for(int i=0;i<K;i++){
//            sum+=arr[i];
//        }
//        for(int i=1;i<N-K;i++){
//            sum+=arr[i+K-1];
//            sum-=arr[i-1];
//            max=Math.max(sum,max);
//        }
//        System.out.println(max);
//    }


    //VARIABLE SIZE WINDOW SLIDING FALSE
//    static void solve(){
//        int N=scan.nextInt();
//        int sum=scan.nextInt();
//        int arr[]=ip(N);
//        int curr=arr[0];
//        int in=0;
//        for(int i=1;i<N;i++){
//            if(curr<sum){
//                curr+=arr[i];
//            }else{
//
//            }
//        }
//    }



//    N-bonacci
//static void solve(){
//        int N=scan.nextInt();
//        int M=scan.nextInt();
//        int arr[]=new int[M];
//        int zeros=N-1;
//        for(int i=0;i<=zeros;i++){
//
//            arr[i]=0;
//            if(i==zeros){
//                arr[i]=1;
//            }
//        }
//        int sum=1;
//        int in=0;
//        for(int i=0;i<M-N;i++){
//            arr[i+N]=
//
//        }
//}

//    static void solve(){
//        int N=scan.nextInt();
//        int arr[]=ip(N);
//        int l=scan.nextInt();
//        int r=scan.nextInt();
//
//
//        int pre[]=new int[N];
//        pre[0]=arr[0];
//        for(int i=1;i<N;i++){
//            pre[i]=pre[i-1]+arr[i];
//        }
//
//        if(l!=0){
//            System.out.println(pre[r]-pre[l-1]);
//        }else{
//            System.out.println(pre[r]);
//        }
//
//
//    }


//    static void solve(){
//        int N=scan.nextInt();
//        int arr[]=ip(N);
//
//
//
//        int pre[]=new int[N];
//        int suf[]=new int[N];
//        pre[0]=arr[0];
//        suf[N-1]=arr[N-1];
//
//        for(int i=1;i<N;i++){
//            pre[i]=pre[i-1]+arr[i];
//        }
//
//        for(int i=N-2;i>=0;i--){
//            suf[i]=suf[i+1]+arr[i];
//        }
//        for(int i=0;i<N;i++){
//            if(i==0){
//                if(suf[1]==0){
//                    System.out.println("YES");
//                    return;
//                }
//                continue;
//            }
//            if(i==N-1){
//                if(pre[N-2]==0){
//                    System.out.println("YES");
//                    return ;
//                }
//                continue;
//            }
//            if(pre[i-1]==suf[i+1]){
//                System.out.println("YES");
//                return;
//            }
//        }
//        System.out.println("NO");
//
//    }

    //EFFICIENT
//    static void solve(){
//        int N=scan.nextInt();
//        int arr[]=new int[N];
//
//        int  total=0;
//        for(int i=0;i<N;i++){
//            arr[i]=scan.nextInt();
//            total+=arr[i];
//        }
//        int left=0;
//        for(int i=0;i<N;i++){
//                if(left==total-arr[i]){
//                    System.out.println("YES");
//                    return ;
//                }
//                left+=arr[i];
//                total-=arr[i];
//        }
//        System.out.println("NO");
//
//
//
//    }

}
