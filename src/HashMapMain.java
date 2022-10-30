import lib.FileIO;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class HashMapMain {
    public static void main(String[] args) throws FileNotFoundException {
        String fName= "fileSave/order_status_hw.csv";
        FileIO fio = new FileIO(fName);

        //  HashMap<Integer,Order> oD = new HashMap<>();

        fio.setFileData();

        ArrayList<String> inLines = fio.getFileData();

        System.out.printf("\nlen:%s", inLines.size());

        ArrayList<HashMapOrder> items = createOrderItems(inLines);



        HashMap<Integer, ArrayList<HashMapOrder>> m = new HashMap<>();


        for(HashMapOrder o: items)
        {
            ArrayList<HashMapOrder> items2 = new ArrayList<>();
            items2.add(o);
            if(m.containsKey(o.getOrder_id()))
            {
                m.get(o.getOrder_id()).add(o);
            }
            else {
                m.put(o.getOrder_id(), items2);

            }

        }
        System.out.println(m.get(1235));

        HashMapManager om = new HashMapManager(m);
        System.out.println(om.AddItemToOrder(9999,444,12));

        ArrayList<HashMapOrder> retItems2 = om.findOrders(9999);

        System.out.println(om.AddItemToOrder(1235,1,10));
        System.out.println(om.findOrders(1235).get(1).getQuantity());



        ArrayList<String> allList = om.getAllOrderId();

        System.out.println(om.updateThisOderLineId(9999,1, "shipped"));
        System.out.println(om.orders.get(9999));


        System.out.println(om.getAllOrderId());
        System.out.println("---");



        System.out.println("Data with Shipped Status:  "+om.getOrdersByState("shipped"));
        System.out.println("Data with new Status:  " + om.getOrdersByState("new"));
        System.out.println("Data with pizzaHut Status:  "+om.getOrdersByState("pizzaHut"));



        System.out.println("---");


    }
    private static ArrayList<HashMapOrder> createOrderItems(ArrayList<String> inLines) {
        ArrayList<HashMapOrder> oItems = new ArrayList<>();
        boolean firstLine = true;
        int ct = 0;
        for(String line : inLines)
        {
            ct++;
            if(firstLine)
            {
                firstLine= false;
                continue;
            }


            String[] toks = line.split(";");
            try{
                int oID = Integer.parseInt(toks[0]);
                int lID = Integer.parseInt(toks[1]);
                int pID = Integer.parseInt(toks[2]);
                int quant = Integer.parseInt(toks[3]);
                String status = toks[4];
                double value = Double.parseDouble(toks[5]);
                oItems.add(new HashMapOrder(oID, lID,pID,quant,status, value));
            }catch(Exception e)
            {
                System.out.printf("\n ooooooopPs help do something!");
                System.exit(1);
            }
        }
        return oItems;
    }


}

