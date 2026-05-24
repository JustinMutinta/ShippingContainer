import java.util.ArrayList;

public class ShipData {

    public Container[] container1 = new Container[5];
    public Container[] container2 = new Container[5];
    public Container[] container3 = new Container[5];
    public Container[] platform1  = new Container[1];
    public Container[] platform2  = new Container[1];

    public ArrayList<Container> availableItems = new ArrayList<>();

    public ShipData() {
        availableItems.add(new Container("Box 1"));
        availableItems.add(new Container("Box 2"));
        availableItems.add(new Container("Box 3"));
        availableItems.add(new Container("Box 4"));
        availableItems.add(new Container("Box 5"));
        availableItems.add(new Container("Electronics Crate A"));
        availableItems.add(new Container("Electronics Crate B"));
        availableItems.add(new Container("Food Supply Box"));
        availableItems.add(new Container("Fragile Items Box"));
        availableItems.add(new Container(60,  60, 120, 450,  "BMW Vehicle",  "45RFT90RV"));
        availableItems.add(new Container(54,  60, 100, 450,  "Honda Vehicle","KL5690TR5"));
        availableItems.add(new Container(65,  70, 140, 1200, "Ford Truck",   "FT7823KL"));
        availableItems.add(new Container(40,  40,  80, 200,  "Motorcycle",   "MC4521XR"));
    }

    public Container[] getContainerByName(String name) {
        switch (name) {
            case "Container 1": return container1;
            case "Container 2": return container2;
            case "Container 3": return container3;
            case "Platform 1":  return platform1;
            case "Platform 2":  return platform2;
            default:            return null;
        }
    }

    // Returns true if item was added, false if container is full or not found
    public boolean addToContainer(Container item, String containerName) {
        Container[] target = getContainerByName(containerName);
        if (target == null) return false;
        for (int i = 0; i < target.length; i++) {
            if (target[i] == null) {
                target[i] = item;
                availableItems.remove(item);
                return true;
            }
        }
        return false;
    }

    // Returns true if item was found and removed, false otherwise
    public boolean removeFromContainer(Container item, String containerName) {
        Container[] target = getContainerByName(containerName);
        if (target == null) return false;
        for (int i = 0; i < target.length; i++) {
            if (target[i] == item) {
                target[i] = null;
                availableItems.add(item);
                return true;
            }
        }
        return false;
    }

    public int countItems(Container[] slots) {
        int count = 0;
        for (Container c : slots) {
            if (c != null) count++;
        }
        return count;
    }
}
