import java.util.Arrays;

public class Experiment {
    private Sorter sorter;
    private Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter = sorter;
        this.searcher = searcher;
    }

    public long measureSortTime(int[] arr, String type) {
        int[] copy = Arrays.copyOf(arr, arr.length);

        long start = System.nanoTime();

        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(copy);
        } else if (type.equalsIgnoreCase("advanced")) {
            sorter.advancedSort(copy);
        }

        long end = System.nanoTime();
        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();
        return end - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {
            System.out.println("\n==============================");
            System.out.println("Array Size: " + size);
            System.out.println("==============================");

            int[] randomArray = sorter.generateRandomArray(size);
            int[] sortedArray = Arrays.copyOf(randomArray, randomArray.length);
            Arrays.sort(sortedArray);

            long basicRandomTime = measureSortTime(randomArray, "basic");
            long advancedRandomTime = measureSortTime(randomArray, "advanced");

            long basicSortedTime = measureSortTime(sortedArray, "basic");
            long advancedSortedTime = measureSortTime(sortedArray, "advanced");

            int target = sortedArray[size / 2];
            long searchTime = measureSearchTime(sortedArray, target);

            System.out.println("Random Array:");
            System.out.println("Bubble Sort Time: " + basicRandomTime + " ns");
            System.out.println("Quick Sort Time: " + advancedRandomTime + " ns");

            System.out.println("\nSorted Array:");
            System.out.println("Bubble Sort Time: " + basicSortedTime + " ns");
            System.out.println("Quick Sort Time: " + advancedSortedTime + " ns");

            System.out.println("\nSearching:");
            System.out.println("Binary Search Time: " + searchTime + " ns");
            System.out.println("Target Found: " + target);
        }
    }
}