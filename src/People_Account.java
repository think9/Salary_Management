/*
 * 인적사항 내에 존재하는 계좌 클래스
 */



public class People_Account {
	private String bank_name;		//은행 이름
	private String account_number;	//계좌번호
	private String account_owner;	//예금주
	
	public People_Account() {
		
	}
	
	public People_Account(String bank_name, String account_owner, String account_number) {
		this.setBank_name(bank_name);
		this.setAccount_owner(account_owner);
		this.setAccount_number(account_number);
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getAccount_owner() {
		return account_owner;
	}

	public void setAccount_owner(String account_owner) {
		this.account_owner = account_owner;
	}
}
