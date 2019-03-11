package com.mydatabindviewmodel.app;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mydatabindviewmodel.app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoginViewModel loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setLoginViewModel(loginViewModel);
        binding.setLifecycleOwner(this);
        //
        loginViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user.getEmail().length() > 0 || user.getPassword().length() > 0)
                    Toast.makeText(getApplicationContext(), "email : " + user.getEmail() + " password " + user.getPassword(), Toast.LENGTH_SHORT).show();
            }

        });

    }
}

