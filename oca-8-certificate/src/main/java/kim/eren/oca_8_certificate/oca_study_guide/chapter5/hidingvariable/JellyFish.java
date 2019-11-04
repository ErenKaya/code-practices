package kim.eren.oca_8_certificate.oca_study_guide.chapter5.hidingvariable;

public class JellyFish extends Animal {
    public int length =8;

    public static void main(String[] args) {
        JellyFish jFish = new JellyFish();
        Animal animal= new JellyFish();

        System.out.println("jFish length"+jFish.length);
        System.out.print("animalLength"+animal.length);
        // output jfish = 8 animal = 2
        // output shows because of animal reference has a jellyfish object but
        // reference is animal so animal property must show there
    }
}