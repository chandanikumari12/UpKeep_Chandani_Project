package com.example.wel.upkeep;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;



/**
 * Created by 103 on 4/19/2018.
 */

public class CommonMethod {
    Context context;
    public CommonMethod(Context context)
    {
        this.context = context;
    }

    public void AlertDialogMethod(String str)
    {
        final android.app.AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("UpKeep");
        alertDialog.setMessage(""+str);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    public void click_back_button()
    {
        Intent intent = new Intent(context,Home_Activity.class);
        context.startActivity(intent);
    }
}
