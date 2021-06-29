pragma solidity ^0.5.16;

contract EmploymentContract {

    string private companyId;
    string private employeeName;
    ufixed private employeeSalary;
    string private employeeSalaryUnit;
    string private employeeSur;
    uint private contractDuration;
    string private contractTerm;
    string private paymentTerm;
    string private country;

    ufixed private balance = 0;
    string private balanceUnit;

    uint private contractInitTimestamp;

    constructor(
        string memory _cid,
        string memory _name,
        string memory _surname,
        uint _duration,
        string memory _term,
        string memory _country,
        string memory _salaryTerm,
        uint _contractInitiationTimestamp) public {
            companyId = _cid;
            employeeName = _name;
            employeeSur = _surname;
            contractDuration = _duration;
            contractTerm = _term;
            country = _country;
            paymentTerm = _salaryTerm;
            contractInitTimestamp = _contractInitiationTimestamp;
    }

    function setBalance(ufixed newBalance) public returns(ufixed) {
        if (newBalance >= 0) {
            return balance += newBalance;
        } else return balance;
    }

    function transferFunds(address fromWallet, address toWallet) public {
    }

    function remainingSalary() private {

    }

    function isActiveContract() public view returns (bool){
        uint remainingContract = now - contractInitTimestamp;
        return (remainingContract >= 0);

    }
}
