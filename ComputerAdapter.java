package com.example.btrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.List;
public class ComputerAdapter extends RecyclerView.Adapter {

    private List mComputer;

    private Context mContext;

    public ComputerAdapter(List _computer, Context mContext) {
        this.mComputer = _computer;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);


        View computerView =
                inflater.inflate(R.layout.computer_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(computerView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Computer computer = (Computer) mComputer.get(position);
        holder.computer_name.setText(computer.getmName());
        holder.gia_tien.setText(computer.getGia()+"");
    }




    @Override
    public int getItemCount() {
        return mComputer.size();
    }

    /**
     * Lớp nắm giữ cấu trúc view
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private View item_view;
        public TextView computer_name;
        private TextView gia_tien;
        public Button detail_button;

        public ViewHolder(View itemView) {
            super(itemView);
            item_view = itemView;
            computer_name = itemView.findViewById(R.id.computer_name);
            gia_tien = itemView.findViewById(R.id.gia_tien);
            detail_button = itemView.findViewById(R.id.detail_button);

            //Xử lý khi nút Chi tiết được bấm
            detail_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                                    computer_name.getText() +" | "
                                            + " Demo function", Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }

        public TextView getGia_tien() {
            return gia_tien;
        }

        public void setGia_tien(TextView gia_tien) {
            this.gia_tien = gia_tien;
        }
    }


}