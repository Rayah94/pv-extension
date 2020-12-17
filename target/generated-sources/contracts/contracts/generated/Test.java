package contracts.generated;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
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
 * <p>Generated with web3j version 4.5.11.
 */
@SuppressWarnings("rawtypes")
public class Test extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506102a5806100206000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c806309bd5a601461006757806323fc7ef3146100815780636c27149f1461012957806384f5e6bc146101465780638bb545cb14610169578063ab7d6aa2146101b3575b600080fd5b61006f6101df565b60408051918252519081900360200190f35b6101276004803603602081101561009757600080fd5b8101906020810181356401000000008111156100b257600080fd5b8201836020820111156100c457600080fd5b803590602001918460018302840111640100000000831117156100e657600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506101e5945050505050565b005b6101276004803603602081101561013f57600080fd5b50356101f2565b6101276004803603604081101561015c57600080fd5b50803590602001356101f7565b6101956004803603604081101561017f57600080fd5b506001600160a01b038135169060200135610211565b60408051938452602084019290925282820152519081900360600190f35b610195600480360360408110156101c957600080fd5b506001600160a01b038135169060200135610250565b60035481565b8051602090910120600355565b600155565b336000908152602081815260408083209383529290522055565b6002602052816000526040600020818154811061022a57fe5b600091825260209091206003909102018054600182015460029092015490935090915083565b60006020818152928152604080822090935290815220805460018201546002909201549091908356fea165627a7a7230582096afc7657dcdd723516e810fe97f9592291bd8b87e9a0a4454fcddd4a486f6d60029";

    public static final String FUNC_HASH = "hash";

    public static final String FUNC_KECCAK = "keccak";

    public static final String FUNC_TESTINT = "testInt";

    public static final String FUNC_COMMITCHALLENGE = "commitChallenge";

    public static final String FUNC_CHALLENGECOMMITMENTS = "challengeCommitments";

    public static final String FUNC_SEEDCOMMITMENTS = "seedCommitments";

    @Deprecated
    protected Test(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Test(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Test(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Test(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<byte[]> hash() {
        final Function function = new Function(FUNC_HASH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> keccak(byte[] value) {
        final Function function = new Function(
                FUNC_KECCAK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> testInt(BigInteger session) {
        final Function function = new Function(
                FUNC_TESTINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(session)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> commitChallenge(byte[] commit, BigInteger session) {
        final Function function = new Function(
                FUNC_COMMITCHALLENGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(commit), 
                new org.web3j.abi.datatypes.generated.Uint256(session)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<byte[], byte[], byte[]>> challengeCommitments(String param0, BigInteger param1) {
        final Function function = new Function(FUNC_CHALLENGECOMMITMENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteFunctionCall<Tuple3<byte[], byte[], byte[]>>(function,
                new Callable<Tuple3<byte[], byte[], byte[]>>() {
                    @Override
                    public Tuple3<byte[], byte[], byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<byte[], byte[], byte[]>(
                                (byte[]) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue(), 
                                (byte[]) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple3<byte[], byte[], byte[]>> seedCommitments(String param0, BigInteger param1) {
        final Function function = new Function(FUNC_SEEDCOMMITMENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteFunctionCall<Tuple3<byte[], byte[], byte[]>>(function,
                new Callable<Tuple3<byte[], byte[], byte[]>>() {
                    @Override
                    public Tuple3<byte[], byte[], byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<byte[], byte[], byte[]>(
                                (byte[]) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue(), 
                                (byte[]) results.get(2).getValue());
                    }
                });
    }

    @Deprecated
    public static Test load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Test(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Test load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Test(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Test load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Test(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Test load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Test(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Test> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Test.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Test> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Test.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Test> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Test.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Test> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Test.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
