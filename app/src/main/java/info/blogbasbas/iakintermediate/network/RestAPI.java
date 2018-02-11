package info.blogbasbas.iakintermediate.network;

import info.blogbasbas.iakintermediate.pojo.ResponseResep;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by User on 10/02/2018.
 */

public interface RestAPI {

    //ngambil respon dari restapi
    @GET("getdataresep.php")
    Call<ResponseResep>getDataResep();

}
