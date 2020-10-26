pragma solidity ^0.5.6;

contract PVContract {

	mapping(address => bool) public participants;
	uint32 n;
	
	uint32 phase;
	uint32 calls;
	uint blocknumber;
	uint offset;
	
	mapping(address => Commitment[]) public seedCommitments;
	mapping(address => Commitment[]) public challengeCommitments;
	
	struct Commitment {
	    bytes32 commit;
	    bytes32 open;
	    bytes32 secret;
	}
	
	constructor(uint32 numberOfParticipants, uint timeOffset) public {
	    n = numberOfParticipants;
	    blocknumber = block.number;
	    phase = 0;
	    calls = 0;
	    offset = timeOffset;
	}
	
	function init() public beforeTimeout{
	    require(phase == 0, "Not in the right phase");
	    participants[msg.sender] = true;
        checkCalls();
	}
	
	function commitChallenge(bytes32 commit, uint session) public isParticipant beforeTimeout{
	    require(phase == 1, "Not in the right phase");
	    challengeCommitments[msg.sender][session].commit = commit;
	    checkCalls();
	}
	
	function commitSeed(bytes32 commit, uint session) public isParticipant beforeTimeout{
	    require(phase == 2, "Not in the right phase");
	    seedCommitments[msg.sender][session].commit = commit;
	    checkCalls();
	}
	
	function openChallenge(bytes32 open, bytes32 secret, uint session) public isParticipant beforeTimeout{
	    require(phase == 3, "Not in the right phase");
	    challengeCommitments[msg.sender][session].open = open;
	    challengeCommitments[msg.sender][session].secret = secret;
	    checkCalls();
	}
	
	function openSeed(bytes32 open, bytes32 secret, uint session) public isParticipant beforeTimeout{
	    require(phase == 4, "Not in the right phase");
	    seedCommitments[msg.sender][session].open = open;
	    seedCommitments[msg.sender][session].secret = secret;
	    checkCalls();
	}
	
	function checkCalls() private {
	    calls++;
	    if(calls >= n) {
	        phase++;
	        calls = 0;
	        blocknumber = block.number;
	    }
	}
	
	modifier isParticipant() {
	    require(participants[msg.sender] == true, "Caller is not participant");
	    _;
	}
	
	modifier beforeTimeout() {
	    require(blocknumber + offset >= block.number, "Call is to late.");
	    _;
	}
	
}