package com.example.common

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import org.koin.android.viewmodel.ext.android.getViewModel

abstract class BaseFragment : Fragment() {

    val fManager: FragmentManager by lazy {
        requireActivity().supportFragmentManager
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initControl()
        initUI()
        initEvent()
        initConfig()

        with(getViewModel()) {

            errorLiveData.observe(viewLifecycleOwner, Observer {
                it.getContentIfNotHandled()?.let {
                    showAlertDialog(
                        title = it,
                        content = "",
                        confirmButtonTitle = "OK",
                        confirmCallback = {},
                        cancelButtonTitle = "",
                        cancelCallback = {}
                    )
                }
            })
        }
    }

    open fun showAlertDialog(
        title: String,
        content: String,
        confirmButtonTitle: String,
        cancelButtonTitle: String,
        confirmCallback: () -> Unit,
        cancelCallback: () -> Unit
    ) {
        val builder: AlertDialog.Builder =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                AlertDialog.Builder(requireContext())
            } else {
                AlertDialog.Builder(requireContext())
            }

        val dialog = builder
            .setTitle(title)
            .setMessage(content)
            .setPositiveButton(confirmButtonTitle) { dialog, _ ->
                confirmCallback.invoke()
            }
            .setNegativeButton(cancelButtonTitle) { _, _ ->
                cancelCallback.invoke()
            }
            .show()

        val positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE)

        positiveButton.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.button_in_alert_dialog_color
            )
        )
        negativeButton.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.button_in_alert_dialog_color
            )
        )
    }

    abstract fun getViewModel(): BaseViewModel

    protected abstract fun initControl()

    protected abstract fun initUI()

    protected abstract fun initEvent()

    protected abstract fun initConfig()

    fun navigate(navDirection: NavDirections, navOptions: NavOptions? = null) {
        navOptions?.let {
            this.findNavController().navigate(navDirection, it)
        } ?: kotlin.run {
            this.findNavController().navigate(navDirection)
        }
    }

    fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    fun backToPrevious() {
        this.findNavController().popBackStack()
    }

    fun hideKeyboard() {
        val inputMethodManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        // Check if no view has focus
        val currentFocusedView = requireActivity().currentFocus
        currentFocusedView?.let {
            inputMethodManager.hideSoftInputFromWindow(
                currentFocusedView.windowToken, InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }

    fun forceHideKeyboard(activity: Activity) {
        val imm =
            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val f = activity.currentFocus
        if (null != f && null != f.windowToken && EditText::class.java.isAssignableFrom(f.javaClass)) imm.hideSoftInputFromWindow(
            f.windowToken,
            0
        ) else activity.window
            .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    fun showKeyboard() {
        val imm =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(
            InputMethodManager.SHOW_IMPLICIT,
            0
        )
    }
}