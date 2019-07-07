public class MultiplyEveryone {
    int[] arrayProduct(int[] arr) {
        int product = 1;
        for (int n: arr) {
            product *= n;
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = product / arr[i];
        }
        return result;
    }
}
