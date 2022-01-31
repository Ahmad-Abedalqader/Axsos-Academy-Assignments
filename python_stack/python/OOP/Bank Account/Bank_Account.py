class BankAccount:
    def __init__(self, int_rate = 0.01, balance = 0):
        self.int_rate = int_rate
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        self.balance -= amount
        return self

    def display_account_info(self):
        print("Balance: $"+str(self.balance))

    def yield_interest(self):
        if self.balance>0:
            self.balance += self.balance * self.int_rate
        return self

account1 = BankAccount(0.02,500)
account2 = BankAccount()

account1.deposit(300).deposit(100).deposit(50).withdraw(730).yield_interest().display_account_info()

account2.deposit(300).deposit(100).withdraw(50).withdraw(100).withdraw(70).withdraw(300).yield_interest().display_account_info()
