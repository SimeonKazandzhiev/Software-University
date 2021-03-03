package shapes;

public class Rectangle extends Shape{

    private Double height;
    private Double width;

    public final Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    Double calculatePerimeter() {
        return (this.height * 2) + (this.width * 2);
    }

    @Override
    Double calculateArea() {
        return this.height * this.width;
    }
}
