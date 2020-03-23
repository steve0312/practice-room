package com.example.graduationproject.result;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduationproject.R;
import com.example.graduationproject.form.FormComponentVO;
import com.example.graduationproject.form.FormDTO;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SummaryViewFragment extends Fragment {
    private View v;

    private Spinner spinner;
//    private ArrayList<String> question;
    private ArrayList<String> answer;
    private String all;
    private ArrayList<String> spinner_question = new ArrayList<String>();
    private ArrayList<String> questions_answer = new ArrayList<String>();
    private ArrayList<String> grid_answer = new ArrayList<String>();
    private ArrayList<String> test_answer = new ArrayList<String>();

    private String url;//getString(R.string.baseUrl);
    private String userEmail;
    private int form_id;
    private FormDTO formDTO=null;

    private ArrayList<IndividualViewDTO> datas1=new ArrayList<>();
    private ArrayList<IndividualResultDTO> datas2;
//    private ArrayList<IndividualResultDTO> datas2;

    private IndividualViewDTO individualViewDTO;
    private RecyclerView individualResultRV;
    private RecyclerView.Adapter  individualResultAdapter;
//    private ArrayList<FormComponentVO> componentVOS;
    private RecyclerView.Adapter  individualViewAdapter;
    private RecyclerView individualViewRV;

    TextView question;
    public static String select_item = "";

    FrameLayout frameLayout;
    LinearLayout linearLayout;
    String title;
    String description;
    int participate_num;
    int range;

    public SummaryViewFragment() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        url=getString(R.string.baseUrl);

        if(getArguments()!=null) {
            userEmail = getArguments().getString("userEmail");
            form_id = getArguments().getInt("form_id");
            individualViewDTO = (IndividualViewDTO) getArguments().getSerializable("resultData");
        }



//        Log.v("11테스트11", "Email : " + userEmail + "/ Id : " + form_id);

        Log.v("순서", "순서1");

        getDataSetting(userEmail, form_id);
        getDataUsing(form_id);

//        onCreateView(R.layout.activity_result_summary,container,false);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        LinearLayout layout=(LinearLayout) inflater.inflate(R.layout.activity_result_summary,container,false);

//        Log.v("순서", "순서3");

//        getServerData(form_id);
//        Log.v("리얼테스트", "size : " + componentVOS.size());

        Log.v("순서", "순서4");



        v = inflater.inflate(R.layout.activity_result_summary, container, false);
//        v = inflater.inflate(R.layout.fragment_graph, container, false);


        spinner = (Spinner)v.findViewById(R.id.summary_spinner);
//        frameLayout = (FrameLayout) v.findViewById(R.id.frag_container_);
//        linearLayout = (LinearLayout) v.findViewById(R.id.description_layout);


//        frameLayout.setlayout

//        spinner_question = new ArrayList<String>();

//        Log.v("테스트이거", "" + spinner_question.get(0));

//        Log.v("테스트드드드", "" + componentVOS.size());

//        ArrayList<String> test = new ArrayList<String>();
//        test.add("테스트1");
//        test.add("테스트2");
//        test.add("테스트3");

//        Log.v("순서", "size는 : " + componentVOS.size());


        Log.v("순서", "순서5");

//        spinner_question.remove(0);
        spinner_question.add("   ===== 결과 보기 ===== ");

        //using ArrayAdapter
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.support_simple_spinner_dropdown_item, spinner_question);
//        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setSelection(0);
        spinner.setAdapter(spinnerAdapter);

        Log.v("순서", "순서6");

        //event listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(), "선택된 아이템 : "+ spinner.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                String selected_item = (String) parent.getItemAtPosition(position);

//                Log.v("넘기는테스트", "item : " + selected_item);
//                Log.v("넘기는테스트", "spinner : " + spinner.getItemAtPosition(position + 1));



//                switch (select) {
//                    case spinner.
//                }
//                Bundle bundle = new Bundle();
//                bundle.putStringArrayList("legend", spinner_question);
//                GraphFragment fg = new GraphFragment();
//                fg.setArguments(bundle);

//                getActivity().getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.frag_container_, new GraphFragment())
//                        .commit();


//                if(spinner.getItemAtPosition(position).equals(spinner_question.get(position))) {
//                if(item.equals(spinner_question.get(position))) {


                if(selected_item != "   ===== 결과 보기 ===== "){

//                if(position != 0){
//                    Bundle bundle = new Bundle();
//                    bundle.putString("legend", "전달 테스트용");
//                    GraphFragment gf = new GraphFragment();
//                    gf.setArguments(bundle);

//                    GraphFragment gf = GraphFragment.newInstance(spinner_question);

                    Log.v("어딘지테스트", "This : " + getActivity());


//                    linearLayout.setVisibility(View.GONE);


                    getActivity().getSupportFragmentManager()
                        .beginTransaction()
//                        .replace(R.id.frag_container_, new GraphFragment())
//                        .replace(R.id.frag_container_, GraphFragment.newInstance(spinner_question))
                        .replace(R.id.frag_container_, GraphFragment.newInstance(selected_item, participate_num, spinner_question, questions_answer, grid_answer, test_answer)).commit();

//                    Intent intent = new Intent(getContext(), GraphActivity.class);
//                    startActivity(intent);
                }
                else {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frag_container_, DescriptionFragment.newInstance(title, description, participate_num)).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getContext(), "아무것도 선택 안됨", Toast.LENGTH_SHORT).show();
            }
        });

        Log.v("순서", "순서66");

        return v;

//        return layout;
    }

    public void getDataSetting(String userEmail, int form_id){
        OkHttpClient client=new OkHttpClient();
        RequestBody requestbody=new MultipartBody.Builder().
                setType(MultipartBody.FORM)
                .addFormDataPart("userEmail",userEmail)
                .addFormDataPart("form_id",String.valueOf(form_id))
                .build();
        okhttp3.Request request=new okhttp3.Request.Builder()
                .url(url+"load")
                .header("Content-Type", "multipart/form-data")
                .post(requestbody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.v("서머리테스트","폼 전송 실패");
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String res=response.body().string();

                Log.v("서머리테스트초기",res);


                res=res.replace ("\\", "")
                        .replace("\"[","[")
                        .replace("]\"","]")
                        .replace("}\"","}")
                        .replace("\"{","{");




                Log.v("서머리테스트",res);
                try {

                    JSONArray jsonArray=new JSONArray(res);
                    participate_num = jsonArray.length();

                    for(int i=0;i<jsonArray.length();i++){
                        IndividualViewDTO individualViewDTO=new IndividualViewDTO();
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        JSONObject jsonObjResult=jsonObject.getJSONObject("surveyResult");
                        jsonObjResult.remove("form_id");
                        jsonObjResult.remove("userEmail");

                        String time=jsonObject.getString("time");
//                        String title=jsonObject.getString("title");
//                        String description=jsonObject.getString("description");

                        Log.v("서머리테스트1",time);
//                        Log.v("서머리테스트11",title);
//                        Log.v("서머리테스트11",description);
                        Log.v("서머리테스트2",jsonObjResult.toString());

                        Log.v("서머리테스트22", jsonObjResult.getString("0"));
                        test_answer.add(jsonObjResult.toString());


                        Iterator<String> keys= jsonObjResult.keys();
                        HashMap<String,ArrayList<String>> gridParser=new HashMap<>();
                        ArrayList<String> removeKeys=new ArrayList<>();
                        while(keys.hasNext()){
                            String key=keys.next();
                            Log.v("서머리테스트3","key값 : "+key);
                            if(key.split("-").length==2){

                                String[] grids=key.split("-");
                                String gridKey=grids[0];
                                String gridVal=jsonObjResult.getString(key);
                                Log.v("서머리테스트4","gridKey : "+gridKey+"  gridVal :" +gridVal+" key : "+key);
                                grid_answer.add(key);
                                grid_answer.add(gridVal);

                                removeKeys.add(key);

                                if(gridParser.containsKey(gridKey)){
                                    gridParser.get(gridKey).add(gridVal);
                                }else{
                                    ArrayList<String> temp=new ArrayList<>();
                                    temp.add(gridVal);
                                    gridParser.put(gridKey,temp);
                                }
                            }
                        }
                        for(int j=0;j<removeKeys.size();j++){
                            jsonObjResult.remove(removeKeys.get(j));
                        }
                        Log.v("서머리테스트5",jsonObjResult.toString());
                        Iterator<String>  iterator=gridParser.keySet().iterator();
                        while(iterator.hasNext()){
                            String key=iterator.next();
                            individualViewDTO.setResult(Integer.valueOf(key),gridParser.get(key));
                        }
                        individualViewDTO.setIndex(i+1);
                        individualViewDTO.setTime(time);

                        for(int j=0;j<jsonObjResult.length();j++){
                            Object json=jsonObjResult.get(String.valueOf(j));

                            if(json instanceof JSONArray){
                                JSONArray multiAnswerJson=(JSONArray)json;
                                ArrayList<String> multiAnswer=new ArrayList<>();
                                for(int k=0;k<multiAnswerJson.length();k++){
                                    multiAnswer.add(multiAnswerJson.getString(k));
//                                    multiAnswer.add(multiAnswerJson.getString(k));
                                }
                                individualViewDTO.setResult(j,multiAnswer);

//                                questions_answer.add("" + individualViewDTO.getResult().get(j));
                            }else{
                                ArrayList<String> multiAnswer=new ArrayList<>();
                                multiAnswer.add(String.valueOf(json));
//                                multiAnswer.add(String.valueOf(json));
                                individualViewDTO.setResult(j,multiAnswer);

//                                questions_answer.add("" + individualViewDTO.getResult().get(j));
                            }
                            Log.v("레드향테스트", "" + individualViewDTO.getResult().get(j));

                            questions_answer.add("" + individualViewDTO.getResult().get(j));
                            Log.v("퀘스천테스트1", "question_answer.size : " + questions_answer.size());
                            Log.v("퀘스천테스트2", "question_answer.get : " + questions_answer.get(j));
                            Log.v("퀘스천테스트3", "individualViewDTO : " + individualViewDTO);

//                            resultlink = individualViewDTO;
//                            Log.v("퀘스천퀘스천테스트", resultlink);
                        }
                        range = jsonArray.length();

                        datas1.add(individualViewDTO);
                        Log.v("퀘스천테스트4", "datas1.size : " + datas1.size());
                        Log.v("퀘스천테스트5", "individualViewDTO : " + individualViewDTO);
//                        Log.v("퀘스천테스트5", "individualViewDTO : " + individualViewDTO.toString());
                    }
//                    getActivity().runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            individualViewAdapter=new IndividualViewRV(getContext(),datas1,form_id);
//                            individualViewRV.setAdapter(individualViewAdapter);
//                        }
//                    });

                }catch (Exception e){
                    e.printStackTrace();
                    Log.v("서머리테스트6",e.getMessage());
                }

            }
        });
    }

    public void getDataUsing(int form_id){
        OkHttpClient client=new OkHttpClient();
        okhttp3.Request request=new okhttp3.Request.Builder()
                .url(url+"individual/"+form_id)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.v("테스트서머리1", "000");

                try{
                    String res=response.body().string();
                    Log.v("테스트서머리2",res);

                    Log.v("테스트서머리3", "000");
                    JSONObject jsonObject=new JSONObject(res);

                    title = jsonObject.getString("title");
                    description = jsonObject.getString("description");
                    Log.v("테스트서머리33", title);
                    Log.v("테스트서머리333", description);


//                    for(int i=0;i<jsonObject.length();i++) {
////                        JSONObject jsonObjResult=jsonObject.getJSONObject("title");
////                        jsonObjResult.remove("userEmail");
//                        String title=jsonObject.getString("title");
//
//                        Log.v("테스트서머리33", title);
//                    }



                    Log.v("테스트서머리4", "000");
                    Gson gson=new Gson();
                    formDTO=gson.fromJson(jsonObject.toString(), FormDTO.class);
                    ArrayList<FormComponentVO> componentVOS=formDTO.getFormComponents();

                    Log.v("테스트서머리5", "" + "size1 : " + componentVOS.size());

                    for(int i=0;i<componentVOS.size();i++) {
                        spinner_question.add(componentVOS.get(i).getQuestion());

                        Log.v("테스트서머리6", "" + "0");

                        Log.v("테스트서머리7", "" + spinner_question.size());
                        Log.v("테스트서머리8", "" + componentVOS.get(i).getQuestion());


                        Log.v("테스트서머리9", "1");
                        IndividualResultDTO individualResultDTO = new IndividualResultDTO();

//                        ViewHolder viewHolder = new IndividualViewRV.ViewHolder(v);


//                        Log.v("테스트서머리10", "" + individualViewDTO.getResult().get(i));
//                        Log.v("테스트서머리10", "" + individualViewDTO.getResult());


//                        Log.v("테스트서서서머리리리", "test : " + individualViewDTO.getResult().get(0));
//                        ArrayList<String> answers = individualViewDTO.getResult().get(i);

                        for (int p = 0; p < range; p++) {
                            ArrayList<String> answers = datas1.get(p).getResult().get(i);
//                        Log.v("테스트서머리머리", "" + datas1.get(i).getResult().get(i));


                            String answer = "";

//                            Log.v("테스트서머리1010", "" + datas1.get(p).getResult().get(i));
//                            Log.v("테스트서머리11", "" + datas1.get(p).getResult().size());


//                        Log.v("테스트서머리1010", "" + answers.size());
//                            Log.v("테스트서머리101010", "" + questions_answer.get(i));
//                        Log.v("테스트서머리11", "" + answers.get(i));



//                        spinner_question.add(componentVOS.get(i).getQuestion());
//
//                        Log.v("리얼이얼테스트2", "" + spinner_question.size());
//                        Log.v("테스트테스트테스트", "" + componentVOS.get(i).getQuestion());


                            Log.v("테스트서머리12", "3");

                            if (componentVOS.get(i).getType() == 6) {
                                for (int j = 0; j < answers.size(); j++) {
                                    answer += (String.valueOf(j + 1) + ". " + componentVOS.get(i).getAddedColOption().get(Integer.valueOf(answers.get(j))) + " ");
//                                Log.v("테스트테스트", "4");
                                }
//
                            } else {
                                for (int j = 0; j < answers.size(); j++) {
                                    answer += answers.get(j);
                                    Log.v("테스트서머리13", "45");
                                }
                            }
                            Log.v("테스트서머리14", "answer11 : " + answer);

                            individualResultDTO.setQuestion(componentVOS.get(i).getQuestion());
                            individualResultDTO.setAnswer(answer);
                            Log.v("테스트서머리15", "7");
                            Log.v("테스트서머리16", componentVOS.get(i).getQuestion() + "  " + answer);

//                        datas2.add(individualResultDTO);
                            Log.v("테스트서머리17", "answer22 : " + answer);
                        }
                    }

//                    getActivity().runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            individualResultAdapter=new IndividualResultRV(getContext(),datas2);
//                            Log.v("테스트테스트", "9");
//                            individualResultRV.setAdapter(individualResultAdapter);
//                            Log.v("테스트테스트", "10");
//                        }
//                    });

                }catch (Exception e){e.printStackTrace();}
            }
        });
    }
}
