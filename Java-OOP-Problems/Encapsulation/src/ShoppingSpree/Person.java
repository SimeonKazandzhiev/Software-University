package ShoppingSpree;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new LinkedList<>();
    }

    private void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    private void setMoney(double money) {
        Validator.validateMoney(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.money) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }
        this.products.add(product);
        this.money -= product.getCost();

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (!this.products.isEmpty()) {
            return this.name + " - " + this.products.stream()
                    .map(Product::getName)
                    .collect(Collectors.joining(", "));

        }
        return  this.name + " - Nothing bought";
    }
}
