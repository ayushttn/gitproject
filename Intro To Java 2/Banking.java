package IntroToJava2;
import java.io.*;
import java.lang.annotation.ElementType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
enum acc_type{
    SAVINGS("Savings"),
    CURRENT("Current");
    public final String value;
    private acc_type(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
};
abstract class Bank{
    int Balance = 0;
    abstract void printDetails();
    abstract void getDetails();
    public String getDateandTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    public boolean Withdrawamount(int amt) throws Exception {
            if((Balance - amt > 0)){
                return true;
            }
            else {
                return false;
            }
    }
}
class SBI extends Bank{
    public void printDetails(){
        System.out.println("State Bank Of India \nCustomer Care Number: 1800-425-3800");
    }
    public void getDetails(){
        System.out.println("Rate of Interest on Savings Account is 2.75% \nRate of Interest on Current Account is 0% \nRate of Interest on Fixed Deposit is 5.20%");
    }
    public SBI(){
        this.Balance = 5000;
    }
}
class BOI extends Bank{
    public void printDetails(){
        System.out.println("Bank of India \nCustomer Care Number: 1800-103-1906");
    }
    public void getDetails(){
        System.out.println("Rate of Interest on Savings Account is 2.90% \nRate of Interest on Current Account is 0% \nRate of Interest on Fixed Deposit is 5%");
    }
    public BOI(){
        this.Balance = 10000;
    }
}
class ICICI extends Bank{
    public void printDetails(){
        System.out.println("ICICI Bank Limited \nCustomer Care Number:1860-120-7777");
    }
    public void getDetails(){
        System.out.println("Rate of Interest on Savings Account is 3% \nRate of Interest on Current Account is 0% \nRate of Interest on Fixed Deposit is 5%");
    }
    public ICICI(){
        this.Balance = 15000;
    }
}
public class Banking {
    public static void main(String[] args) throws Exception {
        SBI sbi = new SBI();
        BOI boi = new BOI();
        ICICI icici = new ICICI();
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Bank: \n1.SBI \n2.BOI \n3.ICICI");
        int bankop = sc.nextInt();
        System.out.println("Enter your choice: \n1.Bank Details \n2. Print Rate of Interest \n3.Transact");
        int opt = sc.nextInt();
        switch (opt){
            case 1: switch (bankop){
                case 1: sbi.printDetails();
                break;
                case 2: boi.printDetails();
                break;
                case 3: icici.printDetails();
                break;
            }
            break;
            case 2: switch (bankop){
                case 1: sbi.getDetails();
                break;
                case 2: boi.getDetails();
                break;
                case 3: icici.getDetails();
                break;
            }
            break;
            case 3:
                if(bankop == 1){
                    System.out.println("Enter Acc no:");
                    long acc_no = sc.nextInt();
                    System.out.println("Account type: \n1.Current \n2.Savings");
                    int ac_ty = sc.nextInt();
                    String Acc_ty = "";
                    if (ac_ty == 1) {
                        acc_type acct = acc_type.CURRENT;
                        Acc_ty = acc_type.CURRENT.getValue();
                    } else if (ac_ty == 2) {
                        acc_type acct = acc_type.SAVINGS;
                        Acc_ty = acc_type.SAVINGS.getValue();
                    }
                    System.out.println("1.Deposit \t2.Withdraw");
                    int oper = sc.nextInt();
                    System.out.println("Enter Amount");
                    int amount = sc.nextInt();
                    int amt_af_op = 0;
                    String Status = "";
                    if (oper == 1) {
                        amt_af_op = sbi.Balance + amount;
                        String tran_status = "Success";
                        Status = tran_status;
                    } else if (oper == 2) {
                        if (sbi.Withdrawamount(amount)) {
                            amt_af_op = sbi.Balance - amount;
                        } else {
                            String tran_status = "InsufficientBalance";
                            Status = tran_status;
                        }
                    }
                    //String file_name = "SBI_" + Long.toString(acc_no);
                    BufferedWriter br = new BufferedWriter(new FileWriter("SBI",true));
                    br.append("Date and Time:" + sbi.getDateandTime() + "\n");
                    br.append("Account Number:" + Long.toString(acc_no) + "\n");
                    br.append("Account Type:" + Acc_ty + "\n");
                    br.append("Amount to be Deposited or Withdraw" + Integer.toString(amount) + "\n");
                    br.append("Amount before Transaction" +Integer.toString(sbi.Balance) + "\n");
                    br.append("Amount after Transaction is:" + Integer.toString(amt_af_op) + "\n");
                    br.append("Transaction Status:" + Status + "\n");
                    if(Status.equals("InsufficientBalance")){
                        br.append("Amount is not sufficient for this transaction\n");
                        br.close();
                        throw new Exception("InsufficientBalanceException");
                    }
                    br.close();
                    break;
                }
                else if(bankop == 2){
                    System.out.println("Enter Acc no:");
                    long acc_no = sc.nextInt();
                    System.out.println("Account type: \n1.Current \n2.Savings");
                    int ac_ty = sc.nextInt();
                    String Acc_ty = "";
                    if (ac_ty == 1) {
                        acc_type acct = acc_type.CURRENT;
                        Acc_ty = acc_type.CURRENT.getValue();
                    } else if (ac_ty == 2) {
                        acc_type acct = acc_type.SAVINGS;
                        Acc_ty = acc_type.SAVINGS.getValue();
                    }
                    System.out.println("1.Deposit \t2.Withdraw");
                    int oper = sc.nextInt();
                    System.out.println("Enter Amount");
                    int amount = sc.nextInt();
                    int amt_af_op = 0;
                    String Status = "";
                    if (oper == 1) {
                        amt_af_op = boi.Balance + amount;
                        String tran_status = "Success";
                        Status = tran_status;
                    } else if (oper == 2) {
                        if (boi.Withdrawamount(amount)) {
                            amt_af_op = boi.Balance - amount;
                        } else {
                            String tran_status = "InsufficientBalance";
                            Status = tran_status;
                        }
                    }
                    //String file_name = "BOI_" + Long.toString(acc_no);
                    BufferedWriter br = new BufferedWriter(new FileWriter("BOI", true));
                    br.append("Date and Time:" + boi.getDateandTime() + "\n");
                    br.append("Account Number:" + Long.toString(acc_no) + "\n");
                    br.append("Account Type:" + Acc_ty + "\n");
                    br.append("Amount to be Deposited or Withdraw" + Integer.toString(amount) + "\n");
                    br.append("Amount before Transaction" +Integer.toString(boi.Balance) + "\n");
                    br.append("Amount after Transaction is:" + Integer.toString(amt_af_op) + "\n");
                    br.append("Transaction Status:" + Status + "\n");
                    if(Status.equals("InsufficientBalance")){
                        br.append("Amount is not sufficient for this transaction\n");
                        br.close();
                        throw new Exception("InsufficientBalanceException");
                    }
                    br.close();
                    break;
                }
                else if(bankop == 3){
                    System.out.println("Enter Acc no:");
                    long acc_no = sc.nextInt();
                    System.out.println("Account type: \n1.Current \n2.Savings");
                    int ac_ty = sc.nextInt();
                    String Acc_ty = "";
                    if (ac_ty == 1) {
                        acc_type acct = acc_type.CURRENT;
                        Acc_ty = acc_type.CURRENT.getValue();
                    } else if (ac_ty == 2) {
                        acc_type acct = acc_type.SAVINGS;
                        Acc_ty = acc_type.SAVINGS.getValue();
                    }
                    System.out.println("1.Deposit \t2.Withdraw");
                    int oper = sc.nextInt();
                    System.out.println("Enter Amount");
                    int amount = sc.nextInt();
                    int amt_af_op = 0;
                    String Status = "";
                    if (oper == 1) {
                        amt_af_op = icici.Balance + amount;
                        String tran_status = "Success";
                        Status = tran_status;
                    } else if (oper == 2) {
                        if (icici.Withdrawamount(amount)) {
                            amt_af_op = icici.Balance - amount;
                        } else {
                            String tran_status = "InsufficientBalance";
                            Status = tran_status;
                        }
                    }
                    //String file_name = "ICICI_" + Long.toString(acc_no);
                    BufferedWriter br = new BufferedWriter(new FileWriter("ICICI",true));
                    br.append("Date and Time:" + icici.getDateandTime() + "\n");
                    br.append("Account Number:" + Long.toString(acc_no) + "\n");
                    br.append("Account Type:" + Acc_ty +"\n");
                    br.append("Amount to be Deposited or Withdraw" + Integer.toString(amount) + "\n");
                    br.append("Amount before Transaction" +Integer.toString(icici.Balance) + "\n");
                    br.append("Amount after Transaction is:" + Integer.toString(amt_af_op) + "\n");
                    br.append("Transaction Status:" + Status + "\n");
                    if(Status.equals("InsufficientBalance")){
                        br.append("Amount is not sufficient for this transaction\n");
                        br.close();
                        throw new Exception("InsufficientBalanceException");
                    }
                    br.close();
                    break;
                }
        }

    }
}
