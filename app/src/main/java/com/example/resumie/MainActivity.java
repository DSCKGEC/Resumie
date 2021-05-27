package com.example.resumie;


import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.resumie.CV.CVFragment;
import com.example.resumie.PDF.PDFFragment;
import com.example.resumie.SharedPrefManager.SharedPrefManager;
import com.example.resumie.SideNavigation.ClickedCallback;
import com.example.resumie.SideNavigation.MenuAdapter;
import com.example.resumie.SideNavigation.MenuItem;
import com.example.resumie.SideNavigation.MenuUtil;
import com.example.resumie.home.HomeFragment;
import com.example.resumie.portfolio.PortfolioFragment;
import com.example.resumie.team.TeamFragment;
import com.google.android.material.textview.MaterialTextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickedCallback {

    ImageView imageView2;
    RecyclerView recyclerView;
    MenuAdapter menuAdapter;
    List<MenuItem> menu;
    int selectedMenuPosition = 0;
    SharedPrefManager sharedPrefManager;
    private int PICK_IMAGE = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSideNavigation();
        sharedPrefManager = new SharedPrefManager(this);

        setHomeFragment();


        if (sharedPrefManager.getHomeData() != null && sharedPrefManager.getHomeData().getProfileImage() != null) {
            Glide.with(this)
                    .load(sharedPrefManager.getHomeData().getProfileImage())
                    .centerCrop()
                    .into(imageView2);
        } else {
            Glide.with(this)
                    .load(R.drawable.user)
                    .centerCrop()
                    .into(imageView2);
        }
    }

    private void setSideNavigation() {
        recyclerView = findViewById(R.id.recyclerview_nav);
        imageView2 = findViewById(R.id.imageView2);

        menu = MenuUtil.getMenuList();
        menuAdapter = new MenuAdapter(menu, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(menuAdapter);

        onClickListeners();
    }

    private void onClickListeners() {

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PopupMenu popup = new PopupMenu(MainActivity.this, imageView2);
                popup.getMenu().add("Display Profile Photo");
                popup.getMenu().add("Upload new image");
                popup.getMenu().add("Cancel");


                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(android.view.MenuItem item) {

                        if (item.getTitle().equals("Upload new image")) {
                            Intent intent = new Intent();
                            intent.setType("image/*");
                            intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
                        } else if (item.getTitle().equals("Display Profile Photo")) {

                            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_profile_image, null);
                            ImageView imageView = view.findViewById(R.id.profile_image);
                            MaterialTextView materialTextView = view.findViewById(R.id.materialTextView);

                            if (sharedPrefManager.getHomeData().getName() == null)
                                materialTextView.setText("UserName");
                            else
                                materialTextView.setText(sharedPrefManager.getHomeData().getName());


                            if (sharedPrefManager.getHomeData().getProfileImage() == null)
                                imageView.setImageResource(R.drawable.user);
                            else {
                                Uri uri = Uri.parse(sharedPrefManager.getHomeData().getProfileImage());
                                imageView.setImageURI(uri);
                            }

                            AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                            adb.setView(view);
                            adb.show();

                        } else if (item.getTitle().equals("Cancel")) {
                            popup.dismiss();
                        }
                        return false;
                    }
                });

                popup.show();


            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && null != data) {

            String str = data.getData().toString();

            System.out.println("The data is " + data);
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            System.out.println(filePathColumn);
            if (data.getData() != null) {

                Uri mUri = data.getData();
                System.out.println("The Uri is " + mUri);
                String ext = GetFileExtension(mUri);
                System.out.println("The extension is " + ext);
                String id = DocumentsContract.getDocumentId(mUri);
                System.out.println(id);
                InputStream inputStream = null;
                try {
                    inputStream = getContentResolver().openInputStream(mUri);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                File file = new File(getCacheDir().getAbsolutePath() + "/" + id + "." + ext);
                System.out.println(file);
                writeFile(inputStream, file);
                String filePath = file.getAbsolutePath();
                System.out.println("The filepath is " + filePath);

                sharedPrefManager.setHomeData(filePath, 6);

                Glide.with(this)
                        .load(str)
                        .centerCrop()
                        .into(imageView2);
            }

        }
    }


    void setPortfolioFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PortfolioFragment()).commit();
    }

    void setCVFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CVFragment()).commit();
    }

    void setHomeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }

    void setTeamFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TeamFragment()).commit();
    }

    void setPDFFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PDFFragment()).commit();
    }

    @Override
    public void onSideMenuItemClick(int i) {

        switch (menu.get(i).getCode()) {

            case MenuUtil.HOME_FRAGMENT:
                setHomeFragment();
                break;
            case MenuUtil.CV_FRAGMENT:
                setCVFragment();
                break;
            case MenuUtil.TEAM_FRAGMENT:
                setTeamFragment();
                break;
            case MenuUtil.PORTFOLIO_FRAGMENT:
                setPortfolioFragment();
                break;
            case MenuUtil.PDF_FRAGMENT:
                setPDFFragment();
                break;
            default:
                setHomeFragment();
        }

        menu.get(selectedMenuPosition).setSelected(false);
        menu.get(i).setSelected(true);
        selectedMenuPosition = i;
        menuAdapter.notifyDataSetChanged();

    }


    // writing the file
    private void writeFile(InputStream inputStream, File file) {
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // getting the file extension of the selected file
    public String GetFileExtension(Uri uri) {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();

        // Return file Extension
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }
}