import java.util.Random;

public class KnapsackMonteCarlo {
    static int[] values = {6, 4, 5, 7};
    static int[] volumes = {2, 4, 3, 2};
    static int[] counts = {1, 2, 2, 1};
    static int capacity = 10;
    static Random random = new Random();

    public static void main(String[] args) {
        int bestValue = 0;
        int[] bestItems = null;

        for (int i = 0; i < 10000; i++) {
            int[] items = new int[values.length];
            int totalVolume = 0;
            int totalValue = 0;

            for (int j = 0; j < items.length; j++) {
                items[j] = random.nextInt(counts[j] + 1);
                totalVolume += items[j] * volumes[j];
                totalValue += items[j] * values[j];
            }

            if (totalVolume <= capacity && totalValue > bestValue) {
                bestValue = totalValue;
                bestItems = items;
            }
        }

        System.out.println("Najlepsza wartość: " + bestValue);
        System.out.print("Przedmioty: ");
        for (int i = 0; i < bestItems.length; i++) {
            System.out.print(bestItems[i] + " ");
        }
    }
}
