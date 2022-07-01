

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static ArrayList<Person> systemUsers = new ArrayList<>();
    public static ArrayList<Meeting> allMeetings = new ArrayList<>();

    public static Scanner scan = new Scanner(System.in);

    public static Person user;
    public static boolean isUserLoggedIn = false;
    public static int indexOfUserLoggedIn = -1;
    private static String menu="0. Login\n" +
            "1. Create/Host new Meeting\n" +
            "2. Cancel a meeting\n" +
            "3. Attend an existing meeting\n" +
            "4. Leave a meeting\n" +
            "5. Display My Meetings\n" +
            "6. Display Meetings organized by me\n" +
            "7. Logout\n" +
            "8. Exit";

    public static void main(String[] args) {

        System.out.println("Create a list of users, -1 to continue with menu");

        createUsers();

        showMenuToUser();

    }

    private static void createUsers() {

        System.out.println("Enter username:");
        String name = scan.nextLine();
        if (name.equals("-1")) {
            return;
        } else if (!name.trim().isEmpty()) {
            var id = systemUsers.size() + 1;
            systemUsers.add(new Person(id, name));
            createUsers();
        } else {
            System.out.println("Not a valid name.");
            createUsers();
        }

    }

    private static void showMenuToUser() {
        System.out.println(menu);
        int choice = Integer.parseInt(scan.nextLine());
        System.out.println("Your choice: " + choice);
        switch (choice) {
            case 0:
                if (isUserLoggedIn) {
                    System.out.println(user.getName() + " is already logged in.");
                } else {
                    String name=getStringFromUser("Enter Name to Login: ");
                    for (Person person : systemUsers) {
                        if (person.getName().equalsIgnoreCase(name)) {
                            user = person;
                            isUserLoggedIn = true;
                            indexOfUserLoggedIn = systemUsers.indexOf(person);
                            System.out.println(name + " have been successfully logged in.");
                            break;
                        }
                    }
                    if (!isUserLoggedIn) {
                        System.out.println("This user doesn't exist.");
                    }
                }
                showMenuToUser();
                break;
            case 1:
                if (isUserLoggedIn) {
                    String name = getStringFromUser("Enter name of the meeting: ");
                    System.out.println("Enter date of the meeting: dd/mm/yyyy");
                    String dateString = scan.nextLine();
                    MDate date = new MDate(dateString);
                    Meeting meeting = new Meeting(name, date, user, true, "http://www.zoom.com");
                    user.organizeMeeting(meeting);
                    allMeetings.add(meeting);
                    System.out.println(meeting.getMeetingDetails() + " created successfull");
                } else {
                    errorMessage();
                }
                showMenuToUser();
                break;
            case 2:
                if (isUserLoggedIn) {
                    if (user.getiOrganize().size() > 0) {
                        user.displayFormattedOrganizations();
                        String name = getStringFromUser("Enter name of the meeting to cancel: ");
                        Meeting meeting = getMeetingNamed(name, user.getiOrganize());
                        if (meeting == null) {
                            System.out.println("You don't host any meeting named " + name);
                        } else {
                            user.cancelMeeting(meeting);
                        }
                    } else {
                        System.out.println("You haven't organized any meeting yet.");
                    }
                } else {
                    errorMessage();
                }
                showMenuToUser();
                break;
            case 3:
                if (isUserLoggedIn) {
                    if (allMeetings.size() > 0) {
                        int countMeetingsNOtHostedByUser = 0;
                        for (Meeting meeting : allMeetings) {
                            if (!meeting.getHost().equals(user)) {
                                countMeetingsNOtHostedByUser++;
                                System.out.println(meeting.getMeetingDetails());
                            }
                        }
                        if (countMeetingsNOtHostedByUser == 0) {
                            System.out.println("No meeting available to join.");
                            return;
                        }
                        String name = getStringFromUser("Enter name of the meeting to attend: ");
                        Meeting meeting = getMeetingNamed(name, allMeetings);
                        if (meeting != null) {
                            meeting.addAttendee(user);
                        } else {
                            System.out.println("There is no meeting named " + name);
                        }
                    } else {
                        System.out.println("There are no meetings available to attend.");
                    }
                } else {
                    errorMessage();
                }
                showMenuToUser();
                break;
            case 4:
                if (isUserLoggedIn) {
                    if (user.getMyMeetings().size() > 0) {
                        for (Meeting meeting : user.getMyMeetings()) {
                            System.out.println(meeting.getMeetingDetails());
                        }
                        String name = getStringFromUser("Enter name of the meeting you want to leave: ");
                        Meeting meeting = getMeetingNamed(name, user.getMyMeetings());
                        if (meeting != null) {
                            meeting.removeAttendee(user);
                            user.removeMeeting(meeting);
                        } else {
                            System.out.println("There is no meeting named " + name);
                        }
                    } else {
                        System.out.println("There are no meetings available.");
                    }
                } else {
                    errorMessage();
                }
                showMenuToUser();
                break;
            case 5:
                if (isUserLoggedIn) {
                   user.displayMyMeetings();
                } else {
                    errorMessage();
                }
                showMenuToUser();
                break;
            case 6:
                if (isUserLoggedIn) {
                    user.displayMyOrganizations();
                } else {
                    errorMessage();
                }
                showMenuToUser();
                break;
            case 7:
                if (isUserLoggedIn) {
                    systemUsers.remove(indexOfUserLoggedIn);
                    systemUsers.add(user);
                    user = null;
                    indexOfUserLoggedIn = -1;
                    isUserLoggedIn = false;
                    System.out.println("Successfully Logged Out.");
                } else {
                    errorMessage();
                }
                showMenuToUser();
                break;
            case 8:
                break;
            default:
                System.out.println("Wrong input.");
        }
    }

    private static void errorMessage() {
        System.out.println("Login to perform any action.");
    }



    private static Meeting getMeetingNamed(String name, ArrayList<Meeting> arr) {
        for (Meeting meeting : arr) {
            if (meeting.getName().equalsIgnoreCase(name)) {
                return meeting;
            }
        }
        return null;
    }

    private static String getStringFromUser(String msg){
        System.out.print(msg);
        return scan.nextLine();
    }


}
