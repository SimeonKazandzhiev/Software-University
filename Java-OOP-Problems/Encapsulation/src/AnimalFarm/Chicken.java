package AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name,int age) {
        this.setName(name);
        this.setAge(age);

    }

    private void setName(String name){
        if(name == null || name.trim().isEmpty()){
            assert name != null;
            if(name.length() <1){
                throw new IllegalArgumentException("Name cannot be empty.");
            }
        }
        this.name = name;
    }
    private void setAge(int age){
        if(age>=0 && age <=15){
            this.age = age;
        }else {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }
    public double productPerDay(){
        return calculateProductPerDay();
    }
    private double calculateProductPerDay(){
        if(this.age >=0 && this.age<=5){
            return 2.00;
        }else if(this.age>5 && this.age<=11){
            return 1.00;
        }
        return 0.75;

    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                this.name,this.age,this.productPerDay());
    }
}
