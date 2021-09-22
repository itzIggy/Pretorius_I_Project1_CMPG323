package za.ac.nwu.ac.domain.persistence;

public class AccountMember {

    public String memberFName;
    public String memberLName;
    public String memberEmail;
    public String memberPhone;

    public AccountMember(){}

    public AccountMember(String memberFName, String memberLName, String memberEmail, String memberPhone){
        this.memberFName = memberFName;
        this.memberLName = memberLName;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
    }
}
