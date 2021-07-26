package ethereum;

import com.worknomads.worknomads.dos.ContractDO;
import com.worknomads.worknomads.dos.ContractDOs;
import com.worknomads.worknomads.dos.RetrievedContractDO;
import com.worknomads.worknomads.dtos.RetrievedContractDTO;
import ethereum.wrappers.EmploymentContract_sol_EmploymentContract;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.util.concurrent.CompletableFuture;


public interface EthNetworkAPI {


    default Web3j getConnection() {
        return Web3j.build(new HttpService("http://localhost:8545"));
    }

    CompletableFuture<TransactionReceipt> createAndPublishContract(ContractDO contractContents, String cid);

    CompletableFuture<RetrievedContractDO> getContractDetailsFromAddress(String contractAddress);

    void createWallet(String password, File location);

}
