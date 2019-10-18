/*
 * 관리자 클래스
 * 관리자
 *  - 모든 사람 정보 출력
 *  - 직원 / 알바 추가
 *  - 정보 수정
 *  - 이름 / 사원번호 검색하여 출력
 *  - 이름 / 사원번호 검색하여 삭제
 *  
 *  사용자가 이름 / 사원번호를 입력 시 해당 객체를 돌려준다.
 */



import java.util.Scanner;

public class Administrator {	
	private Worker[] worker;
	private PartTimer[] partTimer; 
	
	private int idx = 0;			//idx for worker
	private int idx2 = 0;			//idx for part timer
	
	//Admin's ID and PW for manage the whole system
	private String ID;
	private int PW;
	
	//관리자 생성자 -> 사람을 50명까지 생성 가능하다. (has a)
	public Administrator() {
		worker = new Worker[50];
		partTimer = new PartTimer[5];
		
		//Set the admin ID and PW
		ID = "root";
		PW = 1234;
	}
	
	//Check the login attempt is valid
	public int check(String ID, int PW) {
		//Check ID and PW is admin
		if(ID.equals(this.ID) && PW == this.PW) {
			return 1000;
		}
		
		for(int i=0 ; i<idx ; i++) {
			if(worker[i].getName().equals(ID) && worker[i].getPeople_id() == PW) {
				return i;
			}
		}
		
		for(int i=0 ; i<idx2 ; i++) {
			if(partTimer[i].getName().equals(ID) && partTimer[i].getPeople_id() == PW) {
				return 50 + i;
			}
		}
		
		return -1;
	}
	
	public Worker getWorker(int num) {
		return worker[num];
	}
	
	public PartTimer getPartTimer(int num) {
		return partTimer[num];
	}
	
	//Worker Class 제어
	
	//관리자 사람 추가
	public void addWorker() {
		if(idx>49) {
			System.out.println("50명까지만 생성 가능합니다.");
			return;
		}
		System.out.println("직원 추가!");
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.next();
		String rank = null;
		while(true) {
			System.out.println("1.사원 2.대리 3.과장 4.차장 5.부장");
			System.out.print("직급 : ");
			int c = sc.nextInt();
			if(c==1) {
				rank = "사원";
				break;
			}
			else if(c==2) {
				rank = "대리";
				break;
			}
			else if(c==3) {
				rank = "과장";
				break;
			}
			else if(c==4) {
				rank = "차장";
				break;
			}
			else if(c==5) {
				rank = "부장";
				break;
			}
			System.out.println("잘못 된 직급입니다!");
		}
		System.out.print("생일 : ");
		int birthday = sc.nextInt();
		System.out.print("입사일 : ");
		int start = sc.nextInt();
		System.out.print("부서 코드 : ");
		int department_code = sc.nextInt();
		System.out.print("부서 이름 : ");
		String department_name = sc.next();
		System.out.print("핸드폰 번호 : ");
		int phone_number = sc.nextInt();
		System.out.print("사원 번호 : ");
		int worker_id = sc.nextInt();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("주소 : ");
		String address = sc.next();
		System.out.print("계좌 은행명 : ");
		String account_name = sc.next();
		System.out.print("계좌번호 : ");
		String account_number = sc.next();
		System.out.print("계좌 예금주 : ");
		String account_owner = sc.next();
		System.out.print("급여 : ");
		int pay = sc.nextInt();
		System.out.print("초과시급 : ");
		int hourPay = sc.nextInt();
		System.out.print("초과 근무시간 : ");
		int overHour = sc.nextInt();
		System.out.print("초과 야간 근무시간 : ");
		int nightHour = sc.nextInt();
		worker[idx++] = new Worker(name, rank, birthday, start, department_code, department_name, 
				phone_number, worker_id, email, address, account_name, account_number, account_owner, pay, hourPay, overHour, nightHour);
	}
	
	//관리자 전체 출력
	public void printWorker() {
		for(int i=0 ; i<idx ; i++) {
			System.out.println("이름\t : "+worker[i].getName());
			System.out.println("사원번호\t : "+worker[i].getPeople_id());
			System.out.println("번호\t : "+worker[i].getPhone_number());
			System.out.println("생일\t : "+worker[i].getBirthday());
			System.out.println("이메일\t : "+worker[i].getEmail());
			System.out.println("주소\t : "+worker[i].getAddress());
			System.out.println("부서명\t : "+worker[i].getDepartmentName());
			System.out.println("부서번호\t : "+worker[i].getDepartmentCode());
			System.out.println("직급\t : "+worker[i].getRank());
			System.out.println("입사일\t : "+worker[i].getStart());
			System.out.println("계좌번호\t : "+worker[i].getAccountNumber());
			System.out.println("계좌은행\t : "+worker[i].getAccountName());
			System.out.println("계좌예금주\t : "+worker[i].getAccountOwner());
			System.out.println("총급여\t : "+worker[i].getTotal());
			System.out.println("공제액\t : "+worker[i].getTax());
			System.out.println("실지급액\t : "+worker[i].getRealPay());
		}
		System.out.println();
	}
	
	//관리자 직원 검색
	public void searchWorker() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색하고 싶은 사원의 이름과 사원번호를 입력하세요 : ");
		String name = sc.next();
		int worker_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(worker[i].getName().equals(name) && worker[i].getPeople_id() == worker_id) {
				System.out.println("이름\t : "+worker[i].getName());
				System.out.println("사원번호\t : "+worker[i].getPeople_id());
				System.out.println("번호\t : "+worker[i].getPhone_number());
				System.out.println("생일\t : "+worker[i].getBirthday());
				System.out.println("이메일\t : "+worker[i].getEmail());
				System.out.println("주소\t : "+worker[i].getAddress());
				System.out.println("부서명\t : "+worker[i].getDepartmentName());
				System.out.println("부서번호\t : "+worker[i].getDepartmentCode());
				System.out.println("직급\t : "+worker[i].getRank());
				System.out.println("입사일\t : "+worker[i].getStart());
				System.out.println("계좌번호\t : "+worker[i].getAccountNumber());
				System.out.println("계좌은행\t : "+worker[i].getAccountName());
				System.out.println("계좌예금주\t : "+worker[i].getAccountOwner());
				System.out.println("총급여\t : "+worker[i].getTotal());
				System.out.println("공제액\t : "+worker[i].getTax());
				System.out.println("실지급액\t : "+worker[i].getRealPay());
				System.out.println();
				return;
			}
		}
		System.out.println("일치하는 이름 및 사원번호가 없습니다!");
	}
	
	//관리자 직원 수정
	public void editWorker() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정하고 싶은 사원의 이름과 사원번호를 입력하세요 : ");
		String name = sc.next();
		int worker_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(worker[i].getName().equals(name) && worker[i].getPeople_id() == worker_id) {
				while(true) {
					System.out.println("무엇을 수정하시겠습니까?");
					System.out.println("1.이름 2.사원번호 3.번호 4.생일 5.이메일 6.주소 7.부서명 "
							+ "8.부서번호 9.직급 10.입사일 11.계좌번호 12.계좌은행 13.계좌예금주 14.종료");
					int choice = sc.nextInt();
					String str_temp;
					int int_temp;
					switch(choice) {
					//이름
					case 1:
						str_temp = sc.next();
						worker[i].setName(str_temp);
						break;
						//사원번호
					case 2:
						int_temp = sc.nextInt();
						worker[i].setPeople_id(int_temp);
						break;
						//번호
					case 3:
						int_temp = sc.nextInt();
						worker[i].setPhone_number(int_temp);
						break;
						//생일
					case 4:
						int_temp = sc.nextInt();
						worker[i].setBirthday(int_temp);
						break;
						//이메일
					case 5:
						str_temp = sc.next();
						worker[i].setEmail(str_temp);
						break;
						//주소
					case 6:
						str_temp = sc.next();
						worker[i].setAddress(str_temp);
						break;
						//부서명
					case 7:
						str_temp = sc.next();
						worker[i].setDepartmentName(str_temp);
						break;
						//부서번호
					case 8:
						int_temp = sc.nextInt();
						worker[i].setDepartmentCode(int_temp);
						break;
						//직급
					case 9:
						str_temp = sc.next();
						worker[i].setRank(str_temp);
						break;
						//입사일
					case 10:
						int_temp = sc.nextInt();
						worker[i].setStart(int_temp);
						break;
						//계좌번호
					case 11:
						str_temp = sc.next();
						worker[i].SetAccountNumber(str_temp);
						break;
						//계좌은행
					case 12:
						str_temp = sc.next();
						worker[i].SetAccountName(str_temp);
						break;
						//계좌예금주
					case 13:
						str_temp = sc.next();
						worker[i].SetAccountOwner(str_temp);
						break;
					case 14:
						return;
					default:
						System.out.println("잘못 된 입력");
					}
				}
			}
		}
		System.out.println("일치하는 이름 및 사원번호가 없습니다!");
	}
	
	//관리자가 직원 삭제
	public void deleteWorker() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색하고 싶은 사원의 이름과 사원번호를 입력하세요 : ");
		String name = sc.next();
		int worker_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(worker[i].getName().equals(name) && worker[i].getPeople_id() == worker_id) {
				worker[i] = worker[--idx];
				System.out.println("삭제 완료!");
				return;
			}
		}
		System.out.println("일치하는 이름 및 사원번호가 없습니다!");
	}
	
	
	//PartTimer Class 제어
	
	//administrator is adding the part timer
	void addPartTimer() {
		if(idx2>5) {
			System.out.println("5명까지만 생성 가능합니다.");
			return;
		}
		System.out.println("알바 추가!");
		partTimer[idx2] = new PartTimer();
		Scanner sc = new Scanner(System.in);
		partTimer[idx2].setRank("알바");
		//set the values of part timer
		System.out.print("이름 : ");
		partTimer[idx2].setName(sc.next());
		System.out.print("생일 : ");
		partTimer[idx2].setBirthday(sc.nextInt());
		System.out.print("입사일 : ");
		partTimer[idx2].setStart(sc.nextInt());
		System.out.print("부서 코드 : ");
		partTimer[idx2].setDepartmentCode(sc.nextInt());
		System.out.print("부서 이름 : ");
		partTimer[idx2].setDepartmentName(sc.next());
		System.out.print("핸드폰 번호 : ");
		partTimer[idx2].setPhone_number(sc.nextInt());;
		System.out.print("사원 번호 : ");
		partTimer[idx2].setPeople_id(sc.nextInt());
		System.out.print("이메일 : ");
		partTimer[idx2].setEmail(sc.next());
		System.out.print("주소 : ");
		partTimer[idx2].setAddress(sc.next());
		System.out.print("계좌 은행명 : ");
		partTimer[idx2].SetAccountName(sc.next());
		System.out.print("계좌번호 : ");
		partTimer[idx2].SetAccountNumber(sc.next());
		System.out.print("계좌 예금주 : ");
		partTimer[idx2].SetAccountOwner(sc.next());
		System.out.print("시급 : ");
		partTimer[idx2].setHourPay(sc.nextInt());
		System.out.print("근무시간 : ");
		partTimer[idx2].setWorkHour(sc.nextInt());
		System.out.print("초과 근무시간 : ");
		partTimer[idx2].setOverHour(sc.nextInt());
		System.out.print("초과 야간 근무시간 : ");
		partTimer[idx2].setNightHour(sc.nextInt());
		idx2++;
	}
	
	//print all of the part timer
	void printPartTimer() {
		for(int i=0 ; i<idx2 ; i++) {
			System.out.println("이름\t : "+partTimer[i].getName());
			System.out.println("사원번호\t : "+partTimer[i].getPeople_id());
			System.out.println("번호\t : "+partTimer[i].getPhone_number());
			System.out.println("생일\t : "+partTimer[i].getBirthday());
			System.out.println("이메일\t : "+partTimer[i].getEmail());
			System.out.println("주소\t : "+partTimer[i].getAddress());
			System.out.println("부서명\t : "+partTimer[i].getDepartmentName());
			System.out.println("부서번호\t : "+partTimer[i].getDepartmentCode());
			System.out.println("직급\t : "+partTimer[i].getRank());
			System.out.println("입사일\t : "+partTimer[i].getStart());
			System.out.println("계좌번호\t : "+partTimer[i].getAccountNumber());
			System.out.println("계좌은행\t : "+partTimer[i].getAccountName());
			System.out.println("계좌예금주\t : "+partTimer[i].getAccountOwner());
			System.out.println("총급여\t : "+partTimer[i].getTotalPay());
			System.out.println("공제액\t : "+partTimer[i].getTax());
			System.out.println("실지급액\t : "+partTimer[i].getRealPay());
			System.out.println();
		}
		System.out.println("일치하는 알바가 없습니다!");
	}
	
	//get name and people_id and searching the match one
	void searchPartTimer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색하고 싶은 사원의 이름과 사원번호를 입력하세요 : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(partTimer[i].getName().equals(name) && partTimer[i].getPeople_id() == people_id) {
				System.out.println("이름\t : "+partTimer[i].getName());
				System.out.println("사원번호\t : "+partTimer[i].getPeople_id());
				System.out.println("번호\t : "+partTimer[i].getPhone_number());
				System.out.println("생일\t : "+partTimer[i].getBirthday());
				System.out.println("이메일\t : "+partTimer[i].getEmail());
				System.out.println("주소\t : "+partTimer[i].getAddress());
				System.out.println("부서명\t : "+partTimer[i].getDepartmentName());
				System.out.println("부서번호\t : "+partTimer[i].getDepartmentCode());
				System.out.println("직급\t : "+partTimer[i].getRank());
				System.out.println("입사일\t : "+partTimer[i].getStart());
				System.out.println("계좌번호\t : "+partTimer[i].getAccountNumber());
				System.out.println("계좌은행\t : "+partTimer[i].getAccountName());
				System.out.println("계좌예금주\t : "+partTimer[i].getAccountOwner());
				System.out.println("총급여\t : "+partTimer[i].getTotalPay());
				System.out.println("공제액\t : "+partTimer[i].getTax());
				System.out.println("실지급액\t : "+partTimer[i].getRealPay());
				System.out.println();
				return;
			}
		}
		System.out.println("일치하는 알바가 없습니다!");
	}
	
	//get name and people_id and edit the element choose by administrator
	void editPartTimer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정하고 싶은 사원의 이름과 사원번호를 입력하세요 : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(partTimer[i].getName().equals(name) && partTimer[i].getPeople_id() == people_id) {
				while(true) {
					System.out.println("무엇을 수정하시겠습니까?");
					System.out.println("1.이름 2.사원번호 3.번호 4.생일 5.이메일 6.주소 7.부서명 "
							+ "8.부서번호 9.시급 10.입사일 11.계좌번호 12.계좌은행 13.계좌예금주 "
							+ "14.근무시간 15.초과근무시간 16.초과야간근무시간 17.종료");
					int choice = sc.nextInt();
					String str_temp;
					int int_temp;
					switch(choice) {
					//이름
					case 1:
						str_temp = sc.next();
						partTimer[i].setName(str_temp);
						break;
						//사원번호
					case 2:
						int_temp = sc.nextInt();
						partTimer[i].setPeople_id(int_temp);
						break;
						//번호
					case 3:
						int_temp = sc.nextInt();
						partTimer[i].setPhone_number(int_temp);
						break;
						//생일
					case 4:
						int_temp = sc.nextInt();
						partTimer[i].setBirthday(int_temp);
						break;
						//이메일
					case 5:
						str_temp = sc.next();
						partTimer[i].setEmail(str_temp);
						break;
						//주소
					case 6:
						str_temp = sc.next();
						partTimer[i].setAddress(str_temp);
						break;
						//부서명
					case 7:
						str_temp = sc.next();
						partTimer[i].setDepartmentName(str_temp);
						break;
						//부서번호
					case 8:
						int_temp = sc.nextInt();
						partTimer[i].setDepartmentCode(int_temp);
						break;
						//시급
					case 9:
						partTimer[i].setHourPay(sc.nextInt());
						break;
						//입사일
					case 10:
						int_temp = sc.nextInt();
						partTimer[i].setStart(int_temp);
						break;
						//계좌번호
					case 11:
						str_temp = sc.next();
						partTimer[i].SetAccountNumber(str_temp);
						break;
						//계좌은행
					case 12:
						str_temp = sc.next();
						partTimer[i].SetAccountName(str_temp);
						break;
						//계좌예금주
					case 13:
						str_temp = sc.next();
						partTimer[i].SetAccountOwner(str_temp);
						break;
						//근무시간
					case 14:
						partTimer[i].setWorkHour(sc.nextInt());
						break;
						//초과근무시간
					case 15:
						partTimer[i].setOverHour(sc.nextInt());
						break;
						//초과야간근무시간
					case 16:
						partTimer[i].setNightHour(sc.nextInt());
						break;
						//종료
					case 17:
						return;
					default:
						System.out.println("잘못 된 입력");
					}
				}
			}
		}
		System.out.println("일치하는 알바가 없습니다!");
	}
	
	//get name and people_id and delete the element and swap with last one
	void deletePartTimer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제하고 싶은 사원의 이름과 사원번호를 입력하세요 : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(partTimer[i].getName().equals(name) && partTimer[i].getPeople_id() == people_id) {
				partTimer[i] = partTimer[--idx2];
				System.out.println("삭제 완료!");
				return;
			}
		}
		System.out.println("일치하는 알바가 없습니다!");
	}
}
