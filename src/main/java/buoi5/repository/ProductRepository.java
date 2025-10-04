package buoi5.repository;

import buoi5.entity.Category;
import buoi5.entity.Product;
import buoi5.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public List<Product> getAll(){
        List<Product> lstProducts= new ArrayList<>();

        String sql = "SELECT dbo.category.id, dbo.category.category_code, dbo.category.category_name, dbo.product.id AS product_id, dbo.product.product_code, dbo.product.product_name, dbo.product.price, dbo.product.description\n" +
                "FROM     dbo.category INNER JOIN\n" +
                "                  dbo.product ON dbo.category.id = dbo.product.category_id";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            //kiểm tra xem còn next dc ko?
            while (rs.next()){
                //1. tạo đối tượng category
                Category cate= new Category();
                cate.setId(rs.getInt(1));
                cate.setCode(rs.getString(2));
                cate.setName(rs.getString(3));
                //2. tạo đối tượng product
                Product product = new Product();
                product.setId(rs.getInt(4));
                product.setCode(rs.getString(5));
                product.setName(rs.getString(6));
                product.setPrice(rs.getDouble(7));
                product.setDescription(rs.getString(8));
                product.setCategory(cate);//lưu ý: set cả đối tượng

                //3. thêm đối tượng product vào list
                lstProducts.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return  lstProducts;
    }

    public static void main(String[] args) {
        ProductRepository repo= new ProductRepository();
        List<Product> list= repo.getAll();
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }
}
