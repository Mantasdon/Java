package com.debts;


import java.text.DecimalFormat;

import static java.lang.Math.pow;

public class Annuity extends Linear {
    public Annuity(String sum, String period, String rate)
    {
        super(sum, period, rate);
    }
    public void calculatePayment()
    {
        this.payment = ((this.interestRate/100) * this.amount) / (pow((1 - (this.interestRate/100)), this.paymentPeriod * (-1)));
        DecimalFormat df = new DecimalFormat("#.##");
        this.payment = Double.valueOf(df.format(this.payment));
    }
}
