package com.example.newapplication.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class ExportTreatmentListAdapter{
// extends RecyclerView.Adapter<ExportTreatmentListAdapter.ItemHolder> {
//    private List<ExportTreatmentSubmitDbModel> exportSubmitDbModels;
//    private Context context;
//   // OnclickInterfaceSaved clickInterface;
//
//    public ExportTreatmentListAdapter(Context context, List<ExportTreatmentSubmitDbModel> lists, OnclickInterfaceSaved clickInterface) {
//        this.context = context;
//        this.exportSubmitDbModels = lists;
//       // this.clickInterface = clickInterface;
//
//    }
//
//    @NonNull
//    @Override
//    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        ItemExporttreatmentBinding listItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_exporttreatment, parent, false);
//
//        return new ItemHolder(listItemBinding);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ItemHolder holder, @SuppressLint("RecyclerView") int position) {
//        ExportTreatmentSubmitDbModel dataModel = exportSubmitDbModels.get(position);
//        holder.bind(dataModel);
//        holder.binding.cardlist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                clickInterface.onClicktreatment(position, view);
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return exportSubmitDbModels.size();
//    }
//
//    public void setData(List<ExportTreatmentSubmitDbModel> data) {
//        exportSubmitDbModels = data;
//        notifyDataSetChanged();
//    }
//
//    public class ItemHolder extends RecyclerView.ViewHolder {
//        ItemExporttreatmentBinding binding;
//
//        public ItemHolder(@NonNull ItemExporttreatmentBinding itemView) {
//            super(itemView.getRoot());
//            this.binding = itemView;
//
//        }
//
////        void bind(ExportTreatmentSubmitDbModel dataModel) {
////            binding.setModel(dataModel);
////            binding.executePendingBindings();
////        }
//
//    }
}

