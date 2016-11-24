package batfai.samuentropy.brainboard7;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.DialogFragment;
import android.app.AlertDialog;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import batfai.samuentropy.brainboard7.R;


public class NeuronDialogFragment extends DialogFragment {
    public static boolean volt = false;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        // Use the Builder class for convenient dialog construction
        /*AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog);



        builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialogmessage)
                .setTitle(R.string.thedialogtitle);


        builder.setPositiveButton(R.string.okgomb,  new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                volt = true;
            }
        });

        return builder.create();*/

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.cdialog);
        dialog.setTitle(R.string.thedialogtitle);


        TextView text = (TextView) dialog.findViewById(R.id.help_tv);
        text.setText(R.string.dialogmessage);

        Button dialogButton = (Button) dialog.findViewById(R.id.ok_bt);
        final CheckBox checkBox = (CheckBox) dialog.findViewById(R.id.norbironCheck);


        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                    prefs.edit().putBoolean("locked", true).commit();
                }
                dialog.dismiss();
            }
        });




        return  dialog;
    }
}