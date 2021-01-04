package com.example.navigationcomponentu4universe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavAction;
import androidx.navigation.NavArgs;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SentCashFragment extends Fragment {

    TextView tv_reciver;
    EditText et_amount;
    SentCashFragmentArgs args ;
    Button btn_send,btn_done,btn_cancel;

    public SentCashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sent_cash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_reciver = view.findViewById(R.id.tv_reciver);
        et_amount = view.findViewById(R.id.et_amount);
        btn_send = view.findViewById(R.id.btn_send);
        btn_done = view.findViewById(R.id.btn_done);
        btn_cancel = view.findViewById(R.id.btn_cancel);

        //Receiving date sended from Chose reciver fragment through bundle
//        String receiverName = getArguments().getString("name");


        //Receiving date sended from Chose reciver fragment through safeArgs
        args = SentCashFragmentArgs.fromBundle(getArguments());
       String receiverName = args.getReciverName();
        tv_reciver.setText("Sendt Cash to : "+receiverName);



        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amount = et_amount.getText().toString();
                NavDirections navDirections = SentCashFragmentDirections.actionSentCashFragmentToConfirmDialogFragment(receiverName,Integer.parseInt(amount));
                Navigation.findNavController(view).navigate(navDirections);
            }
        });


        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = SentCashFragmentDirections.actionSentCashFragmentToHomeFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // it will go to home fragment and remove all backstace
                Navigation.findNavController(view).popBackStack(R.id.homeFragment,true);
            }
        });
    }
}