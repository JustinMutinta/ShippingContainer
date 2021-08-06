public class Container{
    int height;
    int width;
    int length;
    int weight;
    String description;
    String serialNumber;

    public Container(String description, String serialNumber){  //20 foot container
        this.height = 10;
        this.width = 10;
        this.length = 20;
        this.weight = 4800;
        this.description = description;
        this.serialNumber = serialNumber;
    }

    public Container(String description){
        this.height = 10;
        this.width = 10;
        this.length = 10;
        this.weight = 5;
        this.description = description;
        serialNumber = "No Serial number";
    }

    public Container(int height, int width, int length, int weight,String description, String serialNumber){
        this.height = height;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.description = description;
        this.serialNumber = serialNumber;
    }

}
