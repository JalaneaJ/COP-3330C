/*
    Name: Alexus Jenkins
    Course: COP 3330-14834
    Date: September 6th, 2023
    Program Objective: Create an application to manage the loans provided by the Java Programmers Loan (JPL) company.
    Purpose: Represents Personal Loans offered by the Java Programmers Loan (JPL) Company.
 */
public class PersonalLoan extends Loan{
    private static final double PRIME_INTEREST_RATE = 4.0;

    //Constructor - Sets the interest rate for Personal Loans
    public PersonalLoan(int loanNumber, String customerLastName, double loanAmount, int term, double primeInterestRate){
        super(loanNumber, customerLastName, loanAmount, term);
        setInterestRate(); // Set the interest rate for the business loans
    }

    @Override //Sets the interest rate for Business Loans to 2.7% more than the current prime interest rate
    public void setInterestRate() {
        super.interestRate = getInterestRate() + 2.7;

    }
}
