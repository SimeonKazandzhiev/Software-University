package telephony;


import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (isValidNumber(number)) {
                sb.append(String.format("Calling... %s", number))
                        .append(System.lineSeparator());
            } else {
                sb.append("Invalid number!");
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (isValidURL(url)) {
                sb.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            } else {
                sb.append("Invalid URL!")
                        .append(System.lineSeparator());
            }
        }


        return sb.toString().trim();
    }

    private boolean isValidURL(String url) {
        for (int i = 0; i < url.length(); i++) {
            char current = url.charAt(i);
            if (Character.isDigit(current)) {
                return false;
            }
        }
        return true;
    }


    private boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            if (!Character.isDigit(current)) {
                return false;
            }
        }
        return true;
    }

}
