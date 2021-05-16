package test.com.groovy.unitTests

import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor
import groovy.test.GroovyTestCase
import main.com.groovy.unitTests.BankAccount
import main.com.groovy.unitTests.InsufficientFundsException
import main.com.groovy.unitTests.InterestRateService

/*
    Unit tests must be follow principles : F I R S T
*/
class BankAccountTest extends GroovyTestCase {

    def bankAccount

    def void setUp() {
        bankAccount = new BankAccount(10)
    }

    def void tearDown() {
        bankAccount = null
    }

    def void testDepositInBankAccount() {
        bankAccount.deposit(5)
        assert 15 == bankAccount.balance
    }

    def void testWithdrawFromBankAccount() {
        bankAccount.withdraw(5)
        assert 5 == bankAccount.balance
    }

    def void testWithdrawInsufficientFundsFromBankAccount() {
        shouldFail(InsufficientFundsException) {
            bankAccount.withdraw(15)
        }
    }

    /*
        This will not caught case when someone common out getInterestRate() and hard codes rate in acceredInterest
        eg : // def rate = interestRateService.getInterestRate()
                def rate = 0.30
     */
    def void testAccruedInterestWithStub() {
        def stubService = new StubFor(InterestRateService)
        stubService.demand.getInterestRate {
            return 0.20
        }
        stubService.use {
            bankAccount.accruedInterest()
        }
        assert 12 == bankAccount.balance
    }

    /*
        Mock will throw error is getInterestRate() is not called
        we can control # times a function should be called via Mock
     */
    def void testAccruedInterestWithMock() {
        def stubService = new MockFor(InterestRateService)
        stubService.demand.getInterestRate {
            return 0.20
        }
        stubService.use {
            bankAccount.accruedInterest()
        }
        assert 12 == bankAccount.balance
    }

}
