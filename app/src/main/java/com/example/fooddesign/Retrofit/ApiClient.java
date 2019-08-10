package com.example.fooddesign.Retrofit;


import com.example.fooddesign.Model.Category;
import com.example.fooddesign.Model.Crop;
import com.example.fooddesign.Model.PostSector;
import com.example.fooddesign.Model.Sector;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class ApiClient {

    private static final String urll = "http://togglebits.in/food_gospel/";
    public static PostService postService = null;

    public static PostService getPostService() {
        if (postService == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(urll).addConverterFactory(GsonConverterFactory.create()).build();
            postService = retrofit.create(PostService.class);

        }
        return postService;
    }

    public interface PostService {

        @Headers({"email:demo@demo.com", "password:demo"})
        @POST("sector")
        Call<Sector> getSector();

        @FormUrlEncoded
        @Headers({"email:demo@demo.com", "password:demo"})
        @POST("category")
        Call<Category> getCategory(@Field("sector_id") int sector_id);

        @FormUrlEncoded
        @Headers({"email:demo@demo.com", "password:demo"})
        @POST("crop")
        Call<Crop> getCrop(@Field("category_id") int category_id);

        @FormUrlEncoded
        @Headers({"email:demo@demo.com", "password:demo"})
        @POST("addFarmer")
        Call<PostSector> getPost(@Field("farm_type") String farm_type, @Field("user_id") String user_id, @Field("name") String name, @Field("farm_name") String farm_name, @Field("contact_mode") String contact_mode, @Field("landline") String landline, @Field("mobile") String mobile, @Field("whatsapp") String whatsapp, @Field("email") String email, @Field("market_email") String market_email, @Field("language") String language, @Field("age") String age, @Field("sex") String sex, @Field("qualification") String qualification, @Field("state") String state, @Field("district") String district, @Field("city") String city, @Field("address") String address, @Field("postal_code") String postal_code, @Field("latitude") String latitude, @Field("longitude") String longitude, @Field("mailing_address") String mailing_address, @Field("land_ownership") String land_ownership, @Field("land_hold") String land_hold, @Field("land_hold_type") String land_hold_type, @Field("delivery") String delivery, @Field("send_option") String send_option, @Field("cold_chain_store") String cold_chain_store, @Field("delivery_time") String delivery_time, @Field("time_type") String time_type, @Field("product_use") String product_use, @Field("sector[]") int sector, @Field("sector[]") String sectorsecond, @Field("category[][]") int category, @Field("category[][]") String category_second, @Field("category[][]") String category_third, @Field("category[][]") String category_four, @Field("crop[][]") int crop, @Field("crop[][]") String crop_one, @Field("harvest_month[][]") String harvest, @Field("harvest_month[][]") String harvest_one, @Field("harvest_month[][]") String harvest_two, @Field("harvest_month[][]") String harvest_third, @Field("milk_type[]") String milk, @Field("product[][]") String product, @Field("livestock[]") String livestock, @Field("poultry_grown[]") String poultry, @Field("poultry_count[]") String poultry_one);

    }


}
