package com.example.edward.inventstoryreformat;

        import android.app.Activity;
        import android.os.Bundle;
        import android.support.v7.app.ActionBarActivity;
        import android.view.View;
        import android.view.View.MeasureSpec;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ListAdapter;
        import android.widget.ListView;

/**
 * Created by Edward on 4/17/2016.
`* This class is for list that goes into the 'Organization' to display data.

 */
public class Organlist extends Activity {

    private ListView mListView1, mListView2;

    private String [] data1 ={"Apple", "Orange", "Banana", "Pineapple", "Watermelon", "Kiwi"};
    private String [] data2 ={"Dr. Pepper", "Orange Juice", "Apple Juice", "Jack Daniel", "Coke", "Pepsi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organlist);

        mListView1 = (ListView)findViewById(R.id.listView1);
        mListView2 = (ListView)findViewById(R.id.listView2);

        mListView1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data1));
        mListView2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data2));

        ListUtils.setDynamicHeight(mListView1);
        ListUtils.setDynamicHeight(mListView2);
    }


    public static class ListUtils {
        public static void setDynamicHeight(ListView mListView) {
            ListAdapter mListAdapter = mListView.getAdapter();
            if (mListAdapter == null) {
                // when adapter is null
                return;
            }
            int height = 0;
            int desiredWidth = MeasureSpec.makeMeasureSpec(mListView.getWidth(), MeasureSpec.UNSPECIFIED);
            for (int i = 0; i < mListAdapter.getCount(); i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1));
            mListView.setLayoutParams(params);
            mListView.requestLayout();
        }
    }
}