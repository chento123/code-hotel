import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String strSizeFloors;
        String strSizeRooms;
        String strOption;
        String strFloor;
        String strRoom;
        int sizeFloors;
        int sizeRooms;
        int floor;
        int room;
        int opt;
        String guessName;
        do {
            System.out.println("-------Setting up Guest's House-------");
            System.out.print("Enter number of floors: ");
            strSizeFloors = scanner.next();
            System.out.print("Enter number of room : ");
            strSizeRooms = scanner.next();
            if (!strSizeFloors.matches("^\\d+(\\.\\d+)?") && !strSizeRooms.matches("^\\d+(\\.\\d+)?")) {
                System.out.println("You input number of floor [" + strSizeFloors + "] is not number");
                System.out.println("You input number of room  [" + strSizeRooms + "] is not number");
            } else if (!strSizeFloors.matches("^\\d+(\\.\\d+)?")) {
                System.out.println("You input number of floor [" + strSizeFloors + "] is not number");
            } else if (!strSizeRooms.matches("^\\d+(\\.\\d+)?")) {
                System.out.println("You input number of room  [" + strSizeRooms + "] is not number");
            } else {
                sizeFloors = Integer.valueOf(strSizeFloors);
                sizeRooms = Integer.valueOf(strSizeRooms);
                System.out.println("Guest's House is already set up with " + sizeFloors + " and " + sizeRooms + " rooms");
                System.out.println("Successfully.");
                String[][] hotel = new String[sizeFloors][sizeRooms];
                do {
                    System.out.println("-----------Guest's House Management System-------------");
                    System.out.println("1. Check In");
                    System.out.println("2. Checkout");
                    System.out.println("3. Display");
                    System.out.println("4. Search Guest's Name");
                    System.out.println("5. Search Guest's Floor");
                    System.out.println("6. Update Guest's Name");
                    System.out.println("7. Exit");
                    System.out.print("Choose option(1-5): ");
                    strOption = scanner.next();
                    // validate case-sensitive
                    if (!strOption.matches("^\\d+(\\.\\d+)?")) {
                        System.out.println("You enter " + strOption + " is not number");
                    } else {
                        // if is number convert to int
                        opt = Integer.valueOf(strOption);
                        if (opt < 0 || opt > 7) {
                            System.out.println("option " + opt + " is out of rang please choose again !");
                        } else {
                            // switch case
                            switch (opt) {
                                case 1: {
                                    do {
                                        System.out.println("-------------Checking to Guest's House-----------");
                                        System.out.print("Enter floor number( 1-" + sizeFloors + " ): ");
                                        // validate case-sensitive
                                        strFloor = scanner.next();
                                        if (!strFloor.matches("^\\d+(\\.\\d+)?")) {
                                            System.out.println("You enter " + strFloor + " is not number");
                                        } else {
                                            System.out.print("Enter room number( 1-" + sizeRooms + " ): ");
                                            strRoom = scanner.next();
                                            if (!strRoom.matches("^\\d+(\\.\\d+)?")) {
                                                System.out.println("You enter " + strRoom + " is not number");
                                            } else {
                                                room = Integer.valueOf(strRoom);
                                                floor = Integer.valueOf(strFloor);
                                                if(hotel[floor-1][room-1]==null){
                                                    if (floor > sizeFloors || floor < 1) {
                                                        System.out.println("your floor is out of rang please try again");
                                                        break;
                                                    } else if (room > sizeRooms || room < 1) {
                                                        System.out.println("your room is out of rang please try again");
                                                        break;
                                                    } else if (hotel[floor - 1][room - 1] != null) {
                                                        System.out.println("This room is not available");
                                                    } else {
                                                        System.out.print("Enter guest's name : ");
                                                        guessName = scanner.next();
                                                        hotel[floor - 1][room - 1] = guessName;
                                                        System.out.println("You CheckIn Successfully ");
                                                        break;
                                                    }
                                                }else{
                                                    System.out.println("This room is already checkIn, Please find another Room");
                                                }
                                            }
                                        }
                                    }while (true);
                                }
                                break;
                                case 2: {
                                    do {
                                        System.out.println("-------------Check out to Guest's House-----------");
                                        System.out.print("Enter floor number( 1 - " + sizeFloors + " ): ");
                                        strFloor = scanner.next();
                                        if (!strFloor.matches("^\\d+(\\.\\d+)?")) {
                                            System.out.println("You enter " + strFloor + " is not number");
                                        } else {
                                            checkOutLabel:
                                            do {
                                                System.out.print("Enter room number ( 1- " + sizeRooms + " ): ");
                                                strRoom = scanner.next();
                                                if (!strRoom.matches("^\\d+(\\.\\d+)?")) {
                                                    System.out.println("You enter " + strFloor + " is not number");
                                                } else {
                                                    floor = Integer.valueOf(strFloor);
                                                    room = Integer.valueOf(strRoom);
                                                    // validate hotel has these room and floor or not
                                                    if (floor > sizeFloors || floor < 1) {
                                                        System.out.println("your floor is out of rang please try again");
                                                        break;
                                                    } else if (room > sizeRooms || room < 1) {
                                                        System.out.println("your room is out of rang please try again");
                                                    } else if (hotel[floor - 1][room - 1] != null) {
                                                        String strValusCheck;
                                                        int valueCheck;
                                                        do {
                                                            System.out.println("Guest's Name " + hotel[floor - 1][room - 1] + " , Press 1 to checkout and 0 cancel: ");
                                                            strValusCheck = scanner.next();
                                                            if (!strValusCheck.matches("^\\d+(\\.\\d+)?")) {
                                                                System.out.println("You enter " + strValusCheck + " is not number");
                                                            } else {
                                                                valueCheck = Integer.valueOf(strValusCheck);
                                                                if (valueCheck == 0) {
                                                                    break;
                                                                } else if (valueCheck == 1) {
                                                                    System.out.println(hotel[floor - 1][room - 1] + " has been checked out successfully !");
                                                                    hotel[floor - 1][room - 1] = null;
                                                                } else {
                                                                    System.out.println("Incorrect number try again");
                                                                }
                                                            }
                                                        } while (true);
                                                    }
                                                    // validate the user the room and the floor don't have : so
                                                    else if (hotel[floor - 1][room - 1] == null) {
                                                        int valueCheck;
                                                        String strValusCheck;
                                                        System.out.println("No one checking in this room , can can't checkout");
                                                        // don't understand 1 checkout again
                                                        System.out.print("Press 1 to checkout again and 0 to exit: ");
                                                        strValusCheck = scanner.next();
                                                        if (!strValusCheck.matches("^\\d+(\\.\\d+)?")) {
                                                            System.out.println("You enter " + strValusCheck + " is not number");
                                                        } else {
                                                            valueCheck = Integer.valueOf(strValusCheck);
                                                            if (valueCheck == 0) {
                                                                break;
                                                            } else if (valueCheck != 1 && valueCheck != 0) {
                                                                System.out.println("You enter incorrect number try again");
                                                            }
                                                        }
                                                    }
                                                }
                                            }while (true);
                                        }
                                    } while (true);
                                }
                               // break;
                                case 3: {
                                    int start = 0;
                                    int end = 3;
                                    String strOptOutput;
                                    int optOutput;
                                    do {
                                        for (int i = start; i < end; i++) {
                                            System.out.print(i + 1 + " ");
                                            for (int j = 0; j < hotel[i].length; j++) {
                                                System.out.print(hotel[i][j] + "  ");
                                            }
                                            System.out.println();
                                        }
                                        System.out.println("1. First Page        2. Next Page        3. Previous        4. Last Page     5. back");
                                        System.out.print("Choose one (1-5) : ");
                                        strOptOutput = scanner.next();
                                        if (!strOptOutput.matches("^\\d+(\\.\\d+)?")) {
                                            System.out.println("You enter " + strOptOutput + " is not number");
                                        } else {
                                            optOutput = Integer.valueOf(strOptOutput);
                                            // option
                                            if (optOutput == 1) {
                                                start = 0;
                                                end = 3;
                                            } else if (optOutput == 2) {
                                                // validate next
                                                if (end > hotel.length) {
                                                    start = end - hotel.length;
                                                    end = hotel.length;
                                                } else if (end == hotel.length) {
                                                    // no block of code because I want output the last again and again
                                                } else if (hotel.length - end < 3) {
                                                    start = end;
                                                    end = end + (hotel.length - end);
                                                } else {
                                                    start = end;
                                                    end = end + 3;
                                                }
                                            } else if (optOutput == 3) {
                                                end = start;
                                                start = start - 3;
                                                if (end <= 3) {
                                                    start = 0;
                                                    end = 3;
                                                }

                                            } else if (optOutput == 4) {
                                                // check again
                                                end = hotel.length;
                                                start = end - 3;
                                                if (hotel.length % 3 != 0) {
                                                    start = hotel.length - hotel.length % 3;
                                                }
                                            } else if (optOutput == 5) {
                                                break;
                                            } else {
                                                System.out.println("You Enter incorrect number try again");
                                            }
                                        }
                                        System.out.println("\n");
                                    } while (true);
                                }
                                break;
                                case 4: {
                                    String nameSearch;
                                    String tempName;
                                    boolean search = false;
                                    System.out.print("Enter Guest's name to search : ");
                                    // name must convert to lower case : it uses for case-sensitive
                                    nameSearch = scanner.next();
                                    nameSearch = nameSearch.toLowerCase();
                                    for (int i = 0; i < hotel.length; i++) {
                                        for (int j = 0; j < hotel[i].length; j++) {
                                            // case-sensitive
                                            if (hotel[i][j] != null) {
                                                tempName = hotel[i][j].toLowerCase();
                                                if (tempName == nameSearch) {
                                                    System.out.print("Floor: " + i + 1 + " " + hotel[i][j] + "  ");
                                                    search = true;
                                                }
                                            }
                                        }
                                        System.out.println();
                                    }
                                    if (search == false) {
                                        System.out.println("Search not found");
                                    }
                                }
                                break;
                                case 5: {
                                    String strFloorSearch;
                                    int floorSearch;
                                    boolean check = false;
                                    String record = "";
                                    System.out.print("Enter floor to search : ");
                                    strFloorSearch = scanner.next();
                                    if (!strFloorSearch.matches("^\\d+(\\.\\d+)?")) {
                                        System.out.println("You enter " + strFloorSearch + " is not number");
                                    } else {
                                        floorSearch = Integer.valueOf(strFloorSearch);
                                        for (int i = 0; i < hotel.length; i++) {
                                            if (i + 1 == floorSearch) {
                                                System.out.print("Floor : " + floorSearch);
                                                for (int j = 0; j < hotel[i].length; j++) {
                                                    System.out.print("  " + hotel[i][j] + "  ");
                                                }
                                                check = true;
                                            }
                                            System.out.println();
                                        }
                                        if (check == false) {
                                            System.out.println("Search not found");
                                        }
                                    }

                                }
                                break;
                                case 6: {
                                    do {
                                        String nameSearch;
                                        String tempName;
                                        boolean search = false;
                                        System.out.print("Enter Guest's name to update : ");
                                        nameSearch = scanner.next();
                                        for (int i = 0; i < hotel.length; i++) {
                                            for (int j = 0; j < hotel[i].length; j++) {
                                                if (hotel[i][j] != null) {
                                                    // case-sensitive
                                                    tempName = hotel[i][j].toLowerCase();
                                                    if (tempName == nameSearch) {
                                                        System.out.println("Update Successfully");
                                                        hotel[i][j] = nameSearch;
                                                        search = true;
                                                    }
                                                }
                                            }
                                        }
                                        if (search == false) {
                                            System.out.println("Search not found");
                                        } else {
                                            String strOptCheck;
                                            int optCheck;
                                            System.out.print("enter 1 to try again 0 to exit ");
                                            strOptCheck = scanner.next();
                                            if (!strOptCheck.matches("^\\d+(\\.\\d+)?")) {
                                                System.out.println("You enter " + strOptCheck + " is not number");
                                            } else {
                                                optCheck = Integer.valueOf(strOptCheck);
                                                if (optCheck == 0) {
                                                    break;
                                                }
                                            }
                                        }
                                    } while (true);
                                }
                                break;
                                case 7: {
                                    System.exit(0);
                                }
                                break;
                                default: {
                                    System.out.println("You input incorrect try again !!");
                                }
                            }
                        }
                        System.out.println("\n");
                    }
                } while (true);
            }
        }while (true);
    }
}