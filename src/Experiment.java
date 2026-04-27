public class Experiment {

    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {

        int[] copy = arr.clone();

        long start = System.nanoTime();

        if (type.equals("basic")) {
            sorter.basicSort(copy);
        } else {
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
            System.out.println("\nArray size: " + size);

            int[] randomArr = sorter.generateRandomArray(size);

            int[] sortedArr = randomArr.clone();
            sorter.advancedSort(sortedArr);

            System.out.println("Random Array:");

            long bubbleRandom = measureSortTime(randomArr, "basic");
            long mergeRandom = measureSortTime(randomArr, "advanced");

            System.out.println("Bubble Sort: " + bubbleRandom);
            System.out.println("Merge Sort: " + mergeRandom);

            System.out.println("Sorted Array:");

            long bubbleSorted = measureSortTime(sortedArr, "basic");
            long mergeSorted = measureSortTime(sortedArr, "advanced");

            System.out.println("Bubble Sort: " + bubbleSorted);
            System.out.println("Merge Sort: " + mergeSorted);


            long searchTime = measureSearchTime(sortedArr, sortedArr[size / 2]);

            System.out.println("Binary Search: " + searchTime);
        }
    }
}