package com.example.navigationcomponentu4universe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class ChooseReciverFragment extends Fragment {

    Button btn_next,btn_cancle;
    EditText et_receiver_name;
    NavController navController;


    public ChooseReciverFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_reciver, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_next = view.findViewById(R.id.btn_next);
        et_receiver_name = view.findViewById(R.id.et_receiver_name);
        btn_cancle = view.findViewById(R.id.btn_cancle);

        NavHostFragment navHostFragment =
                (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
         navController = navHostFragment.getNavController();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reciverName = et_receiver_name.getText().toString();

                //Passing data through bundle
/*
                  NavOptions navOptions =  new NavOptions.Builder()
                        .setEnterAnim(R.anim.slide_in_right)
                        .setExitAnim(R.anim.slide_out_left)
                        .setPopEnterAnim(R.anim.slide_in_left)
                        .setPopExitAnim(R.anim.slide_out_right).
                                build();

                Bundle bundle = new Bundle();
                bundle.putString("name",reciverName);

                navController.navigate(R.id.sentCashFragment,bundle,navOptions);

 */
                NavDirections action = ChooseReciverFragmentDirections.actionChooseReciverFragmentToSentCashFragment(reciverName);
                Navigation.findNavController(view).navigate(action);

            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).popBackStack();
            }
        });
    }
}