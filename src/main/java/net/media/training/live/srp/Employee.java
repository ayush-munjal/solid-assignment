package net.media.training.live.srp;
// create a print function separetly 


class Leaves{
    // created a new class for calculating the number of leaves left
    private int yearsInOrg;
    private int[] leavesLeftPreviously;

    public Leaves(){

    }

    public Leaves(int yearsInOrg, int[] leavesLeftPreviously){
        this.yearsInOrg = yearsInOrg;
        this.leavesLeftPreviously = leavesLeftPreviously;
    }

    private int numYears(){
        // added the code for number of years in this function
        int years = 3;
        if (yearsInOrg < 3) {
            years = yearsInOrg;
        }
        return years;
    }

    public int prevLeavesLeft(){
        // added the code for prevLeaves in this function
        int years = numYears();
        int totalLeaveLeftPreviously = 0;
        for (int i = 0; i < years; i++) {
            totalLeaveLeftPreviously += leavesLeftPreviously[yearsInOrg-i-1];
        }
        return totalLeaveLeftPreviously;
    }

}


class address{
    private String addressStreet;
    private String addressCity;
    private String addressCountry;
    
    public address(){

    }

    public address(String addressStreet, String addressCity, String addressCountry){
        this.addressCity = addressCity;
        this.addressCountry = addressCountry;
        this.addressStreet = addressStreet;
    }
}


public class Employee {
    private int empId;
    private static int TOTAL_LEAVES_ALLOWED = 30;

    private double monthlySalary;
    private String name;
    
    private int leavesTaken;
    private int totalLeaveAllowed;
    private int leaveTaken;
    private String manager;
    private int yearsInOrg;
    private int thisYeard;
    private int[] leavesLeftPreviously;

    private Leaves leavesLeft;
    private address Address;

    public Employee(int empId, double monthlySalary, String name, String addressStreet, String addressCity, String addressCountry, int leavesTaken, int[] leavesLeftPreviously) {
        this.empId = empId;
        this.monthlySalary = monthlySalary;
        this.name = name;
        this.Address = new address(addressStreet, addressCity,addressCountry);
        this.leavesTaken = leavesTaken;
        this.leavesLeftPreviously = leavesLeftPreviously;
        this.yearsInOrg = leavesLeftPreviously.length;
        this.leavesLeft = new Leaves(yearsInOrg, leavesLeftPreviously);
    }

    public Employee() {
    }

    private String OrigString(){
        // added the code for original string in this function
        String str = "<div>" +
                "<h1>Employee Info</h1>" +
                "<div id='emp" + empId + "'>" +
                "<span>" + name + "</span>" +
                "<div class='left'>" +
                "<span>Leave Left :</span>" +
                "<span>Annual Salary:</span>" +
                "<span>Manager:</span>" +
                "<span>Reimbursable Leave:</span>" +
                "</div>";
        str += "<div class='right'><span>" + (totalLeaveAllowed - leaveTaken) + "</span>";
        str += "<span>" + Math.round(monthlySalary * 12) + "</span>";
        return str;
    }

    private String isManager(String str){
        // added the code for manager string in this function
        if (manager != null) 
            str += "<span>" + manager + "</span>";
        else 
            str += "<span>None</span>";
        return str;
    }

    public String toHtml() {

        String str = OrigString();
        str = isManager(str);
        int numberOfleavesLeft = this.leavesLeft.prevLeavesLeft();
        str += "<span>" + numberOfleavesLeft + "</span>";
        return str + "</div> </div>";

    }
    //other method related to customer
}
