package SERVICE;

import DTO.OrderRequest;
import ENTITY.Orders;

public interface OrderService {
    Orders create(OrderRequest orderRequest);

}
