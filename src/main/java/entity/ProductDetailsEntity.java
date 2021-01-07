

package entity;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="productDetails")
public class ProductDetailsEntity{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int productDetailsId;
    private String productDetailsName;
    private double price;
    
    @ManyToOne
    @JoinColumn(name="ageGroupId")
    private AgeGroupEntity ageGroup;
    
    @ManyToOne
    @JoinColumn(name="colorId")
    private ColorEntity color;
    
    @ManyToOne
    @JoinColumn(name="sexId")
    private SexEntity sex;
    
    @ManyToOne
    @JoinColumn(name="sizeId")
    private SizeEntity size;
    
    @ManyToOne
    @JoinColumn(name="productId")
    private ProductEntity product;
    
    @OneToMany(mappedBy = "productDetails",fetch = FetchType.EAGER)
    List<ImagesEntity> images;
    
    @OneToMany(mappedBy = "productDetails",fetch = FetchType.LAZY)
    List<OrderDetailsEntity> orderDetails;

    public ProductDetailsEntity() {
    }

    public ProductDetailsEntity(int productDetailsId, String productDetailsName, double price, AgeGroupEntity ageGroup, ColorEntity color, SexEntity sex, SizeEntity size, ProductEntity product, List<ImagesEntity> images, List<OrderDetailsEntity> orderDetails) {
        this.productDetailsId = productDetailsId;
        this.productDetailsName = productDetailsName;
        this.price = price;
        this.ageGroup = ageGroup;
        this.color = color;
        this.sex = sex;
        this.size = size;
        this.product = product;
        this.images = images;
        this.orderDetails = orderDetails;
    }

    public int getProductDetailsId() {
        return productDetailsId;
    }

    public void setProductDetailsId(int productDetailsId) {
        this.productDetailsId = productDetailsId;
    }

    public String getProductDetailsName() {
        return productDetailsName;
    }

    public void setProductDetailsName(String productDetailsName) {
        this.productDetailsName = productDetailsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public AgeGroupEntity getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroupEntity ageGroup) {
        this.ageGroup = ageGroup;
    }

    public ColorEntity getColor() {
        return color;
    }

    public void setColor(ColorEntity color) {
        this.color = color;
    }

    public SexEntity getSex() {
        return sex;
    }

    public void setSex(SexEntity sex) {
        this.sex = sex;
    }

    public SizeEntity getSize() {
        return size;
    }

    public void setSize(SizeEntity size) {
        this.size = size;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public List<ImagesEntity> getImages() {
        return images;
    }

    public void setImages(List<ImagesEntity> images) {
        this.images = images;
    }

   

    public void setOrderDetails(List<OrderDetailsEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }
    
    public String getPriceFormatted(){
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        return  numberFormat.format(price);
    }
    
}
