/*
 * 인적사항 내에 존재하는 부서
 */



public class People_Department {
	private int code;		//부서 번호
	private String name;	//부서 이름
	
	public People_Department() {
		
	}
	
	public People_Department(int code, String name) {
		this.setCode(code);
		this.setName(name); 
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
