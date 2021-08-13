public class Container{ //Class to create objects
    int height;             //Global variables that can be edited by the functions below
    int width;
    int length;
    int weight;
    String description;
    String serialNumber;

    public Container(){ //When an object is created with a new Container(), this function creates the object BUT the variables will be null

    }

    public Container(String description, String serialNumber){  //20 foot container objects
        this.height = 10;
        this.width = 10;
        this.length = 20;
        this.weight = 4800;
        this.description = description;
        this.serialNumber = serialNumber;
    }

    public Container(String description){  //function to create object with only the description. This will be used for making boxes
        this.height = 10;
        this.width = 10;
        this.length = 10;
        this.weight = 5;
        this.description = description;
        serialNumber = "No Serial number";
    }

    //create a more custom object
    public Container(int height, int width, int length, int weight,String description, String serialNumber){
        this.height = height;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.description = description;
        this.serialNumber = serialNumber;
    }

}
