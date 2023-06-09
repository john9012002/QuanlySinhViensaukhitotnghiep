public class GoodStudent extends Student {
    private double gpa;
    private String bestRewardName;

    public GoodStudent(String fullName, String doB, String sex, String phoneNumber, String universityName, double gpa, String bestRewardName) {
        super(fullName, doB, sex, phoneNumber, universityName);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public double getGpa() {
        return gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    @Override
    public void showMyInfo() {
        System.out.println("Full name: " + fullName);
        System.out.println("Date of birth: " + doB);
        System.out.println("Sex: " + sex);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("University name: " + universityName);
        System.out.println("Grade level: GoodStudent");
        System.out.println("GPA: " + gpa);
        System.out.println("Best reward name: " + bestRewardName);
    }

}