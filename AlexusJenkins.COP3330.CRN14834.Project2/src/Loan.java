/*
    Name: Alexus Jenkins
    Course: COP 3330-14834
    Date: September 6th, 2023
    Program Objective: Create an application to manage the loans provided by the Java Programmers Loan (JPL) company.
    Purpose: Define a system that can be shared among different types of loans.
 */
public abstract class Loan {
    //Class Attributes
    private final int loanNumber; //Stores a unique identifier for each loan
    private final String customerLastName; //Stores the last name of a customer associated with the loan
    private double loanAmount; //Represents the amount of money borrowed as part of the loan
    public double interestRate; //Holds the interest rate associated with the loan
    private final int term; //Stores the duration of the loan in years

    //Constructor - Initializes the Loan object with the class attributes.
    public Loan(int loanNumber, String customerLastName, double loanAmount, int term) {
        this.loanNumber = loanNumber;
        this.customerLastName = customerLastName;
        setLoanAmount(loanAmount);
        this.term = term;
    }

    //Getter Methods - Retrieve loan details.
    public int getLoanNumber() {
        return loanNumber;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTerm() {
        return term;
    }


    //Setter Method - Sets the loan amount with validation.

    public void setLoanAmount(double loanAmount) {
        if (loanAmount <= LoanConstants.MAX_LOAN_AMOUNT) {
            this.loanAmount = loanAmount;
        } else {
            System.out.println("Loan amount exceeds the maximum allowed amount.");
        }
    }

    //Abstract Methods - Defines a contract that subclasses must adhere to
    public abstract void setInterestRate();


    //toString() Method - Displays the loan data.
    @Override
    public String toString() {
        return "Loan Type: " + getClass().getSimpleName() + "\n" +
                "Loan Number: " + loanNumber + "\n" +
                "Customer's Last Name: " + customerLastName + "\n" +
                "Loan Amount: $" + loanAmount + "\n" +
                "Interest Rate: " + interestRate + "%\n" +
                "Term: " + term + " years";
    }

    //equals() Method - Determines whether 2 compared loans are equivalent
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Loan otherLoan) {
            return this.loanNumber == otherLoan.loanNumber;
        }
        return false;
    }

    //calculateTotalAmountDue - Calculates the total amount owed at the due date using simple interest.
    public void calculateTotalAmountDue() {
        double totalAmountDue = loanAmount + (loanAmount * interestRate * term);
        System.out.println("Total Amount Due: " + totalAmountDue);
    }

    //totalAmountLoaned - Calculate the total amount that JPL has loaned out in each category (Business/Personal) and in total.
    public static double totalAmountLoaned(boolean isBusinessLoan){
        double totalAmount = 0.0;

        double businessLoanAmount = 50000.0;
        double personalLoanAmount = 25000.0;

        int numBusinessLoans = 2;
        int numPersonalLoans = 3;

        switch (isBusinessLoan ? "Business" : "Personal"){
            case "Business":
                totalAmount = numBusinessLoans * businessLoanAmount;
                break;
            case "Personal":
                totalAmount = numPersonalLoans * personalLoanAmount;
                break;
            default:
                break;
        }
        return totalAmount;
    }


    }

