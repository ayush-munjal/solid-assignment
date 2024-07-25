package net.media.training.live.srp;


public class Employee {
    private int empId;
    private static int TOTAL_LEAVES_ALLOWED = 30;

    private double monthlySalary;
    private String name;
    private String addressStreet;
    private String addressCity;
    private String addressCountry;
    private int leavesTaken;
    private int totalLeaveAllowed;
    private int leaveTaken;
    private String manager;
    private int yearsInOrg;
    private int thisYeard;
    private int[] leavesLeftPreviously;


    public Employee(int empId, double monthlySalary, String name, String addressStreet, String addressCity, String addressCountry, int leavesTaken, int[] leavesLeftPreviously) {
        this.empId = empId;
        this.monthlySalary = monthlySalary;
        this.name = name;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressCountry = addressCountry;
        this.leavesTaken = leavesTaken;
        this.leavesLeftPreviously = leavesLeftPreviously;
        this.yearsInOrg = leavesLeftPreviously.length;
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

    private int numYears(){
        // added the code for number of years in this function
        int years = 3;
        if (yearsInOrg < 3) {
            years = yearsInOrg;
        }
        return years;
    }

    private String prevLeaves(String str, int years){
        // added the code for prevLeaves in this function
        int totalLeaveLeftPreviously = 0;
        for (int i = 0; i < years; i++) {
            totalLeaveLeftPreviously += leavesLeftPreviously[yearsInOrg-i-1];
        }
        str += "<span>" + totalLeaveLeftPreviously + "</span>";
        return str + "</div> </div>";
    }

    public String toHtml() {

        String str = OrigString();
        str = isManager(str);
        int years = numYears();
        return prevLeaves(str, years);

    }
    //other method related to customer
}
