package cscd212comparators.lab2;

import java.util.Comparator;
import cscd212classes.lab2.Television;

public class TelevisionModelScreenSizeComparator extends Object implements Comparator<Television> {

    public int compare(final Television t1, final Television t2) {
        int modelComp =  t1.getModel().compareTo(t2.getModel());
        int screenComp = t1.getScreenSize() - t2.getScreenSize();
        if(modelComp != 0)
            return modelComp;
        return screenComp;
    }

}
