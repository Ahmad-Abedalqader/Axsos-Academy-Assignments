class BankAccount:
    def __init__(self, int_rate = 0.01, balance = 0):
        self.int_rate = int_rate
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        if self.balance - amount < 0 :
            print("Insufficient funds: Charging a $5 fee")
        else:
            self.balance -= amount
        return self

    def display_account_info(self):
        print("Balance: $"+str(self.balance))
        return self

    def yield_interest(self):
        if self.balance>0:
            self.balance += self.balance * self.int_rate
        return self

class User:	
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = BankAccount(int_rate=0.01, balance=0)

    def make_deposit(self, amount):
        self.account.deposit(amount)
        return self

    def make_withdrawal(self,amount):
        self.account.withdraw(amount)
        return self

    def display_user_balance(self):
        print("User:",self.name+",","balance:",self.account.balance)

    def transfer_money(self, other_user, amount):
        self.account.balance-=amount
        other_user.account.balance+=amount
        return self

ahmad = User("Ahmad Abdalqader","abedalqader-ahmad@hotmail.com")
maher = User("Maher Abdalqader","abedalqader-maher@hotmail.com")

ahmad.make_deposit(1000).make_deposit(300).make_withdrawal(1350).display_user_balance()
maher.make_deposit(2000).make_deposit(300).make_withdrawal(500).display_user_balance()


