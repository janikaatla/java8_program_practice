public class Test {
    public static void main (String[] args){


        System.out.println(calc());
    }
    public static int calc() {
        try {
            return (10 / 2);
        } catch (Exception e) {
            System.out.println("Exception Occured: " + e.toString());
            return 20;
        } finally {
            return 30;
        }

}
    }
