package furama_resort.services.iml;
import furama_resort.models.Booking;
import furama_resort.services.IPromotionService;
import java.time.LocalDate;
import java.util.*;

public class PromotionServiceImpl implements IPromotionService {
    Scanner scanner = new Scanner(System.in);
    TreeSet<Booking> bookingList = BookingServiceImpl.readFile(BookingServiceImpl.BOOKING_FILE);

    @Override
    public void displayCustomerUseService() {
        System.out.println(" Enter a number year ");
        String yearBooking = scanner.nextLine();
        for (Booking booking : bookingList) {
            if (booking.getStartDate().contains(yearBooking) || booking.getEndDate().contains(yearBooking)) {
                System.out.println(booking);
            }
        }
    }

    @Override
    public void displayCustomerGetVoucher() {
        Stack<Booking> bookingStack = new Stack<>();
        LocalDate localDate = LocalDate.now();
        String year = String.valueOf(localDate.getYear());
        String month = String.valueOf(localDate.getMonth().getValue());
        for (Booking bookingInMonth : bookingList){
            if (bookingInMonth.getStartDate().contains(year)){
                if (bookingInMonth.getStartDate().contains(month)){
                    bookingStack.push(bookingInMonth);
                }
            }
        }
        System.out.println("Booking number of the month "+month+ " is : " + bookingStack.size());
        int voucher10;
        int voucher20;
        int voucher50;
        do {
            System.out.println("Enter the number of voucher 10%:");
            voucher10 = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the number of voucher 20%:");
            voucher20 = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the number of voucher 50%:");
            voucher50 = Integer.parseInt(scanner.nextLine());
        }while ((voucher10+voucher20+voucher50)!=bookingStack.size());

        Map <String,Integer> voucherMap = new TreeMap<>();
        voucherMap.put("Voucher10",voucher10);
        voucherMap.put("Voucher20",voucher20);
        voucherMap.put("Voucher50",voucher50);
        System.out.println(voucherMap);

        for (Booking booking: bookingStack){
            if (voucherMap.get("Voucher10")>0){
                System.out.println(booking+ " give away voucher 10%");
                voucherMap.put("Voucher10",voucherMap.get("Voucher10")-1);
            } else if (voucherMap.get("Voucher20")>0){
                System.out.println(booking+ " give away voucher 20%");
                voucherMap.put("Voucher20",voucherMap.get("Voucher20")-1);
            } else if (voucherMap.get("Voucher50")>0){
                System.out.println(booking+ " give away voucher 10%");
                voucherMap.put("Voucher50",voucherMap.get("Voucher50")-1);
            }else break;
        }
    }
}
