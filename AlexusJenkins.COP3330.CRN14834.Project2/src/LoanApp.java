/*
    Name: Alexus Jenkins
    Course: COP 3330-14834
    Date: September 6th, 2023
    Program Objective: Create an application to manage the loans provided by the Java Programmers Loan (JPL) company.
    Purpose: Manages loans provided by Java Programmers Loan (JPL) company
 */
public class LoanApp{
    public static void main(String[] args) {
        //Create an array of five loans
        Loan[] loans = new Loan[5];

        //Define Prime Interest Rate
        double primeInterestRate = 4.0;

        //Loan Details
        String[] loanTypes = {"Business", "Personal", "Business", "Personal", "Business"};
        String[] customerLastNames = {"Jenkins", "Jalanea", "Smith", "Johnson", "James"};
        double[] loanAmounts = {25000.0, 20000.0, 10000.0, 30000.0, 18000.0};
        int[] loanTerms = {7, 5, 7, 4, 6};

        //Array - Loan Objects based on Loan Details
        for (int i = 0; i < loans.length; i++){
            if (loanTypes[i].equalsIgnoreCase("Business")){
                loans[i] = new BusinessLoan(i + 1, customerLastNames[i], loanAmounts[i], loanTerms[i], primeInterestRate);
            } else if (loanTypes[i].equalsIgnoreCase("Personal")){
                loans[i] = new PersonalLoan(i + 1, customerLastNames[i], loanAmounts[i], loanTerms[i], primeInterestRate);
            }
        }

        //Display the Bank Name
        System.out.println("Java Programmers Loan (JPL) Company");

        //Display all Loans
        System.out.println("List of Loans:");
        for (Loan loan: loans){
            System.out.println(loan);
        }

        //Display a message that indicates whether the 2nd loan is equal to the 4th loan in the array
        if (loans[1].equals(loans[3])){
            System.out.println("The 2nd loan is equal to the 4th loan.");
        } else {
            System.out.println("The 2nd loan is not equal to the 4th loan.");
        }

        //Display the total amount due for the 3rd loan in the array
        loans[2].calculateTotalAmountDue();

        //Display a message that shows the total amount JPL loaned in each category, as well as the total amount loaned for all loans in the array
        double totalBusinessLoanAmount = Loan.totalAmountLoaned(true);
        double totalPersonalAmount = Loan.totalAmountLoaned(false);
        double totalAmountLoaned = totalBusinessLoanAmount + totalPersonalAmount;

        System.out.println("Total Amount Loaned for Business Loans: $" + totalBusinessLoanAmount);
        System.out.println("Total Amount Loaned for Personal Loans: $" + totalPersonalAmount);
        System.out.println("Total Amount Loaned for All Loans: $" + totalAmountLoaned);


    }
}


