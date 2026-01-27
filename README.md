# ATM Simulator & Bank Account System

A secure, logic-driven banking simulation built in Java. This project demonstrates strict **Access Control** and **Encapsulation** principles, ensuring that account properties are protected from direct modification and handling complex business logic for transactions, status checks, and audit logging.

> **Current Status:** Completed (Developed using TDD methodology)

---

##  Key Features
* **Robust Access Control:** Private fields (`balance`, `accountNumber`) are protected by logic-heavy accessor/mutator methods, preventing invalid states.
* **Transaction Logic:**
    * **Deposits/Withdrawals:** Only permitted on `OPEN` accounts.
    * **Transfers:** atomic transfers between accounts of the same holder, ensuring neither drops below zero.
    * **Overdraft Protection:** Configurable prevention that strictly blocks transactions exceeding the balance.
* **Account States:**
    * **OFAC Freeze:** Blocks balance inquiries and transactions while active.
    * **Closed:** Permanent state; requires zero balance to enter.
* **Audit Trail:** An internal ledger records every transaction (Withdrawal, Deposit, Status Change) for security and debugging.

---

##  Tech Stack
* **Language:** Java
* **Testing:** JUnit (Test-Driven Development)
* **Concepts:** OOP, Encapsulation, State Management, Input Validation

---

##  Architecture & Design
The core of the system is the `BankAccount` class, which strictly enforces business rules.

### 1. Encapsulation & Immutability
Critical fields like `accountNumber` and `accountType` are **immutable**—set only during the constructor and never changed.
```java
public BankAccount(String name, String type, long number) {
    this.accountHolder = name;
    this.accountType = type;   // Immutable
    this.accountNumber = number; // Immutable
    this.status = Status.OPEN;
}
```
### 2. Secure Transaction Handling
The debit (withdraw) method encapsulates multiple checks before modifying the state:

Is the account Open?

Is Overdraft Prevention enabled?

Is there sufficient balance?
```
public boolean debit(double amount) {
    if (status != Status.OPEN || status == Status.FREEZE) return false;
    
    if (overdraftPrevention && (balance - amount < 0)) {
        return false; // Transaction declined
    }
    
    this.balance -= amount;
    recordTransaction("Debit", amount);
    return true;
}
```
### 3. Setup & Testing
This project was built using Test-Driven Development (TDD).

#### 3.1 Clone the repository:
```
git clone https://github.com/srv-0/Bank_Management_System.git
cd atm-simulator
```
#### 3.2 Compile the Project:
```
javac src/*.java
```
#### 3.3 Run Unit Tests: Run the JUnit test suite to verify all business rules (Overdrafts, Freezes, Transfers).
```
java -cp .:junit.jar org.junit.runner.JUnitCore BankAccountTest
```
### Author

Saurav Singh
