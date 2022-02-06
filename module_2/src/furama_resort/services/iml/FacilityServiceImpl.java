package furama_resort.services.iml;

import furama_resort.models.Facility;
import furama_resort.models.House;
import furama_resort.models.Room;
import furama_resort.models.Villa;
import furama_resort.services.IFacilityService;

import java.io.*;
import java.util.*;

public class FacilityServiceImpl implements IFacilityService {
    Scanner scanner = new Scanner(System.in);
    private final String VILLA_FILE = "src/furama_resort/data/villa.csv";
    private final String HOUSE_FILE = "src/furama_resort/data/house.csv";
    private final String ROOM_FILE = "src/furama_resort/data/room.csv";
    //    private static final String VILLA_ID_SERVICE = "^VIL-\\d{4}$";
//    private static final String HOUSE_ID_SERVICE = "^HOU-\\d{4}$";
//    private static final String ROOM_ID_SERVICE = "^ROO-\\d{4}$";
//

    LinkedHashMap<Facility, Integer> villaList = readFile(VILLA_FILE);
    LinkedHashMap<Facility, Integer> roomList = readFile(ROOM_FILE);
    LinkedHashMap<Facility, Integer> houseList = readFile(HOUSE_FILE);


    private LinkedHashMap<Facility, Integer> readFile(String filePath) {
        LinkedHashMap<Facility, Integer> list = new LinkedHashMap<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] facility;
            while ((line = bufferedReader.readLine()) != null) {
                facility = line.split(",");
                if (filePath.equals(VILLA_FILE)) {
                    Villa newVilla = new Villa(facility[0], facility[1], Double.parseDouble(facility[2]), Double.parseDouble(facility[3]), Integer.parseInt(facility[4]), facility[5], facility[6], Integer.parseInt(facility[7]), Integer.parseInt(facility[8]));
                    list.put(newVilla, newVilla.getValue());
                } else if (filePath.equals(HOUSE_FILE)){
                    House newHouse = new House(facility[0], facility[1], Double.parseDouble(facility[2]), Double.parseDouble(facility[3]), Integer.parseInt(facility[4]), facility[5], facility[6], Integer.parseInt(facility[7]));
                    list.put(newHouse, newHouse.getValue());
                }else {
                    Room newRoom = new Room(facility[0], facility[1], Double.parseDouble(facility[2]), Double.parseDouble(facility[3]), Integer.parseInt(facility[4]), facility[5], facility[6]);
                    list.put(newRoom, newRoom.getValue());
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File not found or failure");
            e.printStackTrace();
        }
        return list;
    }

    private void writeFile(Facility facility, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(facility.writeToFile());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("File not found or failure");
            e.printStackTrace();
        }
    }

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
            System.out.print("Your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
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
                    break;

            }
        }
    }

    private void choiceNewFacility(int choice) {
        System.out.println("Enter ID service of facility (ex: VIL-002,HOU-001,ROO-002,...). ");
        String idService = scanner.nextLine();

        System.out.println("Enter name service of facility (ex: Villa service,...");
        String nameService = scanner.nextLine();

        System.out.println("Enter usable area of facility (More than 30)");
        double useArea = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter price of facility: ");
        double prince = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter maximum number of people using( 1 facility)");
        int maxPeople = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter rental type of facility (ex: hour, day, month, year");
        String rentalType = scanner.nextLine();
        if (choice == 1) {
            System.out.println("Enter type villa (Ex:Superior, Standard,...) ");
            String type = scanner.nextLine();
            System.out.println("Enter pool area of villa:  ");
            int poolArea = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter floor number of villa: ");
            int floorNumber = Integer.parseInt(scanner.nextLine());
            Villa newVilla = new Villa(idService, nameService, useArea, prince, maxPeople, rentalType, type, poolArea, floorNumber);
            villaList.put(newVilla, newVilla.getValue());
            writeFile(newVilla, VILLA_FILE);
        } else if (choice == 2) {
            System.out.println("Enter type villa (Ex:Superior, Standard,...) ");
            String type = scanner.nextLine();
            System.out.println("Enter floor number of villa: ");
            int floorNumber = Integer.parseInt(scanner.nextLine());
            House newHouse = new House(idService, nameService, useArea, prince, maxPeople, rentalType, type, floorNumber);
            houseList.put(newHouse, newHouse.getValue());
            writeFile(newHouse, HOUSE_FILE);
        } else if (choice == 3) {
            System.out.println("Enter free service: ");
            String freeService = scanner.nextLine();
            Room newRoom = new Room(idService, nameService, useArea, prince, maxPeople, rentalType, freeService);
            roomList.put(newRoom, newRoom.getValue());
            writeFile(newRoom, ROOM_FILE);
        }

    }

    @Override
    public void displayFacilityMaintenance() {
        System.out.println("Facility Maintenance's List: ");
        for (Facility key : villaList.keySet()) {
            if (villaList.get(key) > 2) {
                System.out.println(key + " " + villaList.get(key));
            }
        }
        for (Facility key : houseList.keySet()) {
            if (houseList.get(key) > 2) {
                System.out.println(key + " " + houseList.get(key));
            }
        }
        for (Facility key : roomList.keySet()) {
            if (roomList.get(key) > 2) {
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
                    villaList.computeIfPresent(key,(k,v)->v+1);
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