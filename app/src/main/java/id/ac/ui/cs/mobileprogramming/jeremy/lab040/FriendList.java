package id.ac.ui.cs.mobileprogramming.jeremy.lab040;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import id.ac.ui.cs.mobileprogramming.jeremy.lab040.databinding.FragmentFriendListBinding;

import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FriendList extends Fragment {

    private FragmentFriendListBinding binding;
    private FriendDetails detailsFragment = new FriendDetails();

    public FriendList() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_friend_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        List<Friend> friendList = new ArrayList<>();
        friendList.add(new Friend( "Rafli Hidayat", "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment", R.drawable.rafli));
        friendList.add(new Friend( "Nasya Oristania", "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment",R.drawable.nasya));
        friendList.add(new Friend("Devin Winardi", "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment", R.drawable.devin));
        friendList.add(new Friend("Palito Jeremy", "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment", R.drawable.palito));
        friendList.add(new Friend("Jose Devian", "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment", R.drawable.jose));
        friendList.add(new Friend("Fadhlan Hafizh", "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment", R.drawable.fadhlan));
        friendList.add(new Friend("Nathasya Eliora", "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment", R.drawable.cici));


        FriendAdapter adapter = new FriendAdapter(friendList);
        binding.recyclerView.setAdapter(adapter);
        adapter.setListener((v, position) -> {
            viewModel.setSelected(adapter.getFriendAt(position));
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.main, detailsFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}