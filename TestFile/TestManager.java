import lib.FileIO;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestManager extends HashMapMain {

    @Test
    public void inputFile() throws FileNotFoundException{
        String fName= "fileSave/order_status_hw.csv";
        FileIO fio = new FileIO(fName);
        fio.setFileData();
        ArrayList<String> inLines = fio.getFileData();
        assertEquals("1233;1;4;2;shipped;500",inLines.get(1));

    }
    @Test
    public void TestAddItemOrder()
    {
        HashMapManager om = new HashMapManager();
        om.AddItemToOrder(9999,444,12);
       // System.out.println();

        assertEquals(true,om.gotThisOrder(9999));


    }
//Update LIst not working
    @Test
    public void TestUpdateExistingOrder()
    {
        HashMapManager om = new HashMapManager();
        om.AddItemToOrder(1235,1,10);

        assertEquals(10,om.findOrders(1235).get(0).getQuantity());


    }

    @Test
    public void TestGetItAsArrayList()
    {
        HashMapManager om = new HashMapManager();
        ArrayList<String> allList = om.getAllOrderId();


        System.out.println(allList);
        assertEquals(12,om.getAllOrderId());

    }
    @Test
    public void TestUpdateOrderStatus()
    {
        HashMapManager om = new HashMapManager();
        System.out.println(om.AddItemToOrder(9999,444,12));

         om.updateThisOderLineId(9999,1, "shipped");
      //  System.out.println(om.orders.get(9999).get(0).getStatus());

        assertEquals("shipped",om.orders.get(9999).get(0).getStatus());
        //   System.out.println(allList);
    }

    @Test
    public void TestFindOrders()
    {
        HashMapManager om = new HashMapManager();
        om.AddItemToOrder(9999,444,12);
        assertEquals(om.orders.get(9999),  om.findOrders(9999));

    }
    @Test
    public void TestFindOrders2()
    {
        HashMapManager om = new HashMapManager();


        assertEquals(null,om.findOrders(112358));

    }
    @Test
    public void TestShipped()
    {
        HashMapManager om = new HashMapManager();
        HashMapMain ma = new HashMapMain();

        assertEquals(null, om.getOrdersByState("shipped"));

    }


}
