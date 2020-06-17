package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

public class RequisitionDao {

    Map<Integer,Requisition> reqDb = new HashMap<>();

    {
        List<Product> products = new ArrayList<>();
        products.add(new Product("meat", 123, 4));
        products.add(new Product("buns", 23, 465));
        products.add(new Product("water", 20, 345));
        products.add(new Product("food", 2, 215));

        List<Product> products1 = new ArrayList<>();
        products1.add(new Product("meat", 12, 4));
        products1.add(new Product("buns", 2378, 46));
        products1.add(new Product("water", 2056, 345));
        products1.add(new Product("food", 255, 215));

        List<Product> products2 = new ArrayList<>();
        products2.add(new Product("meat", 12878, 4));
        products2.add(new Product("buns", 237, 465));
        products2.add(new Product("water", 205, 34));
        products2.add(new Product("food", 25, 215));

        List<Product> products3 = new ArrayList<>();
        products3.add(new Product("meat", 123, 4));
        products3.add(new Product("buns", 237, 465));
        products3.add(new Product("water", 226, 34));
        products3.add(new Product("food", 2, 2153));

        List<Product> products4 = new ArrayList<>();
        products4.add(new Product("meat", 12, 74));
        products4.add(new Product("buns", 238, 425));
        products4.add(new Product("water", 226, 34));
        products4.add(new Product("food", 2, 23));

        Date creationDate = new Date();
        Date reqDate = new Date();
        reqDb.put(1, new Requisition(1, products4, 1, creationDate, reqDate, "PENDING", 1));
        reqDb.put(2, new Requisition(2, products1, 1, creationDate, reqDate, "PENDING", 2));
        reqDb.put(3, new Requisition(3, products2, 1, creationDate, reqDate, "PENDING", 3));
        reqDb.put(4, new Requisition(4, products3, 1, creationDate, reqDate, "PENDING", 1));
        reqDb.put(5, new Requisition(5, products, 1, creationDate, reqDate, "PENDING", 2));
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

    public Requisition getRequisitionById(int id) {
        return reqDb.get(id);
    }

    public void deleteRequisitionById(int id) {
        reqDb.remove(id);
    }
}
