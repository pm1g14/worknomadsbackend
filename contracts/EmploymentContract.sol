//SPDX-License-Identifier: MIT

pragma solidity ^0.8.6;

contract EmploymentContract {

    string private companyId;
    string private employeeName;
    ufixed private employeeSalary;
    string private employeeSalaryUnit;
    string private employeeSur;
    string private paymentTerm;
    string private country;

    string private balanceUnit;

    uint256 expiryTimestamp;
    mapping(string => uint) private termMapping;


    constructor(string memory _cid,string memory _name, string memory _surname, string memory _country, string memory _salaryTerm, string memory _balanceUnit, uint256 _expiryTimestamp) {
            companyId = _cid;
            employeeName = _name;
            employeeSur = _surname;
            country = _country;
            paymentTerm = _salaryTerm;
            balanceUnit = _balanceUnit;
            expiryTimestamp = _expiryTimestamp;
            populateTermMapping();
    }

    event Received(address addr, uint amount);

    receive() external payable {
        emit Received(msg.sender, msg.value);
    }

    fallback() external payable{}

    function addFunds(uint256 newFunds, string memory fundsUnit) public payable {
        require(newFunds >= 0 && keccak256(abi.encodePacked(balanceUnit)) == keccak256(abi.encodePacked(fundsUnit)), "Invalid funds value passed or passed unit doesn't match with balance unit, action cancelled.");
        require(!isActiveContract(), "Cannot add funds to expired contract");
        uint256 contractBalance = address(this).balance;
        contractBalance = contractBalance + newFunds;
    }

    function populateTermMapping() private {
        termMapping["Daily"] = 1 days;
        termMapping["Weekly"] = 1 weeks;
        termMapping["Monthly"] = 4 weeks;
        termMapping["3 Months"] = 12 weeks;
        termMapping["6 Months"] = 24 weeks;
        termMapping["Yearly"] = 365 days;
    }

    function getBalance() public view returns(uint256) {
        return address(this).balance;
    }

    function transferFunds(uint256 amount, address payable toWallet) public {
        address senderAddr = msg.sender;
        require(toWallet != senderAddr && amount <= getBalance(), "The sender and receiver addresses cannot be the same");
        toWallet.transfer(amount);
    }

    function isActiveContract() private view returns (bool){
        return block.timestamp < expiryTimestamp; //TODO implement a safer way because a miner could change the contract's block.timestamp
    }
}
