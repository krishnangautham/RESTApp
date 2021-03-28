
package com.restapp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "SALES_ORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesOrder.findAll", query = "SELECT s FROM SalesOrder s")
    , @NamedQuery(name = "SalesOrder.findByOrderNumber", query = "SELECT s FROM SalesOrder s WHERE s.orderNumber = :orderNumber")
    , @NamedQuery(name = "SalesOrder.findByQuantity", query = "SELECT s FROM SalesOrder s WHERE s.quantity = :quantity")
    , @NamedQuery(name = "SalesOrder.findByOrderDate", query = "SELECT s FROM SalesOrder s WHERE s.orderDate = :orderDate")})
public class SalesOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDER_NUMBER")
    private Integer orderNumber;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false)
    private Client customerId;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    @ManyToOne(optional = false)
    private ProductCatalog productId;

    public SalesOrder() {
    }

    public SalesOrder(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Client getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Client customerId) {
        this.customerId = customerId;
    }

    public ProductCatalog getProductId() {
        return productId;
    }

    public void setProductId(ProductCatalog productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderNumber != null ? orderNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesOrder)) {
            return false;
        }
        SalesOrder other = (SalesOrder) object;
        if ((this.orderNumber == null && other.orderNumber != null) || (this.orderNumber != null && !this.orderNumber.equals(other.orderNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.restapp.entity.SalesOrder[ orderNumber=" + orderNumber + " ]";
    }
    
}
