package com.debts;

public class Debt {
    protected float amount;
    protected int paymentPeriod;
    protected float interestRate;
    protected double[] paymentByMonth;
    protected double payment;
    public Debt(String sum, String period, String rate)
    {
        float sum1 = Float.parseFloat(sum);
        setAmount(sum1);
        int period1 = Integer.parseInt(period);
        setPeriod(period1);
        float rate1 = Float.parseFloat(rate);
        setRate(rate1);
    }
    public void setAmount(float sum)
    {
        this.amount = sum;
    }
    public float getAmount()
    {
        return this.amount;
    }

    public void setPeriod(int paymentPeriod)
    {
        this.paymentPeriod = paymentPeriod;
    }
    public int getPeriod()
    {
        return this.paymentPeriod;
    }

    public void setRate(float interestRate)
    {
        this.interestRate = interestRate;
    }
    public float getRate()
    {
        return this.interestRate;
    }

    public double getPayment()
    {
        return this.payment;
    }
    public void setPaymentArray()
    {
        for(int i = 0; i < paymentByMonth.length; i++)
        {
            if(i == 0)
            {
                paymentByMonth[0] = this.amount - this.payment;
            }
            else
            {
                paymentByMonth[i] = paymentByMonth[i-1] - this.payment;
            }
        }

    }
}
