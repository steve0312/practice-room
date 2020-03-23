package com.example.graduationproject.result;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.graduationproject.R;
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
import com.google.gson.JsonObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GraphFragment extends Fragment {
    PieChart pieChart;
    BarChart barChart;
    LineChart lineChart;

    private ArrayList<String> get_question;
    private ArrayList<String> get_answer;
    private ArrayList<String> get_grid;
    private ArrayList<String> get_test;
    private String get_selected;
    int get_participate;

    TextView question;
    TextView participate_num1;

    TableLayout tableLayout;
    View v;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        get_question = new ArrayList<String>();
//
//        if (getArguments() != null) {
//            get_question = getArguments().getStringArrayList("param");
//        }

        Log.v("여기서테스트", "1");

        Bundle getBundle = getArguments();
        if(getBundle != null) {
            get_question = getBundle.getStringArrayList("question");
            get_answer = getBundle.getStringArrayList("answer");
            get_grid = getBundle.getStringArrayList("grid");
            get_selected = getBundle.getString("selected_item");
            get_participate = getBundle.getInt("participate");
            get_test = getBundle.getStringArrayList("test");
        }

        Log.v("오늘도테스트", "넘어온거 : " + get_selected);
        Log.v("오늘도테스트", "넘어온거 : " + get_participate);

        Log.v("오늘도테스트", "넘어온거 : " + get_test.size());
        Log.v("오늘도테스트", "넘어온거 : " + get_test.get(0));
        Log.v("오늘도테스트", "넘어온거 : " + get_test.get(1));
        Log.v("오늘도테스트", "넘어온거 : " + get_test.get(2));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_graph, container, false);

        tableLayout = (TableLayout) v.findViewById(R.id.table_layout);
        question = (TextView) v.findViewById(R.id.question_text);

//        participate_num1 = (TextView) v.findViewById(R.id.participate_num1);
        for(int q=0; q<get_test.size(); q++) {
//            String str = get_test.get(q).replace("{", "").replace("}", "");
            String str = get_test.get(q);
//            String name = str.get


//            if()
//            Log.v("여기서테스트1", str);
        }

        for(int k=0; k<get_question.size(); k++) {
            Log.v("받은퀘테스트", "Q결과" + k + " : " + get_question.get(k));
        }

        Log.v("받은답답답테스트", "" + get_answer.size());

        for(int m=0; m<get_answer.size(); m++) {
            int condition = m % get_answer.size();

            Log.v("받은답테스트", "A결과1" + m + " : " + get_answer.get(m).replace("[", "").replace("]", "").replace(",", ""));

            if(condition == 0 || condition == 4) {
                Log.v("받은답테스트", "A결과2" + m + " : " + get_answer.get(condition).replace("[", "").replace("]", ""));
            }
        }

        for(int n=0; n<get_grid.size(); n++) {
            Log.v("받은그테스트", "G결과" + n + " : " + get_grid.get(n));
        }


        TableLayout tl = (TableLayout) v.findViewById(R.id.table_layout);
//        tl.removeAllViews();

//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//        TableLayout.LayoutParams params = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT);
//        params.setMargins(0, 0, 3, 0);

//        TableRow tr = new TableRow(getContext());

//        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
//        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
//        params.setMargins(0, 0, 30, 0);


        for(int i=0; i<get_participate; i++) {
            TableRow tr = new TableRow(getContext());

            tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

//            for(int j=0; j<3; j++) {
                TextView element_num = new TextView(getContext());
                element_num.setText("" + (i+1));
                element_num.setPadding(3, 3, 3, 3);
                element_num.setBackgroundColor(Color.RED);
                element_num.setTextSize(15);
                element_num.setGravity(Gravity.CENTER_HORIZONTAL);
//            element_content.setBackgroundColor(Color.WHITE);


                //        TextView element_content = new TextView(tableLayout.getContext());
                TextView element_content = new TextView(getContext());
                element_content.setText("테스트2");
                element_content.setPadding(3, 3, 3, 3);
                element_content.setBackgroundColor(Color.RED);
                element_content.setTextSize(15);
                element_content.setGravity(Gravity.CENTER_HORIZONTAL);
//            element_content.setBackgroundColor(Color.WHITE);


                TextView element_response = new TextView(getContext());
                element_response.setText("테스트3");
                element_response.setPadding(3, 3, 3, 3);
                element_response.setBackgroundColor(Color.RED);
                element_response.setTextSize(15);
                element_response.setGravity(Gravity.CENTER_HORIZONTAL);
//            element_response.setBackgroundColor(Color.WHITE);


                tr.addView(element_num);
                tr.addView(element_content);
                tr.addView(element_response);
//            }
            tl.addView(tr);
        }


////        for(int i=0; i<get_participate; i++) {
//            TextView element_num = new TextView(getContext());
////            element_num.setText("" + (i+1));
//        element_num.setText("테스트1");
//        element_num.setPadding(3, 3, 3, 3);
//            element_num.setBackgroundColor(Color.RED);
//            element_num.setTextSize(15);
//            element_num.setGravity(Gravity.CENTER_HORIZONTAL);
////            element_num.setBackgroundColor(Color.WHITE);
//
////        }
//
////        TextView element_content = new TextView(tableLayout.getContext());
//            TextView element_content = new TextView(getContext());
//            element_content.setText("테스트2");
//        element_content.setPadding(3, 3, 3, 3);
//        element_content.setBackgroundColor(Color.RED);
//        element_content.setTextSize(15);
//            element_content.setGravity(Gravity.CENTER_HORIZONTAL);
////            element_content.setBackgroundColor(Color.WHITE);
//
//
//            TextView element_response = new TextView(getContext());
//            element_response.setText("테스트3");
//        element_response.setPadding(3, 3, 3, 3);
//        element_response.setBackgroundColor(Color.RED);
//            element_response.setTextSize(15);
//            element_response.setGravity(Gravity.CENTER_HORIZONTAL);
////            element_response.setBackgroundColor(Color.WHITE);
//
//        tr.addView(element_item1);
//            tr.addView(element_num);
//            tr.addView(element_content);
//            tr.addView(element_response);
//
//        tl.addView(tr, params);
////            tl.addView(tr, new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
////        }



//        TableLayout tl = (TableLayout) v.findViewById(R.id.table_layout);
//
////        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
////        TableLayout.LayoutParams params = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT);
////        params.setMargins(0, 0, 3, 0);
//
//        TableRow tr = new TableRow(getContext());
//
////        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
//        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
//        params.setMargins(0, 0, 30, 0);
//
////        for(int i=0; i<get_participate; i++) {
//            TextView element_num = new TextView(getContext());
////            element_num.setText("" + (i+1));
//        element_num.setText("테스트1");
//        element_num.setPadding(3, 3, 3, 3);
//            element_num.setBackgroundColor(Color.RED);
//            element_num.setTextSize(15);
//            element_num.setGravity(Gravity.CENTER_HORIZONTAL);
////            element_num.setBackgroundColor(Color.WHITE);
//
////        }
//
////        TextView element_content = new TextView(tableLayout.getContext());
//            TextView element_content = new TextView(getContext());
//            element_content.setText("테스트2");
//        element_content.setPadding(3, 3, 3, 3);
//        element_content.setBackgroundColor(Color.RED);
//        element_content.setTextSize(15);
//            element_content.setGravity(Gravity.CENTER_HORIZONTAL);
////            element_content.setBackgroundColor(Color.WHITE);
//
//
//            TextView element_response = new TextView(getContext());
//            element_response.setText("테스트3");
//        element_response.setPadding(3, 3, 3, 3);
//        element_response.setBackgroundColor(Color.RED);
//            element_response.setTextSize(15);
//            element_response.setGravity(Gravity.CENTER_HORIZONTAL);
////            element_response.setBackgroundColor(Color.WHITE);
//
//
//            tr.addView(element_num);
//            tr.addView(element_content);
//            tr.addView(element_response);
//
//        tl.addView(tr, params);
////            tl.addView(tr, new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
////        }





//        for(int i=0; i<get_participate; i++) {
//            participate_num1.setText("" + (i));
//        }




        for(int i=0; i<get_question.size(); i++) {
            if(get_selected.equals(get_question.get(i))) {
                Log.v("성공테스트", "성공");


                // 일반 차트
//                tableLayout.setVisibility(View.VISIBLE);
//                testText.setText(get_answer.get(1));

                // 원 차트
                pieChart = (PieChart)v.findViewById(R.id.piechart);
                pieChart.setVisibility(View.VISIBLE);

                pieChart.setUsePercentValues(true);
                pieChart.getDescription().setEnabled(false);
                pieChart.setExtraOffsets(5,10,5,5);

                pieChart.setDragDecelerationFrictionCoef(0.95f);

                pieChart.setDrawHoleEnabled(false);
                pieChart.setHoleColor(Color.WHITE);
                pieChart.setTransparentCircleRadius(61f);

                ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

                for(int j=0; j<get_answer.size(); j++) {

                }
                yValues.add(new PieEntry(34f,"Japen"));
                yValues.add(new PieEntry(23f,"USA"));
                yValues.add(new PieEntry(14f,"UK"));
                yValues.add(new PieEntry(35f,"India"));
                yValues.add(new PieEntry(40f,"Russia"));
                yValues.add(new PieEntry(40f,"Korea"));

                Description description = new Description();
                description.setText("세계 국가"); //라벨
                description.setTextSize(15);
                pieChart.setDescription(description);

                pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션

                PieDataSet dataSet = new PieDataSet(yValues,"Countries");
                dataSet.setSliceSpace(3f);
                dataSet.setSelectionShift(5f);
                dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

                PieData piedata = new PieData((dataSet));
                piedata.setValueTextSize(10f);
                piedata.setValueTextColor(Color.YELLOW);

                pieChart.setData(piedata);

            }
        }
//        if(get_selected.equals())


//        Log.v("오늘도테스트", "질문 : " + get_question.size());

//        if(getArguments() != null) {
//            get_question = getArguments().getString("param");
//            get_question = getArguments().getString("param");
//            for(int i=0; i<get_question.size(); i++) {
//            }
//            Log.v("여기서테스트", "2");
//        }



//        Bundle getBundle = getArguments();
//        if(getBundle != null) {
//            get_question = getBundle.getStringArrayList("legend");
//        }

//        Log.v("여기여기서테스트", get_question.get(0));
//        Log.v("여기여기서테스트", get_question.get(1));
//        Log.v("여기여기서테스트", get_question.get(2));



//        question.setText("체인지");
//        Log.v("오늘도테스트", "질문 : " + get_question.get(0));


//        // 일반 차트
//        tableLayout.setVisibility(View.VISIBLE);


//        // 원 차트
//        pieChart = (PieChart)v.findViewById(R.id.piechart);
//        pieChart.setVisibility(View.VISIBLE);
//
//        pieChart.setUsePercentValues(true);
//        pieChart.getDescription().setEnabled(false);
//        pieChart.setExtraOffsets(5,10,5,5);
//
//        pieChart.setDragDecelerationFrictionCoef(0.95f);
//
//        pieChart.setDrawHoleEnabled(false);
//        pieChart.setHoleColor(Color.WHITE);
//        pieChart.setTransparentCircleRadius(61f);
//
//        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();
//
//        yValues.add(new PieEntry(34f,"Japen"));
//        yValues.add(new PieEntry(23f,"USA"));
//        yValues.add(new PieEntry(14f,"UK"));
//        yValues.add(new PieEntry(35f,"India"));
//        yValues.add(new PieEntry(40f,"Russia"));
//        yValues.add(new PieEntry(40f,"Korea"));
//
//        Description description = new Description();
//        description.setText("세계 국가"); //라벨
//        description.setTextSize(15);
//        pieChart.setDescription(description);
//
//        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션
//
//        PieDataSet dataSet = new PieDataSet(yValues,"Countries");
//        dataSet.setSliceSpace(3f);
//        dataSet.setSelectionShift(5f);
//        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
//
//        PieData piedata = new PieData((dataSet));
//        piedata.setValueTextSize(10f);
//        piedata.setValueTextColor(Color.YELLOW);
//
//        pieChart.setData(piedata);


        // 막대바 차트
        barChart = (BarChart) v.findViewById(R.id.barchart);
        barChart.setVisibility(View.VISIBLE);

        List<BarEntry> barentries = new ArrayList<>();
        barentries.add(new BarEntry(0f, 30f));
        barentries.add(new BarEntry(1f, 80f));
        barentries.add(new BarEntry(2f, 60f));
        barentries.add(new BarEntry(3f, 50f));
        // gap of 2f
        barentries.add(new BarEntry(5f, 70f));
        barentries.add(new BarEntry(6f, 60f));

        BarDataSet set = new BarDataSet(barentries, "BarDataSet");

        BarData bardata = new BarData(set);
        bardata.setBarWidth(0.9f); // set custom bar width
        barChart.setData(bardata);
        barChart.setFitBars(true); // make the x-axis fit exactly all bars
        barChart.invalidate(); // refresh


//        // 꺾은선 차트
//        lineChart = (LineChart)v.findViewById(R.id.linetchart);
//
//        ArrayList<Entry> lineentries = new ArrayList<>();
//        lineentries.add(new Entry(4f, 0));
//        lineentries.add(new Entry(8f, 1));
//        lineentries.add(new Entry(6f, 2));
//        lineentries.add(new Entry(2f, 3));
//        lineentries.add(new Entry(18f, 4));
//        lineentries.add(new Entry(9f, 5));
//        lineentries.add(new Entry(16f, 6));
//        lineentries.add(new Entry(5f, 7));
//        lineentries.add(new Entry(3f, 8));
//        lineentries.add(new Entry(7f, 10));
//        lineentries.add(new Entry(9f, 11));
//
//        LineDataSet dataset = new LineDataSet(lineentries, "# of Calls");
//
//        ArrayList<String> labels = new ArrayList<String>();
//        labels.add("January");
//        labels.add("February");
//        labels.add("March");
//        labels.add("April");
//        labels.add("May");
//        labels.add("June");
//        labels.add("July");
//        labels.add("August");
//        labels.add("September");
//        labels.add("October");
//        labels.add("November");
//        labels.add("December");
//
////        LineData data = new LineData(labels, dataset);
//        LineData data = new LineData(dataset);
//
//        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
//        /*dataset.setDrawCubic(true); //선 둥글게 만들기
//        dataset.setDrawFilled(true); //그래프 밑부분 색칠*/
//
//        lineChart.setData(data);
//        lineChart.animateY(5000);

        return v;

//        return inflater.inflate(R.layout.fragment_circle_graph,container,false);
    }

    public static GraphFragment newInstance(String selected, int participate_num, ArrayList<String> spinner_question, ArrayList<String> questions_answer, ArrayList<String> grid_answer, ArrayList<String> test_answer) {
        GraphFragment gf = new GraphFragment();
        Bundle putBundle = new Bundle();
        putBundle.putStringArrayList("question", spinner_question);
        putBundle.putStringArrayList("answer", questions_answer);
        putBundle.putStringArrayList("grid", grid_answer);
        putBundle.putString("selected_item", selected);
        putBundle.putInt("participate", participate_num);
        putBundle.putStringArrayList("test", test_answer);

        gf.setArguments(putBundle);

        Log.d("호출테스트", "GraphFragment newInstance called");

        return gf;
    }
}
