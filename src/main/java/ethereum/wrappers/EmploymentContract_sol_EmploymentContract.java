package ethereum.wrappers;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    public static final String BINARY = "60806040523480156200001157600080fd5b5060405162000c1138038062000c1183398101604081905262000034916200033c565b8751620000499060059060208b0190620001df565b5086516200005f9060009060208a0190620001df565b50845162000075906003906020880190620001df565b5083516200008b906007906020870190620001df565b508251620000a1906004906020860190620001df565b508151620000b7906008906020850190620001df565b5060098190558551620000d2906002906020890190620001df565b50620000dd620000eb565b5050505050505050620004c9565b62015180600a6040516200010a90644461696c7960d81b815260050190565b9081526040805191829003602001822092909255655765656b6c7960d01b8152600a60068083018290528351928390036026908101842062093a809055664d6f6e74686c7960c81b84526007840183905284519384900360270184206224ea0090556733204d6f6e74687360c01b8452600880850184905285519485900360289081018620626ebe0090556736204d6f6e74687360c01b865290850184905285519485900301842062dd7c00905565596561726c7960d01b84529083019190915291519081900390910190206301e133809055565b828054620001ed9062000476565b90600052602060002090601f0160209004810192826200021157600085556200025c565b82601f106200022c57805160ff19168380011785556200025c565b828001600101855582156200025c579182015b828111156200025c5782518255916020019190600101906200023f565b506200026a9291506200026e565b5090565b5b808211156200026a57600081556001016200026f565b600082601f8301126200029757600080fd5b81516001600160401b0380821115620002b457620002b4620004b3565b604051601f8301601f19908116603f01168101908282118183101715620002df57620002df620004b3565b81604052838152602092508683858801011115620002fc57600080fd5b600091505b8382101562000320578582018301518183018401529082019062000301565b83821115620003325760008385830101525b9695505050505050565b600080600080600080600080610100898b0312156200035a57600080fd5b88516001600160401b03808211156200037257600080fd5b620003808c838d0162000285565b995060208b01519150808211156200039757600080fd5b620003a58c838d0162000285565b985060408b0151915080821115620003bc57600080fd5b620003ca8c838d0162000285565b975060608b0151915080821115620003e157600080fd5b620003ef8c838d0162000285565b965060808b01519150808211156200040657600080fd5b620004148c838d0162000285565b955060a08b01519150808211156200042b57600080fd5b620004398c838d0162000285565b945060c08b01519150808211156200045057600080fd5b506200045f8b828c0162000285565b92505060e089015190509295985092959890939650565b600181811c908216806200048b57607f821691505b60208210811415620004ad57634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052604160045260246000fd5b61073880620004d96000396000f3fe6080604052600436106100845760003560e01c8063bb3d48c011610056578063bb3d48c01461013e578063bf64c0da14610153578063c29fe1a814610168578063ee4766c61461017e578063f08e362f1461019357005b806312065fe0146100c55780632db00354146100e75780634fc29886146100fa57806387b8d58e1461011c57005b366100c357604080513381523460208201527f88a5966d370b9919b20f3e2c13ff65706f196a4e32cc2c12bf57088f88525874910160405180910390a1005b005b3480156100d157600080fd5b50475b6040519081526020015b60405180910390f35b6100c36100f53660046104b9565b6101b3565b34801561010657600080fd5b50600954421060405190151581526020016100de565b34801561012857600080fd5b5061013161030f565b6040516100de919061062c565b34801561014a57600080fd5b5061013161039d565b34801561015f57600080fd5b506101316103aa565b34801561017457600080fd5b506100d460015481565b34801561018a57600080fd5b506101316103b7565b34801561019f57600080fd5b506100c36101ae36600461047d565b6103c4565b806040516020016101c49190610574565b6040516020818303038152906040528051906020012060086040516020016101ec9190610590565b60405160208183030381529060405280519060200120146102a05760405162461bcd60e51b815260206004820152605c60248201527f496e76616c69642066756e64732076616c756520706173736564206f7220706160448201527f7373656420756e697420646f65736e2774206d6174636820776974682062616c60648201527f616e636520756e69742c20616374696f6e2063616e63656c6c65642e00000000608482015260a4015b60405180910390fd5b6009544210156102fe5760405162461bcd60e51b8152602060048201526024808201527f43616e6e6f74206164642066756e647320746f206578706972656420636f6e746044820152631c9858dd60e21b6064820152608401610297565b47610309838261065f565b50505050565b6004805461031c906106b1565b80601f0160208091040260200160405190810160405280929190818152602001828054610348906106b1565b80156103955780601f1061036a57610100808354040283529160200191610395565b820191906000526020600020905b81548152906001019060200180831161037857829003601f168201915b505050505081565b6000805461031c906106b1565b6003805461031c906106b1565b6002805461031c906106b1565b336001600160a01b03821681148015906103de5750478311155b6104475760405162461bcd60e51b815260206004820152603460248201527f5468652073656e64657220616e64207265636569766572206164647265737365604482015273732063616e6e6f74206265207468652073616d6560601b6064820152608401610297565b6040516001600160a01b0383169084156108fc029085906000818181858888f19350505050158015610309573d6000803e3d6000fd5b6000806040838503121561049057600080fd5b8235915060208301356001600160a01b03811681146104ae57600080fd5b809150509250929050565b600080604083850312156104cc57600080fd5b82359150602083013567ffffffffffffffff808211156104eb57600080fd5b818501915085601f8301126104ff57600080fd5b813581811115610511576105116106ec565b604051601f8201601f19908116603f01168101908382118183101715610539576105396106ec565b8160405282815288602084870101111561055257600080fd5b8260208601602083013760006020848301015280955050505050509250929050565b60008251610586818460208701610685565b9190910192915050565b600080835481600182811c9150808316806105ac57607f831692505b60208084108214156105cc57634e487b7160e01b86526022600452602486fd5b8180156105e057600181146105f15761061e565b60ff1986168952848901965061061e565b60008a81526020902060005b868110156106165781548b8201529085019083016105fd565b505084890196505b509498975050505050505050565b602081526000825180602084015261064b816040850160208701610685565b601f01601f19169190910160400192915050565b6000821982111561068057634e487b7160e01b600052601160045260246000fd5b500190565b60005b838110156106a0578181015183820152602001610688565b838111156103095750506000910152565b600181811c908216806106c557607f821691505b602082108114156106e657634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052604160045260246000fdfea264697066735822122081dca3f5ebe5d03d30279f504cfa572cc151ebb4c78a9a268562f606e17c45b864736f6c63430008060033";

    public static final String FUNC_ADDFUNDS = "addFunds";

    public static final String FUNC_EMPLOYEEEMAIL = "employeeEmail";

    public static final String FUNC_EMPLOYEENAME = "employeeName";

    public static final String FUNC_EMPLOYEESALARY = "employeeSalary";

    public static final String FUNC_EMPLOYEESUR = "employeeSur";

    public static final String FUNC_GETBALANCE = "getBalance";

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
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(RECEIVED_EVENT, transactionReceipt);
        ArrayList<ReceivedEventResponse> responses = new ArrayList<ReceivedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
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
                EventValuesWithLog eventValues = extractEventParametersWithLog(RECEIVED_EVENT, log);
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
                Arrays.<Type>asList(new Uint256(newFunds),
                new Utf8String(fundsUnit)),
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

    public RemoteFunctionCall<TransactionReceipt> transferFunds(BigInteger amount, String toWallet) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFUNDS,
                Arrays.<Type>asList(new Uint256(amount),
                new Address(160, toWallet)),
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

    public static RemoteCall<EmploymentContract_sol_EmploymentContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _cid, String _name, String _email, String _surname, String _country, String _salaryTerm, String _balanceUnit, BigInteger _expiryTimestamp) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_cid),
                new Utf8String(_name),
                new Utf8String(_email),
                new Utf8String(_surname),
                new Utf8String(_country),
                new Utf8String(_salaryTerm),
                new Utf8String(_balanceUnit),
                new Uint256(_expiryTimestamp)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<EmploymentContract_sol_EmploymentContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _cid, String _name, String _email, String _surname, String _country, String _salaryTerm, String _balanceUnit, BigInteger _expiryTimestamp) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_cid),
                new Utf8String(_name),
                new Utf8String(_email),
                new Utf8String(_surname),
                new Utf8String(_country),
                new Utf8String(_salaryTerm),
                new Utf8String(_balanceUnit),
                new Uint256(_expiryTimestamp)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<EmploymentContract_sol_EmploymentContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _cid, String _name, String _email, String _surname, String _country, String _salaryTerm, String _balanceUnit, BigInteger _expiryTimestamp) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_cid),
                new Utf8String(_name),
                new Utf8String(_email),
                new Utf8String(_surname),
                new Utf8String(_country),
                new Utf8String(_salaryTerm),
                new Utf8String(_balanceUnit),
                new Uint256(_expiryTimestamp)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<EmploymentContract_sol_EmploymentContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _cid, String _name, String _email, String _surname, String _country, String _salaryTerm, String _balanceUnit, BigInteger _expiryTimestamp) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_cid),
                new Utf8String(_name),
                new Utf8String(_email),
                new Utf8String(_surname),
                new Utf8String(_country),
                new Utf8String(_salaryTerm),
                new Utf8String(_balanceUnit),
                new Uint256(_expiryTimestamp)));
        return deployRemoteCall(EmploymentContract_sol_EmploymentContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ReceivedEventResponse extends BaseEventResponse {
        public String addr;

        public BigInteger amount;
    }
}
