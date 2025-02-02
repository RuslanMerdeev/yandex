package leetcode;
// https://leetcode.com/problems/peeking-iterator/

// []
// peek - throw
// next - throw
// hasNext - false
// [1]
// peek - 1
// peek - 1
// next - 1
// hasNext - false
// peek - throw
// next - throw

// [1,2,3,4]                    | ptr = 0 peek = null
// peek - 1         next()      | ptr = 1 peek = 1      // если peek == null -> next() и сохраняем в peek
// peek - 1                     | ptr = 1 peek = 1      // если peek != null -> peek
// next - 1                     | ptr = 1 peek = null   // если peek != null -> peek и сброс peek
// hasNext - true   hasNext()   | ptr = 1 peek = null   // если peek == null -> hasNext()
// peek - 2         next()      | ptr = 2 peek = 2
// hasNext - true               | ptr = 2 peek = 2      // если peek != null -> true
// next - 2                     | ptr = 2 peek = null
// next - 3         next()      | ptr = 3 peek = null   // если peek == null -> next()
// next - 4         next()      | ptr = 3 peek = null
// next - throw     next()      | ptr = 3 peek = null

// [1,2]
// next - 1
// next - 2
// peek - throw

// 1. обернуть внешний итератор, хранить как приват поле
// 2. сначала использовать его реализацию для переопределенных методов
// 3. при peek - если был peek - то вернуть это значение делать next и хранить это значение в поле peek
// 4. при next - если был peek - то вернуть это значение и сделать опять next и сохранить в peek - иначе next

import java.util.Iterator;

public class PeekingIteratorImpl {

    class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;
        private Integer peek = null;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (peek == null) {
                int value = iterator.next();
                peek = value;
                return value;
            }
            return peek;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (peek == null) {
                return iterator.next();
            }
            Integer value = new Integer(peek);
            peek = null;
            return value;
        }

        @Override
        public boolean hasNext() {
            if (peek == null) {
                return iterator.hasNext();
            }
            return true;
        }
    }

    public static void main(String[] args) {
    }
}
