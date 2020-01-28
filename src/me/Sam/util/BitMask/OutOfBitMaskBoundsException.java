package me.Sam.util.BitMask;

public class OutOfBitMaskBoundsException extends Exception {

    public OutOfBitMaskBoundsException() {
        super("A Bit was called outside of the BitMask's size");
    }

}

