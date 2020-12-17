pragma solidity ^0.5.6;

contract Test {
    
    	struct Commitment {
	    bytes32 commit;
	    bytes32 open;
	    bytes32 secret;
	}
    
    mapping(address => mapping(uint256 => Commitment)) public seedCommitments;
    uint test;
	mapping(address => Commitment[]) public challengeCommitments;
	
	bytes32 public hash;
	
    
	function commitChallenge(bytes32 commit, uint256 session) public{
	    mapping(uint256 => Commitment) storage addressMapping = seedCommitments[msg.sender];
	    Commitment storage commitment = addressMapping[session];
	    commitment.commit = commit;
	}
	
	function testInt(uint session) public{
	    test = session;
	}
	
	function keccak(bytes memory value) public {
	    hash = keccak256(value);
	}
}