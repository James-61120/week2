package Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tutorial_v1.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import Model.UserAccount;
import Retrofit.IMyService;
import de.hdodenhof.circleimageview.CircleImageView;
import dmax.dialog.SpotsDialog;
import es.dmoral.toasty.Toasty;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import Retrofit.RetrofitClient;

public class UserAvatarActivity extends AppCompatActivity {
    Toolbar userAvaTB;
    Button ChonAnhThuVien, ChupAnhMoi,updateAva;
    CircleImageView circleImageView;
    File file;
    Bitmap bitmap;
    UserAccount userAccount=new UserAccount();
    IMyService iMyService;
    boolean flag=false,flag2=false;
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_avatar);

        setUIReference();
        ActionToolBar();
        alertDialog= new SpotsDialog.Builder().setContext(this).build();
        Retrofit retrofitClient= RetrofitClient.getInstance();
        iMyService=retrofitClient.create(IMyService.class);
        userAccount= (UserAccount) getIntent().getSerializableExtra("userAcc");
        String avurl="http://149.28.24.98:9000/upload/user_image/";

        Picasso.get().load(avurl+userAccount.getAva()).placeholder(R.drawable.useravatar).error(R.drawable.useravatar).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).into(circleImageView);

        ChonAnhThuVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //choose image using pictures from gallery

            }
        });
        ChupAnhMoi.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                //choose image using camera
            }
        });
        updateAva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //button click to confirm change profile-picture
            }
        });
    }



    private void ActionToolBar() {
        setSupportActionBar(userAvaTB);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        userAvaTB.setTitleTextColor(-1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        userAvaTB.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setUIReference() {
        userAvaTB=findViewById(R.id.userAvaTB);
        circleImageView=findViewById(R.id.userAvatar);
        ChonAnhThuVien=findViewById(R.id.ThuVienAnh);
        ChupAnhMoi=findViewById(R.id.ChupAnhMoi);
        updateAva=findViewById(R.id.updateAva);
    }


}