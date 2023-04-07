package cscd212classes.lab2;

public class Television extends Object implements Comparable<Television> {

    private final String make;
    private final String model;
    private final int screenSize;
    private final int resolution;
    private final boolean smart;
    private final boolean fourK;

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution) {
        if (make.isEmpty() || model.isEmpty() || make == null || model == null || screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("strings are null or empty or the screen size is less than 32 or the resolution is less than 720");
        this.make = make;
        this.model = model;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.smart = smart;
        if (resolution == 2160) // TODO: Missing False
            this.fourK = true;
    }
    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make){
        this(make, model, smart, screenSize, resolution);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public int getResolution() {
        return resolution;
    }

    @Override
    public String toString() {
        //No Smart or 4K Example: TCL-NS32R, 32 inch tv with 720 resolution
        //Smart and 4K Example: Samsung-SM85U, 85 inch smart tv with 4K resolution
        if (smart && fourK)
            return make + ", " + screenSize + " inch smart tv with 4k resolution";
        else if (smart)
            return make + ", " + screenSize + " inch smart tv with " + resolution + " resolution";
        else if (fourK)
            return make + ", " + screenSize + " inch tv with 4k resolution";
        else
            return make + ", " + screenSize + " inch tv with " + resolution + " resolution";
    }


}
