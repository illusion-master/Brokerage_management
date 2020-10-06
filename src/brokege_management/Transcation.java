package brokege_management;
import java.util.Date;

public class Transcation {
	int invoice_no;
	int seller_no;
	int buyer_no;
	int item_no;
	float rate;
	float quantity;
	float commission_rate;
	float commission;
	Date date;
	public Transcation(int invoice_no, int seller_no, int buyer_no, int item_no, float rate,float quantity, float commission_rate) {
		super();
		this.invoice_no = invoice_no;
		this.seller_no = seller_no;
		this.buyer_no = buyer_no;
		this.item_no = item_no;
		this.rate = rate;
		this.quantity = quantity;
		this.commission_rate = commission_rate;
		this.date = new Date();
		this.commission = rate*quantity*commission_rate/100;
	}
	@Override
	public String toString() {
		return "Transcation [invoice_no=" + invoice_no + ", seller_no=" + seller_no + ", buyer_no=" + buyer_no
				+ ", item_no=" + item_no + ", rate=" + rate + ", quantity=" + quantity + ", commission_rate="
				+ commission_rate + ", commission=" + commission + ", date=" + date + "]";
	}
	
}
