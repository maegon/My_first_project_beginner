package org.example.dao;

public class Sample extends Dao {
    private short[] buffer;
    private int size;

    public Sample(short[] buf, int s) {
        buffer = buf.clone();
        size = s;
    }

    public short[] GetBuffer() {
        return buffer;
    }

    public int GetSize() {
        return size;
    }
}
