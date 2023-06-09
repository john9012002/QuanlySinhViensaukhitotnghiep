public abstract class Student {
    protected String fullName;
    protected String doB;
    protected String sex;
    protected String phoneNumber;
    protected String universityName;

    public Student(String fullName, String doB, String sex, String phoneNumber, String universityName) {
        this.fullName = fullName;
        this.doB = doB;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.universityName = universityName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public abstract void showMyInfo();

}

