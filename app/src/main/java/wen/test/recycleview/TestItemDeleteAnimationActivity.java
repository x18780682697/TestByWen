package wen.test.recycleview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import wen.test.BaseActivity;
import wen.testbywen.R;

public class TestItemDeleteAnimationActivity extends BaseActivity {

    RecyclerView            mListView;
    RecyclerView.Adapter    mAdapter;
    List<String>            mDataList = new ArrayList<>();
    Context                 mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_item_delete_animation);

        mContext = this;

        mListView = new RecyclerView(this);
        mListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false));
        mAdapter = new TestAdapter();
        mListView.setAdapter(mAdapter);

        ViewGroup listContainerVg = findViewById(R.id.fl_list_container);
        listContainerVg.addView(mListView);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add_one_with_animation:
                mDataList.add(0, "added item, added time: " + System.currentTimeMillis());
                mAdapter.notifyItemInserted(0);
                break;
            case R.id.btn_delete_one_with_animation:
                mDataList.remove(0);
                mAdapter.notifyItemRemoved(0);
                break;
            case R.id.btn_delete_one_without_animation:
                mDataList.remove(0);
                mAdapter.notifyDataSetChanged();
                break;
            default:break;
        }
    }


    private class TestAdapter extends RecyclerView.Adapter<TestHolder>{

        @NonNull
        @Override
        public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            TextView tv = new TextView(mContext);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 50
            );
            tv.setLayoutParams(layoutParams);
            return new TestHolder(tv);
        }

        @Override
        public void onBindViewHolder(@NonNull TestHolder holder, int position) {
            holder.tv.setBackgroundResource(android.R.color.holo_red_light);
            holder.tv.setText(mDataList.get(position));
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }
    }

    private class TestHolder extends RecyclerView.ViewHolder{

        TextView tv;

        public TestHolder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView) itemView;
        }
    }

}
