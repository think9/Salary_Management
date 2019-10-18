

import java.util.*;


public class MainRun {
	private User user;
	private Administrator administrator;
	
	public MainRun() {
		administrator = new Administrator();
	}
	
	//로그인
	//관리자가 로그인을 판단한다.
	public void login() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("급여관리 포털에 오신 것을 환영합니다!");
			System.out.println("로그인을 통하여 정보를 조회하실 수 있습니다.");
			System.out.println("사원은 이름을 ID로 사원번호를 비밀번호(숫자)로 사용합니다.");
			System.out.println("ID에 0을 입력 시 프로그램을 종료합니다.");
			System.out.print("ID : ");
			String ID = sc.next();
			
			if(ID.equals("0")) {
				System.out.println("프로그램 종료..");
				System.exit(-1);
			}
			
			System.out.print("PW : ");
			int PW = sc.nextInt();
			
			
			int result = administrator.check(ID, PW);
			
			if(result==1000) {
				this.adminRun();
			}
			else if(result >= 0 && result < 50) {
				user = new User(administrator.getWorker(result));
				this.userRun();
			}
			else if(result >= 50 && result < 55) {
				user = new User(administrator.getPartTimer(result-50));
				this.userRun();
			}
			else {
				System.out.println("로그인 실패! 일치하는 정보가 없습니다.");
			}
		}
	}
	
	public void userRun() {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("1.조회 2.수정 3.종료");
			choice = sc.nextInt();
			if(choice==1) {
				user.print();
			}
			else if(choice==2) {
				user.edit();
			}
			else if(choice==3) {
				break;
			}
			else {
				System.out.println("잘못 된 입력입니다.");
			}
		}
	}
	
	public void adminRun() {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("1.정직원 2.알바 3.종료");
			choice = sc.nextInt();
			if(choice == 1) {
				while(true) {
					System.out.println("1.추가 2.전체조회 3.검색 4.수정 5.삭제 6.종료");
					choice = sc.nextInt();
					if(choice==1) {
						administrator.addWorker();
					}
					else if(choice==2) {
						administrator.printWorker();
					}
					else if(choice==3) {
						administrator.searchWorker();
					}
					else if(choice==4) {
						administrator.editWorker();
					}
					else if(choice==5) {
						administrator.deleteWorker();
					}
					else if(choice==6) {
						break;
					}
					else {
						System.out.println("잘못 된 입력입니다.");
					}
				}
			}
			else if(choice == 2) {
				while(true) {
					System.out.println("1.추가 2.전체조회 3.검색 4.수정 5.삭제 6.종료");
					choice = sc.nextInt();
					if(choice==1) {
						administrator.addPartTimer();
					}
					else if(choice==2) {
						administrator.printPartTimer();
					}
					else if(choice==3) {
						
						administrator.searchPartTimer();
					}
					else if(choice==4) {
						administrator.editPartTimer();
					}
					else if(choice==5) {
						administrator.deletePartTimer();
					}
					else if(choice==6) {
						break;
					}
					else {
						System.out.println("잘못 된 입력입니다.");
					}
				}
			}
			else if(choice == 3) {
				break;
			}
			else {
				System.out.println("잘못 된 선택입니다!");
			}
		}
		System.out.println("프로그램 종료");
	}
	
	
	public static void main(String[] args) {
		MainRun mainRun = new MainRun();
		mainRun.login();
	}
}
