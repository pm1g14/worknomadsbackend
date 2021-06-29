pragma solidity ^0.4.0;

contract EmploymentContract {

    String private companyId;
    String private employeeName;
    ufixed private employeeSalary;
    String private employeeSalaryUnit;
    String private employeeSur;
    uint private contractDuration;
    String private contractTerm;
    String private paymentTerm;
    String private country;

    ufixed private balance = 0;
    String private balanceUnit;




    constructor(String cid, String name, String surname, uint duration, String term, String countr, String salaryTerm, uint contractInitiationTimestamp) {
        companyId = cid;
        employeeName = name;
        employeeSur = surname;
        contractDuration = duration;
        contractTerm = term;
        country = countr;
        paymentTerm = salaryTerm;
    }

    function setBalance(ufixed newBalance) public {
        if (newBalance >= 0) {
            return balance += newBalance;
        } else return balance;
    }

    function transferFunds(address fromWallet, address toWallet) public {
    }

    function remainingSalary() private {

    }

    function isActiveContract() view {
        uint remainingContract = now - contractInitiationTimestamp;
        return (remainingContract >= 0);

    }
}
