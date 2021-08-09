public class Gorilla extends Mammal {

        public String throwSomething(String message, int number){
            return String.format("%s %d", message, (displayEnergy(number) - number));
        }
        public String eatBanana(String message, int number){
            return String.format("%s %d", message, (displayEnergy(number) + number));
        }

        public String climb(String message, int number){
            return String.format("%s %d", message, (displayEnergy(number) - number));
        }
}
