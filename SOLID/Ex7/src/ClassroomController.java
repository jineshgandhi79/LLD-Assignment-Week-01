public class ClassroomController {

    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) {
        this.reg = reg;
    }

    public void startClass() {

        DeviceOnOff pjPower = reg.getFirstOfType(Projector.class);
        Connectable pjInput = reg.getFirstOfType(Projector.class);

        pjPower.powerOn();
        pjInput.connectInput("HDMI-1");

        Brightness lights = reg.getFirstOfType(LightsPanel.class);
        lights.setBrightness(60);

        Temperature ac = reg.getFirstOfType(AirConditioner.class);
        ac.setTemperatureC(24);

        Attendance scan = reg.getFirstOfType(AttendanceScanner.class);
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");

        reg.getFirstOfType(Projector.class).powerOff();
        reg.getFirstOfType(LightsPanel.class).powerOff();
        reg.getFirstOfType(AirConditioner.class).powerOff();
    }
}