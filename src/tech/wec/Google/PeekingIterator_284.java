package tech.wec.Google;

import java.util.Iterator;

public class PeekingIterator_284 implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer nextValue;
    private boolean hasNext;

    public PeekingIterator_284(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.hasNext = this.iterator.hasNext();
        if (this.hasNext){
            this.nextValue = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextValue;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer value = nextValue;
        this.hasNext = this.iterator.hasNext();
        if (this.hasNext)
            this.nextValue = iterator.next();
        return value;
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }
}
