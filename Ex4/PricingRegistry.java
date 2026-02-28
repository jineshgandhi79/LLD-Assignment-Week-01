import java.util.*;

public class PricingRegistry {
    private static final Map<Integer,IRoomType> roomPrices = new HashMap<>();
    static {
        roomPrices.put(LegacyRoomTypes.SINGLE, new SingleRoom());
        roomPrices.put(LegacyRoomTypes.DOUBLE, new DoubleRoom());
        roomPrices.put(LegacyRoomTypes.TRIPLE, new TripleRoom());
        roomPrices.put(LegacyRoomTypes.DELUXE, new DeluxeRoom());
    }
    public static IRoomType getRoom(int type) {
        return roomPrices.getOrDefault(type,new DeluxeRoom());
    }
}
