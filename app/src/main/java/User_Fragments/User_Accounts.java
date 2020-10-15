package User_Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rentmandu.MainActivity;
import com.example.rentmandu.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;


public class User_Accounts extends Fragment {

    TextView name, mail;
    Button logout;
    CircleImageView profile_image;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_user__accounts,container,false);



        logout = view.findViewById(R.id.logout);
        name = view.findViewById(R.id.name);
        mail = view.findViewById(R.id.mail);
        profile_image=(CircleImageView) view.findViewById(R.id.user_profile_image);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(getContext());

        if(signInAccount != null){
            name.setText(signInAccount.getDisplayName());
            mail.setText(signInAccount.getEmail());
            Glide.with(getContext()).load(signInAccount.getPhotoUrl()).into(profile_image);

        }
        // Inflate the layout for this fragment
        return view;
    }
}