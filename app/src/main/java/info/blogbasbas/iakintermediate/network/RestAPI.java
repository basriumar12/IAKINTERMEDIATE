package info.blogbasbas.iakintermediate.network;

import info.blogbasbas.iakintermediate.pojo.ResponseModel;
import info.blogbasbas.iakintermediate.pojo.ResponseResep;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by User on 10/02/2018.
 */

public interface RestAPI {

    //ngambil respon dari restapi
    @GET("getdataresep.php")
    Call<ResponseResep>getDataResep();

    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseModel> insertData(@Field("nama_resep")String nama,
                                   @Field("detail")String detailresep,
                                   @Field("gambar")String gambar);
    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseModel> updateData(@Field("id_resep")String id,
                                    @Field("nama_resep")String nama,
                                   @Field("detail")String detailresep,
                                   @Field("gambar")String gambar);
    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseModel> deleteData (@Field("id_resep")String idresep);


}
