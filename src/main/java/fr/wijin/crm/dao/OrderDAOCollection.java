package fr.wijin.crm.dao;

import java.util.ArrayList;
import java.util.List;

import fr.wijin.crm.model.Order;

public class OrderDAOCollection implements IOrderDAO {

    private final List<Order> orders = new ArrayList<>();

    private static OrderDAOCollection instance;

    private OrderDAOCollection() {
        // Private constructor to prevent instantiation
    }

    public synchronized static OrderDAOCollection getInstance() {
        if (instance == null) {
            instance = new OrderDAOCollection();
        }
        return instance;
    }

    @Override
    public Order createOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("order cannot be null");
        }

        boolean isPresent = orders.stream()
                .anyMatch(o -> o.getId().equals(order.getId()));
        if (isPresent) {
            throw new IllegalArgumentException("Order with ID " + order.getId() + " already exists.");
        }

        orders.add(order);
        return order;
    }

    @Override
    public Order getOrderById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        return orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Order updateOrder(Order order) {
        Order existingOrder = getOrderById(order.getId());
        if (existingOrder == null) {
            throw new IllegalArgumentException("Order with ID " + order.getId() + " does not exist.");
        }
        // TODO
        return order; 
    }

    @Override
    public void deleteOrder(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        boolean removed = orders.removeIf(o -> o.getId().equals(id));
        if (!removed) {
            throw new IllegalArgumentException("Order with ID " + id + " does not exist.");
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

}
