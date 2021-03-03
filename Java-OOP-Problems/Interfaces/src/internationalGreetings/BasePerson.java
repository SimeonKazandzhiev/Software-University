package internationalGreetings;

public abstract class BasePerson implements Person{

    private String name;

    protected BasePerson(String name) {
        this.name = name;
    }


    private void setName(){
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
