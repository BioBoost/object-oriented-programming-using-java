## Solutions of Exercises on Arrays

### Sorting

The SortedIntegerArray class:

```java
public class SortedIntegerArray {
    private int[] sorted;

    public SortedIntegerArray(int[] unsortedArray) {
        sorted = new int[unsortedArray.length];

        for (int i = 0; i < unsortedArray.length; i++) {
            sorted[i] = unsortedArray[i];
        }

        sort();
    }

    private void sort() {
        for (int i = 1; i < sorted.length; i++) {
            int currentNumber = sorted[i];
            int x = i-1;
            while (x >= 0 && (currentNumber < sorted[x])) {
                sorted[x+1] = sorted[x];
                x--;
            }
            sorted[x+1] = currentNumber;    
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < sorted.length; i++) {
            result += sorted[i] + " ";
        }
        return result;
    }
}
```

The main program:

```java
int[] numbers = { 5, 12, 18, 1, 0, 24, 13, 25, 101, 8 };

SortedIntegerArray sorted = new SortedIntegerArray(numbers);

System.out.print("Unsorted: ");
for (int i = 0; i < numbers.length; i++) {
    System.out.print(numbers[i] + " ");
}

System.out.println("\nSorted: " + sorted);
```

The output:

```text
Unsorted: 5 12 18 1 0 24 13 25 101 8
Sorted: 0 1 5 8 12 13 18 24 25 101
```
