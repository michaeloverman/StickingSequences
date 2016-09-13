import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 9/7/2016.
 */
public class StickingSequences {
    public int[] num;
    public int counter;
    public boolean stop;
    public Sequence[] fullList,
                      uniq,
                      allFour,
                      all4Uniq;
    public int a = 8; // NUMBER OF STROKES IN SEQUENCE!!!!!!!!
    public int total;

    public static void main(String args[]) {
        new StickingSequences();
    }

    public void generateTestSequence() {
        int [] testArray = new int[4];
        fullList = new Sequence[4];

        testArray[0] = 2;
        testArray[1] = 2;
        testArray[2] = 2;
        testArray[3] = 2;
        fullList [0] = new Sequence(testArray);

        testArray[0] = 1;
        testArray[1] = 2;
        testArray[2] = 3;
        testArray[3] = 4;
        fullList [1] = new Sequence(testArray);

        testArray[0] = 2;
        testArray[1] = 3;
        testArray[2] = 4;
        testArray[3] = 1;
        fullList [2] = new Sequence(testArray);

        testArray[0] = 4;
        testArray[1] = 3;
        testArray[2] = 2;
        testArray[3] = 1;
        fullList [3] = new Sequence(testArray);

    }

    public StickingSequences() {

        System.out.println("Running Sequence of " + a);
        generateFullList();
//        generateTestSequence();
        printEm("Numerical Order", fullList);

        findUniques(fullList);
        printEm("Uniques", uniq);
        findAllFours(fullList);
        printEm("All Four Mallets", allFour);
        findAllFourUniques(fullList);
        printEm("Unique All Four Mallets", all4Uniq);

        saveAll();

        System.out.println("Done");
    }

    public void findUniques(Sequence[] from) {
        int j = from.length;
        List<Sequence> temp = new ArrayList<>();
        temp.add(from[0]);

        for (int i = 1; i < j; i++) {
            int size = temp.size();
            boolean u = false;
            for (int k = 0; k < size; k++) {
                if ( u = from[i].compare(temp.get(k)) ) break;
            }
            if(!u) {
                temp.add(from[i]);
            }
        }
        uniq = temp.toArray(new Sequence[0]);
    }
    public void findAllFours(Sequence[] from) {
        int j = from .length;
        List<Sequence> temp = new ArrayList<>();

        for (int i = 0; i < j; i++) {
            if (from[i].hasAllFour()) temp.add(from[i]);
        }
        allFour = temp.toArray(new Sequence[0]);
    }
    public void findAllFourUniques(Sequence[] from) {
        if (uniq == null) findUniques(from);
        int j = uniq.length;
        List<Sequence> temp = new ArrayList<>();

        for (int i= 0; i < j; i++) {
            if (uniq[i].hasAllFour()) temp.add(uniq[i]);
        }

        all4Uniq = temp.toArray(new Sequence[0]);
    }
    public void generateFullList() {
        total = (int) Math.pow(4, a);
        num = new int[a];
        fullList = new Sequence[total];
        stop = false;
        counter = 0;

        for (int i = 0; i < a; i++) {
            num[i] = 1;
        }
        fullList[counter++] = new Sequence(num);

        while (!stop) {
            increaseOne(a - 1);
        }
    }

    public void increaseOne(int i) {
        if (i < 0) {
            stop = true;
            return;
        }
        if (++num[i] > 4) {
            num[i] = 1;
            increaseOne(i - 1);
        } else {
            fullList[counter++] = new Sequence(num);
        }
    }
    public void printEm(String st, Sequence[] s) {
        System.out.println(st);
        int j = s.length;
        for (int i = 0; i < j; i++) {
            System.out.println((i + 1) + ". " + s[i].toString());
        }
        System.out.println("");
    }
    public void saveAll() {

    }
}
