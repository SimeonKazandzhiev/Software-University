package ShoppingSpree;

public class Validator {

    public static void validateName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalStateException("Name cannot be empty");
        }
    }
    public static void validateMoney(double money){
        if(money<0){
            throw new IllegalStateException("Money cannot be negative");
        }
    }
}
