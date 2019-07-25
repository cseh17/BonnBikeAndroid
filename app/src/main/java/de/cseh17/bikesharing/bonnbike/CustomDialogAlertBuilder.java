package de.cseh17.bikesharing.bonnbike;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

class CustomDialogAlertBuilder {

    static AlertDialog onCreateDialog(Activity mActivity, String title, String message, String buttonText){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mActivity)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(buttonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return dialogBuilder.create();
    }
}
