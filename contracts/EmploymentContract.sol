pragma solidity ^0.5.16;

contract EmploymentContract {

    string private companyId;
    string private employeeName;
    ufixed private employeeSalary;
    string private employeeSalaryUnit;
    string private employeeSur;
    string private paymentTerm;
    string private country;

    string private balanceUnit;


    constructor(
        string memory _cid,
        string memory _name,
        string memory _surname,
        string memory _country,
        string memory _salaryTerm,
        string memory _balanceUnit) public {
            companyId = _cid;
            employeeName = _name;
            employeeSur = _surname;
            country = _country;
            paymentTerm = _salaryTerm;
            balanceUnit = _balanceUnit;
    }

    function addFunds(uint256 newFunds, string memory fundsUnit) public payable {
        require(newFunds >= 0 && keccak256(abi.encodePacked(balanceUnit)) == keccak256(abi.encodePacked(fundsUnit)), "Invalid funds value passed or passed unit doesn't match with balance unit, action cancelled.");
        uint256 contractBalance = address(this).balance;
        contractBalance = contractBalance + newFunds;
    }

    function getBalance() public view returns(uint256) {
        return address(msg.sender).balance;
    }

    function transferFunds(uint256 amount, address payable toWallet) public {
        address thisAddress = msg.sender;
        require(toWallet != thisAddress && amount <= getBalance(), "The sender and receiver addresses cannot be the same");
        toWallet.transfer(amount);
    }

    function isActiveContract() public view returns (bool){


    }
}
