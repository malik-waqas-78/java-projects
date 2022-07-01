package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {
    public static ArrayList<Person> users=new ArrayList<>();
    public static ArrayList<Meeting> allMeetings=new ArrayList<>();

    public static Scanner scan=new Scanner(System.in);

    public static Person loggedInPerson;
    public static boolean isLoggedIn=false;
    public static int indexOfPersonLoggedIn=-1;

    public static boolean isLoopActive=true;

    public static void main(String[] args) {

        System.out.println("Create a list of users, -1 to continue with menu");
        while(true){
            System.out.println("Enter username:");
            String name=scan.nextLine();
            if(name.equals("-1")){
                break;
            }else if(!name.trim().isEmpty()){
                users.add(new Person(users.size()+1,name));
            }else{
                System.out.println("Not a valid name.");
            }

        }

        displayMenu();

    }

    private static void displayMenu() {
        while (isLoopActive){
            System.out.println(getMenu());
            int choice= Integer.parseInt(scan.nextLine());
            System.out.println("Your choice: "+choice);
            switch (choice){
                case 0:
                    if(isLoggedIn){
                        System.out.println(loggedInPerson.getName()+" is already logged in.");
                    }else{
                        login();
                    }
                break;
                case 1:
                    if(isLoggedIn){
                        createAndHostNewMeeting();
                    }else{
                        showErrorMessage();
                    }
                    break;
                case 2:
                    if(isLoggedIn){
                        cancelMeeting();
                    }else{
                        showErrorMessage();
                    }
                    break;
                case 3:
                    if(isLoggedIn){
                        attendMeeting();
                    }else{
                        showErrorMessage();
                    }
                    break;
                case 4:
                    if(isLoggedIn){
                        leaveMeeting();
                    }else{
                        showErrorMessage();
                    }
                    break;
                case 5:
                    if(isLoggedIn){
                        displayMyMeetings();
                    }else{
                        showErrorMessage();
                    }
                    break;
                case 6:
                    if(isLoggedIn){
                        displayMeetingsOrganizedByMe();
                    }else{
                        showErrorMessage();
                    }
                    break;
                case 7:
                    if(isLoggedIn){
                        logout();
                    }else{
                        showErrorMessage();
                    }
                    break;
                case 8:
                    if(!isLoggedIn){
                        isLoopActive=false;
                    }else{
                        System.out.println("You need to loggedOut inorder to exit.");
                    }

                    break;
                default:
                    System.out.println("Wrong input.");
            }
        }
    }

    private static void showErrorMessage() {
        System.out.println("You need to login first");
    }

    private static void leaveMeeting() {
        if(loggedInPerson.getMyMeetings().size()>0){
            for(Meeting meeting:loggedInPerson.getMyMeetings()){
                System.out.println(meeting.getFormattedMeeting());
            }
            System.out.print("Enter name of the meeting you want to leave: ");
            String name= scan.nextLine();
            Meeting meeting=getMeetingNamed(name,loggedInPerson.getMyMeetings());
            if(meeting!=null){
                meeting.removeAttendee(loggedInPerson);
                loggedInPerson.removeMeeting(meeting);
            }else{
                System.out.println("There is no meeting named "+name);
            }
        }else{
            System.out.println("There are no meetings available.");
        }
    }

    private static void displayMyMeetings() {
        loggedInPerson.displayMyMeetings();
    }

    private static void displayMeetingsOrganizedByMe() {
        loggedInPerson.displayMyOrganizations();
    }

    private static void logout() {
        users.remove(indexOfPersonLoggedIn);
        users.add(loggedInPerson);
        loggedInPerson=null;
        indexOfPersonLoggedIn=-1;
        isLoggedIn=false;
        System.out.println("Successfully Logged Out.");
    }

    private static void exit() {

    }

    private static void attendMeeting() {
        if(allMeetings.size()>0){
            int countMeetingsNOtHostedByUser=0;
            for(Meeting meeting:allMeetings){
                if(!meeting.getHost().equals(loggedInPerson)){
                    countMeetingsNOtHostedByUser++;
                    System.out.println(meeting.getFormattedMeeting());
                }
            }
            if(countMeetingsNOtHostedByUser==0){
                System.out.println("No meeting available to join.");
                return;
            }
            System.out.print("Enter name of the meeting to attend: ");
            String name= scan.nextLine();
            Meeting meeting=getMeetingNamed(name,allMeetings);
            if(meeting!=null){
                meeting.addAttendee(loggedInPerson);
            }else{
                System.out.println("There is no meeting named "+name);
            }
        }else{
            System.out.println("There are no meetings available to attend.");
        }
    }

    private static Meeting getMeetingNamed(String name,ArrayList<Meeting> arr) {
        for(Meeting meeting:arr){
            if(meeting.getName().equalsIgnoreCase(name)){
                return meeting;
            }
        }
        return null;
    }

    private static void cancelMeeting() {
        if(loggedInPerson.getiOrganize().size()>0) {
            loggedInPerson.displayFormattedOrganizations();
            System.out.print("Enter name of the meeting to cancel: ");
            String name = scan.nextLine();
            Meeting meeting=getMeetingNamed(name,loggedInPerson.getiOrganize());
            if(meeting==null){
                System.out.println("You don't host any meeting named "+name);
            }else{
                loggedInPerson.cancelMeeting(meeting);
            }
        }else{
            System.out.println("You haven't organized any meeting yet.");
        }
    }

    private static void createAndHostNewMeeting() {
        System.out.print("Enter name of the meeting: ");
        String name =scan.nextLine();
        System.out.println("Enter date of the meeting: dd/mm/yyyy");
        String dateString=scan.nextLine();
        MDate date=new MDate(dateString);
        Meeting meeting=new Meeting(name,date,loggedInPerson,true,"http://www.meetingroom.com");
        loggedInPerson.organizeMeeting(meeting);
        allMeetings.add(meeting);
        System.out.println(meeting.getFormattedMeeting()+" created successfully.");
    }

    private static void login() {
        System.out.print("Enter Name to Login: ");
        String name= scan.nextLine();
        for(Person person:users){
            if(person.getName().equalsIgnoreCase(name)){
                loggedInPerson=person;
                isLoggedIn=true;
                indexOfPersonLoggedIn=users.indexOf(person);
                System.out.println(name+" have been successfully logged in.");
                break;
            }
        }
        if(!isLoggedIn){
            System.out.println("This user doesn't exist.");
        }
    }

    private static String getMenu() {
        return "0. Login\n"+
        "1. Create/Host new Meeting\n"+
        "2. Cancel a meeting\n"+
        "3. Attend an existing meeting\n"+
        "4. Leave a meeting\n"+
        "5. Display My Meetings\n"+
        "6. Display Meetings organized by me\n"+
        "7. Logout\n"+
        "8. Exit";
    }
}
