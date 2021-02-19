package bengalSofts.com.retrofit_real_api_get_method;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import bengalSofts.com.retrofit_real_api_get_method.model.MainDataClass;
import bengalSofts.com.retrofit_real_api_get_method.model.ObjectDataClass;
import bengalSofts.com.retrofit_real_api_get_method.model.OurRetrofitClint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //retrofit instasns
        Retrofit retrofit =new  Retrofit
                .Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OurRetrofitClint ourRetrofitClint =retrofit.create(OurRetrofitClint.class);

     Call<MainDataClass> call= ourRetrofitClint.getData("tSpNihOAjEJAskVF5UsqrINmJTTmnYnXIsxLbIA5u26smS9OZJEbquu8ivv5");

     call.enqueue(new Callback<MainDataClass>() {
         @Override
         public void onResponse(Call<MainDataClass> call, Response<MainDataClass> response) {

             if(response.isSuccessful()){

              List<ObjectDataClass> list = response.body().getData();

              for(ObjectDataClass objectDataClass : list){

                  Log.d("id",String.valueOf(objectDataClass.getId()));
                  Log.d("name",String.valueOf(objectDataClass.getName()));
                  Log.d("resource",String.valueOf(objectDataClass.getResource()));
                  Log.d("updated_at",String.valueOf(objectDataClass.getUpdated_at()));


              }

             }else {
                 Log.d("response","fail");

             }
         }

         @Override
         public void onFailure(Call<MainDataClass> call, Throwable t) {
             Log.d("response","fail");

         }
     });



    }
}