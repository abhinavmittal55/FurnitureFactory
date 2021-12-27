package hackerrank;

import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
     private final HashMap<Furniture, Integer> furnitureItems;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        furnitureItems = new HashMap<Furniture, Integer>();
    }

    FurnitureOrder() {
        // TODO: Complete the constructor
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        furnitureItems.put(type, furnitureCount + furnitureItems.getOrDefault(type,0));
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        //return null;
        return new HashMap<Furniture, Integer>(furnitureItems);
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        //return -1.0f;
        if(furnitureItems.isEmpty())
            return 0.0f;

        return furnitureItems.entrySet().stream().map(f -> f.getKey().cost()*f.getValue())
            .collect(Collectors.toList()).stream().reduce(Float::sum).get();

    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        //return -1;
        return furnitureItems.getOrDefault(type,0);
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        //return -1.0f;
        if(furnitureItems.containsKey(type)) {
            return furnitureItems.get(type)*type.cost();
        }
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        //return -1;

        if(furnitureItems.isEmpty())
            return 0;

        return furnitureItems.values().stream().reduce(Integer::sum).get();
    }
}
