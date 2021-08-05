public class TestFizzBuzz {
    public static void main(String[] args){
        FizzBuzz tester = new FizzBuzz();

        System.out.println(tester.fizBuzz(9));
        System.out.println(tester.fizBuzz(10));
        System.out.println(tester.fizBuzz(16));
        System.out.println(tester.fizBuzz(16));
        System.out.println(tester.fizBuzz(2));


        for(int i = 0; i < 200; i++){
            System.out.println(tester.fizBuzz(i));
        }
    }

}
