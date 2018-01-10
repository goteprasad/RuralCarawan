package com.hatchers.ruralcaravane.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;


import com.hatchers.ruralcaravane.construction_team.ConstructionTeamListFragment;
import com.hatchers.ruralcaravane.customer_registration.database.CustomerTable;
import com.hatchers.ruralcaravane.kitchen_suitability.KitchenSuitabilityList;
import com.hatchers.ruralcaravane.payment_details.PaymentDetailsFragment;
import com.hatchers.ruralcaravane.pref_manager.PrefManager;
import com.hatchers.ruralcaravane.R;
import com.hatchers.ruralcaravane.user_login.LoginActivity;
import com.hatchers.ruralcaravane.user_login.UserDetailsFragment;


public class MenuFragment extends Fragment implements View.OnClickListener{

    private Toolbar menu_toolbar;
    PrefManager prefManager;
    private  FragmentTransaction fragmentTransaction;
    private LinearLayout kitchen_linear,construction_linear,payment_linear;
    private CustomerTable customertable;
    public static MenuFragment getInstance(CustomerTable customertable)
    {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putParcelable(CustomerTable.CUSTOMER_TABLE, customertable);
        fragment.setArguments(args);
        return fragment;

    }


    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            customertable = getArguments().getParcelable(CustomerTable.CUSTOMER_TABLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_menu, container, false);


        initToolbar(view);
        setHasOptionsMenu(true);


        kitchen_linear=(LinearLayout)view.findViewById(R.id.kitchen_linear);
        construction_linear=(LinearLayout)view.findViewById(R.id.construction_linear);
        payment_linear=(LinearLayout)view.findViewById(R.id.payment_linear);
        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();



        kitchen_linear.setOnClickListener(this);
        construction_linear.setOnClickListener(this);
        payment_linear.setOnClickListener(this);


        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window =getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorAccent));
        }

        return view;
    }


    private void initToolbar(View view)
    {
        menu_toolbar = (Toolbar)view.findViewById(R.id.menu_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(menu_toolbar);
        prefManager=new PrefManager(getActivity());
    }
    @Override
    public void onClick(View view) {

        switch (view.getId())
        {

            case R.id.kitchen_linear:
                KitchenSuitabilityList kitchenSuitabilityList= KitchenSuitabilityList.getInstance(customertable);
                fragmentTransaction.replace(R.id.frame_layout,kitchenSuitabilityList).addToBackStack(null).commit();
                break;

            case R.id.construction_linear:
                //ConstructionTeamListFragment constructionTeamListFragment = ConstructionTeamListFragment.getInstance(customertable);
               // fragmentTransaction.replace(R.id.frame_layout,constructionTeamListFragment).addToBackStack(null).commit();
                break;

            case R.id.payment_linear:
                PaymentDetailsFragment paymentDetailsFragment=PaymentDetailsFragment.getInstance(customertable);
                fragmentTransaction.replace(R.id.frame_layout,paymentDetailsFragment).addToBackStack(null).commit();
                break;

            default:
                break;
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.profile:
                UserDetailsFragment userDetailsFragment=new UserDetailsFragment();
                fragmentTransaction.replace(R.id.frame_layout,userDetailsFragment).addToBackStack(null).commit();
                break;

            case R.id.logout:
                prefManager.setLogOut();
                Intent i= new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
                getActivity().finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
