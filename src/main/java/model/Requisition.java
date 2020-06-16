package model;

import java.util.Date;
import java.util.List;

public class Requisition {

    private int id;
    private List<Product> productLine;
    private int userId;
    private Date creationDate;
    private Date requiredDate;
    private String status;

    public Requisition() {
    }

    public Requisition(List<Product> productLine, Date creationDate, Date requiredDate, String status) {
        this.productLine = productLine;
        this.creationDate = creationDate;
        this.requiredDate = requiredDate;
        this.status = status;
    }



    public Requisition(List<Product> productLine, int userId, Date creationDate, Date requiredDate, String status) {
        this.productLine = productLine;
        this.userId = userId;
        this.creationDate = creationDate;
        this.requiredDate = requiredDate;
        this.status = status;
    }

    public Requisition(int id, List<Product> productLine, int userId, Date creationDate, Date requiredDate,
                       String status) {
        this.id = id;
        this.productLine = productLine;
        this.userId = userId;
        this.creationDate = creationDate;
        this.requiredDate = requiredDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProductLine() {
        return productLine;
    }

    public void setProductLine(List<Product> productLine) {
        this.productLine = productLine;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
