package jp.ac.chiba_fjb.x15g029.test150;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        LatLng sydney = new LatLng(35.7016369, 139.9836126);                //位置設定
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,15.0f));   //範囲2.0～21.0(全体～詳細)
//        mMap.addMarker(new MarkerOptions().position(sydney).title("マーカーテスト"));
//        //マーカータップのイベントを拾う
//        mMap.setOnMarkerClickListener(this);
//        sydney = new LatLng(35.7043291,139.9842291);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("船橋情報ビジネス専門学校"));
        //自分の位置をマップ上に表示
        MyLocationSource ls = new MyLocationSource(this);
        googleMap.setMyLocationEnabled(true); //警告は無視
        googleMap.setLocationSource(ls);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(),15.0f));
        return false;

    }
}
