package basePromote.class03;

public class Test {
    public static void main(String[] args) {
        int i=0;
        int j=0;

        while (i<10){
            i++;
            System.out.println("#####"+i);
            while(j<1000){
                j++;
                if (j % 5 == 4){
                    break;
                }
                System.out.println("====="+j);
            }
        }
    }

}
