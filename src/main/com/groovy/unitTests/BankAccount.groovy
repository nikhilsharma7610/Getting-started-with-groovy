package main.com.groovy.unitTests

class BankAccount {
    private balance

    BankAccount(openingBalance) {
        balance = openingBalance
    }

    def void deposit(amount) {
        balance += amount
    }

    def void withdraw(amount) {
        if (amount > balance)
            throw new InsufficientFundsException()

        balance -= amount
    }

    def void accruedInterest() {
        def interestRateService = new InterestRateService()
        def rate = interestRateService.getInterestRate()
        def interest = balance * rate
        deposit(interest)
    }
}
