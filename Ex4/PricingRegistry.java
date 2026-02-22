import java.util.*;
public class PricingRegistry {
    private static final Map<Integer, IRoomPricing> roomRules = new HashMap<>();
    static {
        roomRules.put(LegacyRoomTypes.SINGLE, new SingleRoomPricing());
        roomRules.put(LegacyRoomTypes.DOUBLE, new DoubleRoomPricing());
        roomRules.put(LegacyRoomTypes.TRIPLE, new TripleRoomPricing());
        roomRules.put(LegacyRoomTypes.DELUXE, new DeluxeRoomPricing());
    }
    public static IRoomPricing getRoomRule(int type) {
        return roomRules.getOrDefault(type, new DeluxeRoomPricing());
    }
}