package ethereum.wrappers;

import ethereum.utils.ContractTransactionUtils;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
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
    public static final String BINARY = "60806040523480156200001157600080fd5b5060405162000c7038038062000c70833981016040819052620000349162000329565b8751620000499060009060208b0190620001cc565b5085516200005f906003906020890190620001cc565b50845162000075906005906020880190620001cc565b5083516200008b906004906020870190620001cc565b508251620000a1906006906020860190620001cc565b5060078290558651620000bc9060029060208a0190620001cc565b506001819055620000cc620000da565b505050505050505062000497565b620151806008604051620000f990644461696c7960d81b815260050190565b9081526040805191829003602001822092909255655765656b6c7960d01b8152600860068083018290528351928390036026908101842062093a809055664d6f6e74686c7960c81b84526007840183905284519384900360270184206224ea0090556733204d6f6e74687360c01b845283830183905284519384900360289081018520626ebe0090556736204d6f6e74687360c01b855284840184905285519485900301842062dd7c00905565596561726c7960d01b84529083019190915291519081900390910190206301e133809055565b828054620001da9062000444565b90600052602060002090601f016020900481019282620001fe576000855562000249565b82601f106200021957805160ff191683800117855562000249565b8280016001018555821562000249579182015b82811115620002495782518255916020019190600101906200022c565b50620002579291506200025b565b5090565b5b808211156200025757600081556001016200025c565b600082601f8301126200028457600080fd5b81516001600160401b0380821115620002a157620002a162000481565b604051601f8301601f19908116603f01168101908282118183101715620002cc57620002cc62000481565b81604052838152602092508683858801011115620002e957600080fd5b600091505b838210156200030d5785820183015181830184015290820190620002ee565b838211156200031f5760008385830101525b9695505050505050565b600080600080600080600080610100898b0312156200034757600080fd5b88516001600160401b03808211156200035f57600080fd5b6200036d8c838d0162000272565b995060208b01519150808211156200038457600080fd5b620003928c838d0162000272565b985060408b0151915080821115620003a957600080fd5b620003b78c838d0162000272565b975060608b0151915080821115620003ce57600080fd5b620003dc8c838d0162000272565b965060808b0151915080821115620003f357600080fd5b620004018c838d0162000272565b955060a08b01519150808211156200041857600080fd5b50620004278b828c0162000272565b60c08b015160e0909b0151999c989b509699959894979350505050565b600181811c908216806200045957607f821691505b602082108114156200047b57634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052604160045260246000fd5b6107c980620004a76000396000f3fe60806040526004361061008f5760003560e01c8063bb3d48c011610056578063bb3d48c014610164578063bf64c0da14610179578063c29fe1a81461018e578063ee4766c6146101a4578063f08e362f146101b957005b806312065fe0146100d05780632db00354146100f257806342948e18146101055780634fc298861461012057806387b8d58e1461014257005b366100ce57604080513381523460208201527f88a5966d370b9919b20f3e2c13ff65706f196a4e32cc2c12bf57088f88525874910160405180910390a1005b005b3480156100dc57600080fd5b50475b6040519081526020015b60405180910390f35b6100ce61010036600461054a565b6101cc565b34801561011157600080fd5b506040513381526020016100e9565b34801561012c57600080fd5b50600754421060405190151581526020016100e9565b34801561014e57600080fd5b50610157610328565b6040516100e991906106bd565b34801561017057600080fd5b506101576103b6565b34801561018557600080fd5b506101576103c3565b34801561019a57600080fd5b506100df60015481565b3480156101b057600080fd5b506101576103d0565b6100ce6101c736600461050e565b6103dd565b806040516020016101dd9190610605565b6040516020818303038152906040528051906020012060066040516020016102059190610621565b60405160208183030381529060405280519060200120146102b95760405162461bcd60e51b815260206004820152605c60248201527f496e76616c69642066756e64732076616c756520706173736564206f7220706160448201527f7373656420756e697420646f65736e2774206d6174636820776974682062616c60648201527f616e636520756e69742c20616374696f6e2063616e63656c6c65642e00000000608482015260a4015b60405180910390fd5b6007544210156103175760405162461bcd60e51b8152602060048201526024808201527f43616e6e6f74206164642066756e647320746f206578706972656420636f6e746044820152631c9858dd60e21b60648201526084016102b0565b4761032283826106f0565b50505050565b6004805461033590610742565b80601f016020809104026020016040519081016040528092919081815260200182805461036190610742565b80156103ae5780601f10610383576101008083540402835291602001916103ae565b820191906000526020600020905b81548152906001019060200180831161039157829003601f168201915b505050505081565b6000805461033590610742565b6003805461033590610742565b6002805461033590610742565b306001600160a01b0382168114156104545760405162461bcd60e51b815260206004820152603460248201527f5468652073656e64657220616e64207265636569766572206164647265737365604482015273732063616e6e6f74206265207468652073616d6560601b60648201526084016102b0565b478311156104d85760405162461bcd60e51b815260206004820152604560248201527f496e73756666696369656e742062616c616e63652c2072656d61696e696e672060448201527f62616c616e6365206973206c657373207468616e2074686520616d6f756e742060648201526433b4bb32b760d91b608482015260a4016102b0565b6040516001600160a01b0383169084156108fc029085906000818181858888f19350505050158015610322573d6000803e3d6000fd5b6000806040838503121561052157600080fd5b8235915060208301356001600160a01b038116811461053f57600080fd5b809150509250929050565b6000806040838503121561055d57600080fd5b82359150602083013567ffffffffffffffff8082111561057c57600080fd5b818501915085601f83011261059057600080fd5b8135818111156105a2576105a261077d565b604051601f8201601f19908116603f011681019083821181831017156105ca576105ca61077d565b816040528281528860208487010111156105e357600080fd5b8260208601602083013760006020848301015280955050505050509250929050565b60008251610617818460208701610716565b9190910192915050565b600080835481600182811c91508083168061063d57607f831692505b602080841082141561065d57634e487b7160e01b86526022600452602486fd5b8180156106715760018114610682576106af565b60ff198616895284890196506106af565b60008a81526020902060005b868110156106a75781548b82015290850190830161068e565b505084890196505b509498975050505050505050565b60208152600082518060208401526106dc816040850160208701610716565b601f01601f19169190910160400192915050565b6000821982111561071157634e487b7160e01b600052601160045260246000fd5b500190565b60005b83811015610731578181015183820152602001610719565b838111156103225750506000910152565b600181811c9082168061075657607f821691505b6020821081141561077757634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052604160045260246000fdfea2646970667358221220d06b7ebcbb0732293a315f9a9be90e2588322b8e970be34bd11953f6ec625ecd64736f6c63430008060033";
    private final int RINKEBY_CHAIN_ID = 4;

    public static final String FUNC_ADDFUNDS = "addFunds";

    public static final String FUNC_EMPLOYEEEMAIL = "employeeEmail";

    public static final String FUNC_EMPLOYEENAME = "employeeName";

    public static final String FUNC_EMPLOYEESALARY = "employeeSalary";

    public static final String FUNC_EMPLOYEESUR = "employeeSur";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_GETSENDERADDRESS = "getSenderAddress";

    public static final String FUNC_ISACTIVECONTRACT = "isActiveContract";

    public static final String FUNC_PAYMENTTERM = "paymentTerm";

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

    public RemoteFunctionCall<String> employeeEmail() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_EMPLOYEEEMAIL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> employeeName() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_EMPLOYEENAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> employeeSalary() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_EMPLOYEESALARY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> employeeSur() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_EMPLOYEESUR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getBalance() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getSenderAddress() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETSENDERADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> isActiveContract() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISACTIVECONTRACT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> paymentTerm() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PAYMENTTERM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public CompletableFuture<EthSendTransaction> transferFunds(BigInteger amount, String toWallet) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFUNDS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount),
                        new org.web3j.abi.datatypes.Address(160, toWallet)),
                Collections.<TypeReference<?>>emptyList());

        String encodedFunction = FunctionEncoder.encode(function);
        String source = "0x816f37f9d8088b7ec15808b5c0811b217849614d";
        BigInteger nonce = ContractTransactionUtils.getNonceForAccount(web3j, source);
        //TODO remove these and add separate transaction wallets for each company
        String sourceFile = "C:\\Users\\panosmav\\AppData\\Roaming\\Ethereum\\testnet\\keystore\\UTC--2021-08-16T19-46-41.527495000Z--816f37f9d8088b7ec15808b5c0811b217849614d.json";
        String password = "paokaraoleG41";
        Optional<Credentials> credentials = ContractTransactionUtils.loadCredentials(password, sourceFile);

        String signedMessage = ContractTransactionUtils.signMessage(nonce, encodedFunction, contractAddress, RINKEBY_CHAIN_ID, credentials.get(), FUNC_TRANSFERFUNDS);
        return web3j.ethSendRawTransaction(signedMessage).sendAsync();
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

    public static RemoteCall<EmploymentContract_sol_EmploymentContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _name, String _email, String _surname, String _country, String _salaryTerm, String _balanceUnit, BigInteger _expiryTimestamp, BigInteger _salary) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_email), 
                new org.web3j.abi.datatypes.Utf8String(_surname), 
                new org.web3j.abi.datatypes.Utf8String(_country), 
                new org.web3j.abi.datatypes.Utf8String(_salaryTerm), 
                new org.web3j.abi.datatypes.Utf8String(_balanceUnit), 
                new org.web3j.abi.datatypes.generated.Uint256(_expiryTimestamp), 
                new org.web3j.abi.datatypes.generated.Uint256(_salary)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<EmploymentContract_sol_EmploymentContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _name, String _email, String _surname, String _country, String _salaryTerm, String _balanceUnit, BigInteger _expiryTimestamp, BigInteger _salary) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_email), 
                new org.web3j.abi.datatypes.Utf8String(_surname), 
                new org.web3j.abi.datatypes.Utf8String(_country), 
                new org.web3j.abi.datatypes.Utf8String(_salaryTerm), 
                new org.web3j.abi.datatypes.Utf8String(_balanceUnit), 
                new org.web3j.abi.datatypes.generated.Uint256(_expiryTimestamp), 
                new org.web3j.abi.datatypes.generated.Uint256(_salary)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<EmploymentContract_sol_EmploymentContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _name, String _email, String _surname, String _country, String _salaryTerm, String _balanceUnit, BigInteger _expiryTimestamp, BigInteger _salary) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_email), 
                new org.web3j.abi.datatypes.Utf8String(_surname), 
                new org.web3j.abi.datatypes.Utf8String(_country), 
                new org.web3j.abi.datatypes.Utf8String(_salaryTerm), 
                new org.web3j.abi.datatypes.Utf8String(_balanceUnit), 
                new org.web3j.abi.datatypes.generated.Uint256(_expiryTimestamp), 
                new org.web3j.abi.datatypes.generated.Uint256(_salary)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<EmploymentContract_sol_EmploymentContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _name, String _email, String _surname, String _country, String _salaryTerm, String _balanceUnit, BigInteger _expiryTimestamp, BigInteger _salary) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_email), 
                new org.web3j.abi.datatypes.Utf8String(_surname), 
                new org.web3j.abi.datatypes.Utf8String(_country), 
                new org.web3j.abi.datatypes.Utf8String(_salaryTerm), 
                new org.web3j.abi.datatypes.Utf8String(_balanceUnit), 
                new org.web3j.abi.datatypes.generated.Uint256(_expiryTimestamp), 
                new org.web3j.abi.datatypes.generated.Uint256(_salary)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ReceivedEventResponse extends BaseEventResponse {
        public String addr;

        public BigInteger amount;
    }
}
