import java.util.Arrays;
import java.util.Random;

public class GenerateHash {

    Random r = new Random();
    int[] hashMatrix;
    int m = 0;

    public GenerateHash(int hashSize)
    {
        m = hashSize;
        hashMatrix = new int[hashSize];
        for (int i = 0; i < m; i++)
        {
            hashMatrix[i] = r.nextInt();
        }
    }

    public int hash1(int x, int size)
    {
        int hash = 0;
        for (int i = 0; i < m; i++)
        {
            hash = hash<<1;
            hash = hash | parity(x & hashMatrix[i]);
        }
        return (int) (hash % Math.pow(size, 2));
    }

    private int parity(int p) {
        int flag = 0;
        while(p != 0)
        {
            flag = flag ^ 1;
            p = p & (p-1);
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        GenerateHash h = new GenerateHash(8);
        System.out.println(Arrays.toString(h.hashMatrix));
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println(h.hash1(numbers[i], numbers.length));
        }
    }

}

