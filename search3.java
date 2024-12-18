public class pb3 {

    public static void main(String[] args) {
        
        int[] cost = {1, 3, 4, 5, 6};
        int m = 6;

        int[] result = Flavors(cost, m);

        //question told 2 cost.
        //length array size.
        if (result.length == 2) {
            System.out.println("The two flavors are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two flavors.");
        }
    }

    public static int[] Flavors(int[] cost, int m) {
        
        for (int i = 0; i < cost.length; i++) {
            for (int j = i + 1; j < cost.length; j++) {
                if (cost[i] + cost[j] == m) {

                    // i = 0, j = 3
                    return new int[]{i+1 , j+1 };  
                }
            }
        }

        return new int[]{};
    }
}
