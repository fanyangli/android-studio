package com.example.login;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MyInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyInfoFragment extends Fragment {

    private Context mContext;
    private TextView tvUsername;
    private LinearLayout headLayout;
    private RelativeLayout historyLayout, settingLayout;
    private boolean isLogin;//是否登录的标志位

    public MyInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyInfoFragment newInstance() {
       /* MyInfoFragment fragment = new MyInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return new fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.mContext = getContext();
        this.isLogin = checkLoginStatus();

        View view = inflater.inflate(R.layout.fragment_my_info, container, false);
        tvUsername view.findViewById(R.id.tv_username);
        setUsername(isLogin);

        headLayout = view.findViewById(R.id.ll_head);
        historyLayout = View.findViewById(R.id.rl_history);
        settingLayout = view.findViewById(R.id.rl_setting);
        //3.设置事件监听器
        headLayout.
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_info, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}

    private String readLoginInfo() {
        SharedPreferences sp=mContext.getSharedPreferences("loginInfo",Context.BIND_ABOVE_CLIENT);
        return sp.getString("lofinUser","");
    }
    @Override
public void onActivityResult(int requestCode,int resultCode,Intent data){
    super.onActivityResult(requestCode,resultCode,data);
    if(requestCode== 1 && resultCode== Activity.RESULT_OK && data ! =null){
        isLogin=data.getBooleanExtra("isLogin",false);
        setUsername(isLogin);
        }
    }
}
