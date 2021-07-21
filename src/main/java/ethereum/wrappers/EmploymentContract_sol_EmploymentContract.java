package ethereum.wrappers;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

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
    public static final String BINARY = "60806040523480156200001157600080fd5b50604051620009b8380380620009b8833981016040819052620000349162000325565b8651620000499060009060208a0190620001c8565b5085516200005f906001906020890190620001c8565b50845162000075906004906020880190620001c8565b5083516200008b906006906020870190620001c8565b508251620000a1906005906020860190620001c8565b508151620000b7906007906020850190620001c8565b506008819055620000c7620000d4565b505050505050506200048a565b620151806009604051620000f390644461696c7960d81b815260050190565b9081526040805191829003602001822092909255655765656b6c7960d01b8152600960068083018290528351928390036026908101842062093a809055664d6f6e74686c7960c81b84526007840183905284519384900360270184206224ea0090556733204d6f6e74687360c01b8452600880850184905285519485900360289081018620626ebe0090556736204d6f6e74687360c01b865290850184905285519485900301842062dd7c00905565596561726c7960d01b84529083019190915291519081900390910190206301e133809055565b828054620001d69062000437565b90600052602060002090601f016020900481019282620001fa576000855562000245565b82601f106200021557805160ff191683800117855562000245565b8280016001018555821562000245579182015b828111156200024557825182559160200191906001019062000228565b506200025392915062000257565b5090565b5b8082111562000253576000815560010162000258565b600082601f8301126200028057600080fd5b81516001600160401b03808211156200029d576200029d62000474565b604051601f8301601f19908116603f01168101908282118183101715620002c857620002c862000474565b81604052838152602092508683858801011115620002e557600080fd5b600091505b83821015620003095785820183015181830184015290820190620002ea565b838211156200031b5760008385830101525b9695505050505050565b600080600080600080600060e0888a0312156200034157600080fd5b87516001600160401b03808211156200035957600080fd5b620003678b838c016200026e565b985060208a01519150808211156200037e57600080fd5b6200038c8b838c016200026e565b975060408a0151915080821115620003a357600080fd5b620003b18b838c016200026e565b965060608a0151915080821115620003c857600080fd5b620003d68b838c016200026e565b955060808a0151915080821115620003ed57600080fd5b620003fb8b838c016200026e565b945060a08a01519150808211156200041257600080fd5b50620004218a828b016200026e565b92505060c0880151905092959891949750929550565b600181811c908216806200044c57607f821691505b602082108114156200046e57634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052604160045260246000fd5b61051e806200049a6000396000f3fe6080604052600436106100355760003560e01c806312065fe0146100765780632db0035414610096578063f08e362f146100a957005b3661007457604080513381523460208201527f88a5966d370b9919b20f3e2c13ff65706f196a4e32cc2c12bf57088f88525874910160405180910390a1005b005b34801561008257600080fd5b504760405190815260200160405180910390f35b6100746100a436600461031a565b6100c9565b3480156100b557600080fd5b506100746100c43660046102de565b610225565b806040516020016100da91906103d5565b6040516020818303038152906040528051906020012060076040516020016101029190610410565b60405160208183030381529060405280519060200120146101b65760405162461bcd60e51b815260206004820152605c60248201527f496e76616c69642066756e64732076616c756520706173736564206f7220706160448201527f7373656420756e697420646f65736e2774206d6174636820776974682062616c60648201527f616e636520756e69742c20616374696f6e2063616e63656c6c65642e00000000608482015260a4015b60405180910390fd5b6008544210156102145760405162461bcd60e51b8152602060048201526024808201527f43616e6e6f74206164642066756e647320746f206578706972656420636f6e746044820152631c9858dd60e21b60648201526084016101ad565b4761021f83826104ac565b50505050565b336001600160a01b038216811480159061023f5750478311155b6102a85760405162461bcd60e51b815260206004820152603460248201527f5468652073656e64657220616e64207265636569766572206164647265737365604482015273732063616e6e6f74206265207468652073616d6560601b60648201526084016101ad565b6040516001600160a01b0383169084156108fc029085906000818181858888f1935050505015801561021f573d6000803e3d6000fd5b600080604083850312156102f157600080fd5b8235915060208301356001600160a01b038116811461030f57600080fd5b809150509250929050565b6000806040838503121561032d57600080fd5b82359150602083013567ffffffffffffffff8082111561034c57600080fd5b818501915085601f83011261036057600080fd5b813581811115610372576103726104d2565b604051601f8201601f19908116603f0116810190838211818310171561039a5761039a6104d2565b816040528281528860208487010111156103b357600080fd5b8260208601602083013760006020848301015280955050505050509250929050565b6000825160005b818110156103f657602081860181015185830152016103dc565b81811115610405576000828501525b509190910192915050565b600080835481600182811c91508083168061042c57607f831692505b602080841082141561044c57634e487b7160e01b86526022600452602486fd5b81801561046057600181146104715761049e565b60ff1986168952848901965061049e565b60008a81526020902060005b868110156104965781548b82015290850190830161047d565b505084890196505b509498975050505050505050565b600082198211156104cd57634e487b7160e01b600052601160045260246000fd5b500190565b634e487b7160e01b600052604160045260246000fdfea264697066735822122028d6eaa8695db18d0fbd0b24ea089bb0fff619a200d93c8f3a5d662c6944080664736f6c63430008060033";

    public static final String FUNC_ADDFUNDS = "addFunds";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_TRANSFERFUNDS = "transferFunds";

    public static final Event RECEIVED_EVENT = new Event("Received", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

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

    public List<ReceivedEventResponse> getReceivedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RECEIVED_EVENT, transactionReceipt);
        ArrayList<ReceivedEventResponse> responses = new ArrayList<ReceivedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReceivedEventResponse typedResponse = new ReceivedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReceivedEventResponse> receivedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReceivedEventResponse>() {
            @Override
            public ReceivedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RECEIVED_EVENT, log);
                ReceivedEventResponse typedResponse = new ReceivedEventResponse();
                typedResponse.log = log;
                typedResponse.addr = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReceivedEventResponse> receivedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECEIVED_EVENT));
        return receivedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addFunds(BigInteger newFunds, String fundsUnit) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDFUNDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(newFunds), 
                new org.web3j.abi.datatypes.Utf8String(fundsUnit)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getBalance() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFunds(BigInteger amount, String toWallet) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFUNDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount), 
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
                new org.web3j.abi.datatypes.generated.Uint256(_expiryTimestamp)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<EmploymentContract_sol_EmploymentContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _cid, String _name, String _surname, String _country, String _salaryTerm, String _balanceUnit, BigInteger _expiryTimestamp) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_cid), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_surname), 
                new org.web3j.abi.datatypes.Utf8String(_country), 
                new org.web3j.abi.datatypes.Utf8String(_salaryTerm), 
                new org.web3j.abi.datatypes.Utf8String(_balanceUnit), 
                new org.web3j.abi.datatypes.generated.Uint256(_expiryTimestamp)));
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
                new org.web3j.abi.datatypes.generated.Uint256(_expiryTimestamp)));
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
                new org.web3j.abi.datatypes.generated.Uint256(_expiryTimestamp)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ReceivedEventResponse extends BaseEventResponse {
        public String addr;

        public BigInteger amount;
    }
}
