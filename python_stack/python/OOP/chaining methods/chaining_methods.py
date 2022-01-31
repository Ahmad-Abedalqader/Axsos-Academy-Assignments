class User:	
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0

    def make_deposit(self, amount):
        self.account_balance += amount
        return self

    def make_withdrawal(self,amount):
        self.account_balance -= amount
        return self
    def display_user_balance(self):
        print("User:",self.name+",","balance:",self.account_balance)
        return self

    def transfer_money(self, other_user, amount):
        self.account_balance-=amount
        other_user.account_balance+=amount
        return self

ahmad = User("Ahmad Abdalqader","abedalqader-ahmad@hotmail.com")
maher = User("Maher Abdalqader","abedalqader-maher@hotmail.com")
john = User("john metz","joun-metz@gmail.com")

#---------------these methods are before chaining them-----------------
# ahmad.make_deposit(1000)
# ahmad.make_deposit(300)
# ahmad.make_withdrawal(500)
# ahmad.transfer_money(maher,170)
# ahmad.display_user_balance()

# maher.make_deposit(2000)
# maher.make_deposit(300)
# maher.make_withdrawal(500)
# maher.display_user_balance()

# john.make_deposit(1200)
# john.make_deposit(500)
# john.display_user_balance()

#---------------------now the following is after chaining:-------------
ahmad.make_deposit(1000).make_deposit(300).make_withdrawal(500).transfer_money(maher,170).display_user_balance()
maher.make_deposit(2000).make_deposit(300).make_withdrawal(500).display_user_balance()
john.make_deposit(1200).make_deposit(500).display_user_balance()
