package contracts.generated;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
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
public class PVContract extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506040516040806109d38339810180604052604081101561003057600080fd5b508051602090910151600180544360025563ffffffff191663ffffffff90931692909217600160201b600160601b03191690915560035561095d806100766000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80638bb545cb1161005b5780638bb545cb14610138578063a5d1658d14610182578063ab7d6aa2146101ab578063e1c7392a146101d757610088565b806309e69ede1461008d5780631bd4f4c3146100c7578063477e9a96146100f257806384f5e6bc14610115575b600080fd5b6100b3600480360360208110156100a357600080fd5b50356001600160a01b03166101df565b604080519115158252519081900360200190f35b6100f0600480360360608110156100dd57600080fd5b50803590602081013590604001356101f4565b005b6100f06004803603604081101561010857600080fd5b508035906020013561037e565b6100f06004803603604081101561012b57600080fd5b50803590602001356104bd565b6101646004803603604081101561014e57600080fd5b506001600160a01b0381351690602001356105de565b60408051938452602084019290925282820152519081900360600190f35b6100f06004803603606081101561019857600080fd5b508035906020810135906040013561061d565b610164600480360360408110156101c157600080fd5b506001600160a01b038135169060200135610786565b6100f061079f565b60006020819052908152604090205460ff1681565b3360009081526020819052604090205460ff16151560011461024e5760408051600160e51b62461bcd02815260206004820152601960248201526000805160206108f2833981519152604482015290519081900360640190fd5b436003546002540110156102a25760408051600160e51b62461bcd0281526020600482015260106024820152600160811b6f21b0b6361034b9903a37903630ba329702604482015290519081900360640190fd5b600154640100000000900463ffffffff166003146102f85760408051600160e51b62461bcd0281526020600482015260166024820152600080516020610912833981519152604482015290519081900360640190fd5b33600090815260056020526040902080548491908390811061031657fe5b9060005260206000209060030201600101819055508160056000336001600160a01b03166001600160a01b03168152602001908152602001600020828154811061035c57fe5b90600052602060002090600302016002018190555061037961086b565b505050565b3360009081526020819052604090205460ff1615156001146103d85760408051600160e51b62461bcd02815260206004820152601960248201526000805160206108f2833981519152604482015290519081900360640190fd5b4360035460025401101561042c5760408051600160e51b62461bcd0281526020600482015260106024820152600160811b6f21b0b6361034b9903a37903630ba329702604482015290519081900360640190fd5b600154640100000000900463ffffffff166002146104825760408051600160e51b62461bcd0281526020600482015260166024820152600080516020610912833981519152604482015290519081900360640190fd5b3360009081526004602052604090208054839190839081106104a057fe5b60009182526020909120600390910201556104b961086b565b5050565b3360009081526020819052604090205460ff1615156001146105175760408051600160e51b62461bcd02815260206004820152601960248201526000805160206108f2833981519152604482015290519081900360640190fd5b4360035460025401101561056b5760408051600160e51b62461bcd0281526020600482015260106024820152600160811b6f21b0b6361034b9903a37903630ba329702604482015290519081900360640190fd5b60018054640100000000900463ffffffff16146105c05760408051600160e51b62461bcd0281526020600482015260166024820152600080516020610912833981519152604482015290519081900360640190fd5b3360009081526005602052604090208054839190839081106104a057fe5b600560205281600052604060002081815481106105f757fe5b600091825260209091206003909102018054600182015460029092015490935090915083565b3360009081526020819052604090205460ff1615156001146106775760408051600160e51b62461bcd02815260206004820152601960248201526000805160206108f2833981519152604482015290519081900360640190fd5b436003546002540110156106cb5760408051600160e51b62461bcd0281526020600482015260106024820152600160811b6f21b0b6361034b9903a37903630ba329702604482015290519081900360640190fd5b60015463ffffffff640100000000909104166004146107225760408051600160e51b62461bcd0281526020600482015260166024820152600080516020610912833981519152604482015290519081900360640190fd5b33600090815260046020526040902080548491908390811061074057fe5b9060005260206000209060030201600101819055508160046000336001600160a01b03166001600160a01b03168152602001908152602001600020828154811061035c57fe5b600460205281600052604060002081815481106105f757fe5b436003546002540110156107f35760408051600160e51b62461bcd0281526020600482015260106024820152600160811b6f21b0b6361034b9903a37903630ba329702604482015290519081900360640190fd5b600154640100000000900463ffffffff16156108475760408051600160e51b62461bcd0281526020600482015260166024820152600080516020610912833981519152604482015290519081900360640190fd5b336000908152602081905260409020805460ff1916600117905561086961086b565b565b6001805463ffffffff6801000000000000000080830482168401821681026bffffffff00000000000000001990931692909217928390558281169190920490911610610869576001805467ffffffff000000001981166401000000009182900463ffffffff908116840116909102176bffffffff0000000000000000191690554360025556fe43616c6c6572206973206e6f74207061727469636970616e74000000000000004e6f7420696e2074686520726967687420706861736500000000000000000000a165627a7a72305820ad14ca8855c3655d85aa072966c73e2c2c559777abb47daa14ed9d00d8f57dc90029";

    public static final String FUNC_PARTICIPANTS = "participants";

    public static final String FUNC_OPENCHALLENGE = "openChallenge";

    public static final String FUNC_COMMITSEED = "commitSeed";

    public static final String FUNC_COMMITCHALLENGE = "commitChallenge";

    public static final String FUNC_CHALLENGECOMMITMENTS = "challengeCommitments";

    public static final String FUNC_OPENSEED = "openSeed";

    public static final String FUNC_SEEDCOMMITMENTS = "seedCommitments";

    public static final String FUNC_INIT = "init";

    @Deprecated
    protected PVContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PVContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PVContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PVContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Boolean> participants(String param0) {
        final Function function = new Function(FUNC_PARTICIPANTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> openChallenge(byte[] open, byte[] secret, BigInteger session) {
        final Function function = new Function(
                FUNC_OPENCHALLENGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(open), 
                new org.web3j.abi.datatypes.generated.Bytes32(secret), 
                new org.web3j.abi.datatypes.generated.Uint256(session)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> commitSeed(byte[] commit, BigInteger session) {
        final Function function = new Function(
                FUNC_COMMITSEED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(commit), 
                new org.web3j.abi.datatypes.generated.Uint256(session)), 
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

    public RemoteFunctionCall<TransactionReceipt> openSeed(byte[] open, byte[] secret, BigInteger session) {
        final Function function = new Function(
                FUNC_OPENSEED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(open), 
                new org.web3j.abi.datatypes.generated.Bytes32(secret), 
                new org.web3j.abi.datatypes.generated.Uint256(session)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteFunctionCall<TransactionReceipt> init() {
        final Function function = new Function(
                FUNC_INIT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static PVContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PVContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PVContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PVContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PVContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PVContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PVContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PVContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PVContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger numberOfParticipants, BigInteger timeOffset) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(numberOfParticipants), 
                new org.web3j.abi.datatypes.generated.Uint256(timeOffset)));
        return deployRemoteCall(PVContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<PVContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger numberOfParticipants, BigInteger timeOffset) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(numberOfParticipants), 
                new org.web3j.abi.datatypes.generated.Uint256(timeOffset)));
        return deployRemoteCall(PVContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PVContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger numberOfParticipants, BigInteger timeOffset) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(numberOfParticipants), 
                new org.web3j.abi.datatypes.generated.Uint256(timeOffset)));
        return deployRemoteCall(PVContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PVContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger numberOfParticipants, BigInteger timeOffset) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(numberOfParticipants), 
                new org.web3j.abi.datatypes.generated.Uint256(timeOffset)));
        return deployRemoteCall(PVContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
