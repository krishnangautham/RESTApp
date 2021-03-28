
package com.restapp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "PRODUCT_CATALOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductCatalog.findAll", query = "SELECT p FROM ProductCatalog p")
    , @NamedQuery(name = "ProductCatalog.findByProductId", query = "SELECT p FROM ProductCatalog p WHERE p.productId = :productId")
    , @NamedQuery(name = "ProductCatalog.findByProductName", query = "SELECT p FROM ProductCatalog p WHERE p.productName = :productName")
    , @NamedQuery(name = "ProductCatalog.findByPurchaseCost", query = "SELECT p FROM ProductCatalog p WHERE p.purchaseCost = :purchaseCost")
    , @NamedQuery(name = "ProductCatalog.findByQuantityOnHand", query = "SELECT p FROM ProductCatalog p WHERE p.quantityOnHand = :quantityOnHand")})
public class ProductCatalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @Size(max = 30)
    @Column(name = "PRODUCT_NAME")
    private String productName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PURCHASE_COST")
    private Float purchaseCost;
    @Column(name = "QUANTITY_ON_HAND")
    private Integer quantityOnHand;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<SalesOrder> salesOrderCollection;
    @JoinColumn(name = "PRODUCT_CATEGORY", referencedColumnName = "CATEGORY_CODE")
    @ManyToOne(optional = false)
    private ProductCategory productCategory;

    public ProductCatalog() {
    }

    public ProductCatalog(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(Float purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    @XmlTransient
    public Collection<SalesOrder> getSalesOrderCollection() {
        return salesOrderCollection;
    }

    public void setSalesOrderCollection(Collection<SalesOrder> salesOrderCollection) {
        this.salesOrderCollection = salesOrderCollection;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCatalog)) {
            return false;
        }
        ProductCatalog other = (ProductCatalog) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.restapp.entity.ProductCatalog[ productId=" + productId + " ]";
    }
    
}
