/*
 * ���� Ŭ����
 */



public class Worker extends People{
	private double basePay; //�⺻��(����)
	private double gradePay; // ���� �� �μ�Ƽ��
	private double hourPay; // �ñ�
	private int overHour;	//�ʰ� �ٹ� �ð�
	private double nightPay; // �ʰ��ٹ� ����
	private int nightHour;	//�ʰ� �߰� �ٹ� �ð�
	
	private double totalPay;	//�ѱ޿�
	private double tax;			//����
	private double realPay; //�Ǳ޿� (�������޾�)


	public Worker() {
		
	}
	
	public Worker(String name, String rank, int birthday, int start, int department_code, String department_name, 
			int phone_number, int people_id, String email, String address, String account_name, String account_number, String account_owner,
			int pay, int hourPay, int overHour, int nightHour) {
		super.setPeople(name, rank, birthday, start, department_code, department_name, 
				phone_number, people_id, email, address, account_name, account_number, account_owner);
		gradePay = basePay = realPay = 0;
		this.hourPay = hourPay;
		this.nightHour = nightHour;
		this.overHour = overHour;
		setBasePay(pay);
	}

	//������ �����Ѵ�.
	public void setBasePay(double month_pay) {
		this.basePay = month_pay;
	}

	public double getBasePay() {
		return basePay;
	}

	// �μ�Ƽ�� = �⺻��*�ۼ�Ʈ  �˹� 0% ��� 15%   �븮 30%    ���� 40%   ���� 50%   ���� 60%
	public void setGradePay() { 
		String position = super.getRank(); //getPosition() ��å �޾ƿ���\
		switch(position) {
		case "�˹�":
			this.gradePay = (int)(this.basePay*0.00);
			break;
		case "���":
			this.gradePay = (int)(this.basePay*0.15);
			break;
		case "�븮":
			this.gradePay = (int)(this.basePay*0.30);
			break;
		case "����":
			this.gradePay = (int)(this.basePay*0.40);
			break;
		case "����":
			this.gradePay = (int)(this.basePay*0.50);
			break;
		case "����":
			this.gradePay = (int)(this.basePay*0.60);
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");   
			break;
		}
	}

	public double getGradePay() {
		return gradePay;
	}

	//�߰� �ٹ� �ñ� ����
	public void sethourPay() {
//		String position = super.getRank(); //getPosition() ��å �޾ƿ���\
//		switch(position) {
//		case "�˹�":
//			this.hourPay = 8500;
//			break;
//		case "���":
//			this.hourPay = 8500 * 1.5;
//			break;
//		case "�븮":
//			this.hourPay = 8500 * 2;
//			break;
//		case "����":
//			this.hourPay = 8500 * 3;
//			break;
//		case "����":
//			this.hourPay = 8500 * 5;
//			break;
//		case "����":
//			this.hourPay = 8500 * 10;
//			break;
//		default:
//			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
//			break;
//		}
	}

	public double gethourPay() {
		return hourPay;
	}

	//�߰��ٹ��� �ʰ��ٹ� �ñ��� 1.5��
	public void setNightPay(double hourPay) {
		this.nightPay = hourPay * 1.5;
	}

	public double getNightPay() {
		return nightPay;
	}

	public double getTotal() {
		totalPay = Math.round(this.basePay + this.gradePay + this.nightPay * nightHour + this.hourPay * overHour);
		return totalPay;
	}
	
	public double getTax() {
		tax = CalTax(totalPay);
		return tax;
	}
	
	//���������� ���� �޿��� ������ִ� �κ�
	public double getRealPay() {
		this.setBasePay(basePay);
		this.setGradePay();
		this.setNightPay(hourPay);
		this.sethourPay();
		
		this.realPay = totalPay - tax;
		return realPay;
	}

	//���� ����� �� �ߺ��Ǵ� ������ ������ �Լ�
	//���ο���(4.5%),�ǰ�����(3.23),�����(8.51),��뺸��(0.65)
	public double minusTax(double month_pay) {
		month_pay = (month_pay*0.045) + ((month_pay*0.0323)*1.0851)
				+ (month_pay*0.0065);
		return month_pay;
	}

	//�������� ���
	public double CalTax(double month_pay) {
		double pay = 0;
		//���� �鸸�� ���ϴ� �ҵ漼�� ���� ����
		if(month_pay<1000000) {
			pay = minusTax(month_pay);
		}
		//�ҵ漼 0.005
		else if (month_pay >= 1000000 && month_pay <=1500000) {
			pay = minusTax(month_pay) + 1.1*(month_pay*0.005); 
		}
		//�ҵ漼 0.03
		else if (month_pay >= 1500000 && month_pay <=3000000) {
			pay = minusTax(month_pay) + 1.1*(month_pay*0.03);
		}
		//�ҵ漼 0.06
		else if (month_pay >= 3000000 && month_pay <=5000000) {
			pay = minusTax(month_pay) + 1.1*(month_pay*0.06);
		}
		//�ҵ漼 0.015
		else if (month_pay >= 5000000 && month_pay <= 10000000) {
			pay = minusTax(month_pay) + 1.1*(month_pay*0.15);
		}
		//�ҵ漼 0.025
		else {
			pay = minusTax(month_pay) + 1.1*(month_pay*0.25);
		}

		return Math.round(pay);
	}

}
