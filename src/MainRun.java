

import java.util.*;


public class MainRun {
	private User user;
	private Administrator administrator;
	
	public MainRun() {
		administrator = new Administrator();
	}
	
	//�α���
	//�����ڰ� �α����� �Ǵ��Ѵ�.
	public void login() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("�޿����� ���п� ���� ���� ȯ���մϴ�!");
			System.out.println("�α����� ���Ͽ� ������ ��ȸ�Ͻ� �� �ֽ��ϴ�.");
			System.out.println("����� �̸��� ID�� �����ȣ�� ��й�ȣ(����)�� ����մϴ�.");
			System.out.println("ID�� 0�� �Է� �� ���α׷��� �����մϴ�.");
			System.out.print("ID : ");
			String ID = sc.next();
			
			if(ID.equals("0")) {
				System.out.println("���α׷� ����..");
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
				System.out.println("�α��� ����! ��ġ�ϴ� ������ �����ϴ�.");
			}
		}
	}
	
	public void userRun() {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("1.��ȸ 2.���� 3.����");
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
				System.out.println("�߸� �� �Է��Դϴ�.");
			}
		}
	}
	
	public void adminRun() {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		while(true) {
			System.out.println("1.������ 2.�˹� 3.����");
			choice = sc.nextInt();
			if(choice == 1) {
				while(true) {
					System.out.println("1.�߰� 2.��ü��ȸ 3.�˻� 4.���� 5.���� 6.����");
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
						System.out.println("�߸� �� �Է��Դϴ�.");
					}
				}
			}
			else if(choice == 2) {
				while(true) {
					System.out.println("1.�߰� 2.��ü��ȸ 3.�˻� 4.���� 5.���� 6.����");
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
						System.out.println("�߸� �� �Է��Դϴ�.");
					}
				}
			}
			else if(choice == 3) {
				break;
			}
			else {
				System.out.println("�߸� �� �����Դϴ�!");
			}
		}
		System.out.println("���α׷� ����");
	}
	
	
	public static void main(String[] args) {
		MainRun mainRun = new MainRun();
		mainRun.login();
	}
}
