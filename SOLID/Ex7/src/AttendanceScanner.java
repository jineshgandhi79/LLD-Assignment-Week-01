public class AttendanceScanner extends SmartClassroomDevice implements DeviceOnOff,Attendance {
    @Override public void powerOn() { /* ok */ }
    @Override public void powerOff() { /* no output */ }
    @Override public int scanAttendance() { return 3; }
}