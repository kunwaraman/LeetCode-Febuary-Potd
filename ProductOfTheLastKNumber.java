import java.util.*;
/*
time: O(1)ForAdd,O(K)ForGetproduct
space: O(n)
 */
public class ProductOfTheLastKNumber {
    class ProductOfNumbers {
        ArrayList<Integer> list = new ArrayList<>();


        public ProductOfNumbers() {


        }

        public void add(int num) {
            list.add(num);

        }

        public int getProduct(int k) {
            int n = list.size();
            int prod=1;
            for(int i=n-k;i<n;i++){
                prod=prod*list.get(i);
            }
            return prod;

        }
    }
}
