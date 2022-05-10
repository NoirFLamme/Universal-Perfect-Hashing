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

    public int hash(int x)
    {
        int hash = 0;
        for (int i = 0; i < m; i++)
        {
            hash = hash<<1;
            hash = hash | parity(x & hashMatrix[i]);
        }
        return hash;
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
        GenerateHash h = new GenerateHash(8);
        System.out.println(Arrays.toString(h.hashMatrix));
        System.out.println(h.hash(3));
    }

}

