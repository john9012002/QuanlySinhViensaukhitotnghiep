

public class NormalStudent extends Student {
    private double englishScore;
    private double entryTestScore;

    public NormalStudent(String fullName, String doB, String sex, String phoneNumber, String universityName, double englishScore, double entryTestScore) {
        super(fullName, doB, sex, phoneNumber, universityName);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    @Override
    public void showMyInfo() {
        System.out.println("Full name: " + fullName);
        System.out.println("Date of birth: " + doB);
        System.out.println("Sex: " + sex);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("University name: " + universityName);
        System.out.println("Grade level: NormalStudent");
        System.out.println("English score: " + englishScore);
        System.out.println("Entry test score: " + entryTestScore);
    }

}