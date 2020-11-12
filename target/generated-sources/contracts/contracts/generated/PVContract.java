package contracts.generated;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint32;
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
    public static final String BINARY = "608060405234801561001057600080fd5b50604051606080610d7f8339810180604052606081101561003057600080fd5b5080516020820151604090920151600280544360055563ffffffff191663ffffffff8085169190911767ffffffff0000000019811690925516600381905560006004556006829055600784905591929161008b600182610094565b505050506100de565b8154818355818111156100b8576000838152602090206100b89181019083016100bd565b505050565b6100db91905b808211156100d757600081556001016100c3565b5090565b90565b610c92806100ed6000396000f3fe608060405234801561001057600080fd5b506004361061009e5760003560e01c80639a7a49d8116100665780639a7a49d814610179578063ab7d6aa214610222578063b61f34b6146102d4578063da64730a146102fa578063e1c7392a146103a05761009e565b806309e69ede146100a357806324f72efe146100dd5780632e52d60614610116578063477e9a96146101375780637a1a34461461015c575b600080fd5b6100c9600480360360208110156100b957600080fd5b50356001600160a01b03166103a8565b604080519115158252519081900360200190f35b6100fa600480360360208110156100f357600080fd5b50356103bd565b604080516001600160a01b039092168252519081900360200190f35b61011e6103e4565b6040805163ffffffff9092168252519081900360200190f35b61015a6004803603604081101561014d57600080fd5b50803590602001356103f0565b005b61015a6004803603602081101561017257600080fd5b503561051f565b61015a6004803603606081101561018f57600080fd5b810190602081018135600160201b8111156101a957600080fd5b8201836020820111156101bb57600080fd5b803590602001918460018302840111600160201b831117156101dc57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505082359350505060200135610640565b61024e6004803603604081101561023857600080fd5b506001600160a01b03813516906020013561078a565b6040518084815260200180602001838152602001828103825284818151815260200191508051906020019080838360005b8381101561029757818101518382015260200161027f565b50505050905090810190601f1680156102c45780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b61024e600480360360208110156102ea57600080fd5b50356001600160a01b031661083e565b61015a6004803603604081101561031057600080fd5b810190602081018135600160201b81111561032a57600080fd5b82018360208201111561033c57600080fd5b803590602001918460018302840111600160201b8311171561035d57600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955050913592506108b0915050565b61015a6109ef565b60006020819052908152604090205460ff1681565b600181815481106103ca57fe5b6000918252602090912001546001600160a01b0316905081565b60025463ffffffff1681565b3360009081526020819052604090205460ff16151560011461044a5760408051600160e51b62461bcd0281526020600482015260196024820152600080516020610c27833981519152604482015290519081900360640190fd5b4360065460055401101561049e5760408051600160e51b62461bcd0281526020600482015260106024820152600160811b6f21b0b6361034b9903a37903630ba329702604482015290519081900360640190fd5b60028054600160201b900463ffffffff16146104f25760408051600160e51b62461bcd0281526020600482015260166024820152600080516020610c47833981519152604482015290519081900360640190fd5b33600090815260086020908152604080832084845291829052909120838155610519610af8565b50505050565b3360009081526020819052604090205460ff1615156001146105795760408051600160e51b62461bcd0281526020600482015260196024820152600080516020610c27833981519152604482015290519081900360640190fd5b436006546005540110156105cd5760408051600160e51b62461bcd0281526020600482015260106024820152600160811b6f21b0b6361034b9903a37903630ba329702604482015290519081900360640190fd5b600254600160201b900463ffffffff166001146106225760408051600160e51b62461bcd0281526020600482015260166024820152600080516020610c47833981519152604482015290519081900360640190fd5b33600090815260096020526040902081815561063c610af8565b5050565b3360009081526020819052604090205460ff16151560011461069a5760408051600160e51b62461bcd0281526020600482015260196024820152600080516020610c27833981519152604482015290519081900360640190fd5b436006546005540110156106ee5760408051600160e51b62461bcd0281526020600482015260106024820152600160811b6f21b0b6361034b9903a37903630ba329702604482015290519081900360640190fd5b60025463ffffffff600160201b909104166004146107445760408051600160e51b62461bcd0281526020600482015260166024820152600080516020610c47833981519152604482015290519081900360640190fd5b336000908152600860209081526040808320848452808352922085519091610773916001840191880190610b8b565b5060028101849055610783610af8565b5050505050565b60086020908152600092835260408084208252918352918190208054600180830180548551600293821615610100026000190190911692909204601f810187900487028301870190955284825291949293909283018282801561082e5780601f106108035761010080835404028352916020019161082e565b820191906000526020600020905b81548152906001019060200180831161081157829003601f168201915b5050505050908060020154905083565b6009602090815260009182526040918290208054600180830180548651600293821615610100026000190190911692909204601f81018690048602830186019096528582529194929390929083018282801561082e5780601f106108035761010080835404028352916020019161082e565b3360009081526020819052604090205460ff16151560011461090a5760408051600160e51b62461bcd0281526020600482015260196024820152600080516020610c27833981519152604482015290519081900360640190fd5b4360065460055401101561095e5760408051600160e51b62461bcd0281526020600482015260106024820152600160811b6f21b0b6361034b9903a37903630ba329702604482015290519081900360640190fd5b600254600160201b900463ffffffff166003146109b35760408051600160e51b62461bcd0281526020600482015260166024820152600080516020610c47833981519152604482015290519081900360640190fd5b336000908152600960209081526040909120835190916109da916001840191860190610b8b565b50600281018290556109ea610af8565b505050565b43600654600554011015610a435760408051600160e51b62461bcd0281526020600482015260106024820152600160811b6f21b0b6361034b9903a37903630ba329702604482015290519081900360640190fd5b600254600160201b900463ffffffff1615610a965760408051600160e51b62461bcd0281526020600482015260166024820152600080516020610c47833981519152604482015290519081900360640190fd5b336000818152602081905260409020805460ff1916600190811790915560045481548110610ac057fe5b9060005260206000200160006101000a8154816001600160a01b0302191690836001600160a01b03160217905550610af6610af8565b565b600480546001019081905560035411610af65760028054600163ffffffff600160201b8084048216929092018116820267ffffffff00000000199093169290921780845560006004554360055504161480610b63575060025463ffffffff600160201b909104166004145b15610b7d5760075460025463ffffffff1602600355610af6565b60025463ffffffff16600355565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610bcc57805160ff1916838001178555610bf9565b82800160010185558215610bf9579182015b82811115610bf9578251825591602001919060010190610bde565b50610c05929150610c09565b5090565b610c2391905b80821115610c055760008155600101610c0f565b9056fe43616c6c6572206973206e6f74207061727469636970616e74000000000000004e6f7420696e2074686520726967687420706861736500000000000000000000a165627a7a723058209d02550e42b06322c64e04489832d82090139d810735af896e8627c793e3d6f10029";

    public static final String FUNC_PARTICIPANTS = "participants";

    public static final String FUNC_ADRESSES = "adresses";

    public static final String FUNC_N = "n";

    public static final String FUNC_COMMITSEED = "commitSeed";

    public static final String FUNC_COMMITCHALLENGE = "commitChallenge";

    public static final String FUNC_OPENSEED = "openSeed";

    public static final String FUNC_SEEDCOMMITMENTS = "seedCommitments";

    public static final String FUNC_CHALLENGECOMMITMENTS = "challengeCommitments";

    public static final String FUNC_OPENCHALLENGE = "openChallenge";

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

    public RemoteFunctionCall<String> adresses(BigInteger param0) {
        final Function function = new Function(FUNC_ADRESSES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> n() {
        final Function function = new Function(FUNC_N, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> commitSeed(byte[] commit, BigInteger session) {
        final Function function = new Function(
                FUNC_COMMITSEED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(commit), 
                new org.web3j.abi.datatypes.generated.Uint256(session)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> commitChallenge(byte[] commit) {
        final Function function = new Function(
                FUNC_COMMITCHALLENGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(commit)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> openSeed(String open, byte[] secret, BigInteger session) {
        final Function function = new Function(
                FUNC_OPENSEED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(open), 
                new org.web3j.abi.datatypes.generated.Bytes32(secret), 
                new org.web3j.abi.datatypes.generated.Uint256(session)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<byte[], String, byte[]>> seedCommitments(String param0, BigInteger param1) {
        final Function function = new Function(FUNC_SEEDCOMMITMENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteFunctionCall<Tuple3<byte[], String, byte[]>>(function,
                new Callable<Tuple3<byte[], String, byte[]>>() {
                    @Override
                    public Tuple3<byte[], String, byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<byte[], String, byte[]>(
                                (byte[]) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (byte[]) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple3<byte[], String, byte[]>> challengeCommitments(String param0) {
        final Function function = new Function(FUNC_CHALLENGECOMMITMENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Bytes32>() {}));
        return new RemoteFunctionCall<Tuple3<byte[], String, byte[]>>(function,
                new Callable<Tuple3<byte[], String, byte[]>>() {
                    @Override
                    public Tuple3<byte[], String, byte[]> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<byte[], String, byte[]>(
                                (byte[]) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (byte[]) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> openChallenge(String open, byte[] secret) {
        final Function function = new Function(
                FUNC_OPENCHALLENGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(open), 
                new org.web3j.abi.datatypes.generated.Bytes32(secret)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public static RemoteCall<PVContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger numberOfParticipants, BigInteger sessions, BigInteger timeOffset) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(numberOfParticipants), 
                new org.web3j.abi.datatypes.generated.Uint256(sessions), 
                new org.web3j.abi.datatypes.generated.Uint256(timeOffset)));
        return deployRemoteCall(PVContract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<PVContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger numberOfParticipants, BigInteger sessions, BigInteger timeOffset) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(numberOfParticipants), 
                new org.web3j.abi.datatypes.generated.Uint256(sessions), 
                new org.web3j.abi.datatypes.generated.Uint256(timeOffset)));
        return deployRemoteCall(PVContract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PVContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger numberOfParticipants, BigInteger sessions, BigInteger timeOffset) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(numberOfParticipants), 
                new org.web3j.abi.datatypes.generated.Uint256(sessions), 
                new org.web3j.abi.datatypes.generated.Uint256(timeOffset)));
        return deployRemoteCall(PVContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<PVContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger numberOfParticipants, BigInteger sessions, BigInteger timeOffset) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint32(numberOfParticipants), 
                new org.web3j.abi.datatypes.generated.Uint256(sessions), 
                new org.web3j.abi.datatypes.generated.Uint256(timeOffset)));
        return deployRemoteCall(PVContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
