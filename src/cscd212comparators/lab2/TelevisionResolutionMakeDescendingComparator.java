package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionResolutionMakeDescendingComparator extends Object implements Comparator<Television> {

    public int compare(final Television t1, final Television t2) {
        int resComp = t1.getResolution() - t2.getResolution();
        int makeComp = t1.getMake().compareTo(t2.getMake());
        if (resComp != 0)
            return resComp;
        return makeComp;
    }

}
