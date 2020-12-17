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
    public static final String BINARY = "60806040523480156200001157600080fd5b5060405160608062000dec8339810180604052620000339190810190620000fc565b600280544360055563ffffffff191663ffffffff8581169190911767ffffffff000000001981169092551660038190556000600455600682905560078390556200007f60018262000089565b5050505062000159565b815481835581811115620000b057600083815260209020620000b0918101908301620000b5565b505050565b620000d691905b80821115620000d25760008155600101620000bc565b5090565b90565b6000620000e78251620000d6565b9392505050565b6000620000e7825162000150565b6000806000606084860312156200011257600080fd5b6000620001208686620000ee565b93505060206200013386828701620000d9565b92505060406200014686828701620000d9565b9150509250925092565b63ffffffff1690565b610c8380620001696000396000f3fe608060405234801561001057600080fd5b50600436106100a95760003560e01c80639a7a49d8116100715780639a7a49d814610134578063ab7d6aa214610147578063b1c9fe6e14610169578063b61f34b614610171578063da64730a14610184578063e1c7392a14610197576100a9565b806309e69ede146100ae57806324f72efe146100d75780632e52d606146100f7578063477e9a961461010c5780637a1a344614610121575b600080fd5b6100c16100bc3660046108b3565b61019f565b6040516100ce9190610b0b565b60405180910390f35b6100ea6100e5366004610913565b6101b4565b6040516100ce9190610af7565b6100ff6101db565b6040516100ce9190610b78565b61011f61011a366004610931565b6101e7565b005b61011f61012f366004610913565b6102ae565b61011f610142366004610986565b61035e565b61015a6101553660046108d9565b610437565b6040516100ce93929190610b19565b6100ff6104eb565b61015a61017f3660046108b3565b6104fe565b61011f610192366004610950565b610570565b61011f61063e565b60006020819052908152604090205460ff1681565b600181815481106101c157fe5b6000918252602090912001546001600160a01b0316905081565b60025463ffffffff1681565b3360009081526020819052604090205460ff16151560011461022757604051600160e51b62461bcd02815260040161021e90610b48565b60405180910390fd5b4360065460055401101561025057604051600160e51b62461bcd02815260040161021e90610b68565b60028054600160201b900463ffffffff161461028157604051600160e51b62461bcd02815260040161021e90610b58565b336000908152600860209081526040808320848452918290529091208381556102a86106f9565b50505050565b3360009081526020819052604090205460ff1615156001146102e557604051600160e51b62461bcd02815260040161021e90610b48565b4360065460055401101561030e57604051600160e51b62461bcd02815260040161021e90610b68565b600254600160201b900463ffffffff1660011461034057604051600160e51b62461bcd02815260040161021e90610b58565b33600090815260096020526040902081815561035a6106f9565b5050565b3360009081526020819052604090205460ff16151560011461039557604051600160e51b62461bcd02815260040161021e90610b48565b436006546005540110156103be57604051600160e51b62461bcd02815260040161021e90610b68565b60025463ffffffff600160201b909104166004146103f157604051600160e51b62461bcd02815260040161021e90610b58565b3360009081526008602090815260408083208484528083529220855190916104209160018401918801906107a5565b50600281018490556104306106f9565b5050505050565b60086020908152600092835260408084208252918352918190208054600180830180548551600293821615610100026000190190911692909204601f81018790048702830187019095528482529194929390928301828280156104db5780601f106104b0576101008083540402835291602001916104db565b820191906000526020600020905b8154815290600101906020018083116104be57829003601f168201915b5050505050908060020154905083565b600254600160201b900463ffffffff1681565b6009602090815260009182526040918290208054600180830180548651600293821615610100026000190190911692909204601f8101869004860283018601909652858252919492939092908301828280156104db5780601f106104b0576101008083540402835291602001916104db565b3360009081526020819052604090205460ff1615156001146105a757604051600160e51b62461bcd02815260040161021e90610b48565b436006546005540110156105d057604051600160e51b62461bcd02815260040161021e90610b68565b600254600160201b900463ffffffff1660031461060257604051600160e51b62461bcd02815260040161021e90610b58565b336000908152600960209081526040909120835190916106299160018401918601906107a5565b50600281018290556106396106f9565b505050565b4360065460055401101561066757604051600160e51b62461bcd02815260040161021e90610b68565b600254600160201b900463ffffffff161561069757604051600160e51b62461bcd02815260040161021e90610b58565b336000818152602081905260409020805460ff19166001908117909155600454815481106106c157fe5b9060005260206000200160006101000a8154816001600160a01b0302191690836001600160a01b031602179055506106f76106f9565b565b6004805460010190819055600354116106f75760028054600163ffffffff600160201b8084048216929092018116820267ffffffff000000001990931692909217808455600060045543600555041614156107635760075460025463ffffffff16026003556106f7565b60025463ffffffff600160201b90910416600414156107975760075460025463ffffffff16600019909101026003556106f7565b60025463ffffffff16600355565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106107e657805160ff1916838001178555610813565b82800160010185558215610813579182015b828111156108135782518255916020019190600101906107f8565b5061081f929150610823565b5090565b61083d91905b8082111561081f5760008155600101610829565b90565b600061084c8235610be2565b9392505050565b600061084c823561083d565b600082601f83011261087057600080fd5b813561088361087e82610bad565b610b86565b9150808252602083016020830185838301111561089f57600080fd5b6108aa838284610c07565b50505092915050565b6000602082840312156108c557600080fd5b60006108d18484610840565b949350505050565b600080604083850312156108ec57600080fd5b60006108f88585610840565b925050602061090985828601610853565b9150509250929050565b60006020828403121561092557600080fd5b60006108d18484610853565b6000806040838503121561094457600080fd5b60006108f88585610853565b6000806040838503121561096357600080fd5b823567ffffffffffffffff81111561097a57600080fd5b6108f88582860161085f565b60008060006060848603121561099b57600080fd5b833567ffffffffffffffff8111156109b257600080fd5b6109be8682870161085f565b93505060206109cf86828701610853565b92505060406109e086828701610853565b9150509250925092565b6109f381610be2565b82525050565b6109f381610bed565b6109f38161083d565b6000610a1682610bd5565b610a208185610bd9565b9350610a30818560208601610c13565b610a3981610c3f565b9093019392505050565b6000610a50601983610bd9565b7f43616c6c6572206973206e6f74207061727469636970616e7400000000000000815260200192915050565b6000610a89601683610bd9565b7f4e6f7420696e2074686520726967687420706861736500000000000000000000815260200192915050565b6000610ac2601083610bd9565b7f43616c6c20697320746f206c6174652e00000000000000000000000000000000815260200192915050565b6109f381610bfe565b60208101610b0582846109ea565b92915050565b60208101610b0582846109f9565b60608101610b278286610a02565b8181036020830152610b398185610a0b565b90506108d16040830184610a02565b60208082528101610b0581610a43565b60208082528101610b0581610a7c565b60208082528101610b0581610ab5565b60208101610b058284610aee565b60405181810167ffffffffffffffff81118282101715610ba557600080fd5b604052919050565b600067ffffffffffffffff821115610bc457600080fd5b506020601f91909101601f19160190565b5190565b90815260200190565b6000610b0582610bf2565b151590565b6001600160a01b031690565b63ffffffff1690565b82818337506000910152565b60005b83811015610c2e578181015183820152602001610c16565b838111156102a85750506000910152565b601f01601f19169056fea265627a7a72305820ce7dc10197293c46102358b8f03fbab72312422fcd7556ac32a6cc65a4fcf37d6c6578706572696d656e74616cf50037";

    public static final String FUNC_PARTICIPANTS = "participants";

    public static final String FUNC_ADRESSES = "adresses";

    public static final String FUNC_N = "n";

    public static final String FUNC_COMMITSEED = "commitSeed";

    public static final String FUNC_COMMITCHALLENGE = "commitChallenge";

    public static final String FUNC_OPENSEED = "openSeed";

    public static final String FUNC_SEEDCOMMITMENTS = "seedCommitments";

    public static final String FUNC_PHASE = "phase";

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

    public RemoteFunctionCall<BigInteger> phase() {
        final Function function = new Function(FUNC_PHASE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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
