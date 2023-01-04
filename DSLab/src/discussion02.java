
public class discussion02 {
    public static void main(String[] args) {
        int[][] a = {{0,0,1},{1,1,0},{1,0,1}};
        int[][] b = {{1,1,1},{1,0,0},{0,1,0}};
        print(meet(a,b));
        System.out.println("-------------");
        print(join(a,b));


    }

    //the meet of two matrices
    public static int[][] meet(int[][] a,int[][] b){
        int[][] c = new int[3][3];
        for(int i = 0;i <3;i++){
            for(int j = 0;j <3;j++){
                if(a[i][j] + b[i][j] == 2){
                    c[i][j] = 1;
                }else{
                    c[i][j] = 0;
                }
            }
        }
        return c;
    }

    //the join of two matrices
    public static int[][] join(int[][] a,int[][] b){
        int[][] c = new int[3][3];
        for(int i = 0;i <3;i++){
            for(int j = 0;j <3;j++){
                if(a[i][j] + b[i][j] == 0){
                    c[i][j] = 0;
                }else{
                    c[i][j] = 1;
                }
            }
        }
        return c;
    }

    //print the array
    public static void print(int[][] a){
        for(int i = 0;i <3;i++){
            for(int j = 0;j <3;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
