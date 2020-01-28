package me.Sam.util.BitMask;

public class BitMask {


    int MaskFlags;
    int keyCount;


    //Working BitMask Class.
    public BitMask(int keyCount) {
        MaskFlags = 0;
        this.keyCount = keyCount;
        setTrue(keyCount + 1); // This allows for all bits to be visible even if they are false so that they can pretty print
    }


    private int calculateBitFromId(int id) { // ID Must be 1 or greater
        if(id == 1) {
            return 1;
        } else {
            return 2 * calculateBitFromId(id - 1);
        }
    }

    private void setTrue(int id) {
        if(!checkBit(id)) {
            MaskFlags = MaskFlags | calculateBitFromId(id);
        }
    }

    private void setFalse(int id) {
        if(checkBit(id)) {
            MaskFlags = MaskFlags & ~calculateBitFromId(id);
        }
    }

    private void flipFlagBit(int id)  throws OutOfBitMaskBoundsException{
        if(id > keyCount) {
               throw new OutOfBitMaskBoundsException();
        }
        if(checkBit(id)) {
            setFalse(id);
        } else {
            setTrue(id);
        }
    }

    public void toggleBit(int id) {
        try {
            flipFlagBit(id);
        } catch (OutOfBitMaskBoundsException e) {
            System.out.println("Cannot toggle a bit like that, Tried to toggle something out of bounds");
            e.printStackTrace();
        }
    }

    public boolean checkBit(int id) {
        if(id == 0) return true;
        return (MaskFlags & calculateBitFromId(id)) == calculateBitFromId(id);
    }

    public String toSting() {
        return Integer.toBinaryString(MaskFlags);
    }

    public void printMaskValue() {
        System.out.println(MaskFlags);
    }
}
