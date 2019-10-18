/*
 * 사용자 클래스
 * 관리자 아이디와 비밀번호를 입력하면 관리자로 로그인이 가능하다.
 * 일반 사람의 이름과 사원 번호를 확인하여 해당 사람의 객체를 받아온다.
 * 정보 조회 및 제한적 수정이 가능하다.
 */



import java.util.Scanner;

public class User {
	private People people;
	private Worker worker;
	private PartTimer partTimer;
	
	public User(Worker worker) {
		this.worker = worker;
		people = worker;
		partTimer = null;
	}
	
	public User(PartTimer partTimer) {
		this.partTimer = partTimer;
		people = partTimer;
		worker = null;
	}
	
	public void print() {
		if(worker != null) {
			System.out.println("이름\t : "+worker.getName());
			System.out.println("사원번호\t : "+worker.getPeople_id());
			System.out.println("번호\t : "+worker.getPhone_number());
			System.out.println("생일\t : "+worker.getBirthday());
			System.out.println("이메일\t : "+worker.getEmail());
			System.out.println("주소\t : "+worker.getAddress());
			System.out.println("부서명\t : "+worker.getDepartmentName());
			System.out.println("부서번호\t : "+worker.getDepartmentCode());
			System.out.println("직급\t : "+worker.getRank());
			System.out.println("입사일\t : "+worker.getStart());
			System.out.println("계좌번호\t : "+worker.getAccountNumber());
			System.out.println("계좌은행\t : "+worker.getAccountName());
			System.out.println("계좌예금주\t : "+worker.getAccountOwner());
			System.out.println("총급여\t : "+worker.getTotal());
			System.out.println("공제액\t : "+worker.getTax());
			System.out.println("실지급액\t : "+worker.getRealPay());
			System.out.println();
		}
		else {
			System.out.println("이름\t : "+partTimer.getName());
			System.out.println("사원번호\t : "+partTimer.getPeople_id());
			System.out.println("번호\t : "+partTimer.getPhone_number());
			System.out.println("생일\t : "+partTimer.getBirthday());
			System.out.println("이메일\t : "+partTimer.getEmail());
			System.out.println("주소\t : "+partTimer.getAddress());
			System.out.println("부서명\t : "+partTimer.getDepartmentName());
			System.out.println("부서번호\t : "+partTimer.getDepartmentCode());
			System.out.println("직급\t : "+partTimer.getRank());
			System.out.println("입사일\t : "+partTimer.getStart());
			System.out.println("계좌번호\t : "+partTimer.getAccountNumber());
			System.out.println("계좌은행\t : "+partTimer.getAccountName());
			System.out.println("계좌예금주\t : "+partTimer.getAccountOwner());
			System.out.println("총급여\t : "+partTimer.getTotalPay());
			System.out.println("공제액\t : "+partTimer.getTax());
			System.out.println("실지급액\t : "+partTimer.getRealPay());
			System.out.println();
		}
	}
	
	//동적바인딩 이용
	public void edit() {
		Scanner sc = new Scanner(System.in);
		int choice;
		while(true) {
			System.out.println("1.전화번호 2.이메일 3.주소 4.계좌번호 5.계좌은행 6.계좌예금주 7.종료");
			choice = sc.nextInt();
			if(choice == 1) {
				people.setPhone_number(sc.nextInt());
			}
			else if(choice == 2) {
				people.setEmail(sc.next());
			}
			else if(choice == 3) {
				people.setAddress(sc.next());
			}
			else if(choice == 4 ) {
				people.SetAccountNumber(sc.next());
			}
			else if(choice == 5) {
				people.SetAccountName(sc.next());
			}
			else if(choice == 6) {
				people.SetAccountOwner(sc.next());
			}
			else if(choice == 7) {
				return;
			}
			else {
				System.out.println("잘못 된 입력입니다.");
			}
		}
	}
}
