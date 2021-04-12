package com.ParamveerSingh_C0788065_a10;
import java.util.Scanner;

abstract class Employee implements InterfaceEmp{
    public abstract void calculateCommissionRate();
    public abstract void calculateCommission();
}

interface InterfaceEmp{
    public void calculateGrossPay();
    public abstract void showMonthEndPay();
}

class EmployeeSalary extends Employee implements InterfaceEmp{
    public double sales;
    private double commission;
    protected double grossPay;
    protected double commissionRate;
    double advance;

    public EmployeeSalary(double sales, double advance) {
        this.sales = sales;
        this.advance = advance;
    }

    public double getSales() {
        return sales;
    }

    public double getCommission() {
        return commission;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public double getAdvance() {
        return advance;
    }

    @Override
    public void calculateGrossPay() {
        grossPay = commission - advance;
    }

    @Override
    public void calculateCommission() {
        commission = commissionRate * sales / 100;
    }

    @Override
    public void showMonthEndPay() {
        System.out.println("Total Commission: $"+getCommission());
        if(getGrossPay() > 0)
        {
            System.out.println("Final Commission (after deducting advance pay): $" + grossPay);
        }
        else if(getGrossPay() < 0)
        {
            System.out.println("The sales person must reimburse  $" + (grossPay *- 1) + " back.");
        }
        else{
            System.out.println("Neither PayCheck nor Reimbursing");
        }
    }

    @Override
    public void calculateCommissionRate() {
        if(sales >=0 && sales < 10000)
        {
            commissionRate = 5.0;
        }
        else if(sales >= 10000 && sales <= 14999)
        {
            commissionRate = 10.0;
        }
        else if(sales >= 15000 && sales <= 17999)
        {
            commissionRate = 12.0;
        }
        else if(sales >= 18000 && sales <= 21999)
        {
            commissionRate = 15.0;
        }
        else if(sales >= 22000 )
        {
            commissionRate = 16.0;
        }
        else
        {
            System.out.println("Value of sales should not be negative. Please enter any positive value.");
            System.exit(1);
        }
    }
}

public class ParamveerSingh_C0788065_a10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the salesperson’s monthly sales: ");
        double sales = scanner.nextDouble();
        System.out.print("Enter the amount of advanced pay: ");
        double advance = scanner.nextDouble();
        EmployeeSalary employeeSalary = new EmployeeSalary(sales,advance);
        employeeSalary.calculateCommissionRate();
        employeeSalary.calculateCommission();
        employeeSalary.calculateGrossPay();
        employeeSalary.showMonthEndPay();
    }
}


