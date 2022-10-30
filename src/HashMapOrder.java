public class HashMapOrder{
    private int order_id;
    private int line_id;
    private int partNum;
    private int quantity;
    private String status;
    private double value;

    public HashMapOrder(int order_id, int line_id, int partNum, int quantity, String status, double value) {
        this.order_id = order_id;
        this.line_id = line_id;
        this.partNum = partNum;
        this.quantity = quantity;
        this.status = status;
        this.value = value;
    }

    public HashMapOrder() {

    }


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getLine_id() {
        return line_id;
    }

    public void setLine_id(int line_id) {
        this.line_id = line_id;
    }

    public int getPartNum() {
        return partNum;
    }

    public void setPartNum(int partNum) {
        this.partNum = partNum;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "order_id=" + order_id +
                ", line_id=" + line_id +
                ", partNum=" + partNum +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", value=" + value +
                '}';
    }
}
