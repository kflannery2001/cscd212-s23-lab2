package cscd212classes.lab2;

public class Television extends Object implements Comparable<Television> {

    private final String make;
    private final String model;
    private final int screenSize;
    private final int resolution;
    private final boolean smart;
    private final boolean fourK;

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution) {
        if (make == null || model == null || make.isEmpty() || model.isEmpty() || screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("Invalid parameter in constructor");
        this.make = make;
        this.model = model;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.smart = smart;
        if (resolution == 2160)
            this.fourK = true;
        else
            this.fourK = false;
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
            return make + "-" + model + ", " + screenSize + " inch smart tv with 4K resolution";
        else if (smart)
            return make + "-" + model + ", " + screenSize + " inch smart tv with " + resolution + " resolution";
        else if (fourK)
            return make + "-" + model + ", " + screenSize + " inch tv with 4K resolution";
        else
            return make + "-" + model + ", " + screenSize + " inch tv with " + resolution + " resolution";
    }

    @Override
    public boolean equals(final Object o) {
//The equals methods checks in this order
//obj equal to this returns true
//obj equal to null returns false
//obj not an instance of Television returns false
//All class variables must be exactly equal the variables of another.
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Television))
            return false;
        Television another = (Television)o;
        return this.fourK == another.fourK && this.make.equals(another.make) && this.model.equals(another.model) && this.resolution == another.resolution && this.screenSize == another.screenSize && this.smart == another.smart;
    }

    @Override
    public int hashCode(){
        //The hashCode returns the value of the make hashCode from the String class + the value of the hashCode for the model from the String class + the resolution + the hashCode value of smart from the Boolean class + the hashCode of 4K from the Boolean class
        return this.make.hashCode() + this.model.hashCode() + this.resolution + Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);
    }

    @Override
    public int compareTo(final Television another) {
        //The compareTo method compares based on the make. If the makes are the same then it compares based on the model. If the models are the same it compares based on the screen size.
        if (another == null)
            throw new IllegalArgumentException("null parameter in the compareTo method");
        int makeComp = this.make.compareTo(another.make);
        int modelComp = this.model.compareTo(another.model);
        int screenComp = this.screenSize - another.screenSize;
        if (makeComp != 0)
            return makeComp;
        if (modelComp != 0)
            return modelComp;
        return screenComp;
    }


}
