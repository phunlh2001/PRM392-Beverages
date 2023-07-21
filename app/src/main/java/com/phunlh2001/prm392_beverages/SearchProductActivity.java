package com.phunlh2001.prm392_beverages;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.phunlh2001.prm392_beverages.Interface.RecyclerViewInterface;
import com.phunlh2001.prm392_beverages.adapters.ProductAdapter;
import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.dao.ProductDao;
import com.phunlh2001.prm392_beverages.data.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchProductActivity extends AppCompatActivity {
    private Button btnSearch;
    private Button btnCart;
    private EditText edtSearch;
    private RecyclerView rcvProduct;
    private ProductAdapter productAdapter;
    private List<Product> _list;
    private ProductDao productDao;
    AppDatabase dbConnection;

    ActivityResultLauncher<Intent> mActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==RESULT_OK){
                        Intent intent = result.getData();
                    }
                }
            });

    private void init() {
        // anh xa view
        rcvProduct = findViewById(R.id.rcv_product);
        btnSearch = findViewById(R.id.btn_search);
        edtSearch = findViewById(R.id.edt_search);
        btnCart = findViewById(R.id.btn_cart);

        // khoi tao adapter rcv, bat su kien onclick len rcv
        productAdapter = new ProductAdapter(this, new RecyclerViewInterface() {
            @Override
            public void onItemClick(Product product) {
                onClickgotoActivityDetail(product);
            }

            @Override
            public void onCartClick(Product product) {
                onClickToCart(product);
            }
        });

        // khoi tao dao
        productDao = AppDatabase.getInstance(this).productDao();

        // khoi tao dtb
        dbConnection =AppDatabase.getInstance(this);
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);

        init();
        viewProduct();

        //on click search
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSearchProduct();
            }
        });



    }


    //Ham ket noi vao CSDL va lay toan bo danh sach du lieu
//    private List<Product> setDataTable() {
//        List<Product> datalist = dbConnection.productDao().getAll();
//        return datalist;
//    }
    private void viewProduct() {
        // tao rcv
        GridLayoutManager gridLayoutManager =new GridLayoutManager(this, 1);
        rcvProduct.setLayoutManager(gridLayoutManager);

        // set data
        _list = new ArrayList<>();
        List<Product> _list = productDao.getAll();
        productAdapter.setData(_list);

        // set adapter cho rcvMenu
        rcvProduct.setAdapter(productAdapter);
    }

    private void handleSearchProduct() {
        String strKeyword = edtSearch.getText().toString().trim();
        //tao list product rong cho du lieu da search
        _list = new ArrayList<>();
        _list = AppDatabase.getInstance(this).productDao().searchProduct(strKeyword);
        productAdapter.setData(_list);
    }

    public void onClickgotoActivityDetail(Product product) {
        Intent intent = new Intent(SearchProductActivity.this,ProductDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_product",product);
        intent.putExtras(bundle);
        mActivityResultLauncher.launch(intent);
    }

    private void onClickToCart(Product product){
        product.setTitle(product.getTitle());
        product.setPrice(product.getPrice());
        product.setThumbnail(product.getThumbnail());

        startActivity(new Intent(SearchProductActivity.this , CartActivity.class));
    }
}