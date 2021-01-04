package com.example.navigationcomponentu4universe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ConfirmDialogFragment extends BottomSheetDialogFragment {

    ConfirmDialogFragmentArgs args;
    TextView tv_message;
    Button btn_yes,btn_no;

    public ConfirmDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv_message = view.findViewById(R.id.tv_message);
        btn_yes = view.findViewById(R.id.btn_yes);
        btn_no = view.findViewById(R.id.btn_no);

        args = ConfirmDialogFragmentArgs.fromBundle(getArguments());
        String reciverName = args.getReciverName();
        int amount = args.getAmount();

        tv_message.setText("Do you want to send Rs "+amount+" to "+reciverName);

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), amount+" has been sent to "+reciverName, Toast.LENGTH_SHORT).show();
                //                dismising the bottom dialog
                dismiss();
            }
        });

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dismising the bottom dialog
                dismiss();
            }
        });
    }
}