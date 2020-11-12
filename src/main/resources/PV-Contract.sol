pragma solidity ^0.5.6;

contract PVContract {

	mapping(address => bool) public participants;
	address[] public adresses;
	uint32 public n;
	
	uint32 phase;
	uint calls;
	uint call;
	uint blocknumber;
	uint offset;
	uint t;
	
	
	mapping(address => mapping(uint256 => Commitment)) public seedCommitments;
	mapping(address => Commitment) public challengeCommitments;
	
	struct Commitment {
	    bytes32 commit;
	    string open;
	    bytes32 secret;
	}
	
	constructor(uint32 numberOfParticipants, uint sessions, uint timeOffset) public {
	    n = numberOfParticipants;
	    blocknumber = block.number;
	    phase = 0;
	    calls = n;
	    call = 0;
	    offset = timeOffset;
	    t = sessions;
	    adresses.length = n;
	}
	
	function init() public beforeTimeout{
	    require(phase == 0, "Not in the right phase");
	    participants[msg.sender] = true;
	    adresses[call] = msg.sender;
        checkCalls();
	}
	
	function commitChallenge(bytes32 commit) public isParticipant beforeTimeout{
	    require(phase == 1, "Not in the right phase");

	    Commitment storage commitment = challengeCommitments[msg.sender];
	    commitment.commit = commit;
	    
	    checkCalls();
	}
	
	function commitSeed(bytes32 commit, uint session) public isParticipant beforeTimeout{
	    require(phase == 2, "Not in the right phase");

	    mapping(uint256 => Commitment) storage addressMapping = seedCommitments[msg.sender];
	    Commitment storage commitment = addressMapping[session];
	    commitment.commit = commit;
	    
	    checkCalls();
	}
	
	function openChallenge(string memory open, bytes32 secret) public isParticipant beforeTimeout{
	    require(phase == 3, "Not in the right phase");
	    
	    Commitment storage commitment = challengeCommitments[msg.sender];
	    commitment.open = open;
	    commitment.secret = secret;
	    
	    checkCalls();
	}
	
	function openSeed(string memory open, bytes32 secret, uint session) public isParticipant beforeTimeout{
	    require(phase == 4, "Not in the right phase");
	    
	    mapping(uint256 => Commitment) storage addressMapping = seedCommitments[msg.sender];
	    Commitment storage commitment = addressMapping[session];
	    commitment.open = open;
	    commitment.secret = secret;
	    
	    checkCalls();
	}
	
	function checkCalls() private {
	    call++;
	    if(call >= calls) {
	        phase++;
	        call = 0;
	        blocknumber = block.number;
	        if(phase == 2 || phase == 4) {
	            calls = n * t;
	        } else {
	            calls = n;
	        }
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