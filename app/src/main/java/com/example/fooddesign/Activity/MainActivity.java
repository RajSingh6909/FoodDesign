package com.example.fooddesign.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fooddesign.Retrofit.ApiClient;
import com.example.fooddesign.Model.Category;
import com.example.fooddesign.Model.Category_;
import com.example.fooddesign.Model.Crop;
import com.example.fooddesign.Model.Crop_;
import com.example.fooddesign.R;
import com.example.fooddesign.Model.Sector;
import com.example.fooddesign.Model.Sector_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnersectorname, spinnercategoryname, spinnercropname, spinnercropnamelast;
    private LinearLayout sector_linearlayout, layoutlocation, lineardiff_sector, relativelayout_sector, addnewlineardiff_sector;
    private TextView itemtextview_sector, itemtextview_category, itemtextview_crop, newtextmonth, monthcount;
    private String stringSpinnerItem, stringMonth, spinnercategoty, stringcrop;
    private ArrayList<Sector_> sectorArrayList = new ArrayList<Sector_>();
    private ArrayList<String> sectorname = new ArrayList<String>();
    private ArrayList<Category_> category_s = new ArrayList<Category_>();
    private ArrayList<String> strCategoryname = new ArrayList<String>();
    private ArrayList<Crop_> cropArrayList = new ArrayList<Crop_>();
    private ArrayList<String> strcrops = new ArrayList<String>();
    private ArrayList<String> monthlist = new ArrayList<>();
    private Button submit;
    int PostCatid, PostCropid;
    private ArrayList<Integer> idinteger = new ArrayList<>();
    int PostSectorsid;
    //int sectorid;
    private ArrayList<Integer> sectorid = new ArrayList<>();
    private ArrayList<Integer> categoryid = new ArrayList<>();
    private ArrayList<Integer> cropid = new ArrayList<Integer>();

    List<List<List<List<List<Integer>>>>> matrix = new ArrayList<>();
    List<List<ArrayList<Integer>>> first = new ArrayList<List<ArrayList<Integer>>>();
    List<ArrayList<Integer>> second = new ArrayList<ArrayList<Integer>>();
    List<List<Integer>> third = new ArrayList<>();
    List<Integer> four = new ArrayList<>();
    int[][] sector;

    int count = 0;
    int cpunt;
    int sec, secId;
    int cat, cropId;
    List<Integer> crop;
    String[] spinnermonthItem = {"Select Harvest Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul ", "Aug", "Sept", "Oct", "Nov", "Dec"};
    HashMap<Integer, Integer> objHashMap, objCategory,objCropMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnersectorname = findViewById(R.id.spinnersectorname);
        relativelayout_sector = findViewById(R.id.relativelayout_sector);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //apiPost();
            }
        });
        sectorArrayList.clear();
        sectorname.clear();
        Call<Sector> sectorCall = ApiClient.getPostService().getSector();
        sectorCall.enqueue(new Callback<Sector>() {
            @Override
            public void onResponse(Call<Sector> call, Response<Sector> response) {
                sectorArrayList.addAll(response.body().getSector());
                sectorname.add("Sector name");
                for (int j = 0; j < sectorArrayList.size(); j++) {
                    sectorname.add(sectorArrayList.get(j).getName());
                    idinteger.add(Integer.valueOf(sectorArrayList.get(j).getId()));
                    PostSectorsid = idinteger.get(j);
                    ArrayAdapter aasector = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, sectorname);
                    aasector.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnersectorname.setAdapter(aasector);
                }
            }

            @Override
            public void onFailure(Call<Sector> call, Throwable t) {

            }
        });// first
        spinnersectorname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position != 0) {
                    position = position - 1;
                    sectorid.add(Integer.valueOf(sectorArrayList.get((position)).getId()));
                    for (int i = 0; i < sectorid.size(); i++) {
                        sec = sectorid.get(i);

                    }
//                   second.add(sectorid);
                    // sector=new int[second][];

                    LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View viewsector = layoutInflater.inflate(R.layout.sectorlayout, null);
                    final LinearLayout sectormainlayout = viewsector.findViewById(R.id.sectormainlayout);
                    relativelayout_sector.addView(viewsector);

                    lineardiff_sector = viewsector.findViewById(R.id.lineardiff_sector);
                    LayoutInflater layoutInflaternew = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View viewsectornew = layoutInflaternew.inflate(R.layout.sectorspinneritem, null);
                    lineardiff_sector.addView(viewsectornew);

                    itemtextview_sector = viewsectornew.findViewById(R.id.itemtextview_sector);
                    stringSpinnerItem = spinnersectorname.getSelectedItem().toString();
                    itemtextview_sector.setText(stringSpinnerItem);

                    ImageView txtRemove = viewsectornew.findViewById(R.id.sector_close);
                    txtRemove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            sectormainlayout.setVisibility(View.GONE);
                        }
                    });//second

                    spinnercategoryname = (Spinner) viewsectornew.findViewById(R.id.spinnercategoryname);
                    category_s.clear();
                    strCategoryname.clear();

                    Call<Category> catCall = ApiClient.getPostService().getCategory(sec);
                    catCall.enqueue(new Callback<Category>() {
                        @Override
                        public void onResponse(Call<Category> call, Response<Category> response) {
                            category_s.addAll(response.body().getCategory());
                            strCategoryname.add("Select category");
                            for (int i = 0; i < category_s.size(); i++) {
                                strCategoryname.add(category_s.get(i).getName());
                                ArrayAdapter aacat = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, strCategoryname);
                                aacat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                spinnercategoryname.setAdapter(aacat);
                            }
                        }

                        @Override
                        public void onFailure(Call<Category> call, Throwable t) {
                        }
                    });
                    spinnercategoryname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                            if (position != 0) {
                                position = position - 1;
                                categoryid.add(Integer.valueOf(category_s.get((position)).getId()));
                                for (int i = 0; i < categoryid.size(); i++) {
                                    cat = categoryid.get(i);
                                }


                                objHashMap = new HashMap<Integer, Integer>();
                                objHashMap.put(sec, cat);

                                LayoutInflater catlayoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                View viewcat = catlayoutInflater.inflate(R.layout.categoryspinner, null);
                                lineardiff_sector.addView(viewcat);
                                itemtextview_category = (TextView) viewcat.findViewById(R.id.itemtextview_category);
                                spinnercategoty = spinnercategoryname.getSelectedItem().toString();
                                itemtextview_category.setText(spinnercategoty);
                                final LinearLayout category_linearlayout = viewcat.findViewById(R.id.category_linearlayout);
                                ImageView txtRemove = viewcat.findViewById(R.id.category_close);
                                txtRemove.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        category_linearlayout.setVisibility(View.GONE);
                                    }
                                });//third
                                spinnercropname = (Spinner) viewcat.findViewById(R.id.spinnercategorynames);
                                cropArrayList.clear();
                                strcrops.clear();

                                Call<Crop> cropCall = ApiClient.getPostService().getCrop(cat);
                                cropCall.enqueue(new Callback<Crop>() {
                                    @Override
                                    public void onResponse(Call<Crop> call, Response<Crop> response) {
                                        cropArrayList.addAll(response.body().getCrop());
                                        strcrops.add("Select crop");
                                        for (int i = 0; i < cropArrayList.size(); i++) {
                                            System.out.println("Selected Position" + categoryid);
                                            strcrops.add(cropArrayList.get(i).getName());
                                            System.out.println("printselectstrmonthlast" + strcrops);
                                            System.out.println("datasectr" + cropArrayList);
                                            ArrayAdapter aaCrop = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, strcrops);
                                            aaCrop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                            spinnercropname.setAdapter(aaCrop);
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Crop> call, Throwable t) {
                                    }
                                });
                                spinnercropname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                                        if (position != 0) {
                                            position = position - 1;
                                            cropid.add(Integer.valueOf(cropArrayList.get((position)).getId()));
                                            for (int i = 0; i < cropid.size(); i++) {
                                                crop = Collections.singletonList(cropid.get(i));
                                                cropId = cropid.get(i);
                                            }

                                            Toast.makeText(getApplicationContext(), "Sector Id" + sec, Toast.LENGTH_LONG).show();
                                            Toast.makeText(getApplicationContext(), "Category Id" + cat, Toast.LENGTH_LONG).show();
                                            Toast.makeText(getApplicationContext(), "Crop Id" + crop, Toast.LENGTH_LONG).show();


                                            LayoutInflater croplayoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                            View viewcrop = croplayoutInflater.inflate(R.layout.cropspinner, null);
                                            lineardiff_sector.addView(viewcrop);
                                            addnewlineardiff_sector = viewcrop.findViewById(R.id.addnewlineardiff_sector);
                                            itemtextview_crop = (TextView) viewcrop.findViewById(R.id.itemtextview_crop);
                                            stringcrop = spinnercropname.getSelectedItem().toString();
                                            itemtextview_crop.setText(stringcrop);
                                            final LinearLayout crop_linearlayout = viewcrop.findViewById(R.id.crop_linearlayout);

                                            ImageView txtRemove = viewcrop.findViewById(R.id.crop_close);
                                            txtRemove.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    crop_linearlayout.setVisibility(View.GONE);
                                                }
                                            });//four

                                            monthcount = viewcrop.findViewById(R.id.monthcount);
                                            spinnercropnamelast = (Spinner) viewcrop.findViewById(R.id.spinnercropnamelast);
                                            ArrayAdapter aamonth = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, spinnermonthItem);
                                            aamonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                            spinnercropnamelast.setAdapter(aamonth);

                                            spinnercropnamelast.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                                                    if (position != 0) {
                                                        LayoutInflater layoutInflaterr = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                                        final View addViewmonthh = layoutInflaterr.inflate(R.layout.newmonthlayout, null);
                                                        addnewlineardiff_sector.addView(addViewmonthh);
                                                        newtextmonth = addViewmonthh.findViewById(R.id.newtextmonth);
                                                        monthlist.add(spinnercropnamelast.getSelectedItem().toString());
                                                        System.out.println("animalsecrtoe" + monthlist);
                                                        for (int i = 0; i < monthlist.size(); i++) {
                                                            stringMonth = monthlist.get(i);
                                                        }
                                                        int id = (int) spinnercropnamelast.getSelectedItemId();
                                                        ArrayList<Integer> monthlist = new ArrayList<>();
                                                        if (monthlist.addAll(Collections.singleton(id))) {
                                                            count++;
                                                            System.out.println("ctotalcount= " + count);
                                                            monthcount.setVisibility(View.VISIBLE);
                                                            monthcount.setText(String.valueOf(count));
                                                        }
                                                        //four.add(count);
                                                        newtextmonth.setText(stringMonth);
                                                        final LinearLayout month_linearlayout = addViewmonthh.findViewById(R.id.newmonthlinearlayout);
                                                        ImageView txtRemove = addViewmonthh.findViewById(R.id.month_close);
                                                        txtRemove.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                month_linearlayout.setVisibility(View.GONE);
                                                            }
                                                        });
                                                    }
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> adapterView) {
                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {
                                    }
                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    private void apiPost() {

        Log.d("Selected Sector ID", sectorid.toString());
        Log.d("Selected Category Id", categoryid.toString());
        Log.d("Selected Crop Id", cropid.toString());
        Log.d("MonthList", monthlist.toString());

        for (Map.Entry m : objHashMap.entrySet()) {
            System.out.println(m.getKey() + "," + m.getValue());

        }

        for (Map.Entry category : objCategory.entrySet()) {
            System.out.println(category.getKey() + "," + category.getValue());
        }

//        Call<PostSector> sectorCall = ApiClient.getPostService().getPost("1", "2", "rajsubhammohite", "TikTokIndiaBand", "SMS", "", "7896587452", "9898745879", "xyz@mail.com", "abc@mail.com", "2", "40", "male", "PHD", "1", "1", "1", "laxmi nagar,bandra(w),mumbai-97", "400097", "19.17630130", "73.10028076", "s.v road,andheri(w),mumbai-98", "Owned", "5", "Cents", "food_gospel_pickup", "NEED 12 HOUR PRIOR NOTICE", "", "", "", "PRIVATE USE", sectorid, categoryid, cropid, monthlist, "292", "Cheese", "1", "304", "2");
//        sectorCall.enqueue(new Callback<PostSector>() {
//            @Override
//            public void onResponse(Call<PostSector> call, Response<PostSector> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                    Log.d("mrtscss", response.body().getMessage());
//                }
//            }
//            @Override
//            public void onFailure(Call<PostSector> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "response failed", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

}