package bengalSofts.com.retrofit_real_api_get_method.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OurRetrofitClint {

    @GET("continents")
    Call<MainDataClass> getData(@Query("api_token") String token);

}
