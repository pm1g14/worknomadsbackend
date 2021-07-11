package ethereum.wrappers;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;


/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class EmploymentContract_sol_EmploymentContract extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b506040516200097d3803806200097d833981016040819052620000349162000325565b8651620000499060009060208a0190620001c8565b5085516200005f906001906020890190620001c8565b50845162000075906004906020880190620001c8565b5083516200008b906006906020870190620001c8565b508251620000a1906005906020860190620001c8565b508151620000b7906007906020850190620001c8565b506008819055620000c7620000d4565b505050505050506200048a565b620151806009604051620000f390644461696c7960d81b815260050190565b9081526040805191829003602001822092909255655765656b6c7960d01b8152600960068083018290528351928390036026908101842062093a809055664d6f6e74686c7960c81b84526007840183905284519384900360270184206224ea0090556733204d6f6e74687360c01b8452600880850184905285519485900360289081018620626ebe0090556736204d6f6e74687360c01b865290850184905285519485900301842062dd7c00905565596561726c7960d01b84529083019190915291519081900390910190206301e133809055565b828054620001d69062000437565b90600052602060002090601f016020900481019282620001fa576000855562000245565b82601f106200021557805160ff191683800117855562000245565b8280016001018555821562000245579182015b828111156200024557825182559160200191906001019062000228565b506200025392915062000257565b5090565b5b8082111562000253576000815560010162000258565b600082601f8301126200028057600080fd5b81516001600160401b03808211156200029d576200029d62000474565b604051601f8301601f19908116603f01168101908282118183101715620002c857620002c862000474565b81604052838152602092508683858801011115620002e557600080fd5b600091505b83821015620003095785820183015181830184015290820190620002ea565b838211156200031b5760008385830101525b9695505050505050565b600080600080600080600060e0888a0312156200034157600080fd5b87516001600160401b03808211156200035957600080fd5b620003678b838c016200026e565b985060208a01519150808211156200037e57600080fd5b6200038c8b838c016200026e565b975060408a0151915080821115620003a357600080fd5b620003b18b838c016200026e565b965060608a0151915080821115620003c857600080fd5b620003d68b838c016200026e565b955060808a0151915080821115620003ed57600080fd5b620003fb8b838c016200026e565b945060a08a01519150808211156200041257600080fd5b50620004218a828b016200026e565b92505060c0880151905092959891949750929550565b600181811c908216806200044c57607f821691505b602082108114156200046e57634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052604160045260246000fd5b6104e3806200049a6000396000f3fe6080604052600436106100345760003560e01c806312065fe0146100395780632db0035414610059578063f08e362f1461006e575b600080fd5b34801561004557600080fd5b504760405190815260200160405180910390f35b61006c6100673660046102df565b61008e565b005b34801561007a57600080fd5b5061006c6100893660046102a3565b6101ea565b8060405160200161009f919061039a565b6040516020818303038152906040528051906020012060076040516020016100c791906103d5565b604051602081830303815290604052805190602001201461017b5760405162461bcd60e51b815260206004820152605c60248201527f496e76616c69642066756e64732076616c756520706173736564206f7220706160448201527f7373656420756e697420646f65736e2774206d6174636820776974682062616c60648201527f616e636520756e69742c20616374696f6e2063616e63656c6c65642e00000000608482015260a4015b60405180910390fd5b6008544210156101d95760405162461bcd60e51b8152602060048201526024808201527f43616e6e6f74206164642066756e647320746f206578706972656420636f6e746044820152631c9858dd60e21b6064820152608401610172565b476101e48382610471565b50505050565b336001600160a01b03821681148015906102045750478311155b61026d5760405162461bcd60e51b815260206004820152603460248201527f5468652073656e64657220616e64207265636569766572206164647265737365604482015273732063616e6e6f74206265207468652073616d6560601b6064820152608401610172565b6040516001600160a01b0383169084156108fc029085906000818181858888f193505050501580156101e4573d6000803e3d6000fd5b600080604083850312156102b657600080fd5b8235915060208301356001600160a01b03811681146102d457600080fd5b809150509250929050565b600080604083850312156102f257600080fd5b82359150602083013567ffffffffffffffff8082111561031157600080fd5b818501915085601f83011261032557600080fd5b81358181111561033757610337610497565b604051601f8201601f19908116603f0116810190838211818310171561035f5761035f610497565b8160405282815288602084870101111561037857600080fd5b8260208601602083013760006020848301015280955050505050509250929050565b6000825160005b818110156103bb57602081860181015185830152016103a1565b818111156103ca576000828501525b509190910192915050565b600080835481600182811c9150808316806103f157607f831692505b602080841082141561041157634e487b7160e01b86526022600452602486fd5b818015610425576001811461043657610463565b60ff19861689528489019650610463565b60008a81526020902060005b8681101561045b5781548b820152908501908301610442565b505084890196505b509498975050505050505050565b6000821982111561049257634e487b7160e01b600052601160045260246000fd5b500190565b634e487b7160e01b600052604160045260246000fdfea2646970667358221220020f256c22d0c0699bedc34e455822c5e632d04f8353f45ac85a61c7d6db2b4664736f6c63430008060033";

    public static final String FUNC_ADDFUNDS = "addFunds";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_TRANSFERFUNDS = "transferFunds";

    @Deprecated
    protected EmploymentContract_sol_EmploymentContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EmploymentContract_sol_EmploymentContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected EmploymentContract_sol_EmploymentContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected EmploymentContract_sol_EmploymentContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addFunds(BigInteger newFunds, String fundsUnit) {
        final Function function = new Function(
                FUNC_ADDFUNDS, 
                Arrays.<Type>asList(new Uint256(newFunds),
                new org.web3j.abi.datatypes.Utf8String(fundsUnit)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getBalance() {
        final Function function = new Function(FUNC_GETBALANCE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFunds(BigInteger amount, String toWallet) {
        final Function function = new Function(
                FUNC_TRANSFERFUNDS,
                Arrays.<Type>asList(new Uint256(amount),
                new org.web3j.abi.datatypes.Address(160, toWallet)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static EmploymentContract_sol_EmploymentContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EmploymentContract_sol_EmploymentContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static EmploymentContract_sol_EmploymentContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EmploymentContract_sol_EmploymentContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static EmploymentContract_sol_EmploymentContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new EmploymentContract_sol_EmploymentContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static EmploymentContract_sol_EmploymentContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new EmploymentContract_sol_EmploymentContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<EmploymentContract_sol_EmploymentContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _cid, String _name, String _surname, String _country, String _salaryTerm, String _balanceUnit, BigInteger _expiryTimestamp) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_cid),
                new org.web3j.abi.datatypes.Utf8String(_name),
                new org.web3j.abi.datatypes.Utf8String(_surname),
                new org.web3j.abi.datatypes.Utf8String(_country),
                new org.web3j.abi.datatypes.Utf8String(_salaryTerm),
                new org.web3j.abi.datatypes.Utf8String(_balanceUnit),
                new Uint256(_expiryTimestamp)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<EmploymentContract_sol_EmploymentContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _cid, String _name, String _surname, String _country, String _salaryTerm, String _balanceUnit, BigInteger _expiryTimestamp) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_cid),
                new org.web3j.abi.datatypes.Utf8String(_name),
                new org.web3j.abi.datatypes.Utf8String(_surname),
                new org.web3j.abi.datatypes.Utf8String(_country),
                new org.web3j.abi.datatypes.Utf8String(_salaryTerm),
                new org.web3j.abi.datatypes.Utf8String(_balanceUnit),
                new Uint256(_expiryTimestamp)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<EmploymentContract_sol_EmploymentContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _cid, String _name, String _surname, String _country, String _salaryTerm, String _balanceUnit, BigInteger _expiryTimestamp) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_cid),
                new org.web3j.abi.datatypes.Utf8String(_name),
                new org.web3j.abi.datatypes.Utf8String(_surname),
                new org.web3j.abi.datatypes.Utf8String(_country),
                new org.web3j.abi.datatypes.Utf8String(_salaryTerm),
                new org.web3j.abi.datatypes.Utf8String(_balanceUnit),
                new Uint256(_expiryTimestamp)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<EmploymentContract_sol_EmploymentContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _cid, String _name, String _surname, String _country, String _salaryTerm, String _balanceUnit, BigInteger _expiryTimestamp) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_cid),
                new org.web3j.abi.datatypes.Utf8String(_name),
                new org.web3j.abi.datatypes.Utf8String(_surname),
                new org.web3j.abi.datatypes.Utf8String(_country),
                new org.web3j.abi.datatypes.Utf8String(_salaryTerm),
                new org.web3j.abi.datatypes.Utf8String(_balanceUnit),
                new Uint256(_expiryTimestamp)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
