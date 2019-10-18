/*
 * 알바 클래스
 */



public class PartTimer extends People{
	private int hourPay;		//시급
	private int workHour;		//근무시간
	private int overHour;		//초과 근무시간
	private int nightHour;		//야간 초과 근무시간
	
	private int holidayPay;		//주휴수당
	private double totalPay;	//총 급여
	private double tax;			//세금
	private double realPay;		//실수령액
	
	public PartTimer() {
		
	}
	
	public PartTimer(int hourPay, int workHour, int overHour, int nightHour) {
		this.hourPay = hourPay;
		this.workHour = workHour;
		this.overHour = overHour;
		this.nightHour = nightHour;
	}
	
	public void setHourPay(int hourPay) {
		this.hourPay = hourPay;
	}
	
	public void setWorkHour(int workHour) {
		this.workHour = workHour;
	}
	
	public void setOverHour(int overHour) {
		this.overHour = overHour;
	}
	
	public void setNightHour(int nightHour) {
		this.nightHour = nightHour;
	}

	public void setHolidayPay() {
		holidayPay = workHour / 40 * 8 * hourPay; 
	}
	
	public void setTotalPay() {
		totalPay = hourPay * (workHour + overHour) + hourPay * 1.5 * nightHour + holidayPay;
	}
	
	public double getTotalPay() {
		setTotalPay();
		return Math.round(totalPay);
	}
	
	public void setTax() {
		tax = PartTax(totalPay);
	}
	
	public double getTax() {
		setTax();
		return Math.round(tax);
	}
	
	public void setRealPay() {
		realPay = totalPay - tax;
	}
	
	public double getRealPay() {
		setRealPay();
		return realPay;
	}
	
	//세금 계산
	public double PartTax(double partTotal) {
	      double pay = partTotal*0.0841;
	      return pay;
	}
}
