/*
 * ������ Ŭ����
 * ������
 *  - ��� ��� ���� ���
 *  - ���� / �˹� �߰�
 *  - ���� ����
 *  - �̸� / �����ȣ �˻��Ͽ� ���
 *  - �̸� / �����ȣ �˻��Ͽ� ����
 *  
 *  ����ڰ� �̸� / �����ȣ�� �Է� �� �ش� ��ü�� �����ش�.
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
	
	//������ ������ -> ����� 50����� ���� �����ϴ�. (has a)
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
	
	//Worker Class ����
	
	//������ ��� �߰�
	public void addWorker() {
		if(idx>49) {
			System.out.println("50������� ���� �����մϴ�.");
			return;
		}
		System.out.println("���� �߰�!");
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");
		String name = sc.next();
		String rank = null;
		while(true) {
			System.out.println("1.��� 2.�븮 3.���� 4.���� 5.����");
			System.out.print("���� : ");
			int c = sc.nextInt();
			if(c==1) {
				rank = "���";
				break;
			}
			else if(c==2) {
				rank = "�븮";
				break;
			}
			else if(c==3) {
				rank = "����";
				break;
			}
			else if(c==4) {
				rank = "����";
				break;
			}
			else if(c==5) {
				rank = "����";
				break;
			}
			System.out.println("�߸� �� �����Դϴ�!");
		}
		System.out.print("���� : ");
		int birthday = sc.nextInt();
		System.out.print("�Ի��� : ");
		int start = sc.nextInt();
		System.out.print("�μ� �ڵ� : ");
		int department_code = sc.nextInt();
		System.out.print("�μ� �̸� : ");
		String department_name = sc.next();
		System.out.print("�ڵ��� ��ȣ : ");
		int phone_number = sc.nextInt();
		System.out.print("��� ��ȣ : ");
		int worker_id = sc.nextInt();
		System.out.print("�̸��� : ");
		String email = sc.next();
		System.out.print("�ּ� : ");
		String address = sc.next();
		System.out.print("���� ����� : ");
		String account_name = sc.next();
		System.out.print("���¹�ȣ : ");
		String account_number = sc.next();
		System.out.print("���� ������ : ");
		String account_owner = sc.next();
		System.out.print("�޿� : ");
		int pay = sc.nextInt();
		System.out.print("�ʰ��ñ� : ");
		int hourPay = sc.nextInt();
		System.out.print("�ʰ� �ٹ��ð� : ");
		int overHour = sc.nextInt();
		System.out.print("�ʰ� �߰� �ٹ��ð� : ");
		int nightHour = sc.nextInt();
		worker[idx++] = new Worker(name, rank, birthday, start, department_code, department_name, 
				phone_number, worker_id, email, address, account_name, account_number, account_owner, pay, hourPay, overHour, nightHour);
	}
	
	//������ ��ü ���
	public void printWorker() {
		for(int i=0 ; i<idx ; i++) {
			System.out.println("�̸�\t : "+worker[i].getName());
			System.out.println("�����ȣ\t : "+worker[i].getPeople_id());
			System.out.println("��ȣ\t : "+worker[i].getPhone_number());
			System.out.println("����\t : "+worker[i].getBirthday());
			System.out.println("�̸���\t : "+worker[i].getEmail());
			System.out.println("�ּ�\t : "+worker[i].getAddress());
			System.out.println("�μ���\t : "+worker[i].getDepartmentName());
			System.out.println("�μ���ȣ\t : "+worker[i].getDepartmentCode());
			System.out.println("����\t : "+worker[i].getRank());
			System.out.println("�Ի���\t : "+worker[i].getStart());
			System.out.println("���¹�ȣ\t : "+worker[i].getAccountNumber());
			System.out.println("��������\t : "+worker[i].getAccountName());
			System.out.println("���¿�����\t : "+worker[i].getAccountOwner());
			System.out.println("�ѱ޿�\t : "+worker[i].getTotal());
			System.out.println("������\t : "+worker[i].getTax());
			System.out.println("�����޾�\t : "+worker[i].getRealPay());
		}
		System.out.println();
	}
	
	//������ ���� �˻�
	public void searchWorker() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��ϰ� ���� ����� �̸��� �����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int worker_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(worker[i].getName().equals(name) && worker[i].getPeople_id() == worker_id) {
				System.out.println("�̸�\t : "+worker[i].getName());
				System.out.println("�����ȣ\t : "+worker[i].getPeople_id());
				System.out.println("��ȣ\t : "+worker[i].getPhone_number());
				System.out.println("����\t : "+worker[i].getBirthday());
				System.out.println("�̸���\t : "+worker[i].getEmail());
				System.out.println("�ּ�\t : "+worker[i].getAddress());
				System.out.println("�μ���\t : "+worker[i].getDepartmentName());
				System.out.println("�μ���ȣ\t : "+worker[i].getDepartmentCode());
				System.out.println("����\t : "+worker[i].getRank());
				System.out.println("�Ի���\t : "+worker[i].getStart());
				System.out.println("���¹�ȣ\t : "+worker[i].getAccountNumber());
				System.out.println("��������\t : "+worker[i].getAccountName());
				System.out.println("���¿�����\t : "+worker[i].getAccountOwner());
				System.out.println("�ѱ޿�\t : "+worker[i].getTotal());
				System.out.println("������\t : "+worker[i].getTax());
				System.out.println("�����޾�\t : "+worker[i].getRealPay());
				System.out.println();
				return;
			}
		}
		System.out.println("��ġ�ϴ� �̸� �� �����ȣ�� �����ϴ�!");
	}
	
	//������ ���� ����
	public void editWorker() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϰ� ���� ����� �̸��� �����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int worker_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(worker[i].getName().equals(name) && worker[i].getPeople_id() == worker_id) {
				while(true) {
					System.out.println("������ �����Ͻðڽ��ϱ�?");
					System.out.println("1.�̸� 2.�����ȣ 3.��ȣ 4.���� 5.�̸��� 6.�ּ� 7.�μ��� "
							+ "8.�μ���ȣ 9.���� 10.�Ի��� 11.���¹�ȣ 12.�������� 13.���¿����� 14.����");
					int choice = sc.nextInt();
					String str_temp;
					int int_temp;
					switch(choice) {
					//�̸�
					case 1:
						str_temp = sc.next();
						worker[i].setName(str_temp);
						break;
						//�����ȣ
					case 2:
						int_temp = sc.nextInt();
						worker[i].setPeople_id(int_temp);
						break;
						//��ȣ
					case 3:
						int_temp = sc.nextInt();
						worker[i].setPhone_number(int_temp);
						break;
						//����
					case 4:
						int_temp = sc.nextInt();
						worker[i].setBirthday(int_temp);
						break;
						//�̸���
					case 5:
						str_temp = sc.next();
						worker[i].setEmail(str_temp);
						break;
						//�ּ�
					case 6:
						str_temp = sc.next();
						worker[i].setAddress(str_temp);
						break;
						//�μ���
					case 7:
						str_temp = sc.next();
						worker[i].setDepartmentName(str_temp);
						break;
						//�μ���ȣ
					case 8:
						int_temp = sc.nextInt();
						worker[i].setDepartmentCode(int_temp);
						break;
						//����
					case 9:
						str_temp = sc.next();
						worker[i].setRank(str_temp);
						break;
						//�Ի���
					case 10:
						int_temp = sc.nextInt();
						worker[i].setStart(int_temp);
						break;
						//���¹�ȣ
					case 11:
						str_temp = sc.next();
						worker[i].SetAccountNumber(str_temp);
						break;
						//��������
					case 12:
						str_temp = sc.next();
						worker[i].SetAccountName(str_temp);
						break;
						//���¿�����
					case 13:
						str_temp = sc.next();
						worker[i].SetAccountOwner(str_temp);
						break;
					case 14:
						return;
					default:
						System.out.println("�߸� �� �Է�");
					}
				}
			}
		}
		System.out.println("��ġ�ϴ� �̸� �� �����ȣ�� �����ϴ�!");
	}
	
	//�����ڰ� ���� ����
	public void deleteWorker() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��ϰ� ���� ����� �̸��� �����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int worker_id = sc.nextInt();
		for(int i=0 ; i<idx ; i++) {
			if(worker[i].getName().equals(name) && worker[i].getPeople_id() == worker_id) {
				worker[i] = worker[--idx];
				System.out.println("���� �Ϸ�!");
				return;
			}
		}
		System.out.println("��ġ�ϴ� �̸� �� �����ȣ�� �����ϴ�!");
	}
	
	
	//PartTimer Class ����
	
	//administrator is adding the part timer
	void addPartTimer() {
		if(idx2>5) {
			System.out.println("5������� ���� �����մϴ�.");
			return;
		}
		System.out.println("�˹� �߰�!");
		partTimer[idx2] = new PartTimer();
		Scanner sc = new Scanner(System.in);
		partTimer[idx2].setRank("�˹�");
		//set the values of part timer
		System.out.print("�̸� : ");
		partTimer[idx2].setName(sc.next());
		System.out.print("���� : ");
		partTimer[idx2].setBirthday(sc.nextInt());
		System.out.print("�Ի��� : ");
		partTimer[idx2].setStart(sc.nextInt());
		System.out.print("�μ� �ڵ� : ");
		partTimer[idx2].setDepartmentCode(sc.nextInt());
		System.out.print("�μ� �̸� : ");
		partTimer[idx2].setDepartmentName(sc.next());
		System.out.print("�ڵ��� ��ȣ : ");
		partTimer[idx2].setPhone_number(sc.nextInt());;
		System.out.print("��� ��ȣ : ");
		partTimer[idx2].setPeople_id(sc.nextInt());
		System.out.print("�̸��� : ");
		partTimer[idx2].setEmail(sc.next());
		System.out.print("�ּ� : ");
		partTimer[idx2].setAddress(sc.next());
		System.out.print("���� ����� : ");
		partTimer[idx2].SetAccountName(sc.next());
		System.out.print("���¹�ȣ : ");
		partTimer[idx2].SetAccountNumber(sc.next());
		System.out.print("���� ������ : ");
		partTimer[idx2].SetAccountOwner(sc.next());
		System.out.print("�ñ� : ");
		partTimer[idx2].setHourPay(sc.nextInt());
		System.out.print("�ٹ��ð� : ");
		partTimer[idx2].setWorkHour(sc.nextInt());
		System.out.print("�ʰ� �ٹ��ð� : ");
		partTimer[idx2].setOverHour(sc.nextInt());
		System.out.print("�ʰ� �߰� �ٹ��ð� : ");
		partTimer[idx2].setNightHour(sc.nextInt());
		idx2++;
	}
	
	//print all of the part timer
	void printPartTimer() {
		for(int i=0 ; i<idx2 ; i++) {
			System.out.println("�̸�\t : "+partTimer[i].getName());
			System.out.println("�����ȣ\t : "+partTimer[i].getPeople_id());
			System.out.println("��ȣ\t : "+partTimer[i].getPhone_number());
			System.out.println("����\t : "+partTimer[i].getBirthday());
			System.out.println("�̸���\t : "+partTimer[i].getEmail());
			System.out.println("�ּ�\t : "+partTimer[i].getAddress());
			System.out.println("�μ���\t : "+partTimer[i].getDepartmentName());
			System.out.println("�μ���ȣ\t : "+partTimer[i].getDepartmentCode());
			System.out.println("����\t : "+partTimer[i].getRank());
			System.out.println("�Ի���\t : "+partTimer[i].getStart());
			System.out.println("���¹�ȣ\t : "+partTimer[i].getAccountNumber());
			System.out.println("��������\t : "+partTimer[i].getAccountName());
			System.out.println("���¿�����\t : "+partTimer[i].getAccountOwner());
			System.out.println("�ѱ޿�\t : "+partTimer[i].getTotalPay());
			System.out.println("������\t : "+partTimer[i].getTax());
			System.out.println("�����޾�\t : "+partTimer[i].getRealPay());
			System.out.println();
		}
		System.out.println("��ġ�ϴ� �˹ٰ� �����ϴ�!");
	}
	
	//get name and people_id and searching the match one
	void searchPartTimer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��ϰ� ���� ����� �̸��� �����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(partTimer[i].getName().equals(name) && partTimer[i].getPeople_id() == people_id) {
				System.out.println("�̸�\t : "+partTimer[i].getName());
				System.out.println("�����ȣ\t : "+partTimer[i].getPeople_id());
				System.out.println("��ȣ\t : "+partTimer[i].getPhone_number());
				System.out.println("����\t : "+partTimer[i].getBirthday());
				System.out.println("�̸���\t : "+partTimer[i].getEmail());
				System.out.println("�ּ�\t : "+partTimer[i].getAddress());
				System.out.println("�μ���\t : "+partTimer[i].getDepartmentName());
				System.out.println("�μ���ȣ\t : "+partTimer[i].getDepartmentCode());
				System.out.println("����\t : "+partTimer[i].getRank());
				System.out.println("�Ի���\t : "+partTimer[i].getStart());
				System.out.println("���¹�ȣ\t : "+partTimer[i].getAccountNumber());
				System.out.println("��������\t : "+partTimer[i].getAccountName());
				System.out.println("���¿�����\t : "+partTimer[i].getAccountOwner());
				System.out.println("�ѱ޿�\t : "+partTimer[i].getTotalPay());
				System.out.println("������\t : "+partTimer[i].getTax());
				System.out.println("�����޾�\t : "+partTimer[i].getRealPay());
				System.out.println();
				return;
			}
		}
		System.out.println("��ġ�ϴ� �˹ٰ� �����ϴ�!");
	}
	
	//get name and people_id and edit the element choose by administrator
	void editPartTimer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϰ� ���� ����� �̸��� �����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(partTimer[i].getName().equals(name) && partTimer[i].getPeople_id() == people_id) {
				while(true) {
					System.out.println("������ �����Ͻðڽ��ϱ�?");
					System.out.println("1.�̸� 2.�����ȣ 3.��ȣ 4.���� 5.�̸��� 6.�ּ� 7.�μ��� "
							+ "8.�μ���ȣ 9.�ñ� 10.�Ի��� 11.���¹�ȣ 12.�������� 13.���¿����� "
							+ "14.�ٹ��ð� 15.�ʰ��ٹ��ð� 16.�ʰ��߰��ٹ��ð� 17.����");
					int choice = sc.nextInt();
					String str_temp;
					int int_temp;
					switch(choice) {
					//�̸�
					case 1:
						str_temp = sc.next();
						partTimer[i].setName(str_temp);
						break;
						//�����ȣ
					case 2:
						int_temp = sc.nextInt();
						partTimer[i].setPeople_id(int_temp);
						break;
						//��ȣ
					case 3:
						int_temp = sc.nextInt();
						partTimer[i].setPhone_number(int_temp);
						break;
						//����
					case 4:
						int_temp = sc.nextInt();
						partTimer[i].setBirthday(int_temp);
						break;
						//�̸���
					case 5:
						str_temp = sc.next();
						partTimer[i].setEmail(str_temp);
						break;
						//�ּ�
					case 6:
						str_temp = sc.next();
						partTimer[i].setAddress(str_temp);
						break;
						//�μ���
					case 7:
						str_temp = sc.next();
						partTimer[i].setDepartmentName(str_temp);
						break;
						//�μ���ȣ
					case 8:
						int_temp = sc.nextInt();
						partTimer[i].setDepartmentCode(int_temp);
						break;
						//�ñ�
					case 9:
						partTimer[i].setHourPay(sc.nextInt());
						break;
						//�Ի���
					case 10:
						int_temp = sc.nextInt();
						partTimer[i].setStart(int_temp);
						break;
						//���¹�ȣ
					case 11:
						str_temp = sc.next();
						partTimer[i].SetAccountNumber(str_temp);
						break;
						//��������
					case 12:
						str_temp = sc.next();
						partTimer[i].SetAccountName(str_temp);
						break;
						//���¿�����
					case 13:
						str_temp = sc.next();
						partTimer[i].SetAccountOwner(str_temp);
						break;
						//�ٹ��ð�
					case 14:
						partTimer[i].setWorkHour(sc.nextInt());
						break;
						//�ʰ��ٹ��ð�
					case 15:
						partTimer[i].setOverHour(sc.nextInt());
						break;
						//�ʰ��߰��ٹ��ð�
					case 16:
						partTimer[i].setNightHour(sc.nextInt());
						break;
						//����
					case 17:
						return;
					default:
						System.out.println("�߸� �� �Է�");
					}
				}
			}
		}
		System.out.println("��ġ�ϴ� �˹ٰ� �����ϴ�!");
	}
	
	//get name and people_id and delete the element and swap with last one
	void deletePartTimer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϰ� ���� ����� �̸��� �����ȣ�� �Է��ϼ��� : ");
		String name = sc.next();
		int people_id = sc.nextInt();
		
		for(int i=0 ; i<idx2 ; i++) {
			if(partTimer[i].getName().equals(name) && partTimer[i].getPeople_id() == people_id) {
				partTimer[i] = partTimer[--idx2];
				System.out.println("���� �Ϸ�!");
				return;
			}
		}
		System.out.println("��ġ�ϴ� �˹ٰ� �����ϴ�!");
	}
}
