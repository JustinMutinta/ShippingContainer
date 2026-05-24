public class Container {
    public int height;
    public int width;
    public int length;
    public int weight;
    public String description;
    public String serialNumber;

    public Container() {
    }

    // 20-foot shipping container
    public Container(String description, String serialNumber) {
        this.height = 10;
        this.width = 10;
        this.length = 20;
        this.weight = 4800;
        this.description = description;
        this.serialNumber = serialNumber;
    }

    // Box/small item (no serial number)
    public Container(String description) {
        this.height = 10;
        this.width = 10;
        this.length = 10;
        this.weight = 5;
        this.description = description;
        this.serialNumber = "No Serial Number";
    }

    // Custom object with all fields
    public Container(int height, int width, int length, int weight, String description, String serialNumber) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.description = description;
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return description;
    }
}