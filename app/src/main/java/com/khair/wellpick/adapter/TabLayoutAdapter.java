package com.khair.wellpick.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.khair.wellpick.model.TabModel;

import java.util.List;

public class TabLayoutAdapter extends FragmentStateAdapter {

    private List<TabModel> tab;

    public TabLayoutAdapter(@NonNull FragmentActivity fragmentActivity,List<TabModel>tab) {
        super(fragmentActivity);
        this.tab=tab;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        try {
            // Dynamically instantiate the fragment class
            return tab.get(position).getFragmentclass().newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace(); // Log the error
            return new Fragment(); // Return a fallback fragment
        }
    }

    @Override
    public int getItemCount() {
        return tab.size();
    }
}
