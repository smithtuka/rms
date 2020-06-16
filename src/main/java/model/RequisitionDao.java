package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

public class RequisitionDao {

    static  Map<Integer,Requisition> reqDb = new HashMap<>();

    static {
        List<Product> products = new ArrayList<>();
        products.add(new Product("meat", 123, 4));
        products.add(new Product("buns", 23, 465));
        products.add(new Product("water", 20, 345));
        products.add(new Product("food", 2, 215));

        Date creationDate = new Date();
        Date reqDate = new Date();
        reqDb.put(1, new Requisition(1, products, 1, creationDate, reqDate, "PENDING"));
        reqDb.put(2, new Requisition(2, products, 1, creationDate, reqDate, "PENDING"));
        reqDb.put(3, new Requisition(3, products, 1, creationDate, reqDate, "PENDING"));
        reqDb.put(4, new Requisition(4, products, 1, creationDate, reqDate, "PENDING"));
        reqDb.put(5, new Requisition(5, products, 1, creationDate, reqDate, "PENDING"));
    }

    public int generateID() {
        return reqDb.size() + 1;
    }

    public List<Requisition> getRequisitions() {
        return new ArrayList<>(reqDb.values());
    }

    public void saveRequisition(Requisition requisition) {
        reqDb.put(requisition.getId(), requisition);
    }
}
