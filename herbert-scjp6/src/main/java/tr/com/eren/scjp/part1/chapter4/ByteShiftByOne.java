package tr.com.eren.scjp.part1.chapter4;

public class ByteShiftByOne {

    public static void main(String[] args) {
        int i;
        int num = 0xFFFFFFF;
        for (i = 0; i < 4; i++) {
            num = num << 1;
            System.out.println(num);
        }
    }

}
