public class sixtiforth_sum_of_n {
    public static void main(String[] args) {

    }
    public int Sum_Solution(int n) {
        return sum(n);
    }
    int sum(int n){
        try{
            int i = 1%n;
            return n+sum(n-1);
        }
        catch(Exception e){
            return 0;
        }
    }

}
