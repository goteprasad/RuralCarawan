package com.hatchers.ruralcaravane.construction_team;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hatchers.ruralcaravane.construction_team.database.ConstructionTable;
import com.hatchers.ruralcaravane.construction_team.database.ConstructionTableHelper;
import com.hatchers.ruralcaravane.R;
import com.hatchers.ruralcaravane.kitchen_suitability.database.KitchenTable;
import com.hatchers.ruralcaravane.pref_manager.PrefManager;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class ConstructionTeamRegistrationFragment extends Fragment {

    private KitchenTable kitchenTable;
    private  FragmentTransaction fragmentTransaction;
    private Toolbar construction_toolbar;
    private ImageButton construction_btnBack;
    private Button saveBtn,register_Byscanid;
    private TextInputEditText construction_member_name, construction_member_address,
            construction_member_mobileno, construction_member_age;
    private RadioGroup radioGroupGender;
    private RadioButton male, female;
    private String selectedGender = "";
    PrefManager prefManager;

    ConstructionTable constructionTable;

    public static ConstructionTeamRegistrationFragment newInstance(KitchenTable kitchenTable) {
        ConstructionTeamRegistrationFragment fragment = new ConstructionTeamRegistrationFragment();
        Bundle args = new Bundle();
        args.putParcelable(KitchenTable.KITCHEN_TABLE, kitchenTable);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            kitchenTable = getArguments().getParcelable(KitchenTable.KITCHEN_TABLE);
        }
    }

    public ConstructionTeamRegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_construction_team_details, container, false);

        ((AppCompatActivity) getActivity()).setSupportActionBar(construction_toolbar);

        initializations(view);
        onclicklisteners();
        setGender();


        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
        }


        return view;
    }

    private void initializations(View view)
    {
        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        construction_toolbar = (Toolbar) view.findViewById(R.id.construction_toolbar);

        construction_btnBack = (ImageButton) view.findViewById(R.id.construction_btnBack);
        register_Byscanid=(Button)view.findViewById(R.id.register_Byscanid);
        saveBtn = (Button) view.findViewById(R.id.saveBtn);
        construction_member_name = (TextInputEditText) view.findViewById(R.id.construction_member_name);
        construction_member_address = (TextInputEditText) view.findViewById(R.id.construction_member_address);
        construction_member_mobileno = (TextInputEditText) view.findViewById(R.id.construction_member_mobileno);
        construction_member_age = (TextInputEditText) view.findViewById(R.id.construction_member_age);
        radioGroupGender = (RadioGroup) view.findViewById(R.id.radio_gender);
        male = (RadioButton) view.findViewById(R.id.male);
        female = (RadioButton) view.findViewById(R.id.female);

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.DarkBrown));
        }

    }

    private void onclicklisteners()
    {

        construction_btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setConstructionTeamData();
                if (checkValidation()) {
                    SweetAlertDialog sweetAlertDialog =new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE)
                            .setTitleText("Please wait");

                    sweetAlertDialog.show();

                    if(ConstructionTableHelper.insertConstructionTeamData(getContext(), constructionTable))
                    {
                        sweetAlertDialog.changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                        sweetAlertDialog.setTitleText("Construction Team Data Added Successfully");
                        sweetAlertDialog.setConfirmText("Ok");
                        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismissWithAnimation();


                                construction_member_name.setText("");
                                construction_member_address.setText("");
                                construction_member_mobileno.setText("");
                                construction_member_age.setText("");
                                male.setChecked(false);
                                female.setChecked(false);
                            }
                        });
                    }

                    else
                    {
                        sweetAlertDialog.changeAlertType(SweetAlertDialog.ERROR_TYPE);
                        sweetAlertDialog.setTitleText("Construction Team Data Failed");
                        sweetAlertDialog.setConfirmText("Ok");
                        sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismissWithAnimation();
                            }
                        });
                    }
                }
            }
        });
    }

    private void setConstructionTeamData()
    {
        constructionTable = new ConstructionTable();

        constructionTable.setTechnicianNameValue(construction_member_name.getText().toString());
        constructionTable.setTechnicianAddressValue(construction_member_address.getText().toString());
        constructionTable.setTechnicianAgeValue(construction_member_age.getText().toString());
        constructionTable.setTechnicianMobileNoValue(construction_member_mobileno.getText().toString());
        constructionTable.setTechnicianGenderValue(selectedGender);
        constructionTable.setKitchentUniqueId(kitchenTable.getKitchenUniqueIdValue());
        constructionTable.setKitchenIdValue(kitchenTable.getKitchen_idValue());
    }


    public void setGender()
    {
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.male) {
                    selectedGender = "M";
                } else if (checkedId == R.id.female) {
                    selectedGender = "F";
                }
            }
        });

    }


    private boolean checkValidation()
    {
        boolean response = true;

        if (construction_member_name.getText().toString().trim().length() == 0) {
            construction_member_name.setError("Please Enter Construction Member Name");
            response = false;
        } else {
            construction_member_name.setError(null);
        }

        if (construction_member_age.getText().toString().trim().length() == 0) {
            construction_member_age.setError("Please Enter Construction Member Age ");
            response = false;
        } else {
            construction_member_age.setError(null);
        }

        if (construction_member_address.getText().toString().trim().length() == 0) {
            construction_member_address.setError("Please Enter Construction Member Address ");
            response = false;
        } else {
            construction_member_address.setError(null);
        }

        if (construction_member_mobileno.getText().toString().trim().length() == 0) {
            construction_member_mobileno.setError("Please Enter Construction Member Mobile Number");
            response = false;
        } else {
            construction_member_mobileno.setError(null);
        }

        if (radioGroupGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getActivity(), "Please Select Gender", Toast.LENGTH_SHORT).show();
            response = false;
            // no radio buttons are checked
        } else {
            // one of the radio buttons is checked

        }
        return response;
    }

}


