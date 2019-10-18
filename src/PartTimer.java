/*
 * �˹� Ŭ����
 */



public class PartTimer extends People{
	private int hourPay;		//�ñ�
	private int workHour;		//�ٹ��ð�
	private int overHour;		//�ʰ� �ٹ��ð�
	private int nightHour;		//�߰� �ʰ� �ٹ��ð�
	
	private int holidayPay;		//���޼���
	private double totalPay;	//�� �޿�
	private double tax;			//����
	private double realPay;		//�Ǽ��ɾ�
	
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
	
	//���� ���
	public double PartTax(double partTotal) {
	      double pay = partTotal*0.0841;
	      return pay;
	}
}
