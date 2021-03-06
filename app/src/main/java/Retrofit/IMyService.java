package Retrofit;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

public interface IMyService {

    //Login Activity
    @POST("login")
    @FormUrlEncoded
    Observable<Response<String>> loginUser(@Field("email") String email, @Field("password") String actToken);

    //Register Activity
    @POST("register")
    @FormUrlEncoded
    Observable<Response<String>> registerUser(@Field("name") String name,
                                              @Field("email") String email,
                                              @Field("password") String password,
                                              @Field("phone") String phone,
                                              @Field("address") String address,
                                              @Field("description") String descript,
                                              @Field("gender") String gender);

    //Active Account Activity
    @POST("active-account")
    @FormUrlEncoded
    Observable<String>  activeAccUser(@Field("email") String email,
                                      @Field("activeToken") String actToken);

    //UserInfo Activity
    @PUT("change-profile")
    @FormUrlEncoded
    Observable<Response<String>>  changeProfile(@Field("name") String oldPass,
                                                @Field("phone") String phone,
                                                @Field("address") String address,
                                                @Field("description") String description,
                                                @Field("gender") String gender,
                                                @Header("auth-token") String authToken);

    //UserAvatar Activity
    @Multipart
    @PUT("change-avatar")
    Observable<Response<String>>  changeAva(@Part MultipartBody.Part file,
                                            @Header("auth-token") String authToken);

    //UserPasswordChange Activity
    @PUT("change-password")
    @FormUrlEncoded
    Observable<Response<String>>  changePass(@Field("oldpassword") String oldPass,
                                             @Field("newpassword") String newPass,
                                             @Header("auth-token") String authToken);

    //Account Fragment
    @GET("logout")
    Observable<String>  userLogout(@Header("auth-token") String authToken);


}
