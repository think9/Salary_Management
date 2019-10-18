/*
 * 직원 클래스
 */



public class Worker extends People{
	private double basePay; //기본급(월급)
	private double gradePay; // 직급 별 인센티브
	private double hourPay; // 시급
	private int overHour;	//초과 근무 시간
	private double nightPay; // 초과근무 수당
	private int nightHour;	//초과 야간 근무 시간
	
	private double totalPay;	//총급여
	private double tax;			//세금
	private double realPay; //실급여 (실제지급액)


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

	//월급을 세팅한다.
	public void setBasePay(double month_pay) {
		this.basePay = month_pay;
	}

	public double getBasePay() {
		return basePay;
	}

	// 인센티브 = 기본급*퍼센트  알바 0% 사원 15%   대리 30%    과장 40%   차장 50%   부장 60%
	public void setGradePay() { 
		String position = super.getRank(); //getPosition() 직책 받아오기\
		switch(position) {
		case "알바":
			this.gradePay = (int)(this.basePay*0.00);
			break;
		case "사원":
			this.gradePay = (int)(this.basePay*0.15);
			break;
		case "대리":
			this.gradePay = (int)(this.basePay*0.30);
			break;
		case "과장":
			this.gradePay = (int)(this.basePay*0.40);
			break;
		case "차장":
			this.gradePay = (int)(this.basePay*0.50);
			break;
		case "부장":
			this.gradePay = (int)(this.basePay*0.60);
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");   
			break;
		}
	}

	public double getGradePay() {
		return gradePay;
	}

	//추가 근무 시급 설정
	public void sethourPay() {
//		String position = super.getRank(); //getPosition() 직책 받아오기\
//		switch(position) {
//		case "알바":
//			this.hourPay = 8500;
//			break;
//		case "사원":
//			this.hourPay = 8500 * 1.5;
//			break;
//		case "대리":
//			this.hourPay = 8500 * 2;
//			break;
//		case "과장":
//			this.hourPay = 8500 * 3;
//			break;
//		case "차장":
//			this.hourPay = 8500 * 5;
//			break;
//		case "부장":
//			this.hourPay = 8500 * 10;
//			break;
//		default:
//			System.out.println("잘못 입력하셨습니다.");
//			break;
//		}
	}

	public double gethourPay() {
		return hourPay;
	}

	//야간근무는 초과근무 시급의 1.5배
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
	
	//실질적으로 최종 급여를 계산해주는 부분
	public double getRealPay() {
		this.setBasePay(basePay);
		this.setGradePay();
		this.setNightPay(hourPay);
		this.sethourPay();
		
		this.realPay = totalPay - tax;
		return realPay;
	}

	//세금 계산할 때 중복되는 연산을 정의한 함수
	//국민연금(4.5%),건강보험(3.23),장기요양(8.51),고용보험(0.65)
	public double minusTax(double month_pay) {
		month_pay = (month_pay*0.045) + ((month_pay*0.0323)*1.0851)
				+ (month_pay*0.0065);
		return month_pay;
	}

	//월급으로 계산
	public double CalTax(double month_pay) {
		double pay = 0;
		//월급 백만원 이하는 소득세를 받지 않음
		if(month_pay<1000000) {
			pay = minusTax(month_pay);
		}
		//소득세 0.005
		else if (month_pay >= 1000000 && month_pay <=1500000) {
			pay = minusTax(month_pay) + 1.1*(month_pay*0.005); 
		}
		//소득세 0.03
		else if (month_pay >= 1500000 && month_pay <=3000000) {
			pay = minusTax(month_pay) + 1.1*(month_pay*0.03);
		}
		//소득세 0.06
		else if (month_pay >= 3000000 && month_pay <=5000000) {
			pay = minusTax(month_pay) + 1.1*(month_pay*0.06);
		}
		//소득세 0.015
		else if (month_pay >= 5000000 && month_pay <= 10000000) {
			pay = minusTax(month_pay) + 1.1*(month_pay*0.15);
		}
		//소득세 0.025
		else {
			pay = minusTax(month_pay) + 1.1*(month_pay*0.25);
		}

		return Math.round(pay);
	}

}
