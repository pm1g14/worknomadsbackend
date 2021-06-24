package ethereum;

import com.worknomads.worknomads.dtos.ContractDTO;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public interface EthNetworkAPI {

    default Web3j getConnection() {
        return Web3j.build(new HttpService("http://localhost:8545"));
    }
}
