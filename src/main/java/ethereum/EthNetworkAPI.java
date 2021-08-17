package ethereum;

import com.worknomads.worknomads.dos.ContractDO;
import com.worknomads.worknomads.dos.RetrievedContractDO;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;


public interface EthNetworkAPI {


    default Web3j getConnection() {
        return Web3j.build(new HttpService("http://localhost:8545"));
    }

    CompletableFuture<TransactionReceipt> createAndPublishContract(ContractDO contractContents, String cid);

    RetrievedContractDO getContractDetailsFromAddress(String contractAddress);

    void createWallet(String password, File location);

    String payContract(String contractAddress, BigInteger amount, String toWallet);

}
