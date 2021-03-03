package animals;

public abstract class Animal implements ProduceSound {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public void setAge(int age) {
        if(age <0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }
    public void setName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name= name;
    }

    public void setGender(String gender){
        if(gender == null || gender.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s",this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("%s %d %s%n%s",this.getName(),this.getAge(),this.getGender(),this.produceSound()));

        return sb.toString();

    }
}
