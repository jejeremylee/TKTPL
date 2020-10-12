package id.ac.ui.cs.mobileprogramming.jeremy.lab040;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import id.ac.ui.cs.mobileprogramming.jeremy.lab040.databinding.FriendListRowBinding;


import java.util.List;

    public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {
        private List<Friend> list;
        private OnItemClickListener listener;

        public interface OnItemClickListener {
            void onClick(View view, int position);
        }

        public FriendAdapter(List<Friend> list) {
            this.list = list;
        }

        public void setListener(OnItemClickListener listener) {
            this.listener = listener;
        }

        public Friend getFriendAt(int position) {
            return list.get(position);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            FriendListRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.friend_list_row, parent, false);
            return new ViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.binding.name.setText(list.get(position).getName());
            holder.binding.image.setImageResource(list.get(position).getImg());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private FriendListRowBinding binding;

            public ViewHolder(@NonNull FriendListRowBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
                this.binding.getRoot().setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                listener.onClick(v, getAdapterPosition());
            }
        }
    }

