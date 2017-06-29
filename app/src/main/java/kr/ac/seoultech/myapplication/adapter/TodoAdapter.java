package kr.ac.seoultech.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import kr.ac.seoultech.myapplication.R;
import kr.ac.seoultech.myapplication.model.Todo;

/**
 * Created by eveck on 2017-06-27.
 */

public class TodoAdapter extends BaseAdapter {

    private Context context;    // Context : Toast를 띄울때, 문자열을 참조할 때, 등 사용
    private int layoutId;
    private List<Todo> items;
    private LayoutInflater inflater;

    private SimpleDateFormat sdf;

    public TodoAdapter(Context context, int layoutId, List<Todo> items){    // 항상 동일한 코드가 들어감.(데이터 타입이 다를 뿐)
        this.context = context;
        this.layoutId = layoutId;
        this.items = items;
        this.inflater = LayoutInflater.from(context);

        sdf = new SimpleDateFormat("yyyy.MM.dd");
    }


    @Override
    public int getCount() {
        return items.size();
    }   // 항상 동일한 코드가 들어감.

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }   // 항상 동일한 코드가 들어감.

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }   // 항상 동일한 코드가 들어감.

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){       // View가 없으면 View를 생성하라.
            convertView = inflater.inflate(this.layoutId, null);
        }

        convertView.findViewById(R.id.txt_create_at);


        // View 찾아오기
        TextView txtCreateAt = (TextView) convertView.findViewById(R.id.txt_create_at);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.txt_title);
        TextView txtContent = (TextView) convertView.findViewById(R.id.txt_content);


        // 찾아온 View값을 setText로 입력하기
        Todo todo = this.items.get(position);
        txtCreateAt.setText(sdf.format(todo.getCreateAt()));
        txtTitle.setText(todo.getTitle().toString());
        txtContent.setText(todo.getContent().toString());


        return convertView;
    }


    public void addItem(int index, Todo todo){
        this.items.add(index, todo);
        notifyDataSetChanged();
    }

    public void setItem(int index, Todo todo){
        this.items.set(index, todo);
        notifyDataSetChanged();
    }
}
