package ua.com.alevel;

import java.math.BigDecimal;
import java.math.MathContext;

public class MathSet<T extends Number> {

    private final static int DEFAULT_SIZE = 10;
    private final static int MAGNIFIER_SIZE = 2;

    private T[] numbers;
    private int index = 0;

    public MathSet() {
        numbers = (T[]) new Number[DEFAULT_SIZE];
    }

    public MathSet(int capacity) {
        numbers = (T[]) new Number[capacity];
    }

    public MathSet(T[] numbers) {
        this();
        removeDuplicate(numbers);
    }

    public MathSet(T[]... numbers) {
        this();
        for (T[] array : numbers) {
            if (array == null) continue;
            removeDuplicate(array);
        }
    }

    public MathSet(MathSet<T> numbers) {
        this(numbers.toArray());
    }

    public MathSet(MathSet<T>... numbers) {
        this();
        for (MathSet<T> mathSet : numbers) {
            if (mathSet == null) continue;
            removeDuplicate(mathSet.toArray());
        }
    }

    public void add(T n) {
        if (contains(n)) return;
        if (numbers.length == index) {
            T[] tmp = (T[]) new Number[numbers.length * MAGNIFIER_SIZE + MAGNIFIER_SIZE];
            System.arraycopy(numbers, 0, tmp, 0, numbers.length);
            numbers = tmp;
        }
        numbers[index++] = n;
    }

    public void add(T... n) {
        for (T number : n) {
            add(number);
        }
    }

    public void join(MathSet<T> ms) {
        removeDuplicate(ms.toArray());
    }

    public void join(MathSet<T>... ms) {
        for (MathSet<T> mathSet : ms) {
            if (mathSet == null) continue;
            join(mathSet);
        }
    }

    public void intersection(MathSet<T> ms) {
        MathSet<T> copy = new MathSet<>(ms.toArray().length);
        for (T number : ms.toArray()) {
            if (contains(number)) {
                copy.add(number);
            }
        }
        numbers = copy.toArray();
        index = copy.index;
    }

    public void intersection(MathSet<T>... ms) {
        for (MathSet<T> mathSet : ms) {
            if (mathSet == null) continue;
            intersection(mathSet);
        }
    }

    public void sortDesc() {
        sortDesc(0, index);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        if (checkRange(firstIndex, lastIndex)) {
            System.out.println("You cannot do such sort with this arguments");
            return;
        }
        for (int i = lastIndex - 1; i > 0; i--) {
            for (int j = firstIndex; j < i; j++) {
                if (isBigger(numbers[j], numbers[j + 1])) {
                    T temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public void sortDesc(T value) {
        if (value == null) return;
        for (int i = 0; i < index; i++) {
            if (value.equals(numbers[i])) {
                sortDesc(i, index);
                return;
            }
        }
    }

    public void sortAsc() {
        sortAsc(0, index);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        if (checkRange(firstIndex, lastIndex)) {
            System.out.println("You cannot do such sort with this arguments");
            return;
        }
        for (int i = lastIndex - 1; i > 0; i--) {
            for (int j = firstIndex; j < i; j++) {
                if (!isBigger(numbers[j], numbers[j + 1])) {
                    T temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public void sortAsc(T value) {
        if (value == null) return;
        for (int i = 0; i < index; i++) {
            if (value.equals(numbers[i])) {
                sortAsc(i, index);
                return;
            }
        }
    }

    public T get(int index) {
        if (index < 0 || index > numbers.length) {
            return null;
        }
        return numbers[index];
    }

    public T getMax() {
        T tmp = numbers[0];
        for (T number : numbers) {
            if (number != null && new BigDecimal(tmp.doubleValue()).compareTo(new BigDecimal(number.doubleValue())) < 0) {
                tmp = number;
            }
        }
        return tmp;
    }

    public T getMin() {
        T tmp = numbers[0];
        for (T number : numbers) {
            if (number != null && new BigDecimal(tmp.doubleValue()).compareTo(new BigDecimal(number.doubleValue())) > 0) {
                tmp = number;
            }
        }
        return tmp;
    }

    public T getAverage() {
        BigDecimal res = BigDecimal.ZERO;
        for (T number : numbers) {
            if (number != null) {
                res = res.add(new BigDecimal(number.doubleValue()));
            }
        }
        return (T) res.divide(new BigDecimal(index), MathContext.DECIMAL32);
    }

    public T getMedian() {
        final int median = 2;
        T[] tmp = toArray();
        sortDesc();
        BigDecimal res = new BigDecimal(numbers[index / median - 1].doubleValue());
        if (index % 2 == 0) {
            res = res.add(new BigDecimal(numbers[index / median].doubleValue()));
            res = res.divide(new BigDecimal(median), MathContext.DECIMAL32);
        } else {
            res = new BigDecimal(numbers[index / median].doubleValue());
        }
        numbers = tmp;
        return (T) res;
    }

    public T[] toArray() {
        return numbers;
    }

    public T[] toArray(int firstIndex, int lastIndex) {
        if (checkRange(firstIndex, lastIndex)) {
            System.out.println("You cannot do such sort with this arguments");
            return numbers;
        }
        T[] numbersRange = (T[]) new Number[lastIndex - firstIndex];
        System.arraycopy(numbers, firstIndex, numbersRange, 0, lastIndex - firstIndex);
        return numbersRange;
    }

    public MathSet<T> cut(int firstIndex, int lastIndex) {
        MathSet<T> numbers = new MathSet<>(toArray(firstIndex, lastIndex));
        return numbers;
    }

    public void clear() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = null;
        }
    }

    public void clear(T[] nums) {
        T[] clearArray = (T[]) new Number[numbers.length];
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (T number : nums) {
                if (numbers[i] != null && number != null && numbers[i].equals(number)) {
                    numbers[i] = null;
                }
            }
            if (numbers[i] != null) {
                clearArray[count++] = numbers[i];
            }
        }
        numbers = clearArray;
    }

    @Override
    public String toString() {
        for (T number : numbers) {
            if (number != null) {
                System.out.print(number + " ");
            }
        }
        return "";
    }

    private void removeDuplicate(T[] numbers) {
        for (T number : numbers) {
            add(number);
        }
    }

    private boolean contains(T number) {
        if (number == null) return true;
        for (T n : numbers) {
            if (n == null) return false;
            if (new BigDecimal(n.doubleValue()).equals(new BigDecimal(number.doubleValue()))) {
                return true;
            }
        }
        return false;
    }

    private boolean isBigger(T firstNumber, T secondNumber) {
        int res = new BigDecimal(firstNumber.doubleValue()).compareTo(new BigDecimal(secondNumber.doubleValue()));
        return res > 0;
    }

    private boolean checkRange(int firstIndex, int lastIndex) {
        return firstIndex < 0 || lastIndex > numbers.length || firstIndex > lastIndex;
    }

}
