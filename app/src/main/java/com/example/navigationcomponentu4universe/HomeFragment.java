package com.example.navigationcomponentu4universe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment {

    Button btn_send_money,view_balance,view_transaction;
    NavController navController;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_send_money = view.findViewById(R.id.btn_send_money);
        view_balance = view.findViewById(R.id.view_balance);
        view_transaction = view.findViewById(R.id.view_transaction);



        btn_send_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Navigate using Id
//                navController.navigate(R.id.chooseReciverFragment);

                //Navigate using Action
//                navController.navigate(R.id.action_homeFragment_to_chooseReciverFragment);

                //Navigate using SafeArgs Plugin Recommend way
                NavDirections  action = HomeFragmentDirections.actionHomeFragmentToChooseReciverFragment();
                Navigation.findNavController(view).navigate(action);

            }
        });

        view_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Navigate using Id
//                Animation
            /*    NavOptions navOptions =  new NavOptions.Builder()
                        .setEnterAnim(R.anim.slide_in_right)
                        .setExitAnim(R.anim.slide_out_left)
                        .setPopEnterAnim(R.anim.slide_in_left)
                        .setPopExitAnim(R.anim.slide_out_right).
                                build();
                navController.navigate(R.id.viewBalanceFragment,null,navOptions);*/

                //Navigate using Action
//                navController.navigate(R.id.action_homeFragment_to_viewBalanceFragment);

                //Navigate using SafeArgs Plugin Recommend way
                NavDirections action = HomeFragmentDirections.actionHomeFragmentToViewBalanceFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });

        view_transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Navigate using Id
//                navController.navigate(R.id.viewTrancationFragment);

                //Navigate using Action
//                navController.navigate(R.id.action_homeFragment_to_viewTrancationFragment);

                //Navigate using SafeArgs Plugin Recommend way
                NavDirections action = HomeFragmentDirections.actionHomeFragmentToViewTrancationFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });

    }
}