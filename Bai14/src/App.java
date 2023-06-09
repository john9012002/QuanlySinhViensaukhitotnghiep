import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        int numGoodStudents = 0;
        int numNormalStudents = 0;
        try {
            System.out.print("Enter number of students: ");
            int numStudents = scanner.nextInt();
            if (numStudents < 11 || numStudents > 15) {
                throw new Exception("Invalid number of students !!!");
            }
            for (int i = 0; i < numStudents; i++) {
                System.out.println("Enter student information:");
                System.out.print("Full name: ");
                scanner.nextLine();
                String fullName = scanner.nextLine();
                if (fullName.length() < 10 || fullName.length() > 50) {
                    throw new InvalidFullNameException("Full name must be between 10 and 50 characters !!!");
                }
                System.out.print("Date of birth (dd/mm/yyyy): ");
                String doB = scanner.nextLine();
                String[] parts = doB.split("/");
                if (parts.length != 3) {
                    throw new InvalidDOBException("Invalid date of birth format !!!");
                }
                System.out.print("Sex: ");
                String sex = scanner.nextLine();
                System.out.print("Phone number: ");
                String phoneNumber = scanner.nextLine();
                if (phoneNumber.length() != 10 || (!phoneNumber.startsWith("090") && !phoneNumber.startsWith("098")
                        && !phoneNumber.startsWith("091") && !phoneNumber.startsWith("031")
                        && !phoneNumber.startsWith("035") && !phoneNumber.startsWith("038"))) {
                    throw new InvalidPhoneNumberException("Invalid phone number !!!");
                }
                System.out.print("University name: ");
                String universityName = scanner.nextLine();
                System.out.print("Grade level (GoodStudent/NormalStudent): ");
                String gradeLevel = scanner.nextLine();
                if (gradeLevel.equals("GoodStudent")) {
                    System.out.print("GPA: ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Best reward name: ");
                    String bestRewardName = scanner.nextLine();
                    studentList.add(new GoodStudent(fullName, doB, sex, phoneNumber, universityName, gpa, bestRewardName));
                    numGoodStudents++;
                } else if (gradeLevel.equals("NormalStudent")) {
                    System.out.print("English score: ");
                    double englishScore = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Entry test score: ");
                    double entryTestScore = scanner.nextDouble();
                    scanner.nextLine();
                    studentList.add(new NormalStudent(fullName, doB, sex, phoneNumber, universityName, englishScore, entryTestScore));
                    numNormalStudents++;
                } else {
                    throw new Exception("Invalid grade level !!!");
                }
            }
            if (numGoodStudents >= numStudents) {
                System.out.println("All good students are recruited !!!");
            } else {
                int numRemainingStudents = numStudents - numGoodStudents;
                if (numGoodStudents > 0) {
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student s1, Student s2) {
                            if (s1 instanceof GoodStudent && s2 instanceof GoodStudent) {
                                GoodStudent g1 = (GoodStudent) s1;
                                GoodStudent g2 = (GoodStudent) s2;
                                if (g1.getGpa() == g2.getGpa()) {
                                    return g1.getFullName().compareTo(g2.getFullName());
                                } else {
                                    return Double.compare(g2.getGpa(), g1.getGpa());
                                }
                            } else if (s1 instanceof GoodStudent) {
                                return -1;
                            } else if (s2 instanceof GoodStudent) {
                                return 1;
                            } else {
                                NormalStudent n1 = (NormalStudent) s1;
                                NormalStudent n2 = (NormalStudent) s2;
                                if (n1.getEntryTestScore() == n2.getEntryTestScore()) {
                                    if (n1.getEnglishScore() == n2.getEnglishScore()) {
                                        return n1.getFullName().compareTo(n2.getFullName());
                                    } else {
                                        return Double.compare(n2.getEnglishScore(), n1.getEnglishScore());
                                    }
                                } else {
                                    return Double.compare(n2.getEntryTestScore(), n1.getEntryTestScore());
                                }
                            }
                        }
                    });
                }
                System.out.println("Selected students:");
                for (int i = 0; i < Math.min(numRemainingStudents, studentList.size()); i++) {
                    System.out.println(studentList.get(i).getFullName() + " - " + studentList.get(i).getPhoneNumber());
                }
            }
        } catch (InvalidFullNameException | InvalidDOBException | InvalidPhoneNumberException e1) {
            System.out.println(e1.getMessage());
        } catch (Exception e2) {
            System.out.println("Input files have unknown errors !!!");
        }
    }

}
