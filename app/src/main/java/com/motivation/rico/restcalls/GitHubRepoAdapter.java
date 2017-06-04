package com.motivation.rico.restcalls;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Ronald Boodram on 12/26/16.
 */

public class GitHubRepoAdapter extends ArrayAdapter<MotivateMsgs> {

    private Context context;
    private List<MotivateMsgs> values;

    public GitHubRepoAdapter(Context context, List<MotivateMsgs> values) {
        super(context, R.layout.list_item_pagination, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_pagination, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.list_item_pagination_text);

        MotivateMsgs item = values.get(position);
        String message1 = item.getMsg();
        String message2 = item.getTag();
        textView.setText(message1 + message2);

        return row;
    }
}
