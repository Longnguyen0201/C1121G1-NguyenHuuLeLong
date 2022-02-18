package furama_resort.services.iml;

import com.sun.org.apache.xpath.internal.objects.XString;
import furama_resort.models.Facility;
import furama_resort.models.House;
import furama_resort.models.Room;
import furama_resort.models.Villa;
import furama_resort.services.IFacilityService;
import furama_resort.utils.RegexData;
import furama_resort.utils.WriteAndReadToCsv;

import java.io.*;
import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    Scanner scanner = new Scanner(System.in);

    public static final String REGEX_ID_SERVICE = "^(SV)(VL|HO|RO)-\\d{4}$";
    public static final String REGEX_STRING_NAME = "^( ?[A-Z][a-z]+)*$";
    public static final String REGEX_AREA = "^([3-9]\\d|[1-9]\\d{2,})(.?[0-9]+)?$";
    public static final String REGEX_INTEGER = "^[1-9]\\d+$";
    public static final String REGEX_PEOPLE_USE = " ^([1-9]|[1][0-9]|20)$";

    LinkedHashMap<Facility, Integer> villaList = WriteAndReadToCsv.readFileFacilityToCsv(WriteAndReadToCsv.VILLA_FILE);
    LinkedHashMap<Facility, Integer> roomList = WriteAndReadToCsv.readFileFacilityToCsv(WriteAndReadToCsv.ROOM_FILE);
    LinkedHashMap<Facility, Integer> houseList = WriteAndReadToCsv.readFileFacilityToCsv(WriteAndReadToCsv.HOUSE_FILE);



    @Override

    public void displayFacility() {
        System.out.println("Villa list: ");
        for (Facility key : villaList.keySet()) {
            System.out.println(key + " " + villaList.get(key));
        }
        System.out.println("House list: ");
        for (Facility key : houseList.keySet()) {
            System.out.println(key + " " + houseList.get(key));
        }
        System.out.println("Room list: ");
        for (Facility key : roomList.keySet()) {
            System.out.println(key + " " + roomList.get(key));
        }
    }

    @Override
    public void addFacility() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("menu service:");
            System.out.println("1.\tVilla\n" +
                    "2.\tHouse\n" +
                    "3.\tRoom\n" +
                    "0.\tExit\n");
            while (true) {
                try {
                    System.out.print("Your choice: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Wrong format input, Please re-enter");
                }
            }
            switch (choice) {
                case 1:
                    choiceNewFacility(1);
                    break;
                case 2:
                    choiceNewFacility(2);
                    break;
                case 3:
                    choiceNewFacility(3);
                    break;
                case 0:
                    throw new ArithmeticException("Don't found option");
            }
        }
    }

    private void choiceNewFacility(int choice) {
        System.out.println("Enter ID service of facility (ex: SVVL-0002): ");
        String idService = RegexData.regex(scanner.nextLine(), REGEX_ID_SERVICE, " ex: SVVL-0002,SVHO-0001,SVRO-0002,...)");
        System.out.println("Enter name service of facility (ex: Villa Two Bedroom Pool, House Service One Bedroom, Room Ocean,...)");
        String nameService = RegexData.regex(scanner.nextLine(), REGEX_STRING_NAME, "ex: Villa Two Bedroom Pool");

        System.out.println("Enter usable area of facility ");
        Double useArea;
        while (true)
        try {
            useArea = Double.parseDouble(scanner.nextLine());
            if (useArea <= 30 ){
                System.out.println("Area more than 30, Please re-enter:");
                useArea =Double.parseDouble(scanner.nextLine());
            }else{
                break;
            }
        }catch (NumberFormatException e){
            System.out.println("Wrong format input, Please re-enter: ");
        }

        System.out.println("Enter price of facility: ");
        Double prince = Double.parseDouble(RegexData.regex(scanner.nextLine(), REGEX_INTEGER, "Integer > 0"));

        System.out.println("Enter maximum number of people using( 1 facility)");
        int maxPeople = Integer.parseInt(RegexData.regex(scanner.nextLine(), REGEX_PEOPLE_USE, "0 < people < 20"));

        System.out.println("Enter rental type of facility (ex: Hour, Day, Month, Year)");
        String rentalType = RegexData.regex(scanner.nextLine(), REGEX_STRING_NAME, "ex: Hour, Day, Month, Year");

        if (choice == 1) {
            System.out.println("Enter type villa (Ex:Superior, Standard,...) ");
            String type = RegexData.regex(scanner.nextLine(), REGEX_STRING_NAME, "Ex:Superior, Standard,...");
            int poolArea;
            System.out.println("Enter pool area of villa:  ");
            while (true)
                try {
                    poolArea = Integer.parseInt(scanner.nextLine());
                    if (poolArea <= 30 ){
                        System.out.println("Area more than 30, Please re-enter:");
                        poolArea = Integer.parseInt(scanner.nextLine());
                    }else{
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Wrong format input, Please re-enter: ");
                }

            System.out.println("Enter floor number of villa: ");
            int floorNumber = Integer.parseInt(RegexData.regex(scanner.nextLine(), REGEX_INTEGER, "Integer > 0"));

            Facility newVilla = new Villa(idService, nameService, useArea, prince, maxPeople, rentalType, type, poolArea, floorNumber);
            villaList.put(newVilla, newVilla.getValue());
            WriteAndReadToCsv.writeFileFacilityToCsv(newVilla,WriteAndReadToCsv.VILLA_FILE);
        } else if (choice == 2) {
            System.out.println("Enter type villa (Ex:Superior, Standard,...) ");
            String type = RegexData.regex(scanner.nextLine(), REGEX_STRING_NAME, "Ex:Superior, Standard,...");

            System.out.println("Enter floor number of villa: ");
            int floorNumber = Integer.parseInt(RegexData.regex(scanner.nextLine(), REGEX_INTEGER, "Integer > 0"));
            House newHouse = new House(idService, nameService, useArea, prince, maxPeople, rentalType, type, floorNumber);
            houseList.put(newHouse, newHouse.getValue());
            WriteAndReadToCsv.writeFileFacilityToCsv(newHouse,WriteAndReadToCsv.HOUSE_FILE);
        } else if (choice == 3) {
            System.out.println("Enter free service: ");
            String freeService = RegexData.regex(scanner.nextLine(),REGEX_STRING_NAME,"Abbc");
            Room newRoom = new Room(idService, nameService, useArea, prince, maxPeople, rentalType, freeService);
            roomList.put(newRoom, newRoom.getValue());
            WriteAndReadToCsv.writeFileFacilityToCsv(newRoom,WriteAndReadToCsv.ROOM_FILE);
        }
    }

    @Override
    public void displayFacilityMaintenance() {
        System.out.println("Facility Maintenance's List: ");
        for (Facility key : villaList.keySet()) {
            if (villaList.get(key) > 5) {
                System.out.println(key + " " + villaList.get(key));
            }
        }
        for (Facility key : houseList.keySet()) {
            if (houseList.get(key) > 5) {
                System.out.println(key + " " + houseList.get(key));
            }
        }
        for (Facility key : roomList.keySet()) {
            if (roomList.get(key) > 5) {
                System.out.println(key + " " + roomList.get(key));
            }
        }
    }

    @Override
    public void useFacility(String serviceName) {
        if (serviceName.contains("Villa")) {
            Set<Facility> keyVilla = villaList.keySet();
            for (Facility key : keyVilla) {
                if (key.getNameService().contains(serviceName)) {
                    villaList.computeIfPresent(key, (k, v) -> v + 1);
//                    key.setValue(key.getValue()+1);
//                    writeFile(key,VILLA_FILE);
                    break;
                }
            }
        } else if (serviceName.contains("House")) {
            Set<Facility> keyVilla = houseList.keySet();
            for (Facility key : keyVilla) {
                if (key.getNameService().contains(serviceName)) {
                    houseList.computeIfPresent(key, (k, v) -> v + 1);
                    break;
                }
            }
        } else {
            Set<Facility> keyVilla = roomList.keySet();
            for (Facility key : keyVilla) {
                if (key.getNameService().contains(serviceName)) {
                    roomList.computeIfPresent(key, (k, v) -> v + 1);
                    break;
                }
            }
        }
    }

}