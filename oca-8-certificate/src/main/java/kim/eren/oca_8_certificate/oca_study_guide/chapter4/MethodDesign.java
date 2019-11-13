package kim.eren.oca_8_certificate.oca_study_guide.chapter4;
public class MethodDesign extends MethodDesignParent{
    protected int a=2;
    public MethodDesign(){
        this(2);
        System.out.println("child executed");
    }

    public MethodDesign(int a){
        super(a);
        this.a = a;
        System.out.println("child executed+"+a);
    }
    public static void walk(int a, int... aList){
        System.out.println("aList length: "+aList.length);
    }

    public void autoBoxing(int param){
        System.out.println(param);
    }

    public int autoBoxing(Integer param){
        System.out.println(param);
        return 0;
    }

    public static void objectPassByValueTest(MethodDesign methodDesign){
        methodDesign = new MethodDesign(7);
        methodDesign.a = 5;
    }

    public static final void main(String[] args){
        walk(1);
        walk(1,2);
        walk(1,2,3);
        walk(1,new int[]{1,2});

        int arg = 2;
        final MethodDesign md = new MethodDesign(1);
        objectPassByValueTest(md);
        System.out.println("methoddesign md"+md.a);
        // actually you can not create one more same method
        // because of java already autobox that primitive to wrapper class
        md.autoBoxing(arg);
    }
}

class MethodDesignParent {
    public MethodDesignParent(){
        System.out.println("parent executed");
    }

    public MethodDesignParent(int a){
        System.out.println("parent executed+"+a);
    }

}