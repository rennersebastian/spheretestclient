package main.sphere_test;

import io.sphere.client.model.SearchResult;
import io.sphere.client.shop.SphereClient;
import io.sphere.client.shop.SphereClientConfig;
import io.sphere.client.shop.model.Product;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import com.google.common.util.concurrent.ListenableFuture;

public class JavaClientExample {
	
	private static SphereClient sphere;
	
	public void initialize(){
    	SphereClientConfig scc = new SphereClientConfig.Builder("zebra", "TENi1qh1goZOGLsSKX3bR2Vx", "WYcG1Hg-jmdgmfAU57PXJPOOvOxrpdLb",
                Locale.ENGLISH).build();

        sphere = SphereClient.create(scc);
    }
    
    public void endSession(){
        sphere.shutdown();
    }
    
    public int getProductCount() throws InterruptedException, ExecutionException {
		ListenableFuture<SearchResult<Product>> products = sphere.products()
		        .all().fetchAsync();
		
		return products.get().getCount();
	}
    
    public void listProductNames() throws InterruptedException, ExecutionException{
    	ListenableFuture<SearchResult<Product>> products = sphere.products()
		        .all().page(0).fetchAsync();
		
		List<Product> results = products.get().getResults();
		
		for (Product p : results) {
		    System.out.println("Product name: " + p.getName());
		}
    }
}
