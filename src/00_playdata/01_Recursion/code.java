public class code{
    public static void main(String[] args){
        int n = 4;
        func(4);
    }

    public static void func(int k){
        if(k<=0)
            return;
        else{
            System.out.println("HEllo");
            func(k-1);
        }
    }
}