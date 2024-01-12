/*
    Name: Alexus Jenkins
    Course: COP 3330-14834
    Date: September 6th, 2023
    Program Objective: Create an application to manage the loans provided by the Java Programmers Loan (JPL) company.
    Purpose: Represents Business Loans offered by the Java Programmers Loan (JPL) Company.
 */
public class BusinessLoan extends Loan {
        private static final double PRIME_INTEREST_RATE = 4.0;
    //Constructor - Sets the interest rate for Business Loans
    public BusinessLoan(int loanNumber, String customerLastName, double loanAmount, int term, double primeInterestRate){
        super(loanNumber, customerLastName, loanAmount, term);
        setInterestRate(); // Set the interest rate for the business loans
    }

    @Override //Sets the interest rate for Business Loans to 3.2% more than the current prime interest rate
    public void setInterestRate() {
        super.interestRate = getInterestRate() + 3.2;

    }
}
