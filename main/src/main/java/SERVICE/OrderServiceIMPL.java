package SERVICE;

import CONVERTER.OrderConverter;
import DAO.OrderDao;
import DAO.OrderDaoIMPL;
import DAO.ProductDAO;
import DAO.ProductDAOimpl;
import DTO.OrderRequest;
import ENTITY.Orders;
import ENTITY.Product;
import config.HibernateConfig;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderServiceIMPL implements OrderService{

    private SessionFactory sessionFactory= HibernateConfig.getSessionFactory();
    private ProductDAO productDAO= new ProductDAOimpl(sessionFactory);
    private OrderDao orderDao = new OrderDaoIMPL(sessionFactory);
    @Override
    public Orders create(OrderRequest orderRequest) {
        List<Long > productIds=orderRequest.getOrderItemRequests()
                .stream()
                .map(orderItemRequest   -> orderItemRequest.getProductId())
                .collect(Collectors.toList());
        Map<Long, Double> mapPrice=new HashMap<>();

        List<Product> getProducts=productDAO.findAllByIds(productIds);
        for (Product product:getProducts){
            mapPrice.put(product.getId(), product.getPrice());
        }

        Orders orders = OrderConverter.cnvertOrderToEntity(orderRequest);
        orders.getOrderItemsList().stream().forEach(
                orderItems -> orderItems.setSubTotal(orderItems.getQuantity()
                        * mapPrice.get(orderItems.getProduct().getId()))
        );
        Double total = orders.getOrderItemsList().stream().mapToDouble(
                orderItem -> orderItem.getSubTotal()
        ).sum();
        orders.setTotal(total);
        return orderDao.create(orders);

    }
}
