package com.khair.wellpick;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.khair.wellpick.adapter.TabLayoutAdapter;
import com.khair.wellpick.fragment.HomeFragment;
import com.khair.wellpick.model.TabModel;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lodeTabLayout();

    }///onCreate end here********************************************

    public void lodeTabLayout() {
        List<TabModel> tab = Arrays.asList(
                new TabModel("Home", HomeFragment.class),
                new TabModel("Home", HomeFragment.class),
                new TabModel("Home", HomeFragment.class),
                new TabModel("Home", HomeFragment.class),
                new TabModel("Home", HomeFragment.class),
                new TabModel("Home", HomeFragment.class),
                new TabModel("Home", HomeFragment.class),
                new TabModel("Home", HomeFragment.class)

        );

        TabLayout tabLayout = findViewById(R.id.TabLayout);
        ViewPager2 viewPager2 = findViewById(R.id.ViewPager2);




        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });


        TabLayoutAdapter adapter = new TabLayoutAdapter(this, tab);
        viewPager2.setAdapter(adapter);

        // Connect TabLayout and ViewPager2
        new TabLayoutMediator(tabLayout, viewPager2, (tabs, position) -> {

            View customView = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            // Ensure R.id.tab_text is a TextView
            TextView tab_text=customView.findViewById(R.id.tab_text);

            for (TabModel tabModel : tab) {
               tab_text.setText(tabModel.getTittle());
            }
            tabs.setCustomView(customView);


        }).attach();



    }

}///public Class end here +++++++++++++++++++++++++++++++++++++++++++