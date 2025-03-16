// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Abstract method to calculate bill
    public abstract double calculateBill();

    // Concrete method to display patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Getter and Setter methods
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);

    String viewRecords();
}

// Subclass InPatient
class InPatient extends Patient implements MedicalRecord {
    private double roomCharges;

    public InPatient(String patientId, String name, int age, double roomCharges) {
        super(patientId, name, age);
        this.roomCharges = roomCharges;
    }

    @Override
    public double calculateBill() {
        return roomCharges + 500; // Additional charges
    }

    @Override
    public void addRecord(String record) {
        System.out.println("Record added: " + record);
    }

    @Override
    public String viewRecords() {
        return "Medical records for InPatient";
    }
}

// Main class to demonstrate polymorphism
public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient patient1 = new InPatient("P001", "John Doe", 30, 200);
        patient1.getPatientDetails();
        System.out.println("Total Bill: " + patient1.calculateBill());
        ((MedicalRecord) patient1).addRecord("Initial checkup");
    }
}