package ethereum;

import com.worknomads.worknomads.dos.ContractDO;
import com.worknomads.worknomads.dos.RetrievedContractDO;
import org.springframework.beans.factory.annotation.Value;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;


public interface EthNetworkAPI {

    @Value("${eth.network.url}")
    String ethServiceUrl = "http://localhost:8545";


    default Web3j getConnection() {
        return Web3j.build(new HttpService(ethServiceUrl));
    }

    CompletableFuture<TransactionReceipt> createAndPublishContract(ContractDO contractContents, String cid);

    RetrievedContractDO getContractDetailsFromAddress(String contractAddress);

    void createWallet(String password, File location);

    String payContract(String contractAddress, BigInteger amount, String toWallet);

}
