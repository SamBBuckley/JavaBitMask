import me.Sam.util.BitMask.BitMask;

public class Main {


    //This is a working BitMask
    public static void main(String[] args) {


        //Imagine 4 ID's and I need to check them all.
        BitMask mask = new BitMask(4);
        mask.toggleBit(4);
        mask.toggleBit(3);
        mask.toggleBit(2);
        mask.toggleBit(1);
        System.out.println(mask.toSting());
        //Try flipping some bits off.
//        mask.toggleBit(3);
//        mask.toggleBit(2);
//        mask.toggleBit(1);
//        mask.toggleBit(2);
        System.out.println(mask.toSting());
        boolean idValue = mask.checkBit(4);
        if(idValue) {
            System.out.println("The Bit was flipped to true");
        } else {
            System.out.println("The Bit was flipped to false");
        }
        mask.printMaskValue();
    }
}
