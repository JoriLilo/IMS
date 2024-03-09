package DTO;

import ENTITY.PaymentStatusEnum;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {
    private Long clientId;
    private PaymentStatusEnum paymentStatus;
    List<OrderItemRequest> orderItemRequests= new ArrayList<>();

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public PaymentStatusEnum getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public List<OrderItemRequest> getOrderItemRequests() {
        return orderItemRequests;
    }

    public void setOrderItemRequests(List<OrderItemRequest> orderItemRequests) {
        this.orderItemRequests = orderItemRequests;
    }
}
