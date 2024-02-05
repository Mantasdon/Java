package com.debts;
import java.text.DecimalFormat;
public class Linear extends Debt {

    public Linear(String sum, String period, String rate)
    {
        super(sum, period, rate);
        calculatePayment();
        paymentByMonth = new double[this.paymentPeriod];
        setPaymentArray();
    }


    public void calculatePayment()
    {
        this.payment = this.amount * (this.interestRate/100 /this.paymentPeriod);
        DecimalFormat df = new DecimalFormat("#.##");
        this.payment = Double.valueOf(df.format(this.payment));
    }
    public void setPaymentArray() {
        for (int i = 0; i < paymentByMonth.length; i++) {
            if (i == 0) {
                paymentByMonth[0] = this.amount - this.payment;
            } else {
                paymentByMonth[i] = paymentByMonth[i - 1] - this.payment;
            }
        }
    }
    public double getPaymentArray(int i)
    {
        return paymentByMonth[i];
    }


}
