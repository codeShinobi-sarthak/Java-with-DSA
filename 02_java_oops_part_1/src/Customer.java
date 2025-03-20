public class Customer {
    private final String name;
    private final int creditLimit;
    private final String email;

    public Customer() {
        this("ram", 55555, "ram@gmail.com");
        System.out.println("this is constructor without parameter\n");
    }

    public Customer(String name, int creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;

        System.out.println("constructor with three parameter is called" +
                "\nname: " + name +
                        "\ncredit limit: " + creditLimit +
                        "\nemail: " + email);
    }

    public Customer(String name, String email) {
        this(name, 7894, email);
        System.out.println("constructor with two parameter is called\n");
    }

    public String getName() {
        return name;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
