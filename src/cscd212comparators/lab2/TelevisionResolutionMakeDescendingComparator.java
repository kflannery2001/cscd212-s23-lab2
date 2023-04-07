package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionResolutionMakeDescendingComparator extends Object implements Comparator<Television> {

    public int compare(final Television t1, final Television t2) {
        if(t1 == null || t2 == null)
            throw new IllegalArgumentException("null parameter in TelevisionResolutionMakeDescendingComparator");
        int resComp = t2.getResolution() - t1.getResolution();
        int makeComp = t2.getMake().compareTo(t1.getMake());
        if (resComp != 0)
            return resComp;
        return makeComp;
    }

}
