import java.util.*;

class BankAccount {
    int accountNumber;
    String username;
    double balance;

    public BankAccount(int accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }
}

public class Main {

    static LinkedList<BankAccount> accounts = new LinkedList<>();
    static Stack<String> history = new Stack<>();
    static Queue<String> billQueue = new LinkedList<>();
    static Queue<BankAccount> requests = new LinkedList<>();
    static int nextAccountId = 4; // для уникальных ID (после 3 предустановленных)

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //TASK 6
        BankAccount[] arr = new BankAccount[3];
        arr[0] = new BankAccount(1, "Ali", 150000);
        arr[1] = new BankAccount(2, "Sara", 220000);
        arr[2] = new BankAccount(3, "John", 100000);


        for (BankAccount acc : arr) {
            accounts.add(acc);
        }

        System.out.println("=== TASK 6: Array Accounts ===");
        for (BankAccount acc : arr) {
            System.out.println(acc.username + " - Balance: " + acc.balance);
        }

        // MAIN MENU
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bankMenu();
                    break;
                case 2:
                    atmMenu();
                    break;
                case 3:
                    adminMenu();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    //  BANK MENU
    static void bankMenu() {
        while (true) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1 - Submit account opening request");
            System.out.println("2 - Deposit money");
            System.out.println("3 - Withdraw money");
            System.out.println("4 - Transaction history (Stack)");
            System.out.println("5 - Add bill payment (Queue)");
            System.out.println("6 - Display all accounts");
            System.out.println("7 - Back to main menu");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    openAccountRequest();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transactionHistoryMenu();
                    break;
                case 5:
                    addBillPayment();
                    break;
                case 6:
                    displayAllAccounts();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    // 1
    static void openAccountRequest() {
        System.out.print("Enter username: ");
        String name = sc.next();
        BankAccount newAccount = new BankAccount(nextAccountId++, name, 0);
        requests.add(newAccount);
        System.out.println("✓ Account request submitted for: " + name);
        history.push("Account request submitted for " + name);
    }

    // 1 & 2:
    static void deposit() {
        System.out.print("Enter username: ");
        String name = sc.next();

        BankAccount acc = findAccount(name);

        if (acc == null) {
            System.out.println("❌ Account not found!");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount > 0) {
            acc.balance += amount;
            String transaction = "Deposit " + amount + " to " + name;
            history.push(transaction);
            System.out.println("✓ Deposit successful!");
            System.out.println("New balance for " + name + ": " + acc.balance);
        } else {
            System.out.println("❌ Invalid amount!");
        }
    }

    // TASK 2
    static void withdraw() {
        System.out.print("Enter username: ");
        String name = sc.next();

        BankAccount acc = findAccount(name);

        if (acc == null) {
            System.out.println("❌ Account not found!");
            return;
        }

        withdrawFromAccount(acc);
    }

    static void withdrawFromAccount(BankAccount acc) {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount > 0 && acc.balance >= amount) {
            acc.balance -= amount;
            String transaction = "Withdraw " + amount + " from " + acc.username;
            history.push(transaction);
            System.out.println("✓ Withdrawal successful!");
            System.out.println("New balance for " + acc.username + ": " + acc.balance);
        } else if (amount <= 0) {
            System.out.println("❌ Invalid amount!");
        } else {
            System.out.println("❌ Insufficient balance! Available: " + acc.balance);
        }
    }

    // TASK 3
    static void transactionHistoryMenu() {
        while (true) {
            System.out.println("\n--- TRANSACTION HISTORY (Stack) ---");
            System.out.println("1 - Add transaction (already done via deposit/withdraw)");
            System.out.println("2 - Undo last transaction (pop)");
            System.out.println("3 - Display last transaction (peek)");
            System.out.println("4 - Show all transaction history");
            System.out.println("5 - Back");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Use Deposit or Withdraw from main Bank menu to add transactions");
                    break;
                case 2:
                    undoLastTransaction();
                    break;
                case 3:
                    peekLastTransaction();
                    break;
                case 4:
                    showAllTransactions();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    static void undoLastTransaction() {
        if (history.isEmpty()) {
            System.out.println("❌ No transactions to undo!");
            return;
        }
        String removed = history.pop();
        System.out.println("✓ Undo successful!");
        System.out.println("Removed transaction: " + removed);
    }

    static void peekLastTransaction() {
        if (history.isEmpty()) {
            System.out.println("❌ No transactions found!");
            return;
        }
        System.out.println("📜 Last transaction: " + history.peek());
    }

    static void showAllTransactions() {
        if (history.isEmpty()) {
            System.out.println("❌ No transaction history!");
            return;
        }
        System.out.println("\n=== TRANSACTION HISTORY ===");
        int i = 1;
        for (String trans : history) {
            System.out.println(i++ + ". " + trans);
        }
    }

    //4
    static void addBillPayment() {
        System.out.print("Enter bill description (e.g., Electricity Bill): ");
        sc.nextLine(); // consume newline
        String bill = sc.nextLine();
        billQueue.add(bill);
        System.out.println("✓ Added: " + bill);
        history.push("Bill added: " + bill);
    }

    static void processNextBill() {
        if (billQueue.isEmpty()) {
            System.out.println("❌ No bills to process!");
            return;
        }
        String bill = billQueue.poll();
        System.out.println("✓ Processing: " + bill);
        if (!billQueue.isEmpty()) {
            System.out.println("Remaining bills: " + billQueue.size());
            System.out.println("Next in queue: " + billQueue.peek());
        } else {
            System.out.println("Bill queue is now empty!");
        }
        history.push("Bill processed: " + bill);
    }

    static void displayBillQueue() {
        if (billQueue.isEmpty()) {
            System.out.println("📭 Bill queue is empty!");
            return;
        }
        System.out.println("\n=== BILL PAYMENT QUEUE (FIFO) ===");
        int i = 1;
        for (String bill : billQueue) {
            System.out.println(i++ + ". " + bill);
        }
    }

    // TASK 1
    static void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("❌ No accounts found!");
            return;
        }
        System.out.println("\n=== ALL BANK ACCOUNTS ===");
        int i = 1;
        for (BankAccount acc : accounts) {
            System.out.println(i++ + ". " + acc.username + " - Account #" + acc.accountNumber + " - Balance: " + acc.balance);
        }
    }

    // TASK 5
    static BankAccount findAccount(String username) {
        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(username)) {
                return acc;
            }
        }
        return null;
    }

    // MENU
    static void atmMenu() {
        while (true) {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1 - Balance enquiry");
            System.out.println("2 - Withdraw money");
            System.out.println("3 - Back to main menu");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 3) return;

            System.out.print("Enter username: ");
            String name = sc.next();

            BankAccount acc = findAccount(name);

            if (acc == null) {
                System.out.println("❌ Account not found!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("💰 Balance for " + name + ": " + acc.balance);
                    break;
                case 2:
                    withdrawFromAccount(acc);
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    // ADMIN MENU
    static void adminMenu() {
        while (true) {
            System.out.println("\n--- ADMIN AREA ---");
            System.out.println("1 - Process account requests (move to main accounts)");
            System.out.println("2 - View pending account requests");
            System.out.println("3 - View bill payment queue");
            System.out.println("4 - Process next bill payment");
            System.out.println("5 - View all accounts");
            System.out.println("6 - Back to main menu");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    processAccountRequest();
                    break;
                case 2:
                    displayPendingRequests();
                    break;
                case 3:
                    displayBillQueue();
                    break;
                case 4:
                    processNextBill();
                    break;
                case 5:
                    displayAllAccounts();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    //  5
    static void processAccountRequest() {
        if (requests.isEmpty()) {
            System.out.println("❌ No pending account requests!");
            return;
        }
        BankAccount newAcc = requests.poll();
        accounts.add(newAcc);
        System.out.println("✓ Account approved and created!");
        System.out.println("Username: " + newAcc.username);
        System.out.println("Account Number: " + newAcc.accountNumber);
        System.out.println("Initial Balance: " + newAcc.balance);
        history.push("Admin approved account for " + newAcc.username);
    }

    static void displayPendingRequests() {
        if (requests.isEmpty()) {
            System.out.println("📭 No pending account requests!");
            return;
        }
        System.out.println("\n=== PENDING ACCOUNT REQUESTS ===");
        int i = 1;
        for (BankAccount req : requests) {
            System.out.println(i++ + ". Username: " + req.username + " (Request ID: " + req.accountNumber + ")");
        }
        System.out.println("Total pending: " + requests.size());
    }
}