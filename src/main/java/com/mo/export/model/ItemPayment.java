package com.mo.export.model;

import com.mo.export.common.ExportData;

import java.math.BigDecimal;
import java.util.Date;

public class ItemPayment extends ExportData {


    /**
     * 外键，关联到tx_order.id
     */
    private Long orderId;

    /**
     * 订单商品id
     */
    private Long orderItemId;

    /**
     * 支付id
     */
    private Long paymentId;

    /**
     * 本次付款金额
     */
    private BigDecimal payableAmount;

    /**
     * 本次促销金额
     */
    private BigDecimal promotionAmount;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 
     */
    private Integer deleteFlag;



    /**
     * 外键，关联到tx_order.id
     * @return order_id 外键，关联到tx_order.id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 外键，关联到tx_order.id
     * @param orderId 外键，关联到tx_order.id
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 订单商品id
     * @return order_item_id 订单商品id
     */
    public Long getOrderItemId() {
        return orderItemId;
    }

    /**
     * 订单商品id
     * @param orderItemId 订单商品id
     */
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * 支付id
     * @return payment_id 支付id
     */
    public Long getPaymentId() {
        return paymentId;
    }

    /**
     * 支付id
     * @param paymentId 支付id
     */
    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * 本次付款金额
     * @return payable_amount 本次付款金额
     */
    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    /**
     * 本次付款金额
     * @param payableAmount 本次付款金额
     */
    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    /**
     * 本次促销金额
     * @return promotion_amount 本次促销金额
     */
    public BigDecimal getPromotionAmount() {
        return promotionAmount;
    }

    /**
     * 本次促销金额
     * @param promotionAmount 本次促销金额
     */
    public void setPromotionAmount(BigDecimal promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 
     * @return delete_flag 
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 
     * @param deleteFlag 
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}