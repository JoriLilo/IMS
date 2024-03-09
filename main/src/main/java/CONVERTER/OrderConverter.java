package CONVERTER;

import DTO.OrderItemRequest;
import DTO.OrderRequest;
import ENTITY.Client;
import ENTITY.Orders;
import ENTITY.OrderItems;
import ENTITY.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {
    public static Orders cnvertOrderToEntity(OrderRequest orderRequest){
        Orders orders =new Orders();
        orders.setPaymentStatusEnum(orderRequest.getPaymentStatus());
        orders.setClient(new Client(orderRequest.getClientId()));
        orders.setOrderItemsList(convertOrderItemToEntity(orderRequest.getOrderItemRequests()));
        return orders;
    }
    public static List<OrderItems> convertOrderItemToEntity(List<OrderItemRequest> requests){
        List<OrderItems> orderItemsList= new ArrayList<>();
        for (OrderItemRequest orderItemRequest:requests){
            OrderItems orderItems= new OrderItems();
            orderItems.setProduct(new Product(orderItemRequest.getProductId()));
            orderItems.setQuantity(orderItemRequest.getQuantity());
            orderItemsList.add(orderItems);

        }
        return orderItemsList;
    }
}
