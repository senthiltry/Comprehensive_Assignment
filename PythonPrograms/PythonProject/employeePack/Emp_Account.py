class EmployeeDetails:
    EmpId = 0
    EmpName = ""
    EmpAcctBalance = 0

    def __init__(self, EmpId, EmpName, EmpAcctBalance):
        EmployeeDetails.EmpId = EmpId
        EmployeeDetails.EmpName = EmpName
        EmployeeDetails.EmpAcctBalance = EmpAcctBalance

    def get_empId(self):
        return self.EmpId

    def set_empId(self, value):
        self.EmpId = value

    def get_empName(self):
        return self.EmpName

    def set_empName(self, value):
        self.EmpName = value

    def get_empAcctBalance(self):
        return self.EmpAcctBalance

    def set_empAcctBalance(self, value):
        self.EmpAcctBalance = value


class EmpFinalbalance:

    def creditAmount(cr):
        emp = EmployeeDetails(0, "", 0)
        emp.set_empId(111)
        emp.set_empName("Senthil")
        emp.set_empAcctBalance(50000)
        empId = emp.get_empId()
        empName = emp.get_empName()
        availableBalance = emp.get_empAcctBalance()
        updatedBalanceAfterCreditedAmount = availableBalance + cr
        print("Employee id: ", empId)
        print("Employee name: ", empName)
        print("Employee account's available balance: ", availableBalance)
        print("Credited amount to employee's account: ", cr)
        print("Updated balance after credit amount: ", updatedBalanceAfterCreditedAmount)
        return updatedBalanceAfterCreditedAmount;

    def debitAmount(db, creditAmount):
        totalAmount = EmpFinalbalance.creditAmount(creditAmount)
        finalBalanceAfterDebitedAmount = totalAmount - db
        print("Debited amount from employee's account: ", db)
        if db <= totalAmount:
            print("Final balance after debit amount: ", finalBalanceAfterDebitedAmount)
        else:
            print("Debit amount: ", db, " is higher than the available amount: ", totalAmount)


EmpFinalbalance.debitAmount(20000, 30000)