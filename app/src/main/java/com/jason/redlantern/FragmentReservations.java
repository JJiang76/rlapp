package com.jason.redlantern;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import info.hoang8f.widget.FButton;

public class FragmentReservations extends Fragment {

    MaterialEditText editName;
    MaterialEditText numberPpl;
    MaterialEditText editPhone;
    FButton btnReservation;

    String name;
    String ppl;
    String phone;

    private final String PHONE_NUMBER = "3136708832";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservations, container, false);

        editName = view.findViewById(R.id.ResEditName);
        numberPpl = view.findViewById(R.id.ResNumberPpl);
        editPhone = view.findViewById(R.id.ResEditPhone);
        btnReservation = view.findViewById(R.id.btnReservation);

        name = editName.getText().toString();
        ppl = numberPpl.getText().toString();
        phone = editPhone.getText().toString();



        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getActivity(), "Reservation Made!", Toast.LENGTH_SHORT).show();

                    /*SmsManager smgr = SmsManager.getDefault();

                    smgr.sendTextMessage(PHONE_NUMBER, null,
                            "RESERVATION\n" + name + "\n" + ppl + " people\nPhone Number: " + phone,
                            null, null);

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("smsto:"));
                    i.setType("vnd.android-dir/mms-sms");
                    i.putExtra("address", PHONE_NUMBER);
                    i.putExtra("sms_body", "Reservation test");
                    startActivity(Intent.createChooser(i, "Send sms via:"));*/
                }
                catch(Exception e){
                    Toast.makeText(getActivity(), "SMS Failed!!", Toast.LENGTH_SHORT).show();
                }
            }
        });






        return view;

    }


}