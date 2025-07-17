package fr.wijin.crm.dao;

import java.util.List;

import fr.wijin.crm.model.Order;

public interface IOrderDAO {


    public Order createOrder(Order order);


    public Order getOrderById(Integer id);

    public Order updateOrder(Order order);

    public void deleteOrder(Integer id);

    public List<Order> getAllOrders();
}
