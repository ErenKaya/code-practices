package kim.eren.oca_8_certificate.mala_gupta_guide.chapterIII.topicVIII;

class Person{
    private String name;

    public Person setName(String name){
        this.name = name;
        return this;
    }

    public String getName(){
        return this.name;
    }
}

public class PersonTest{

    public static void swap(Person p1,Person p2){
        Person temp = p1;
        p1=p2;
        p2=temp;
    }

    public static void main(String[] args) {
        Person person1 = new Person().setName("John");
        Person person2 = new Person().setName("Wiley");
        System.out.println("Person1Name :"+person1.getName()+" Person2Name :"+person2.getName());
        swap(person1, person2);
        System.out.println("Person1Name :"+person1.getName()+" Person2Name :"+person2.getName());

    }
}