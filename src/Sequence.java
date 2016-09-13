/**
 * Created by Michael on 9/7/2016.
 */
public class Sequence {
    private int[] s;
    private int id;
    private int sAsInt;
    private int length = 4;
    private boolean hasAll4;

    public Sequence() {
        s = new int[length];
    }
    public Sequence(int[] seq) {
        this.length = seq.length;
        this.s = new int[length];
        this.hasAll4 = false;

        boolean[] mallet = new boolean[4];
        for (int i = 0; i < length; i++) {
            this.s[i] = seq[i];
            sAsInt = sAsInt * 10 + s[i];
            mallet[s[i] - 1] = true;
        }

        if (mallet[0] && mallet[1] && mallet[2] && mallet[3]) {
            this.hasAll4 = true;
        }
    }
    public boolean hasAllFour() {
        return hasAll4;
    }
    public String toString() {
        return Integer.toString(sAsInt);
    }
    public int toInt() {
        return sAsInt;
    }
    public int[] getArray() {
        return s; // should this return a COPY of the array???
    }
    public int getLength() {
        return length;
    }
    public boolean compare(Sequence other) {
        int[] array1 = getArray();
        int[] array2 = other.getArray();

        boolean isSame = false;
        for (int i = 0; i < length; i++) {
            //ROTATE
            int t = array2[0];
            for (int j = 0; j < length - 1; j++) {
                array2[j] = array2[j+1];
            }
            array2[length-1] = t;

            //COMPARE
            for (int j = 0; j < length; j++) {
                if (array1[j] == array2[j]) {
                    isSame = true;
                } else {
                    isSame = false;
                    break;
                }
            }
            if (isSame) break;
        }
        return isSame;
    }
}
