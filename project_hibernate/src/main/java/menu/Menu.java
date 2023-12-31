package menu;

import entity.*;
import entity.enumuration.*;
import lombok.ToString;
import util.ApplicationContext;
import util.DatesApp;
import validation.RegexValidation;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import static menu.RegisterOrRefundMenu.registerOrRefund;
import static menu.SignInMenu.signup;
import static validation.RegexValidation.validateDate;

@SuppressWarnings("unused")
@ToString
public class Menu {
    public static Optional<Student> optionalStudent;
    public static final Scanner scanner = new Scanner(System.in);

    public static void firstMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*************************************************************");
        System.out.println("|                WELCOME TO HIBERNATE-PROJECT                 |");
        System.out.println("*************************************************************\n");
        System.out.println("1- Sign in");
        System.out.println("2- Sign up");
        System.out.println("3- Exit\n");
        System.out.println("Enter your select:");
        try {
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> signIn();
                case 2 -> signup();
                case 3 -> {
                    System.out.println("exit");
                    break;
                }
                default -> System.out.println("---Eror404---");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("!!!WRONG!!!");
        }


    }


//////////////////////////////////////////////////sign in start/////////////////////////////////////////////////////////

    public static void signIn() throws SQLException {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("enter username :");
            String username = scanner.next();

            System.out.println("enter password :");
            String password = scanner.next();

            optionalStudent = ApplicationContext.getStudentServiceImpl().login(username, password);


            if (optionalStudent.isPresent()) {
                registerOrRefund();
                isTrue = false;
            } else {
                System.out.println("username and password UnCorrect !!!!\n");
                System.out.println("Please Again ... ");
                firstMenu();

            }

        }
    }
//////////////////////////////////////////////////register is start///////////////////////////////////////////////////////


    public static void showRepaymentOptions() {
        System.out.println("Repayment Options:");
        System.out.println("1. Installments that paid in past");
        System.out.println("2. Unpaid Installments");
        System.out.println("3. Pay Installment");
        Integer input = scanner.nextInt();
        scanner.nextLine();

        switch (input) {
            case 1 -> paidInstallments();
            case 2 -> unPaidInstallments();
            case 3 -> payInstallments();
            default -> System.out.println("---Error404---");

        }
    }

    public static void payInstallments() {

        System.out.println("please enter the payNumber:");
        int payNumber = scanner.nextInt();
        scanner.nextLine();

        if (optionalStudent.isPresent()) {
            Integer id = optionalStudent.get().getId();

            ApplicationContext.getInstallmentService().payInstallments(payNumber, id);
            System.out.println("you pay installemnt with the payNumber :" + payNumber);
            registerOrRefund();
        }
    }
    public static void paidInstallments() {

        if (optionalStudent.isPresent()) {
            Integer id = optionalStudent.get().getId();
            ApplicationContext.getInstallmentService().paidInstallments(id).forEach(System.out::println);
            registerOrRefund();
        }
    }


    public static void unPaidInstallments() {
        if (optionalStudent.isPresent()) {
            Integer id = optionalStudent.get().getId();
            ApplicationContext.getInstallmentService().unpaidInstallments(id).forEach(System.out::println);
            registerOrRefund();

        }
    }

    //////////////////////////////////////////////////validation is start/////////////////////////////////////////////////////////
    //////////////////////////////////////////////////validation is start/////////////////////////////////////////////////////////

    //////////////////////////////////////////////////validation is start/////////////////////////////////////////////////////////
    //////////////////////////////////////////////////validation is start/////////////////////////////////////////////////////////


    public static String validationFirstName() {
        String firstname = null;
        boolean isTrue = true;
        while (isTrue) {
            firstname = scanner.nextLine();
            if (RegexValidation.validatonFirstname(firstname)) {
                isTrue = false;
            } else {
                System.out.println("put write word!!!!");
            }
        }
        return firstname;
    }

    public static String validationLastName() {
        String lastName = null;
        boolean isTrue = true;
        while (isTrue) {
            lastName = scanner.nextLine();
            if (RegexValidation.validatonLastname(lastName)) {
                isTrue = false;
            } else {
                System.out.println("put write word!!!!");
            }
        }
        return lastName;
    }

    public static String validationMotherName() {
        String motherName = null;
        boolean isTrue = true;
        while (isTrue) {
            motherName = scanner.nextLine();
            if (RegexValidation.validatonMothername(motherName)) {
                isTrue = false;
            } else {
                System.out.println("put write word!!!!");
            }
        }
        return motherName;
    }

    public static Integer validationShenasname() {
        Integer shenasname = null;
        boolean isTrue = true;
        while (isTrue) {
            shenasname = Integer.parseInt(scanner.next());
            if (RegexValidation.validationShenasnameNumber(shenasname)) {
                isTrue = false;
            } else {
                System.out.println("wrong number you put !!!!");
            }
        }
        return shenasname;
    }


    public static String validationNameOfUniversity() {
        String nameOfUniversity = null;
        boolean isTrue = true;
        while (isTrue) {
            nameOfUniversity = scanner.next();
            if (RegexValidation.validationNameOfUniversity(nameOfUniversity)) {
                isTrue = false;
            } else {
                System.out.println("put write word!!!!");
            }
        }
        return nameOfUniversity;
    }

    public static Integer validationNumberOfTerm() {
        Integer numberOfTerm = null;
        boolean isTrue = true;
        while (isTrue) {
            numberOfTerm = scanner.nextInt();
            if (RegexValidation.validationNumberOfTerm(numberOfTerm)) {
                isTrue = false;
            } else {
                System.out.println("wrong number you put !!!!");
            }
        }
        return numberOfTerm;
    }

    public static LocalDate validateEnterDate() {
        LocalDate enterDate = null;
        boolean isValid = false;
        while (!isValid) {
            String input = scanner.next();
            if (validateDate(input)) {
                enterDate = LocalDate.parse(input);
                isValid = true;
            } else {
                System.out.println("Wrong date format! Please enter a valid date (yyyy-MM-dd):");
            }
        }
        return enterDate;
    }

    public static String validationNumberOfCard() {
        String numberOfCard = null;
        boolean isTrue = true;
        while (isTrue) {
            numberOfCard = scanner.next();
            if (RegexValidation.validationNumberOfCard(numberOfCard)) {
                isTrue = false;
            } else {
                System.out.println("put write correct!!!!");
            }
        }
        return numberOfCard;
    }

    public static Integer validationNumberOfCvv2() {
        Integer cvv2 = null;
        boolean isTrue = true;
        while (isTrue) {
            cvv2 = scanner.nextInt();
            if (RegexValidation.validationNumberOfCvv2(cvv2)) {
                isTrue = false;
            } else {
                System.out.println("wrong number you put !!!!");
            }
        }
        return cvv2;
    }


}