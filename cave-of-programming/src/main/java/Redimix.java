
public class Redimix extends Concrete {
    Redimix(){
        System.out.println("r ");
    }
    public static void main(String[] args) {
        new Redimix();
    }
}

class Concrete extends Sand {

    Concrete() {System.out.print("c ");
    }
    private Concrete(String s){
        
    }

}

abstract class Sand {
    Sand(){System.out.print("s ");
        
    }

}
