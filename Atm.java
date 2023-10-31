import java.util.*; 

class Customer {
    private String name;         
    private int accountNumber;   
    private double balance;      
    public Customer(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance is : " + balance);
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance is : " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class Bank {
    private Map<Integer, Customer> customers; 
    public Bank() {
        customers = new HashMap<>();
    }
    public void addCustomer(Customer customer) {
        customers.put(customer.getAccountNumber(), customer);
    }
    public Customer getCustomer(int accountNumber) {
        return customers.get(accountNumber);
    }
    public void deleteCustomer(int accountNumber) {
        customers.remove(accountNumber);
    }
    public void showAllAccounts() {
        if (customers.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("List of accounts:");
            System.out.println("-----------------------------------------------");
            for (Customer customer : customers.values()) {
                System.out.println("Account Number: " + customer.getAccountNumber());
                System.out.println("Customer Name: " + customer.getName());
                System.out.println("Balance: " + customer.getBalance());
                System.out.println("-----------------------------------------------");
            }
        }
    }
}

class Bms {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Welcome to the Bank Management System!");

        while (true) {
            System.out.println("-----------------------------------------------");
            System.out.println("1. Add an account");
            System.out.println("2. Delete an account");
            System.out.println("3. Access an account");
            System.out.println("4. Show list of accounts");
            System.out.println("5. Exit");
            System.out.println("-----------------------------------------------");
            System.out.print("Choose an option:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter customer name:");
                    String name = scanner.next(); 
                    System.out.println("Enter account number:");
                    int accountNumber = scanner.nextInt(); 
                    System.out.println("Enter initial balance:");
                    double balance = scanner.nextDouble(); 

                    Customer newCustomer = new Customer(name, accountNumber, balance); 
                    bank.addCustomer(newCustomer);
                    System.out.println("Account added successfully!");
                    break;
                case 2:
                    System.out.println("Enter the account number to delete:");
                    int accountToDelete = scanner.nextInt(); 

                    Customer customerToDelete = bank.getCustomer(accountToDelete); 
                    if (customerToDelete != null) {
                        bank.deleteCustomer(accountToDelete);
                        System.out.println("Account deleted successfully!");
                    } else {
                        System.out.println("Account not found. Please enter a valid account number.");
                    }
                    break;
                case 3:
                    System.out.println("Enter your account number:");
                    int accountNumberToAccess = scanner.nextInt();
                    Customer customer = bank.getCustomer(accountNumberToAccess);

                    if (customer == null) {
                        System.out.println("Account not found. Please enter a valid account number.");
                    } else {
                        System.out.println("Welcome, " + customer.getName() + "!");
                        System.out.println("Your current balance is: " + customer.getBalance());

                        
                        System.out.println("-----------------------------------------------");
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Back to main menu");
                        System.out.println("-----------------------------------------------");
                        System.out.print("Choose an option:");
                        int subChoice = scanner.nextInt();

                        switch (subChoice) {
                            case 1:
                                System.out.println("Enter the amount to deposit:");
                                double depositAmount = scanner.nextDouble();
                                customer.deposit(depositAmount);
                                break;
                            case 2:
                                System.out.println("Enter the amount to withdraw:");
                                double withdrawAmount = scanner.nextDouble();
                                customer.withdraw(withdrawAmount); 
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    break;
                case 4:
                    bank.showAllAccounts();
                    break;
                case 5:
                    System.out.println("Thank you for using the Bank Management System!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
