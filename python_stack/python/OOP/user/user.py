class User:	
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0

    def make_deposit(self, amount):
        self.account_balance += amount

    def make_withdrawal(self,amount):
        self.account_balance -= amount

    def display_user_balance(self):
        print("User:",self.name+",","balance:",self.account_balance)

    def transfer_money(self, other_user, amount):
        self.account_balance-=amount
        other_user.account_balance+=amount

ahmad = User("Ahmad Abdalqader","abedalqader-ahmad@hotmail.com")
maher = User("Maher Abdalqader","abedalqader-maher@hotmail.com")
john = User("john metz","joun-metz@gmail.com")

ahmad.make_deposit(1000)
print(ahmad.account_balance)

ahmad.make_withdrawal(500)
print(ahmad.account_balance)

ahmad.display_user_balance()

ahmad.transfer_money(maher,170)
print(ahmad.account_balance)
print(maher.account_balance)


