package com.example.newapplication.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.newapplication.R;
import com.example.newapplication.databinding.IssueDetailsCardBinding;
import com.example.newapplication.model.IssueDetailsData;
import com.example.newapplication.model.VersionData;

import java.util.List;

public class ExportTreatmentListAdapter extends RecyclerView.Adapter<ExportTreatmentListAdapter.ItemHolder> {
    private List<VersionData> exportSubmitDbModels;
    private Context context;
   // OnclickInterfaceSaved clickInterface;

    public ExportTreatmentListAdapter(Context context, List<VersionData> lists) {
        this.context = context;
        this.exportSubmitDbModels = lists;
       // this.clickInterface = clickInterface;

    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.issue_details_card, parent, false);

  //   RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(listItem);
     IssueDetailsCardBinding listItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.issue_details_card, parent, false);

      return new ItemHolder(listItemBinding);
       // return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, @SuppressLint("RecyclerView") int position) {
        VersionData dataModel = exportSubmitDbModels.get(position);
        holder.bind(dataModel);
//        holder.binding.tvNamevalue.setText(dataModel.getAssigneeName());
        holder.binding.llview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "pos"+position, Toast.LENGTH_SHORT).show();
               // clickInterface.onClicktreatment(position, view);
            }
        });

    }

    @Override
    public int getItemCount() {
        return exportSubmitDbModels.size();
    }

    public void setData(List<VersionData> data) {
        exportSubmitDbModels = data;
        notifyDataSetChanged();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        IssueDetailsCardBinding binding;

        public ItemHolder(@NonNull IssueDetailsCardBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;

        }

        void bind(VersionData dataModel) {
            binding.setModel(dataModel);
            binding.executePendingBindings();
        }

    }
}

