package com.worknomads.worknomads.ethereum.wrappers;

import com.worknomads.worknomads.ethereum.constants.EnvironmentConstants;
import com.worknomads.worknomads.ethereum.utils.ContractTransactionUtils;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
import org.web3j.protocol.exceptions.TransactionException;
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
    public static final String BINARY = "60806040819052600680546001600160a01b03191673816f37f9d8088b7ec15808b5c0811b217849614d17905562000d7c388190039081908339810160408190526200004b9162000342565b8751620000609060009060208b0190620001e5565b50855162000076906003906020890190620001e5565b5084516200008c906005906020880190620001e5565b508351620000a2906004906020870190620001e5565b508251620000b8906007906020860190620001e5565b5060088290558651620000d39060029060208a0190620001e5565b506001819055620000e3620000f1565b5050505050505050620004b0565b6201518060096040516200011090644461696c7960d81b815260050190565b9081526040805191829003602001822092909255655765656b6c7960d01b8152600960068083018290528351928390036026908101842062093a809055664d6f6e74686c7960c81b84526007840183905284519384900360270184206224ea0090556733204d6f6e74687360c01b8452600880850184905285519485900360289081018620626ebe0090556736204d6f6e74687360c01b865290850184905285519485900301842062dd7c00905565596561726c7960d01b84529083019190915291519081900390910190206301e133809055565b828054620001f3906200045d565b90600052602060002090601f01602090048101928262000217576000855562000262565b82601f106200023257805160ff191683800117855562000262565b8280016001018555821562000262579182015b828111156200026257825182559160200191906001019062000245565b506200027092915062000274565b5090565b5b8082111562000270576000815560010162000275565b600082601f8301126200029d57600080fd5b81516001600160401b0380821115620002ba57620002ba6200049a565b604051601f8301601f19908116603f01168101908282118183101715620002e557620002e56200049a565b816040528381526020925086838588010111156200030257600080fd5b600091505b8382101562000326578582018301518183018401529082019062000307565b83821115620003385760008385830101525b9695505050505050565b600080600080600080600080610100898b0312156200036057600080fd5b88516001600160401b03808211156200037857600080fd5b620003868c838d016200028b565b995060208b01519150808211156200039d57600080fd5b620003ab8c838d016200028b565b985060408b0151915080821115620003c257600080fd5b620003d08c838d016200028b565b975060608b0151915080821115620003e757600080fd5b620003f58c838d016200028b565b965060808b01519150808211156200040c57600080fd5b6200041a8c838d016200028b565b955060a08b01519150808211156200043157600080fd5b50620004408b828c016200028b565b60c08b015160e0909b0151999c989b509699959894979350505050565b600181811c908216806200047257607f821691505b602082108114156200049457634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052604160045260246000fd5b6108bc80620004c06000396000f3fe60806040526004361061009a5760003560e01c8063bb3d48c011610061578063bb3d48c01461016f578063bf64c0da14610184578063c29fe1a814610199578063cbf0b0c0146101af578063ee4766c6146101cf578063f08e362f146101e457005b806312065fe0146100db5780632db00354146100fd57806342948e18146101105780634fc298861461012b57806387b8d58e1461014d57005b366100d957604080513381523460208201527f88a5966d370b9919b20f3e2c13ff65706f196a4e32cc2c12bf57088f88525874910160405180910390a1005b005b3480156100e757600080fd5b50475b6040519081526020015b60405180910390f35b6100d961010b36600461063d565b6101f7565b34801561011c57600080fd5b506040513381526020016100f4565b34801561013757600080fd5b50600854421060405190151581526020016100f4565b34801561015957600080fd5b50610162610353565b6040516100f491906107b0565b34801561017b57600080fd5b506101626103e1565b34801561019057600080fd5b506101626103ee565b3480156101a557600080fd5b506100ea60015481565b3480156101bb57600080fd5b506100d96101ca3660046105ef565b6103fb565b3480156101db57600080fd5b50610162610495565b6100d96101f2366004610611565b6104a2565b8060405160200161020891906106f8565b6040516020818303038152906040528051906020012060076040516020016102309190610714565b60405160208183030381529060405280519060200120146102e45760405162461bcd60e51b815260206004820152605c60248201527f496e76616c69642066756e64732076616c756520706173736564206f7220706160448201527f7373656420756e697420646f65736e2774206d6174636820776974682062616c60648201527f616e636520756e69742c20616374696f6e2063616e63656c6c65642e00000000608482015260a4015b60405180910390fd5b6008544210156103425760405162461bcd60e51b8152602060048201526024808201527f43616e6e6f74206164642066756e647320746f206578706972656420636f6e746044820152631c9858dd60e21b60648201526084016102db565b4761034d83826107e3565b50505050565b6004805461036090610835565b80601f016020809104026020016040519081016040528092919081815260200182805461038c90610835565b80156103d95780601f106103ae576101008083540402835291602001916103d9565b820191906000526020600020905b8154815290600101906020018083116103bc57829003601f168201915b505050505081565b6000805461036090610835565b6003805461036090610835565b6006546001600160a01b031633146104895760405162461bcd60e51b8152602060048201526044602482018190527f5468652073656e646572206f66206b696c6c696e672074686520636f6e747261908201527f63742c206e6565647320746f20626520612076616c6964207369676e2077616c6064820152633632ba1760e11b608482015260a4016102db565b806001600160a01b0316ff5b6002805461036090610835565b306001600160a01b0382168114156105195760405162461bcd60e51b815260206004820152603460248201527f5468652073656e64657220616e64207265636569766572206164647265737365604482015273732063616e6e6f74206265207468652073616d6560601b60648201526084016102db565b4783111561059d5760405162461bcd60e51b815260206004820152604560248201527f496e73756666696369656e742062616c616e63652c2072656d61696e696e672060448201527f62616c616e6365206973206c657373207468616e2074686520616d6f756e742060648201526433b4bb32b760d91b608482015260a4016102db565b6040516001600160a01b0383169084156108fc029085906000818181858888f1935050505015801561034d573d6000803e3d6000fd5b80356001600160a01b03811681146105ea57600080fd5b919050565b60006020828403121561060157600080fd5b61060a826105d3565b9392505050565b6000806040838503121561062457600080fd5b82359150610634602084016105d3565b90509250929050565b6000806040838503121561065057600080fd5b82359150602083013567ffffffffffffffff8082111561066f57600080fd5b818501915085601f83011261068357600080fd5b81358181111561069557610695610870565b604051601f8201601f19908116603f011681019083821181831017156106bd576106bd610870565b816040528281528860208487010111156106d657600080fd5b8260208601602083013760006020848301015280955050505050509250929050565b6000825161070a818460208701610809565b9190910192915050565b600080835481600182811c91508083168061073057607f831692505b602080841082141561075057634e487b7160e01b86526022600452602486fd5b8180156107645760018114610775576107a2565b60ff198616895284890196506107a2565b60008a81526020902060005b8681101561079a5781548b820152908501908301610781565b505084890196505b509498975050505050505050565b60208152600082518060208401526107cf816040850160208701610809565b601f01601f19169190910160400192915050565b6000821982111561080457634e487b7160e01b600052601160045260246000fd5b500190565b60005b8381101561082457818101518382015260200161080c565b8381111561034d5750506000910152565b600181811c9082168061084957607f821691505b6020821081141561086a57634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052604160045260246000fdfea2646970667358221220ef09f415e848e419e704e8a6c81fcc5baeeadad1ac520d7743c0ecc5e11f155864736f6c63430008060033";
    public static final int RINKEBY_CHAIN_ID = 4;
    public static final int GANACHE_CHAIN_ID = 1337;
    public static final String FUNC_ADDFUNDS = "addFunds";

    public static final String FUNC_EMPLOYEEEMAIL = "employeeEmail";

    public static final String FUNC_EMPLOYEENAME = "employeeName";

    public static final String FUNC_EMPLOYEESALARY = "employeeSalary";

    public static final String FUNC_EMPLOYEESUR = "employeeSur";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_GETSENDERADDRESS = "getSenderAddress";

    public static final String FUNC_ISACTIVECONTRACT = "isActiveContract";

    public static final String FUNC_KILL = "kill";

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

    public RemoteFunctionCall<TransactionReceipt> kill(String to) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_KILL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> paymentTerm() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_PAYMENTTERM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public CompletableFuture<EthSendTransaction> transferFunds(BigInteger amount, String toWallet) throws TransactionException {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_TRANSFERFUNDS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount),
                        new org.web3j.abi.datatypes.Address(160, toWallet)),
                Collections.<TypeReference<?>>emptyList());

        String encodedFunction = FunctionEncoder.encode(function);

        //TODO remove these and add separate transaction wallets for each company
        var credentials = ContractTransactionUtils.createCredentialsFromPassword(EnvironmentConstants.walletPrivate);
        BigInteger nonce = ContractTransactionUtils.getNonceForAccount(web3j, EnvironmentConstants.signWalletGanache);
        String signedMessage = ContractTransactionUtils.signMessage(
                nonce, encodedFunction, contractAddress, GANACHE_CHAIN_ID, credentials, FUNC_TRANSFERFUNDS
        );
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
