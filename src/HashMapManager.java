import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class HashMapManager{
    HashMap<Integer, ArrayList<HashMapOrder>>orders = new HashMap<>();


    //HashSet<Integer> byOrderId = new HashSet<>();

    public HashMapManager(){

    }
    public HashMapManager(HashMap<Integer, ArrayList<HashMapOrder>> orders) {

        this.orders = orders;
      //  byOrderId.add(orders.keySet());
       /* for(HashMapOrder o: orders)
        {
            byOrderId.add(o.getOrder_id());
        }*/
    }

    public void addOrder( HashMapOrder o){
        //orders.add( o );

    }
    public boolean gotThisOrder(int id){
        // ToDo: Write this method to return O(1) if the id is in the order set
        //
        if(orders.containsKey(id))
        {
            return true;
        }
        return false;
    }
    public ArrayList<HashMapOrder> findOrders(int oId){
        // ToDo: Rewrite this method to operation O(1) instead of O(n)


        return orders.get(oId);

    }
    public ArrayList<HashMapOrder> getOrdersByState(String inState ){
        ArrayList<HashMapOrder> stat = new ArrayList<>();
        //ToDo: Rewrite this method to be more efficent and use a hash

        for (Integer s : orders.keySet()) {
            for (HashMapOrder r : orders.get(s))
            {
                if(r.getStatus().equals(inState))
                {
                    stat.add(r);
                }
            }
        }



        return stat;
    }
    // ToDo: Write a method
    public boolean updateThisOderLineId( int orderId, int lineId, String newStatus ){

        //ToDo: find the orderId and lineId that matches the input and

        Boolean test = true;
        int i = 0;
        if(orders.containsKey(orderId))
        {
            while(test)
            {
                if(orders.get(orderId).get(i).getLine_id() == lineId)
                {
                    orders.get(orderId).get(i).setStatus(newStatus);
                    test = false;

                }
                i++;

            }
            return true;

        }
        else
        {
            return false;
        }


    }
    public ArrayList<String> getAllOrderId(){
        ArrayList<String> s = new ArrayList<>();

        // ToDo: Return arrayList of all the unique orderIds

        Object[] objectArray = orders.entrySet().toArray();

        s.add(Arrays.toString(objectArray));


        return s;
    }
    //
    public boolean AddItemToOrder( int OrderId, int partNum,  int quantity ){
        //ToDo:  Search through the orders for OrderNumer and partNum. If it exists
        //       add the quantity to the exsiting order. However if its status is shipped do not
        //       add the quantity to the exsiting order. However if its status is shipped do not
        //       add it and return false.
        // If the orderNumer and partNum is not found then add the order and set lineNumb to 1, and
        //         status to "new"
        //int c = 0;

       boolean test = true;
       int i = 0;
        if(orders.containsKey(OrderId))
        {
            while(test)
            {
                if(orders.get(OrderId).get(i).getPartNum() == partNum)
                {
                    orders.get(OrderId).get(i).setQuantity(quantity);
                    test = false;
                }
                i++;
            }
            return true;

        }
        if(!(orders.containsKey(OrderId)))
        {
            ArrayList<HashMapOrder> retOrder = new ArrayList<>();

            retOrder.add(new HashMapOrder(OrderId, 1,partNum, 10,"new",500));

            orders.put(OrderId, retOrder);
            return true;
        }
    return false;

    }



}


