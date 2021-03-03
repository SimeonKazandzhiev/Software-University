package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }
   //2lw + 2lh + 2wh
    public double calculateSurfaceArea() {
        return (2 * this.length * this.width) + (2 * this.length * this.height)
                + (2 * this.width * this.height);
    }
    //2lh + 2wh
    public double calculateLateralSurfaceArea(){
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }
   // lwh
    public double calculateVolume(){
        return this.length * this.width * this.height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Surface Area - %.2f",this.calculateSurfaceArea()))
                .append(System.lineSeparator())
                .append(String.format("Lateral Surface Area - %.2f",this.calculateLateralSurfaceArea()))
                .append(System.lineSeparator())
                .append(String.format("Volume - %.2f",this.calculateVolume()));

        return sb.toString();
    }
}
