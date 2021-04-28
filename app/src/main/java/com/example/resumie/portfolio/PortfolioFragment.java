package com.example.resumie.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.resumie.CV.CVAdapter;
import com.example.resumie.CV.CVitem;
import com.example.resumie.R;
import com.example.resumie.team.TeamAdapter;
import com.example.resumie.team.TeamItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PortfolioFragment extends Fragment implements PortfolioCallback {

    RecyclerView recyclerView;
    PortfolioAdapter portfolioAdapter;
    public List<PortfolioItem> mdata;

    public PortfolioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_portfolio);
        mdata=new ArrayList<>();
        mdata.add(new PortfolioItem(R.drawable.astro));
        mdata.add(new PortfolioItem(R.drawable.astro));
        mdata.add(new PortfolioItem(R.drawable.astro));
        mdata.add(new PortfolioItem(R.drawable.astro));
        mdata.add(new PortfolioItem(R.drawable.astro));
        mdata.add(new PortfolioItem(R.drawable.astro));




        portfolioAdapter=new PortfolioAdapter(mdata,this);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setAdapter(portfolioAdapter);
    }

    @Override
    public void onPortfolioItemClick(int pos) {


        PortfolioDetailsFragment portfolioDetailsFragment =
                new PortfolioDetailsFragment();


        Bundle bundle = new Bundle();
        bundle.putSerializable("object", mdata.get(pos));
        portfolioDetailsFragment.setArguments(bundle);

        portfolioDetailsFragment.show(getActivity().getSupportFragmentManager(),"tagname");
    }
}
