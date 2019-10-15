package com.example.weknot_android.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.weknot_android.BR
import com.example.weknot_android.R
import com.example.weknot_android.base.fragment.BaseFragment
import com.example.weknot_android.databinding.MyinfoFragmentBinding
import com.example.weknot_android.viewmodel.MyinfoViewModel

class MyinfoFragment : BaseFragment<MyinfoFragmentBinding, MyinfoViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.myinfo_fragment
    }

    override fun getViewModel(): Class<MyinfoViewModel> {
        return MyinfoViewModel::class.java
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun initObserver() {
        with(viewModel) {
            onErrorEvent.observe(this@MyinfoFragment, Observer {
                simpleToast(it.message)
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    override fun onResume() {
        super.onResume()
        viewModel.setUp()
    }

    private fun setUp() {
        viewModel.id.value = viewModel.getMyId()
    }
}