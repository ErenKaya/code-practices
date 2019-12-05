package kim.eren.oca_8_certificate.oca_study_guide.chapter5.polymorphism;


public class VirtualMethod extends VirtualMethodParent{
    // if you declare a method in parent class and uses overriden method 
 // output shows that child method output

    public String getName(){
        return "VirtualMethodChild";
    }

    public static void main(String[] args) {
        VirtualMethod vm = new VirtualMethod();
        vm.showResult();
    }
}

class VirtualMethodParent{

    public String getName(){
        return "Unknown";
    }

    public void showResult(){
        System.out.println("result : "+getName());
    }
}