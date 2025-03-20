//chalenge

public class bankAccount {

//   I have set the default value you can change them using set methods 
//    private int accountNo = 1234;
//    private double balance = 5555;
//    private String name = "tom";
//    private String email = "tom@gmail.com";
//    private int phoneNo = 1234567890;
    private int accountNo;
    private double balance;
    private String name;
    private String email;
    private String phoneNo;

    public bankAccount(){
        this(6857, 6458.56, "tommy", "tommy@gmail.com", "7078821994");
        System.out.println("constructor without parameter is called");
    }
    public bankAccount(int accountNo, double balance, String name, String email, String phoneNo){
        System.out.println("constructor with paramerter is called");
        this.accountNo = accountNo;
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;

        System.out.println("number: " + accountNo +
        "\nbalance: " + balance +
                "\nname: " + name +
                "\nemail: " + email +
                "\nphoneNo: " + phoneNo);
    }
    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void deposites(double deposite) {
//        this.balance = balance + deposite;
        System.out.println("balance after deposite: " + (this.balance+deposite));
    }

    public void withdrawls(double withdrawl) {
        this.balance -=  withdrawl;
        if (this.balance < 0){
            System.out.println("insufficient balance");
        }else System.out.println("balance after withdrawl: " + this.balance);
    }
}
