In this project, I created a simple banking system in Java using different data structures. I used a LinkedList to store bank accounts, a Stack to keep transaction history, and Queues to manage bill payments and account requests. I also used an Array to store predefined accounts.

The program allows users to deposit and withdraw money, check balance, submit account requests, and view transaction history. There are separate menus for Bank, ATM, and Admin, which simulate real banking operations.

Overall, this project helped me understand how data structures work in real-life applications.


Task 1 – LinkedList: Created BankAccount class (accountNumber, username, balance). Used LinkedList to store accounts. Implemented: add account, display all accounts, search by username.

Task 2 – Deposit/Withdraw: Added deposit and withdraw methods with balance updates.

Task 3 – Stack (LIFO): Created Stack<String> for transaction history. Implemented: add transaction, undo last transaction (pop), display last transaction (peek).

Task 4 – Queue (FIFO): Created billQueue for bill payments. Implemented: add bill, process next bill, display queue.

Task 5 – Account Opening Queue: Created queue for account requests. User submits request → Admin processes → account added to LinkedList.

Task 6 – Array: Created BankAccount[3] with three predefined accounts (Ali, Sara, John) and displayed them.

Mini Banking Menu: Integrated all structures into one menu: Bank Menu (requests, deposit, withdraw, history, bills), ATM Menu (balance, withdraw), Admin Menu (process requests, bill queue).

Issues Solved: Scanner bug fixed with sc.nextLine(), account ID conflict fixed with counter, "class Main is public" error fixed by removing public.

Result: All 6 tasks and the mini banking menu work correctly. The program uses LinkedList, Stack, Queue, and Array as required.
