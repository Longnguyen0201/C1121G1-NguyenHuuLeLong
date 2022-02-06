package furama_resort.services.iml;

import furama_resort.models.Booking;

import java.util.Comparator;
import java.util.stream.Stream;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        int[] startDay1 = Stream.of(o1.getStartDate().split("/")).mapToInt(Integer::parseInt).toArray();
        int[] startDay2 = Stream.of(o2.getStartDate().split("/")).mapToInt(Integer::parseInt).toArray();

        if (compareDays(startDay1,startDay2)!= 0){
            return compareDays(startDay1,startDay2);
        }else {
            int[] endDay1 = Stream.of(o1.getEndDate().split("/")).mapToInt(Integer::parseInt).toArray();
            int[] endDay2 = Stream.of(o2.getEndDate().split("/")).mapToInt(Integer::parseInt).toArray();
            return compareDays(endDay1,endDay2);
        }
    }
    public int compareDays(int[] day1, int[] day2){
        if (day1[2]==day2[2]){
            if (day1[1]==day2[1]){
                return day1[0] - day2[0];
            }else return day1[1]-day2[1];
        }else return day1[2]-day2[2];
    }
}
